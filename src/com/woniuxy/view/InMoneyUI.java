package com.woniuxy.view;

import com.woniuxy.dao.AccountDaoImpl;
import com.woniuxy.dao.IAccountDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.woniuxy.view.InsertCardUI.cardNo;

public class InMoneyUI extends JFrame implements ActionListener {
    /**
     * 存款图层
     */
    private JButton jbInMoney;
    private JTextField jtInMoney;

    public InMoneyUI() {
        this.setBounds(200, 200, 250, 300);
        this.setTitle("存款页面");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // 初始化控件
        jbInMoney = new JButton("存款");
        JLabel jlInMoney = new JLabel("请输入存款金额:");
        jtInMoney = new JTextField(5);
        //创建面板
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        //面板布局,网格布局
//        panel.setLayout(new GridLayout(3, 1));

        panel1.add(jlInMoney);
        panel1.add(jtInMoney);
        panel2.add(jbInMoney);

        //注册监听事件
        jbInMoney.addActionListener(this);

        //将面板添加到窗口
        this.add(panel1);
        this.add(panel2);
        this.setLayout(new GridLayout( 2,1));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IAccountDao iAccountDao = new AccountDaoImpl();
        if (e.getSource() == jbInMoney) {
            int cnt = iAccountDao.updateMoney(cardNo, Float.parseFloat(jtInMoney.getText()));
            if (cnt > 0) {
                new InMoneySuccessUI();
            } else {
                new InMoneyFaileUI();
            }
        }
    }
}
