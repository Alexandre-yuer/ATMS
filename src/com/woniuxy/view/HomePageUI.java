package com.woniuxy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageUI extends JFrame implements ActionListener {
    /**
     * 登录图层
     */
    private JButton jbOpenAccount;
    private JButton jbUpdateMoney;
    private JButton jbExit;

    public HomePageUI() {
        this.setBounds(200, 200, 250, 300);
        this.setTitle("欢迎光临中国银行");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // 初始化控件
        jbOpenAccount = new JButton("开户");
        jbUpdateMoney = new JButton("存/取款");
        jbExit = new JButton("退出");

        //创建面板
        JPanel panel = new JPanel();
        //面板布局,网格布局
        panel.setLayout(new GridLayout(3, 1));

        panel.add(jbOpenAccount);
        panel.add(jbUpdateMoney);
        panel.add(jbExit);

        //注册监听事件
        jbOpenAccount.addActionListener(this);
        jbUpdateMoney.addActionListener(this);
        jbExit.addActionListener(this);

        //将面板添加到窗口
        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbOpenAccount) {
            new OpenAccountUI();
        } else if (e.getSource() == jbUpdateMoney) {
            new ATMUI();
        } else {
            System.exit(0);
        }
    }
}
