package com.company.suppliers;

import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Created by dimav on 05.10.2017.
 * Don't copy my code. The truth must be taken.
 */
public class DoubleSupplier implements Supplier<Double> {
    private Scanner scanner;
    public DoubleSupplier(Scanner scanner){
        this.scanner = scanner;
    }
    @Override
    public Double get() {
        return scanner.nextDouble();
    }
}
