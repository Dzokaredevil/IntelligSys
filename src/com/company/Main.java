package com.company;

import com.company.suppliers.DoubleSupplier;
import com.company.suppliers.IntegSupplier;
import com.company.suppliers.LineSupplier;
import com.company.suppliers.WordSupplier;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

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
    private static void task3(){
        Scanner in = new Scanner(System.in);
        String inputHex = in.nextLine();
        try {
            int outputDeci = Integer.parseInt(inputHex, 16);
            System.out.println("Decimal Equivalent = " + outputDeci);
        }
        catch(NumberFormatException ne){
            System.out.println("Invalid Input");
        }
        finally{
            in.close();
        }
    }
    private static void task4() throws IOException {
        String fileName = "C://Users//dimav//IdeaProjects//IntelligSys//src//com//company//lines.txt";

        InputStream inputStream = new ByteArrayInputStream(Files.readAllBytes(Paths.get(fileName)));

        Scanner in = new Scanner(inputStream);
        IntegSupplier integSupplier = new IntegSupplier(in);
        DoubleSupplier doubleSupplier = new DoubleSupplier(in);
        LineSupplier lineSupplier = new LineSupplier(in);
        WordSupplier wordSupplier = new WordSupplier(in);
        System.out.println("integers =");
        System.out.println(integSupplier.get().toString());

        System.out.println("doubles =");
        System.out.println(doubleSupplier.get().toString());

        System.out.println("lines =");
        System.out.print(lineSupplier.get());
        System.out.println(lineSupplier.get());

        System.out.println("word =");
        System.out.println(wordSupplier.get().toString());
    }


    public static void main(String[] args) throws IOException {
        //task1();
        //task2();
        //task3();
        task4();
        /*Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        OnlinePalindrome.checkPalindrome(s, 256, 101);
        */

    }
}
