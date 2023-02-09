package com.gua.gm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gua.gm.entity.Order;
import com.gua.gm.entity.OrderLine;
import com.gua.gm.mapper.OrderLineMapper;
import com.gua.gm.mapper.OrderMapper;
import com.gua.gm.pojo.qo.OrderQO;
import com.gua.gm.pojo.qo.ProductQo;
import com.gua.gm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author auto-genergator
 * @since 2023-02-09
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private OrderLineMapper orderLineMapper;

    @Override
    public Order addOrder(OrderQO orderQO) {


        Order order = new Order();
        order.setCusId(orderQO.getCusId());
        int totalMoney = orderQO.getProductQoList().stream().mapToInt(ProductQo::getMoney).sum();
        order.setTotalMoney(totalMoney);
        this.baseMapper.insert(order);


        for (ProductQo productQo : orderQO.getProductQoList()) {
            OrderLine orderLine = new OrderLine();
            orderLine.setOrderId(order.getId());
            orderLine.setProductId(productQo.getProductId());
            orderLine.setCount(productQo.getCount());
            orderLine.setMoney(productQo.getMoney());
            orderLineMapper.insert(orderLine);
        }
        return order;
    }
}
