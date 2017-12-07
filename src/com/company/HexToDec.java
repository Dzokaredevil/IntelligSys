package com.company;

import java.util.Scanner;

import static java.lang.Math.pow;
/**
 * Created by dimav on 07.12.2017.
 * Don't copy my code. The truth must be taken.
 */
class HexToDec {

    HexToDec() {
        Scanner in = new Scanner(System.in);
        String income;
        System.out.println("Введите число в шестнадцатеричном формате (с заглавными буквами):"); // получаем число в 16-м формате
        income = in.nextLine();
        long outcome = hex_to_dec(income);
        if (outcome == -1) {
            System.out.println("Неверный формат.");
        } else {
            System.out.println("Это число в десятичной системе = " + outcome);
        }
    }

    private long hex_to_dec(String hex) {
        boolean flag = false;
        if (hex.charAt(0) == '-') {
            flag = true;
            hex = hex.substring(1);
        }
        long decimal = 0;
        String numbers = "0123456789ABCDEF";
        int length = hex.length(), base = 16;
        for (int i = 0; i < length; i++)
            if (numbers.contains(String.valueOf(hex.charAt(i)))) {
                decimal += (numbers.indexOf(hex.charAt(i))) * (pow(base, (length - i - 1)));
            } else {
                return -1;
            }
        if (flag) {
            return 0 - decimal;
        } else {
            return decimal;
        }
    }
}
