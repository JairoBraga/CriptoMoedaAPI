package com.workshop.teste.job;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {
	
	@Bean
	public JobDetail jobQuartzDetail() {
		return JobBuilder.newJob(BatchScheduleJob.class).storeDurably().build();
	}
	
	@Bean
	public Trigger jobTrigger() {
		 return TriggerBuilder.newTrigger()
				    .withIdentity("trigger")
				    .forJob(jobQuartzDetail())
				    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 7,17 ? * * *"))
				    .build();
	}
}
