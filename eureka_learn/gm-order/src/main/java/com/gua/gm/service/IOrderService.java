package com.gua.gm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gua.gm.entity.Order;
import com.gua.gm.pojo.qo.OrderQO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author auto-genergator
 * @since 2023-02-09
 */
public interface IOrderService extends IService<Order> {

    Order addOrder(OrderQO orderQO);
}
