package com.gua.as.async;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class BillMoneySumAsyncService {

    @Autowired
    private BillMoneyService billMoneyService;


    /**
     * 多线程查询数据库，并合并数据库查询结果并返回
     *
     * 1.需要配置线程池
     * 2.设置@EnableAsync注解
     * 3.在需要多线程执行的方法上使用@Async注解,并且方法返回Future<T>
     * 4.不断轮询Future的状态，等待所有线程执行完，并返回所有线程结果
     * 5.聚合所有线程结果并返回
     * @param userId
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public Integer testAsync(String userId) throws ExecutionException, InterruptedException {

        Future<Integer> future1 = billMoneyService.moneySum(userId, 0);
        Future<Integer> future2 = billMoneyService.moneySum(userId, 1);

        List<Future<Integer>> futureList = new ArrayList<>();
        futureList.add(future1);
        futureList.add(future2);


        List<Integer> resultList = new ArrayList<>();
        //查询任务执行的结果
        for (Future<Integer> future : futureList) {
            while (true) {//CPU高速轮询：每个future都并发轮循，判断完成状态然后获取结果，这一行，是本实现方案的精髓所在。即有10个future在高速轮询，完成一个future的获取结果，就关闭一个轮询
                if (future.isDone() && !future.isCancelled()) { //获取future成功完成状态，如果想要限制每个任务的超时时间，取消本行的状态判断+future.get(1000*1, TimeUnit.MILLISECONDS)+catch超时异常使用即可。
                    Integer result = future.get();//获取结果
                    resultList.add(result);
                    break;//当前future获取结果完毕，跳出while
                } else {
                    Thread.sleep(1);//每次轮询休息1毫秒（CPU纳秒级），避免CPU高速轮循耗空CPU---》新手别忘记这个
                }
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).sum();
    }
}
