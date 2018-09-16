package com.wuyuan.spring.cloud.predicter.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wuyuan.spring.cloud.predicter.job.WeatherDataSyncJob;

@Configuration
public class QuartzConfiguration {
	static final int TIME=1000;
	//Jobdetail
	@Bean
	public JobDetail weatherSyncJobDetail(){
		return JobBuilder.newJob(WeatherDataSyncJob.class)
				.withIdentity("WeatherDataSyncJob")
				.storeDurably().build();
	}
	//Trigger
	@Bean
	public Trigger weatherSyncTrgger(){
		
		SimpleScheduleBuilder schedBuilder= SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(TIME)
				.repeatForever();
		return TriggerBuilder.newTrigger().forJob(weatherSyncJobDetail())
				.withIdentity("weatherSync").withSchedule(schedBuilder).build();
	}
}
