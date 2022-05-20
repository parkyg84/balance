package com.batch.balance.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.listener.ChunkListenerSupport;
import org.springframework.batch.core.scope.context.ChunkContext;

@Slf4j
public class ChunkExecutionListener extends ChunkListenerSupport {

    @Override
    public void afterChunk(ChunkContext context) {

        log.info("ChunkExecutionListener afterChunk start");
        super.afterChunk(context);
    }

    @Override
    public void beforeChunk(ChunkContext context) {
        log.info("ChunkExecutionListener  beforeChunk start");
        context.attributeNames();
        super.beforeChunk(context);
    }

}