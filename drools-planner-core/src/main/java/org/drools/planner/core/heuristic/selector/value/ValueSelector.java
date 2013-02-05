/*
 * Copyright 2012 JBoss Inc
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

package org.drools.planner.core.heuristic.selector.value;

import java.util.Iterator;

import org.drools.planner.api.domain.value.ValueRange;
import org.drools.planner.api.domain.variable.PlanningVariable;
import org.drools.planner.core.domain.variable.PlanningVariableDescriptor;
import org.drools.planner.core.heuristic.selector.IterableSelector;
import org.drools.planner.core.heuristic.selector.Selector;

/**
 * Selects values from the {@link ValueRange) for a {@link PlanningVariable} annotated property.
 * @see AbstractValueSelector
 */
public interface ValueSelector extends Selector  {

    /**
     * Similar to {@link IterableSelector#getSize()}, but requires an entity.
     * @param entity never null
     * @return the approximate number of elements generated by this {@link Selector}, always >= 0
     * @throws IllegalStateException if {@link #isContinuous} returns true,
     * but not if only {@link #isNeverEnding()} returns true
     */
    long getSize(Object entity);

    /**
     * Similar to {@link IterableSelector#iterator()}, but requires an entity.
     * @param entity never null
     * @return never null
     */
    Iterator<Object> iterator(Object entity);

    /**
     * @return never null
     */
    PlanningVariableDescriptor getVariableDescriptor();

}
