package com.woniuxy.test;

import com.woniuxy.dao.AccountDaoImpl;
import com.woniuxy.dao.IAccountDao;
import org.junit.Test;

public class JTest {
    IAccountDao iAccountDao = new AccountDaoImpl();

    @Test
    public void test() {
        int cnt = iAccountDao.transferMoney("123456789987654321", "271515893857178668", 1000);
        System.out.println(cnt);
    }
}
