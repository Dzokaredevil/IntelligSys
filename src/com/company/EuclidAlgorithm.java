package com.company;

import static java.lang.Math.floorMod;

/**
 * Created by dimav on 05.10.2017.
 */
public class EuclidAlgorithm {
    public static int gcd(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }
    public static int gcdfloorMod(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = floorMod(p, q);
            p = temp;
        }
        return p;
    }
    public static int gcdrem(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = (int) Math.IEEEremainder ((double)p,(double)q);
            p = temp;
        }
        return p;
    }
}
