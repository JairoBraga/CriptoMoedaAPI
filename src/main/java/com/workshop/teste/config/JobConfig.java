package com.workshop.teste.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilder;
	
	@Autowired
	private StepBuilderFactory stepBuilder;
	
	@Bean
	public Job job() {
		return this.jobBuilder.get("JobQuartz").incrementer(new RunIdIncrementer()).start(step()).build();
	}

	private Step step() {
		return this.stepBuilder.get("Step Agendado").tasklet((stepContribution, chunkContext) -> {
			System.out.println("Processo de atualização das criptmoedas iniciado!");
			return RepeatStatus.FINISHED;
		}).build();
	}
}
