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

package org.apache.shardingsphere.infra.yaml.config.pojo.data.pipeline;

import lombok.Data;
import org.apache.shardingsphere.infra.util.yaml.YamlConfiguration;
import org.apache.shardingsphere.infra.yaml.config.pojo.algorithm.YamlAlgorithmConfiguration;

/**
 * YAML pipeline write configuration.
 */
@Data
public final class YamlPipelineWriteConfiguration implements YamlConfiguration {
    
    private static final Integer DEFAULT_WORKER_THREAD = 40;
    
    private static final Integer DEFAULT_BATCH_SIZE = 1000;
    
    private Integer workerThread = DEFAULT_WORKER_THREAD;
    
    private Integer batchSize = DEFAULT_BATCH_SIZE;
    
    private YamlAlgorithmConfiguration rateLimiter;
    
    /**
     * Build with default value.
     *
     * @return write configuration
     */
    public static YamlPipelineWriteConfiguration buildWithDefaultValue() {
        return new YamlPipelineWriteConfiguration();
    }
    
    /**
     * Fill in null fields with default value.
     */
    public void fillInNullFieldsWithDefaultValue() {
        if (null == workerThread) {
            workerThread = DEFAULT_WORKER_THREAD;
        }
        if (null == batchSize) {
            batchSize = DEFAULT_BATCH_SIZE;
        }
    }
    
    /**
     * Copy non-null fields from another.
     *
     * @param another another configuration
     */
    public void copyNonNullFields(final YamlPipelineWriteConfiguration another) {
        if (null == another) {
            return;
        }
        if (isAllFieldsNull(another)) {
            setAllFieldsNull(this);
        }
        if (null != another.workerThread) {
            workerThread = another.workerThread;
        }
        if (null != another.batchSize) {
            batchSize = another.batchSize;
        }
        if (null != another.rateLimiter) {
            rateLimiter = another.rateLimiter;
        }
    }
    
    private boolean isAllFieldsNull(final YamlPipelineWriteConfiguration config) {
        return null == config.workerThread && null == config.batchSize && null == config.rateLimiter;
    }
    
    private void setAllFieldsNull(final YamlPipelineWriteConfiguration config) {
        config.workerThread = null;
        config.batchSize = null;
        config.rateLimiter = null;
    }
}
