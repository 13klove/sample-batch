package com.example.samplebatch.job.sample02.config

import mu.KLogging
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.support.ListItemReader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StepLinkSample02Config(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
) {

    companion object: KLogging() {
        const val NAME = "stepLinkSample02"
        const val CHUNK = 100
    }

    @Bean
    fun stepLinkSample02Job(): Job =
        jobBuilderFactory.get("${NAME}Job")
            .incrementer(RunIdIncrementer())
            .start(stepLinkSample021Step())
            .next(stepLinkSample022Step())
            .build()

    @Bean
    fun stepLinkSample021Step(): Step =
        stepBuilderFactory.get("${NAME}Step021")
            .chunk<String, String>(CHUNK)
            .reader(reader021())
            .writer {
                it.forEach {
                    logger.info { "stepLinkSample021: $it" }
                }
            }
            .build()

    @Bean
    fun reader021(): ItemReader<String> = ListItemReader(listOf("a", "b", "c"))

    @Bean
    fun stepLinkSample022Step(): Step =
        stepBuilderFactory.get("${NAME}Step022")
            .chunk<String, String>(CHUNK)
            .reader(reader022())
            .writer {
                it.forEach {
                    logger.info { "stepLinkSample022: $it" }
                }
            }
            .build()

    @Bean
    fun reader022(): ItemReader<String> = ListItemReader(listOf("e", "f", "g"))
}