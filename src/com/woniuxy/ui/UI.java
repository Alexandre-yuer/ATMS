package com.woniuxy.ui;

import com.woniuxy.dao.AccountDaoImpl;
import com.woniuxy.dao.IAccountDao;
import com.woniuxy.utils.NoGenerator;

import java.util.Scanner;

public class UI {
    public void menu() {
        IAccountDao iAccountDao = new AccountDaoImpl();
        String cardNo = "";
        while (true) {
            System.out.println("1.开户 2.插卡 3.退出");
            int opt = new Scanner(System.in).nextInt();
            switch (opt) {
                case 1:
                    System.out.println("请输入密码:");
                    String pwd = new Scanner(System.in).next();
                    if (pwd.length() <= 6) {
                        String s = NoGenerator.generatorNo();
                        int cnt = iAccountDao.openAccount(s, pwd);
                        if (cnt > 0) {
                            System.out.println("开户成功,您的卡号为:" + s);
                        } else {
                            System.out.println("开户失败");
                        }
                    } else {
                        System.out.println("请您输入一个小于等于6位数的密码");
                    }
                    break;
                case 2:
                    System.out.println("请输入卡号:");
                    String no = new Scanner(System.in).next();
                    System.out.println("请输入密码:");
                    String passwd = new Scanner(System.in).next();
                    cardNo = iAccountDao.insertCard(no, passwd);
                    if (cardNo == null) {
                        System.out.println("密码输入错误,请重新输入");
                    } else {
                        while (true) {
                            System.out.println("1.查询余额 2.存款 3.取款 4.退出");
                            int choose = new Scanner(System.in).nextInt();
                            switch (choose) {
                                case 1:
                                    float money = iAccountDao.selectMoney(cardNo);
                                    System.out.println("账户余额:" + money);
                                    break;
                                case 2:
                                    System.out.println("请输入存款金额:");
                                    float moneyIn = new Scanner(System.in).nextFloat();
                                    int cnt = iAccountDao.updateMoney(cardNo, moneyIn);
                                    if (cnt > 0) {
                                        System.out.println("存款成功");
                                    } else {
                                        System.out.println("存款失败");
                                    }
                                    break;
                                case 3:
                                    System.out.println("请输入取款金额:");
                                    float moneyOut = new Scanner(System.in).nextFloat();
                                    int cnt1 = iAccountDao.updateMoney(cardNo, moneyOut);
                                    if (cnt1 > 0) {
                                        System.out.println("取款成功");
                                    } else if (cnt1 == -1) {
                                        System.out.println("余额不足");
                                    } else {
                                        System.out.println("取款失败");
                                    }
                                    break;
                                case 4:
                                    System.exit(0);
                                default:
                                    System.out.println("您的输入有误,请重新输入");
                                    break;
                            }
                        }
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("您的输入有误,请重新输入");
                    break;
            }
        }
    }
}
