package com.woniuxy.dao;

import com.woniuxy.entity.Account;
import com.woniuxy.utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl extends BaseDao implements IAccountDao {
    @Override
    public int openAccount(String cardNo, String cardPwd) {
        String sql = "insert into t_atm (card_no,card_pwd,card_money) values('" + cardNo + "','" + cardPwd + "',1000)";
        return this.excuteUpdate(sql);
    }

    @Override
    public String insertCard(String No, String Pwd) {
        String cardNo = null;
        String sql = "select * from t_atm where card_no = '" + No + "' and card_pwd = '" + Pwd + "'";
        ResultSet rs = this.excuteQuery(sql);
        try {
            if (rs.next()) {
                cardNo = rs.getString("card_no");
            }
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardNo;
    }

    @Override
    public float selectMoney(String cardNo) {
        float money = 0f;
        String sql = "select card_money from t_atm where card_no = '" + cardNo + "'";
        ResultSet rs = this.excuteQuery(sql);
        try {
            if (rs.next()) {
                money = rs.getFloat("card_money");
            }
            this.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return money;
    }

    @Override
    public int updateMoney(String cardNo, float money) {
        int cnt = 0;
        String sql = "update t_atm set card_money = card_money + " + money + " where card_no = '" + cardNo + "'";
        if (money > 0) {
            cnt = this.excuteUpdate(sql);
        } else {
            float selectMoney = this.selectMoney(cardNo);
            if (selectMoney >= -money) {
                cnt = this.excuteUpdate(sql);
            } else {
                cnt = -1;
            }
        }
        return cnt;
    }

    @Override
    public int transferMoney(String cardNo, String cardNoOther, float money) {
        int cnt = 0;
        Connection connection = this.getConnection();
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        try {
            // 关闭自动提交,开始事务;
            connection.setAutoCommit(false);
            if(money < selectMoney(cardNo)){
                String sql1 = "update t_atm set card_money = card_money - " + money + " where card_no = '" + cardNo + "' ";
                String sql2 = "update t_atm set card_money = card_money + " + money + " where card_no = '" + cardNoOther + "' ";
                pst1 = connection.prepareStatement(sql1);
                pst2 = connection.prepareStatement(sql2);
                int cnt1 = pst1.executeUpdate();
                int x = 1/0;
                int cnt2 = pst2.executeUpdate();
                if (cnt1 > 0 && cnt2 > 0) {
                    cnt = 1;
                }
            }else{
                cnt = -1;
            }
            // 提交
            connection.commit();
        } catch (Exception e) {
            try {
                // 如果转账存在异常,进行回滚,避免一方账户金额发生错误变化
                connection.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                // 关闭事务
                connection.setAutoCommit(true);
                // 关闭连接
                pst1.close();
                pst2.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cnt;
    }
}
//1
//2
