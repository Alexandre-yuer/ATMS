package com.woniuxy.view;

import com.woniuxy.utils.NoGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.woniuxy.view.OpenAccountUI.s;

public class SuccessUI extends JFrame {
    /**
     * 成功图层
     * @param s
     */
    public SuccessUI() {
        this.setBounds(200, 200, 250, 300);
        this.setTitle("温馨提示");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel jPanel = new JPanel();
        JLabel label1 = new JLabel("注册成功");
        JLabel label2 = new JLabel("您的卡号为:" + s);
        s = NoGenerator.generatorNo();
        jPanel.add(label1);
        jPanel.add(label2);

        this.add(jPanel);
        this.setVisible(true);
    }
}
