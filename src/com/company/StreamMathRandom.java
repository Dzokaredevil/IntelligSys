package com.company;

import java.util.stream.Stream;

/**
 * Created by dimav on 07.10.2017.
 * Don't copy my code. The truth must be taken.
 */
public class StreamMathRandom {
    public static Stream<Long> getRS(long a, long c, long m) {
        return Stream.iterate(1L, n -> (a * n + c) % m);
    }
}
