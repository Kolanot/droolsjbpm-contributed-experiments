package benchmarks.dispatch.fact.derived;

/*
 * Copyright 2007 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import benchmarks.dispatch.fact.independent.Job;
import benchmarks.dispatch.fact.independent.Worker;

public class ScoreComponent extends Compatibility {

    private static final long serialVersionUID = 1L;

    public enum Type {
        LATE_TO_JOB, EXCESSIVE_DISTANCE_TO_JOB, DEFAULT
    }

    private Double contribution;
    private Type   type;

    public ScoreComponent(Job job,
                          Worker worker) {
        super( job,
               worker );
    }

    public void setContribution(Double scoreContribution) {
        this.contribution = scoreContribution;
    }

    public Double getContribution() {
        return contribution;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) return true;
        if ( !super.equals( obj ) ) return false;
        if ( getClass() != obj.getClass() ) return false;
        final ScoreComponent other = (ScoreComponent) obj;
        if ( type == null ) {
            if ( other.type != null ) return false;
        } else if ( !type.equals( other.type ) ) return false;
        return true;
    }

}
