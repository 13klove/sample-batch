package com.example.samplebatch.job.sample01.config

import com.example.samplebatch.job.sample01.task.TaskSample01
import mu.KLogging
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TaskSample01Config(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
) {

    companion object: KLogging(){
        const val NAME = "taskSample01"
    }

    @Bean
    fun taskSampleJob(): Job =
        jobBuilderFactory.get("${NAME}Job")
            .incrementer(RunIdIncrementer())
            .start(taskSampleStep())
            .build()

    @Bean
    fun taskSampleStep(): Step =
        stepBuilderFactory.get("${NAME}Step")
            .tasklet(TaskSample01())
            .build()

}