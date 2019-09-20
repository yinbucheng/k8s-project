package cn.bucheng.zuul.filter.base;
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

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.lang.reflect.Field;

/**
 * @author buchengyin
 * @create 2019/9/20 14:00
 * @describe
 */
@Slf4j
public class DefaultFilterPipeline {
    private AbstractFilter first;
    private AbstractFilter current;

    public DefaultFilterPipeline addLast(AbstractFilter filter) {
        if (first == null) {
            first = current = filter;
            return this;
        }
        current.addLast(filter);
        current = filter;
        return this;
    }

    public void run(String type) {
        if (Strings.isBlank(type)) {
            log.warn("no type find ");
            return;
        }
        log.info("type is {}", type);
        for (AbstractFilter tempFilter = first; tempFilter != null; tempFilter = tempFilter.next()) {
            if (type.equals(tempFilter.filterType())) {
                if (tempFilter.shouldFilter()) {
                    tempFilter.run();
                }
            }
        }
    }

    @SneakyThrows
    protected void init() {
        for (AbstractFilter tempFilter = first; tempFilter != null; tempFilter = tempFilter.next()) {
            Field[] declaredFields = tempFilter.getClass().getDeclaredFields();
            if (declaredFields != null) {
                for (Field field : declaredFields) {
                    Autowired annotation = field.getAnnotation(Autowired.class);
                    if (annotation != null) {
                        field.setAccessible(true);
                        field.set(tempFilter, BeanFactoryAndEnvironmentUtils.getBean(field.getType()));
                        continue;
                    }

                    Value annotationValue = field.getAnnotation(Value.class);
                    if (annotationValue != null) {
                        field.setAccessible(true);
                        String value = annotationValue.value();
                        if (!value.startsWith("${")) {
                            field.set(tempFilter, value);
                            continue;
                        }
                        value = value.substring(2, value.length() - 1);
                        field.set(tempFilter, BeanFactoryAndEnvironmentUtils.getValue(value));
                        continue;
                    }

                    Resource resource = field.getAnnotation(Resource.class);
                    if (resource != null) {
                        field.setAccessible(true);
                        String name = resource.name();
                        field.set(tempFilter, BeanFactoryAndEnvironmentUtils.getBean(name));
                        continue;
                    }

                }
            }

        }
    }
}
