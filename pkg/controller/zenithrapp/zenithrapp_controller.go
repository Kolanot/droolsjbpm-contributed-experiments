package zenithrapp

import (
	"context"
	"encoding/json"
	"k8s.io/apimachinery/pkg/util/intstr"
	"reflect"

	zenithrv1 "github.com/kiegroup/zenithr-operator/pkg/apis/zenithr/v1"
	corev1 "k8s.io/api/core/v1"
	"k8s.io/apimachinery/pkg/api/errors"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/types"
	"sigs.k8s.io/controller-runtime/pkg/client"
	"sigs.k8s.io/controller-runtime/pkg/controller"
	"sigs.k8s.io/controller-runtime/pkg/controller/controllerutil"
	"sigs.k8s.io/controller-runtime/pkg/handler"
	"sigs.k8s.io/controller-runtime/pkg/manager"
	"sigs.k8s.io/controller-runtime/pkg/reconcile"
	logf "sigs.k8s.io/controller-runtime/pkg/runtime/log"
	"sigs.k8s.io/controller-runtime/pkg/source"
)

var log = logf.Log.WithName("controller_zenithrapp")

/**
* USER ACTION REQUIRED: This is a scaffold file intended for the user to modify with their own Controller
* business logic.  Delete these comments after modifying this file.*
 */

// Add creates a new ZenithrApp Controller and adds it to the Manager. The Manager will set fields on the Controller
// and Start it when the Manager is Started.
func Add(mgr manager.Manager) error {
	return add(mgr, newReconciler(mgr))
}

// newReconciler returns a new reconcile.Reconciler
func newReconciler(mgr manager.Manager) reconcile.Reconciler {
	return &ReconcileZenithrApp{client: mgr.GetClient(), scheme: mgr.GetScheme()}
}

// add adds a new Controller to mgr with r as the reconcile.Reconciler
func add(mgr manager.Manager, r reconcile.Reconciler) error {
	// Create a new controller
	c, err := controller.New("zenithrapp-controller", mgr, controller.Options{Reconciler: r})
	if err != nil {
		return err
	}

	// Watch for changes to primary resource ZenithrApp
	err = c.Watch(&source.Kind{Type: &zenithrv1.ZenithrApp{}}, &handler.EnqueueRequestForObject{})
	if err != nil {
		return err
	}

	// Watch for changes to secondary resource Pods and Services, and requeue the owner ZenithrApp
	if err = watchResources(c, &corev1.Pod{}); err != nil {
		return err
	}
	if err = watchResources(c, &corev1.Service{}); err != nil {
		return err
	}
	return nil
}

func watchResources(controller controller.Controller, resource runtime.Object) error {
	return controller.Watch(&source.Kind{Type: resource}, &handler.EnqueueRequestForOwner{
		IsController: true,
		OwnerType:    &zenithrv1.ZenithrApp{},
	})
}

var _ reconcile.Reconciler = &ReconcileZenithrApp{}

// ReconcileZenithrApp reconciles a ZenithrApp object
type ReconcileZenithrApp struct {
	// This client, initialized using mgr.Client() above, is a split client
	// that reads objects from the cache and writes to the apiserver
	client client.Client
	scheme *runtime.Scheme
}

type KubeObject interface {
	runtime.Object
	metav1.Object
}

