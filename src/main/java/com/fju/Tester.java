package com.fju;

import java.awt.event.MouseListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        int buy;
        String keep ="F";
        Product[] products = {new Product1(), new Product2(), new Product3(), new Product4(), new Product5()};
        Money money = new  Money();
        Scanner scanner = new Scanner(System.in);
        System.out.println("~~Welcome to vending machine~~");
        System.out.println("═════════════ MENU ═════════════");
        //輸出menu
        for (Product product : products) {
            System.out.println(product.getId()+")"+product.getName() + " \t " + product.getPrice()+"元");
        }
        System.out.println("════════════════════════════════");
        System.out.println("請投入硬幣：");
        int inputMoney =Integer.parseInt(scanner.next());
        System.out.println("請選擇商品代碼：");
        int chooseId = Integer.parseInt(scanner.next());
             for (Product product : products) {
                 if (chooseId == product.getId()){
                     int price = product.getPrice();
                     if (inputMoney  >= price ){
                         System.out.println( "成功購買" +"["+ product.getName() +"]");
                         inputMoney -= price;
                     }else {
                         System.out.println("!金額不足!");
                     }
                 }
             }

        money.setMoney(inputMoney);
        money.getMoney();
        //判斷是否找零|餘額不足|繼續購買
        System.out.println("謝謝光臨");




    }
}
