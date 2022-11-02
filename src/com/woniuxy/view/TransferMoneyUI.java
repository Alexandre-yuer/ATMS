package com.woniuxy.view;

import com.woniuxy.dao.AccountDaoImpl;
import com.woniuxy.dao.IAccountDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.woniuxy.view.InsertCardUI.cardNo;

public class TransferMoneyUI extends JFrame implements ActionListener {
    /**
     * 转账图层
     */
    private JTextField jtNo;
    private JTextField jtMoney;
    private JButton jButton;
    private JLabel jLabel;
    public TransferMoneyUI() {
        this.setBounds(200, 200, 300, 300);
        this.setTitle("转账页面");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        jtNo = new JTextField(15);
        jtMoney = new JTextField(5);
        jButton = new JButton("转账");
        JLabel jlNo = new JLabel("卡号:");
        JLabel jlMoney = new JLabel("转账金额:");
        jLabel = new JLabel();

        jButton.addActionListener(this);

        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = new JPanel();


//        jPanel.setLayout(new GridLayout(3, 1));
        jPanel1.add(jlNo);
        jPanel1.add(jtNo);
        jPanel2.add(jlMoney);
        jPanel2.add(jtMoney);
        jPanel4.add(jLabel);
        jPanel3.add(jButton);


        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel4);
        this.add(jPanel3);
        this.setLayout(new GridLayout(4,2));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IAccountDao iAccountDao = new AccountDaoImpl();
        if(Float.parseFloat(jtMoney.getText()) > 0){
            int cnt = iAccountDao.transferMoney(cardNo, jtNo.getText(), Float.parseFloat(jtMoney.getText()));
            if (cnt > 0) {
                new TransferSuccessUI();
            } else {
                new TransferFaileUI();
            }
        }else {
            jLabel.setText("请输入正确的转账金额");
        }
    }
}
