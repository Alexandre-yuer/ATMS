package com.woniuxy.view;

import javax.swing.*;

public class FaileUI extends JFrame {
    /**
     * 失败图层
     */
    public FaileUI() {
        this.setBounds(200, 200, 250, 300);
        this.setTitle("温馨提示");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel jPanel = new JPanel();
        JLabel label = new JLabel("请输入正确格式的密码");
        jPanel.add(label);

        this.add(jPanel);
        this.setVisible(true);
    }
}
