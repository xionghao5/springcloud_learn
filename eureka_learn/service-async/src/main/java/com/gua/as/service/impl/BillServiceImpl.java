package com.gua.as.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gua.as.entity.Bill;
import com.gua.as.mapper.BillMapper;
import com.gua.as.service.IBillService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auto-genergator
 * @since 2023-02-05
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements IBillService {

    @Override
    public Integer moneySum(String userId, Integer type) {
        QueryWrapper<Bill> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Bill.USER_ID,userId);
        queryWrapper.eq(Bill.TYPE,type);
        List<Bill> orderList = this.baseMapper.selectList(queryWrapper);
        return orderList.stream().mapToInt(Bill::getMoney).sum();
    }
}
