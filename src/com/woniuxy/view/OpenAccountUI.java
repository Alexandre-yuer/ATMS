package com.woniuxy.view;

import com.woniuxy.dao.AccountDaoImpl;
import com.woniuxy.dao.IAccountDao;
import com.woniuxy.utils.NoGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class OpenAccountUI extends JFrame implements ActionListener {
    /**
     * 开户图层
     */
    private JTextField jtNo;
    private JTextField jtPwd;
    private JButton jButton;
    private JLabel jlPwd3;
    public static String s = NoGenerator.generatorNo();
    public OpenAccountUI() {
        this.setBounds(200, 200, 300, 300);
        this.setTitle("开户");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

//        jtNo = new JTextField(15);
        jtPwd = new JTextField(5);
        jButton = new JButton("开户");
//        JLabel jlNo = new JLabel("卡号:");
        JLabel jlPwd1 = new JLabel("请输入您的注册密码");
        JLabel jlPwd2 = new JLabel("密码:");
        jlPwd3 = new JLabel();


        jButton.addActionListener(this);

        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = new JPanel();
//        jPanel.setLayout(new GridLayout(3, 1));
        jPanel1.add(jlPwd1);
//        jPanel1.add(jtNo);
//        jPanel2.add(jlPwd1);
        jPanel2.add(jlPwd2);
        jPanel2.add(jtPwd);
        jPanel3.add(jlPwd3);
        jPanel4.add(jButton);

        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(jPanel4);
        this.setLayout(new GridLayout(4,1));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IAccountDao iAccountDao = new AccountDaoImpl();
        if (e.getSource() == jButton) {
            if(jtPwd.getText().equals("") && jtPwd.getText().length() <=6){
//                jtPwd.setText();
                jlPwd3.setText("请输入正确格式的密码");
            }else{
                int cnt = iAccountDao.openAccount(s, jtPwd.getText());
                if (cnt > 0) {
                    new SuccessUI();
                } else {
                    new FaileUI();
                }
            }

        }
    }
}
