package com.woniuxy.view;

import javax.swing.*;

public class InsertFaileUI extends JFrame {
    public InsertFaileUI() {
        this.setBounds(200, 200, 250, 300);
        this.setTitle("温馨提示");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel jPanel = new JPanel();
        JLabel label = new JLabel("卡号或密码不正确,请重新输入!!!");
        jPanel.add(label);

        this.add(jPanel);
        this.setVisible(true);
    }
}
