package com.example.samplebatch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SampleBatchApplication

fun main(args: Array<String>) {
    runApplication<SampleBatchApplication>(*args)
}