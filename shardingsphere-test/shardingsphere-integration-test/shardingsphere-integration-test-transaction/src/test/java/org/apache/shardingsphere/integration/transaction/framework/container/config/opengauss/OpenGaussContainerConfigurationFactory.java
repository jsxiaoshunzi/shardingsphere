/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.integration.transaction.framework.container.config.opengauss;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.test.integration.env.container.atomic.storage.config.StorageContainerConfiguration;

import java.util.Collections;
import java.util.Map;

/**
 * OpenGauss container configuration factory.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OpenGaussContainerConfigurationFactory {
    
    /**
     * Create new instance of openGauss container configuration.
     *
     * @return created instance
     */
    public static StorageContainerConfiguration newInstance() {
        return new StorageContainerConfiguration(getCommand(), getContainerEnvironments(), getMountedResources());
    }
    
    private static String getCommand() {
        return "--max_connections=600 --max_prepared_transactions=600";
    }
    
    private static Map<String, String> getContainerEnvironments() {
        return Collections.singletonMap("GS_PASSWORD", "Test@123");
    }
    
    private static Map<String, String> getMountedResources() {
        return Collections.singletonMap("/env/postgresql/postgresql.conf", "/usr/local/opengauss/share/postgresql/postgresql.conf.sample");
    }
}
