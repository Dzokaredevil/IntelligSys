package com.company.suppliers;

import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Created by dimav on 05.10.2017.
 * Don't copy my code. The truth must be taken.
 */
public class LineSupplier implements Supplier<String> {
    private Scanner scanner;
    public LineSupplier(Scanner scanner){
        this.scanner = scanner;
    }
    @Override
    public String get() {
        return scanner.nextLine();
    }
}
