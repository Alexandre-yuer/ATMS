package com.woniuxy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMUI extends JFrame implements ActionListener {
    /**
     * ATM图层
     */
    private JButton jbInsertCard;
    private JButton jbExit;

    public ATMUI() {
        this.setBounds(200, 200, 300, 100);
        this.setTitle("中国银行ATM自主存款一体机");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // 初始化控件
        jbInsertCard = new JButton("插卡");
        jbExit = new JButton("退出");

        //创建面板
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        //面板布局,网格布局
//        panel.setLayout(new GridLayout(2, 1));
        //网格布局


        panel1.add(jbInsertCard);
        panel2.add(jbExit);

        //注册监听事件
        jbInsertCard.addActionListener(this);
        jbExit.addActionListener(this);

        //将面板添加到窗口
        this.add(panel1);
        this.add(panel2);
        this.setLayout(new GridLayout(2,1));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbInsertCard) {
            new InsertCardUI();
        } else {
            System.exit(0);
        }
    }
}