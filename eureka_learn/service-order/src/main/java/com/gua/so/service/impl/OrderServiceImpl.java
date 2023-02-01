package com.gua.so.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gua.so.entity.Order;
import com.gua.so.feign.client.ServiceAccountClient;
import com.gua.so.mapper.OrderMapper;
import com.gua.so.service.IOrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author auto-genergator
 * @since 2023-01-31
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {


    @Autowired
    private ServiceAccountClient serviceAccountClient;

    @Override
    public void createOrder() {

        serviceAccountClient.accountCreate();

        orderCreate();


    }

    private void orderCreate() {
        Order order = new Order();
        order.setUserId("1");
        order.setCount(1);
        order.setCommodityCode("001");
        order.setMoney(100);
        this.save(order);
    }

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void testSeata() {

        System.out.println("Seata全局事务id=================>{}" + RootContext.getXID());


        serviceAccountClient.accountCreate();

        Boolean flag = true;
        if (flag) {
            throw new RuntimeException();
        }

        orderCreate();


    }
}
