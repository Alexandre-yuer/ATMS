package com.woniuxy.view;

import javax.swing.*;

public class OutMoneyFaileUI extends JFrame {
    public OutMoneyFaileUI() {
        this.setBounds(200, 200, 250, 300);
        this.setTitle("温馨提示");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel jPanel = new JPanel();
        JLabel label = new JLabel("取款失败,余额不足!!!");
        jPanel.add(label);

        this.add(jPanel);
        this.setVisible(true);
    }
}
