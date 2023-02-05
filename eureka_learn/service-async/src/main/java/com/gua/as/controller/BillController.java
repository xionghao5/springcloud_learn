package com.gua.as.controller;


import com.gua.as.async.BillMoneyService;
import com.gua.as.async.BillMoneySumAsyncService;
import com.gua.as.entity.Bill;
import com.gua.as.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author auto-genergator
 * @since 2023-02-05
 */
@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillMoneySumAsyncService orderAsyncService;

    @Autowired
    private IBillService billService;

    @GetMapping("/testInsert")
    public Bill testInsert(String userId, Integer type, Integer money) {
        Bill bill = new Bill();
        bill.setUserId(userId);
        bill.setType(type);
        bill.setMoney(money);
        billService.save(bill);
        return bill;
    }

    @GetMapping("/testSum")
    public Integer testSum(String userId, Integer type) {
        return billService.moneySum(userId, type);
    }


    /**
     * 测试多线程查询数据库，并汇总多线程查询结果，提高查询效率
     *
     * @param userId
     * @return
     */
    @GetMapping("/testAsync")
    public Integer testAsync(String userId) {
        try {
            return orderAsyncService.testAsync(userId);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

