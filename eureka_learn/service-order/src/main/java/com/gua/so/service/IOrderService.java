package com.gua.so.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gua.so.entity.Order;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author auto-genergator
 * @since 2023-01-31
 */
public interface IOrderService extends IService<Order> {

    void createOrder();

    void testSeata();
}
