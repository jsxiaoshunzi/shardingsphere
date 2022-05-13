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

package org.apache.shardingsphere.infra.executor.sql.hook;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.spi.ShardingSphereServiceLoader;

import java.util.Collection;

/**
 * SQL Execution hook factory.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SQLExecutionHookFactory {
    
    static {
        ShardingSphereServiceLoader.register(SQLExecutionHook.class);
    }
    
    /**
     * Get all instances of SQL Execution hook.
     *
     * @return got instances
     */
    public static Collection<SQLExecutionHook> getAllInstances() {
        return ShardingSphereServiceLoader.getServiceInstances(SQLExecutionHook.class);
    }
}