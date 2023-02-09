package com.gua.gm.controller;


import com.gua.gm.entity.Order;
import com.gua.gm.pojo.qo.OrderQO;
import com.gua.gm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author auto-genergator
 * @since 2023-02-09
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("add")
    public Order addProductCategory(@RequestBody OrderQO orderQO) {
        return orderService.addOrder(orderQO);
    }


}

