package com.woniuxy.view;

import javax.swing.*;

public class TransferSuccessUI extends JFrame {
    public TransferSuccessUI() {
        this.setBounds(200, 200, 250, 300);
        this.setTitle("温馨提示");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel jPanel = new JPanel();
        JLabel label = new JLabel("转账成功");
        jPanel.add(label);

        this.add(jPanel);
        this.setVisible(true);
    }
}
