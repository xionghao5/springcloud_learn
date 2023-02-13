package com.gua.gm.controller;


import com.gua.gm.client.GmCustomerClient;
import com.gua.gm.client.GmProductClient;
import com.gua.gm.client.pojo.Customer;
import com.gua.gm.client.pojo.Product;
import com.gua.gm.entity.Order;
import com.gua.gm.pojo.qo.OrderQO;
import com.gua.gm.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author auto-genergator
 * @since 2023-02-09
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单模块相关接口")
public class OrderController {

    @Autowired
    private IOrderService orderService;


    @Autowired
    private GmCustomerClient gmCustomerClient;

    @Autowired
    private GmProductClient gmProductClient;

    @PostMapping("add")
    @ApiOperation(value = "新增订单", notes = "根据顾客和商品创建订单")
    @ApiImplicitParam(value = "orderQO", dataType = "orderQO", name = "订单请求参数对象", required = true)
    public Order addProductCategory(@RequestBody @Valid OrderQO orderQO) {
        return orderService.addOrder(orderQO);
    }


    @GetMapping("testFeign")
    public Customer testFeign(Long cusId) {
        return gmCustomerClient.get(cusId);
    }

    @GetMapping("testFeignProduct")
    public Product testFeignProduct(Long productId) {
        return gmProductClient.get(productId);
    }

}

