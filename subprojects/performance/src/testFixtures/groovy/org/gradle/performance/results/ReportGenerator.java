/*
 * Copyright 2013 the original author or authors.
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

package org.gradle.performance.results;

import java.io.File;

public class ReportGenerator {
    void generate(final ResultsStore store, File outputDirectory) {
        try {
            HtmlRenderer htmlRenderer = new HtmlRenderer();
            htmlRenderer.render(store, new IndexPageGenerator(), new File(outputDirectory, "index.html"));
            for (String testName : store.getTestNames()) {
                htmlRenderer.render(store.getTestResults(testName), new TestPageGenerator(), new File(outputDirectory, testName.replaceAll("\\s+", "-") + ".html"));
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("Could not generate performance test report to '%s'.", outputDirectory), e);
        }
    }
}
