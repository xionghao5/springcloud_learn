package com.gua.gm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gua.gm.client.GmCustomerClient;
import com.gua.gm.client.GmProductClient;
import com.gua.gm.client.pojo.Customer;
import com.gua.gm.client.pojo.Product;
import com.gua.gm.entity.Order;
import com.gua.gm.entity.OrderLine;
import com.gua.gm.mapper.OrderLineMapper;
import com.gua.gm.mapper.OrderMapper;
import com.gua.gm.pojo.qo.OrderQO;
import com.gua.gm.pojo.qo.ProductQo;
import com.gua.gm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private GmCustomerClient gmCustomerClient;

    @Autowired
    private GmProductClient gmProductClient;

    @Override
    public Order addOrder(OrderQO orderQO) {


        Customer customer = gmCustomerClient.get(orderQO.getCusId());

        if (customer == null) {
            throw new RuntimeException("这个顾客不存在");
        }

        int totalMoney = 0;
        Map<Long,Integer> productIdAndSubMoneyMap =new HashMap<>();
        List<ProductQo> productQoList = orderQO.getProductQoList();
        for (ProductQo productQo : productQoList) {

            Long productId = productQo.getProductId();
            Product product = gmProductClient.get(productId);
            if (product == null) {
                throw new RuntimeException("这个商品不存在");
            }

            int subMoney = productQo.getCount() * product.getMoney();
            totalMoney = totalMoney + subMoney;

            productIdAndSubMoneyMap.put(productId,subMoney);
        }


        Order order = new Order();
        order.setCusId(orderQO.getCusId());
        order.setTotalMoney(totalMoney);
        this.baseMapper.insert(order);


        for (ProductQo productQo : orderQO.getProductQoList()) {
            OrderLine orderLine = new OrderLine();
            orderLine.setOrderId(order.getId());
            orderLine.setProductId(productQo.getProductId());
            orderLine.setCount(productQo.getCount());
            orderLine.setMoney(productIdAndSubMoneyMap.get(productQo.getProductId()));
            orderLineMapper.insert(orderLine);
        }
        return order;
    }
}
