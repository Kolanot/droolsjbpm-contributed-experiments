/*
 * Copyright 2008 Red Hat
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
 *
 */
package org.drools.examples.lotrc.model;

/**
 * Represents a card in the game
 * 
 * @author etirelli
 */
public interface Card extends Model {

    public Allegiance getAllegiance();
    
    public CardName getName();

    public CardAbility getAbility();

    public int getPower();
    
    public CardStatus getStatus();
    
    public void setStatus( CardStatus status );

}
