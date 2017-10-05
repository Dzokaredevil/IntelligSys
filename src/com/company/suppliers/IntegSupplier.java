package com.company.suppliers;

import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Created by dimav on 05.10.2017.
 * Don't copy my code. The truth must be taken.
 */
public class IntegSupplier implements Supplier<Integer> {
    private Scanner scanner;
    public IntegSupplier(Scanner scanner){
        this.scanner = scanner;
    }
    @Override
    public Integer get() {
        return scanner.nextInt();
    }
}
