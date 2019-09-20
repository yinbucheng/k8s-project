package cn.bucheng.zuul.filter.config;
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

import cn.bucheng.zuul.filter.*;
import cn.bucheng.zuul.filter.base.DefaultFilterPipelineBuilder;
import cn.bucheng.zuul.filter.base.DefaultFilterPipeline;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author buchengyin
 * @create 2019/9/20 14:09
 * @describe
 */
@Configuration
public class DefaultPipelineConfiguration {


    @Bean
    public DefaultFilterPipeline pipeline() {
        DefaultFilterPipelineBuilder builder = new DefaultFilterPipelineBuilder();
        builder.addLast(new FirstPreFilter());
        builder.addLast(new EndPreFilter());
        builder.addLast(new FirstPostFilter());
        builder.addLast(new EndPostFilter());
        builder.addLast(new FirstErrorFilter());
        return builder.build();
    }
}
