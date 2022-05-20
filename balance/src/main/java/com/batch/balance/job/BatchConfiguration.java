package com.batch.balance.job;


import com.batch.balance.listener.ChunkExecutionListener;
import com.batch.balance.listener.JobCompletionNotificationListener;
import com.batch.balance.listener.StepExecutionNotificationListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class BatchConfiguration extends DefaultBatchConfigurer {

    @Override
    public void setDataSource(DataSource dataSource) {}

    @Bean
    public StepExecutionNotificationListener stepExecutionListener() {
        return new StepExecutionNotificationListener();
    }

    @Bean
    public ChunkExecutionListener chunkListener() {
        return new ChunkExecutionListener();
    }

    @Bean
    public JobCompletionNotificationListener jobExecutionListener() {
        return new JobCompletionNotificationListener();
    }

}
