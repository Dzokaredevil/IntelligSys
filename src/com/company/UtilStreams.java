package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dimav on 07.10.2017.
 * Don't copy my code. The truth must be taken.
 */
public class UtilStreams {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Queue<T> elementsA = first.collect(Collectors.toCollection(LinkedList::new));
        Queue<T> elementsB = second.limit(elementsA.size()).collect(Collectors.toCollection(LinkedList::new));
        return Stream.generate(new Supplier<T>() {
            boolean first = true;
            @Override
            public T get() {
                Queue<T> queue = first ? elementsA : elementsB;
                first = !first;
                return queue.poll();
            }
        }).limit(Math.min(elementsA.size(), elementsB.size()) * 2);
    }
}
