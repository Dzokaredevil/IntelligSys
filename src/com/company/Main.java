package com.company;

import java.util.Scanner;

public class Main {

    private static void task1(){
        System.out.println("input 2 numbers:");
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int a = EuclidAlgorithm.gcd(n1,n2);
        int b = EuclidAlgorithm.gcdfloorMod(n1,n2);
        int c = EuclidAlgorithm.gcdrem(n1,n2);
        System.out.print("%=");
        System.out.println(a);
        System.out.print("floorMod=");
        System.out.println(b);
        System.out.print("IEEE=");
        System.out.println(c);
    }

    public static void main(String[] args) {
        task1();

    }
}
