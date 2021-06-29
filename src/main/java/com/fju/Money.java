package com.fju;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Money {
    int one;
    int five;
    int ten;
    int money;

    public void setMoney(int inputMoney) {//應找金額硬幣數量
        money = inputMoney;
        ten = (int) inputMoney / 10;
        five = (int) (inputMoney - ten * 10) / 5;
        one = inputMoney - (ten * 10 + five * 5);
    }

    public void getMoney() {//印出硬幣數量
        System.out.println("退" + ten + "個10元硬幣");
        System.out.println("退" + five + "個5元硬幣");
        System.out.println("退" + one + "個1元硬幣");
        System.out.println("共退" + money + "元");
    }


}


