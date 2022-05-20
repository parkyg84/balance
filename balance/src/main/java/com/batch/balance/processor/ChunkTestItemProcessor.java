package com.batch.balance.processor;

import com.batch.balance.domain.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class ChunkTestItemProcessor implements ItemProcessor<Order,Order> {
    
    @Override
    public Order process(Order item) throws Exception {
        log.debug("process~~~");
        log.debug(item.toString());

        return item;
    }

}
