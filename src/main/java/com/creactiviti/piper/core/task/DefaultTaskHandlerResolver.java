/*
 * Copyright 2016-2018 the original author or authors.
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
package com.creactiviti.piper.core.task;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class DefaultTaskHandlerResolver implements TaskHandlerResolver {

  private Map<String, TaskHandler<?>> taskHandlers = new HashMap<String, TaskHandler<?>>();
  
  @Override
  public TaskHandler<?> resolve(Task aJobTask) {
    TaskHandler<?> taskHandler = taskHandlers.get(aJobTask.getType());
    Assert.notNull(taskHandler,"Unknown task handler: " + aJobTask.getType());
    return taskHandler;
  }

  @Autowired(required=false)
  public void setTaskHandlers(Map<String, TaskHandler<?>> aTaskHandlers) {
    taskHandlers = aTaskHandlers;
  }
  
}