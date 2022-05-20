package com.batch.balance.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

@Slf4j
public class StepExecutionNotificationListener extends StepExecutionListenerSupport {

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
       log.info("afterStep");
        return super.afterStep(stepExecution);
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("beforeStep ");
        super.beforeStep(stepExecution);
    }

}