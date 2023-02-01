package com.gua.sa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gua.sa.entity.Account;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author auto-genergator
 * @since 2023-01-31
 */
public interface IAccountService extends IService<Account> {

    void createAccount();
}
