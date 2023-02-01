package com.gua.sa.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gua.sa.entity.Account;
import com.gua.sa.mapper.AccountMapper;
import com.gua.sa.service.IAccountService;
import io.seata.core.context.RootContext;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auto-genergator
 * @since 2023-01-31
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Override
    public void createAccount() {
        System.out.println("Seata全局事务id=================>{}" + RootContext.getXID());

        Account account = new Account();
        account.setUserId("1");
        account.setMoney(100);
        this.save(account);
    }
}
