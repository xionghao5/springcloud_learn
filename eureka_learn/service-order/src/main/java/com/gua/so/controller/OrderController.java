package com.gua.so.controller;


import com.gua.so.entity.Order;
import com.gua.so.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author auto-genergator
 * @since 2023-01-31
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/getAll")
    public List<Order> getAll(){
        return orderService.list();
    }

    @GetMapping("/create")
    public void create(){
        orderService.createOrder();
    }

    @GetMapping("/testSeata")
    public void testSeata(){
        orderService.testSeata();
    }

}

