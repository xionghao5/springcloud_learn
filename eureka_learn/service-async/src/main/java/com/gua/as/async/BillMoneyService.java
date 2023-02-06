package com.gua.as.async;


import com.gua.as.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class BillMoneyService {
    @Autowired
    private IBillService billService;

    @Async("threadPoolTaskExecutor")
    public Future<Integer> moneySum(String userId, Integer type) {
        Integer sum = billService.moneySum(userId, type);
        return new AsyncResult<>(sum);
    }
}
