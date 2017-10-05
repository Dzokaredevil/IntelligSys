package com.company;

import java.util.Scanner;

public class Main {

    private static void task1(){
        System.out.println("input 2 numbers:");
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int a = EuclidAlgorithm.gcd(num1,num2);
        int b = EuclidAlgorithm.gcdfloorMod(num1,num2);
        int c = EuclidAlgorithm.gcdrem(num1,num2);
        System.out.print("%=");
        System.out.println(a);
        System.out.print("floorMod=");
        System.out.println(b);
        System.out.print("IEEE=");
        System.out.println(c);
    }
    private static void task2(){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String ans1 = Rot13.rot(s);
        String ans2 = Rot13.rot(ans1);
        System.out.println("incoded str = "+ans1);
        System.out.println("REincoded str = "+ans2);
    }


    public static void main(String[] args) {
        //task1();
        task2();
    }
}
