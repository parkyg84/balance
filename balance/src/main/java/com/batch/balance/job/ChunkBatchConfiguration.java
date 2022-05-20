package com.batch.balance.job;


import com.batch.balance.incrementer.CurrentTimeIncrementer;
import com.batch.balance.listener.JobCompletionNotificationListener;
import com.batch.balance.processor.ChunkTestItemProcessor;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스터디용
//https://cheese10yun.github.io/spring-batch-basic/

@Configuration
public class ChunkBatchConfiguration {

    private static final int chunkSize = 10;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public ChunkBatchConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean("mySqlBatchProcess")
    @StepScope
    public ItemProcessor mySqlBatchProcess() {
        return new ChunkTestItemProcessor();
    }


    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step stepChunk1) {
          return jobBuilderFactory
                .get("testChunkJob")
                .incrementer(new CurrentTimeIncrementer())
                .listener(listener)
                  //.start( stepChunk1)
                .flow( stepChunk1)
                .end()
                .build();
    }

    @Bean
    public Step stepChunk1(
            @Qualifier("myBatisPagingItemReader") MyBatisPagingItemReader myBatisPagingItemReader,
            @Qualifier("mySqlBatchProcess") ItemProcessor mySqlBatchProcess,
            @Qualifier("myBatisBatchItemWriter") MyBatisBatchItemWriter myBatisBatchItemWriter) {


        return stepBuilderFactory.get("stepChunk1")
                .chunk(chunkSize)
                .reader(myBatisPagingItemReader)
                .processor(mySqlBatchProcess)
                .writer(myBatisBatchItemWriter)
                .build();



//메타테이블 확인해봐야함!!
//대용량 데이터 이동 처리...속도 체크해봐야함!!
//skip, retry 등 예외처리 만들어봐야함!!
//https://medium.com/finnq-tech/spring-batch-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B3%A0-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-7319f810f808


    }
}
