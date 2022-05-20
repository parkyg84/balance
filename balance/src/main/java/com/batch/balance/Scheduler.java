package com.batch.balance;

import com.batch.balance.job.ChunkBatchConfiguration;
import com.batch.balance.listener.JobCompletionNotificationListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Component
@RequiredArgsConstructor
public class Scheduler {
    
    
    //https://kitty-geno.tistory.com/91  --> jenkins 빌드
    //https://helloino.tistory.com/60   --> jenkins 스케쥴링 샘플
    //https://www.cloudbees.com/blog/how-to-schedule-a-jenkins-job
    //https://oingdaddy.tistory.com/237 -->jenkins job

    //https://techblog.lotteon.com/d-142cbbd5010

    private final JobLauncher jobLauncher;
    private final ChunkBatchConfiguration jobConfiguration;
    private final JobCompletionNotificationListener listener;
    private final Step stepChunk1;

    @Scheduled(initialDelay = 1000, fixedDelay =  1000 * 10)
    public void CopyJob(){

        JobExecution execution;

        try{
            log.info("start schedule Job~~~~~~~~~");
            //execution = jobLauncher.run(jobConfiguration.importUserJob(listener, stepChunk1) ,simpleJobParam());
            //log.info("Job finished with status : " + execution.getStatus());
            log.info("Current Thread : {}" + Thread.currentThread().getName());
            log.info("end schedule Job~~~~~~~~~");
        }
        catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }

    }

    private JobParameters simpleJobParam(){
        Map<String, JobParameter> confMap = new HashMap<>();
        confMap.put("time", new JobParameter(System.currentTimeMillis()));
        return new JobParameters(confMap);
    }


}
