package com.fju.calculation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Calculating extends JPanel implements MouseListener {
    public static Panel pn1=new Panel(new GridLayout(4,3));
    public static Panel pn2=new Panel(new GridLayout(4,1));
    public static Label lab=new Label("0",Label.RIGHT);
    //依序為清除、加、減、乘、除、等於
    public static Button clean,plus,cut,mul,div,amo;
    //0~9的數字
    public static Button digits[]=new Button[10];
    public static long num;//存放結果
    public static byte op;//代表運算子

    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setBounds(450,250,280,260);
        frame.setResizable(false);
        lab.setBounds(20,30,210,30);
        lab.setBackground(new Color(220,250,221));
        pn1.setBounds(20,60,160,170);
        pn2.setBounds(180,60,50,170);
        //0~9數字鈕
        for(int i=9;i>=0;i--){
            digits[i]=new Button(Integer.toString(i));
            pn1.add(digits[i]);
            digits[i].addActionListener((ActionListener) new ActLis());
        }
        //清除鈕
        clean=new Button("C");
        pn1.add(clean);
        clean.addActionListener(new ActLis());
        //等於鈕
        amo=new Button("=");
        pn1.add(amo);
        amo.addActionListener(new ActLis());
        //加鈕
        plus=new Button("+");
        pn2.add(plus);
        plus.addActionListener(new ActLis());
        //減鈕
        cut=new Button("-");
        pn2.add(cut);
        cut.addActionListener(new ActLis());
        //乘鈕
        mul=new Button("*");
        pn2.add(mul);
        mul.addActionListener(new ActLis());
        //除鈕
        div=new Button("/");
        pn2.add(div);
        div.addActionListener(new ActLis());

        frame.addWindowListener(new WindowAdapter(){public void
        windowClosing(WindowEvent e){System.exit(0);}});
        frame.add(lab);
        frame.add(pn1);
        frame.add(pn2);
        frame.setVisible(true);
    }



    public static class ActLis implements ActionListener {
    public void actionPerformed(ActionEvent e) throws NumberFormatException, ArithmeticException {
        long result;//存放由字串轉成的數值

        Button btn = (Button) e.getSource();
        try {
            //處理數值1-9
            for (int i = 0; i <= 9; i++) {
                if (btn == digits[i]) {
                    output_digit(digits[i]);
                    break;
                }
            }
            if (btn == clean) {
                result = 0L;//把儲存的結果歸0
                num = 0L;
                op = 0;
                lab.setText(Long.toString(num));
            } else if (btn == plus) {//加
                save_num(plus);
                op = 1;
            } else if (btn == cut) {//減
                save_num(cut);
                op = 2;
            } else if (btn == mul) {//乘
                save_num(mul);
                op = 3;
            } else if (btn == div) {//除
                save_num(div);
                op = 4;
            } else if (btn == amo) {
                result = Long.parseLong(lab.getText());

                switch (op) {
                    case 1:
                        num += result;
                        break;
                    case 2:
                        num -= result;
                        break;
                    case 3:
                        num *= result;
                        break;
                    case 4:
                        num /= result;
                        break;
                    default:
                }
                result = 0L;
                //輸出運算後的結果到顯示器
                lab.setText(Long.toString(num));
            }
        } catch (NumberFormatException ne) {
            //捕捉例外
        } catch (ArithmeticException ae) {
            //捕捉被除數是零的例外
        }

    }

    //輸出數值到顯示器
    public void output_digit(Button btn) {
        lab.setText(Long.toString(Long.parseLong(lab.getText() + btn.getLabel())));
    }

    //把第一組數值儲存起來
    public void save_num(Button o) {
        num = Long.parseLong(lab.getText());
        lab.setText(Long.toString(0L));
    }
    }
}