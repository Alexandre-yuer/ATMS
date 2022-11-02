package com.woniuxy.view;

import javax.swing.*;

public class TransferFaileUI extends JFrame {
    public TransferFaileUI() {
        this.setBounds(200, 200, 250, 300);
        this.setTitle("温馨提示");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel jPanel = new JPanel();
        JLabel label = new JLabel("您输入的账号有误或余额不足,请重新输入!!!");
        jPanel.add(label);

        this.add(jPanel);
        this.setVisible(true);
    }
}
