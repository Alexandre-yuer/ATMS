package com.woniuxy.view;

import com.woniuxy.dao.AccountDaoImpl;
import com.woniuxy.dao.IAccountDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.woniuxy.view.InsertCardUI.cardNo;

public class ATMInUI extends JFrame implements ActionListener {

    /**
     * ATM图层
     */
    private JButton jbInMoney;
    private JButton jbOutMoney;
    private JButton jbSelectMoney;
    private JButton jbTransferMoney;
    private JButton jbExit;

    public ATMInUI() {
        this.setBounds(400, 400, 500, 600);
        this.setTitle("中国银行ATM自主存款一体机");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // 初始化控件
        jbInMoney = new JButton("存款");
        jbOutMoney = new JButton("取款");
        jbSelectMoney = new JButton("查余额");
        jbTransferMoney = new JButton("转账");
        jbExit = new JButton("退卡");

        //创建面板
        JPanel panel = new JPanel();
        //面板布局,网格布局
        panel.setLayout(new GridLayout(5, 1));
        //网格布局
//        panel.setLayout(new BorderLayout());

        panel.add(jbInMoney);
        panel.add(jbOutMoney);
        panel.add(jbSelectMoney);
        panel.add(jbTransferMoney);
        panel.add(jbExit);


        //注册监听事件
        jbInMoney.addActionListener(this);
        jbOutMoney.addActionListener(this);
        jbSelectMoney.addActionListener(this);
        jbTransferMoney.addActionListener(this);
        jbExit.addActionListener(this);

        //将面板添加到窗口
        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbInMoney) {
            new InMoneyUI();
        } else if (e.getSource() == jbOutMoney) {
            new OutMoneyUI();
        } else if (e.getSource() == jbSelectMoney) {
            IAccountDao iAccountDao = new AccountDaoImpl();
            float money = iAccountDao.selectMoney(cardNo);
            new SelectMoneyUI(money);
        } else if (e.getSource() == jbTransferMoney) {
            new TransferMoneyUI();
        } else {
            System.exit(0);
        }
    }
}
