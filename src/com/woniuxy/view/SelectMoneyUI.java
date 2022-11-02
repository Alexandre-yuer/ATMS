package com.woniuxy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectMoneyUI extends JFrame implements ActionListener {
    /**
     * 查询余额图层
     */
    private JLabel jLabel;

    public SelectMoneyUI(float money) {
        this.setBounds(200, 200, 250, 300);
        this.setTitle("查询余额页面");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // 初始化控件
        JLabel jlInMoney = new JLabel("账户余额为:");
        jLabel = new JLabel(money + "");
        //创建面板
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        //面板布局,网格布局
//        panel.setLayout(new GridLayout(2, 1));

        panel1.add(jlInMoney);
        panel2.add(jLabel);

        //将面板添加到窗口
        this.add(panel1);
        this.add(panel2);
        this.setLayout(new GridLayout(1,2));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
