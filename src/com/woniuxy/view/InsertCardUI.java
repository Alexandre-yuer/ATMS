package com.woniuxy.view;

import com.woniuxy.dao.AccountDaoImpl;
import com.woniuxy.dao.IAccountDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertCardUI extends JFrame implements ActionListener {
    /**
     * 插卡
     */
    private JTextField jtNo;
    private JTextField jtPwd;
    private JButton jButton;
    public static String cardNo;

    public InsertCardUI() {
        this.setBounds(200, 200, 300, 300);
        this.setTitle("请输入卡号和密码");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        jtNo = new JTextField(15);
        jtPwd = new JTextField(5);
        jButton = new JButton("登录");
        JLabel jlNo = new JLabel("卡号:");
        JLabel jlPwd = new JLabel("密码:");

        jButton.addActionListener(this);

        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();


//        jPanel.setLayout(new GridLayout(3, 1));
        jPanel1.add(jlNo);
        jPanel1.add(jtNo);
        jPanel2.add(jlPwd);
        jPanel2.add(jtPwd);
        jPanel3.add(jButton);

        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.setLayout(new GridLayout(3,2));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IAccountDao iAccountDao = new AccountDaoImpl();
        if (e.getSource() == jButton) {
            cardNo = iAccountDao.insertCard(jtNo.getText(), jtPwd.getText());
            if (cardNo != null) {
                new ATMInUI();
            } else {
                new InsertFaileUI();
            }
        }
    }
}
