/*
 * Copyright 1999-2018 tinntetuki Group Holding Ltd.
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
package com.tinntetuki.config;

/**
 * @author tinntetuki
 */
public class QuartzConfig {

    /*@Bean
    public JobDetail SymbolQuartz() {
        return JobBuilder.newJob(SymbolTask.class)
                .withIdentity("SymbolTask").storeDurably().build();
    }

    @Bean
    public Trigger CallSymbolQuartzTaskTrigger() {
        //5秒执行一次
        //创建触发器
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMinutes(1)
                .repeatForever();
        //cron方式，每天定时执行一次
        //这些星号由左到右按顺序代表 ：*    *    *    *    *    *   *
        //格式：                 [秒] [分] [小时] [日] [月] [周] [年]
*//*        return TriggerBuilder.newTrigger().forJob(SymbolQuartz())
                .withIdentity("CallPayQuartzTask")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 1/* * * * ?"))
                .build();*//*

        return TriggerBuilder.newTrigger().forJob(SymbolQuartz())
                .withIdentity("SymbolTask")
                .withSchedule(scheduleBuilder)
                .build();
    }*/
}
