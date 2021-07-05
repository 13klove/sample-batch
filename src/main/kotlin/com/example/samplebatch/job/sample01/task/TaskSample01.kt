package com.example.samplebatch.job.sample01.task

import mu.KLogging
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus

class TaskSample01: Tasklet {

    companion object: KLogging()

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        logger.info { "user logger: run Task" }
        return RepeatStatus.FINISHED
    }

}