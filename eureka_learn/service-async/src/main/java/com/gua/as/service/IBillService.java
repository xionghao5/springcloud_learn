package com.gua.as.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gua.as.entity.Bill;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author auto-genergator
 * @since 2023-02-05
 */
public interface IBillService extends IService<Bill> {

    Integer moneySum(String userId, Integer type);

}
