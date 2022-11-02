package com.woniuxy.entity;

public class Account {
    private String cardNo;
    private String cardPasswd;
    private float cardMoney;

    public Account() {
    }

    public Account(String cardNo, String cardPasswd, float cardMoney) {
        this.cardNo = cardNo;
        this.cardPasswd = cardPasswd;
        this.cardMoney = cardMoney;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardPasswd() {
        return cardPasswd;
    }

    public void setCardPasswd(String cardPasswd) {
        this.cardPasswd = cardPasswd;
    }

    public float getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(float cardMoney) {
        this.cardMoney = cardMoney;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cardNo='" + cardNo + '\'' +
                ", cardPasswd='" + cardPasswd + '\'' +
                ", cardMoney=" + cardMoney +
                '}';
    }
}
