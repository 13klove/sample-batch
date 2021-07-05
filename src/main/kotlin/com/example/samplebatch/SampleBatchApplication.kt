package com.example.samplebatch

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableBatchProcessing
class SampleBatchApplication

fun main(args: Array<String>) {
	runApplication<SampleBatchApplication>(*args)
}
