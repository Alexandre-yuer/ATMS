package com.woniuxy.view;

import javax.swing.*;

public class OutMoneySuccessUI extends JFrame {
    public OutMoneySuccessUI() {
        this.setBounds(200, 200, 250, 300);
        this.setTitle("温馨提示");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel jPanel = new JPanel();
        JLabel label = new JLabel("取款成功");
        jPanel.add(label);

        this.add(jPanel);
        this.setVisible(true);
    }
}