// Reconcile reads that state of the cluster for a ZenithrApp object and makes changes based on the state read
// and what is in the ZenithrApp.Spec
// Note:
// The Controller will requeue the Request to be processed again if the returned error is non-nil or
// Result.Requeue is true, otherwise upon completion it will remove the work from the queue.
func (r *ReconcileZenithrApp) Reconcile(request reconcile.Request) (reconcile.Result, error) {
	reqLogger := log.WithValues("Request.Namespace", request.Namespace, "Request.Name", request.Name)
	reqLogger.Info("Reconciling ZenithrApp")

	// Fetch the ZenithrApp instance
	instance := &zenithrv1.ZenithrApp{}
	err := r.client.Get(context.TODO(), request.NamespacedName, instance)
	if err != nil {
		if errors.IsNotFound(err) {
			// Request object not found, could have been deleted after reconcile request.
			// Owned objects are automatically garbage collected. For additional cleanup logic use finalizers.
			// Return and don't requeue
			return reconcile.Result{}, nil
		}
		// Error reading the object - requeue the request.
		return reconcile.Result{}, err
	}

	requested := []KubeObject{newPodForCR(instance), newServiceForCR(instance)}
	existing := []KubeObject{&corev1.Pod{}, &corev1.Service{}}
	for index := 0; index < len(requested); index++ {
		// Set ZenithrApp instance as the owner and controller
		if err := controllerutil.SetControllerReference(instance, requested[index], r.scheme); err != nil {
			return reconcile.Result{}, err
		}

		// Check if this resource already exists
		err = r.client.Get(context.TODO(), types.NamespacedName{Name: requested[index].GetName(), Namespace: requested[index].GetNamespace()}, existing[index])
		if err != nil && errors.IsNotFound(err) {
			reqLogger.Info("Creating a new resource of type ", "Resource Type", reflect.TypeOf(requested[index]), "Pod.Namespace", requested[index].GetNamespace(), "Pod.Name", requested[index].GetName())
			err = r.client.Create(context.TODO(), requested[index])
			if err != nil {
				return reconcile.Result{}, err
			}
			// Resource created successfully - don't requeue
		} else if err != nil {
			return reconcile.Result{}, err
		}
	}

	return reconcile.Result{}, nil
}

// newPodForCR returns a functioning pod with the same name/namespace as the cr
func newPodForCR(cr *zenithrv1.ZenithrApp) *corev1.Pod {
	labels := map[string]string{
		"app": cr.Name,
	}
	return &corev1.Pod{
		ObjectMeta: metav1.ObjectMeta{
			Name:      cr.Name,
			Namespace: cr.Namespace,
			Labels:    labels,
		},
		Spec: corev1.PodSpec{
			Containers: []corev1.Container{
				{
					Name:  cr.Name,
					Image: "quay.io/bmozaffa/zenithr",
					Env: []corev1.EnvVar{
						{
							Name:  "GET",
							Value: getJson(cr.Spec),
						},
						{
							Name:  "NAME",
							Value: cr.Name,
						},
					},
					ReadinessProbe: &corev1.Probe{
						Handler: corev1.Handler{
							HTTPGet: &corev1.HTTPGetAction{
								Path: "health",
								Port: intstr.IntOrString{IntVal: 8080},
							},
						},
						InitialDelaySeconds: 5,
						PeriodSeconds:       3,
						FailureThreshold:    20,
					},
					LivenessProbe: &corev1.Probe{
						Handler: corev1.Handler{
							HTTPGet: &corev1.HTTPGetAction{
								Path: "health",
								Port: intstr.IntOrString{IntVal: 8080},
							},
						},
						InitialDelaySeconds: 60,
						PeriodSeconds:       60,
					},
				},
			},
		},
	}
}

// newServiceForCR returns a service that directs to the application pod
func newServiceForCR(cr *zenithrv1.ZenithrApp) *corev1.Service {
	labels := map[string]string{
		"app": cr.Name,
	}
	return &corev1.Service{
		ObjectMeta: metav1.ObjectMeta{
			Name:      cr.Name,
			Namespace: cr.Namespace,
			Labels:    labels,
		},
		Spec: corev1.ServiceSpec{
			Ports:     []corev1.ServicePort{
				{
					Name:       "http",
					Port:       8080,
				},
			},
			Selector:  labels,
		},
	}
}

func getJson(spec zenithrv1.ZenithrAppSpec) string {
	bytes, err := json.Marshal(spec)
	if err != nil {
		panic("Failed to parse input!")
	}
	return string(bytes)
}
