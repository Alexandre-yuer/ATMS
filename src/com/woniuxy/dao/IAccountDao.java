package com.woniuxy.dao;

import com.woniuxy.entity.Account;

public interface IAccountDao {
    /**
     * 开户
     */
    public int openAccount(String cardNo, String cardPwd);

    /**
     * 插卡
     */
    public String insertCard(String cardNo, String cardPwd);

    /**
     * 查询余额
     */
    public float selectMoney(String cardNo);

    /**
     * 存取款
     */
    public int updateMoney(String cardNo, float money);

    /**
     * 转账
     */
    public int transferMoney(String cardNo, String cardNoOther, float money);
}
