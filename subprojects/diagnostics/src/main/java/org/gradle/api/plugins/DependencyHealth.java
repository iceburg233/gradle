/*
 * Copyright 2020 the original author or authors.
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

package org.gradle.api.plugins;

import org.gradle.api.Action;
import org.gradle.api.model.ObjectFactory;

import javax.inject.Inject;

public class DependencyHealth {
    private final DependencyHealthSuppression suppression;

    @Inject
    public DependencyHealth(ObjectFactory objectFactory) {
        this.suppression = objectFactory.newInstance(DependencyHealthSuppression.class);
    }

    public DependencyHealthSuppression getSuppressed() {
        return suppression;
    }

    public void suppress(Action<DependencyHealthSuppression> action) {
        action.execute(getSuppressed());
    }
}
