package com.fju;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        try {
            //Driver讀取驅動程式
            Class.forName("org.mariadb.jdbc.Driver");
            //Connection連線 要確認database名稱、密碼
            Connection conn = DriverManager
                    .getConnection("jdbc:mariadb://localhost:3306/demo?user=root&password=407570347&useUnicode=true&characterEncoding=UTF-8");
            Statement statement = conn.createStatement();
            List<Product> products = new ArrayList<>();
            //data collected
            //print products information
            System.out.println("Please insert coins for products: ");
            for(Product product:products){
//                System.out.println(product);
                System.out.println(product.id +") "+ product.name +"\t"+ product.price);
            }

            Scanner scanner = new Scanner(System.in);
            int money =Integer.parseInt(scanner.next());
            //只能投入1,5,10,50



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
