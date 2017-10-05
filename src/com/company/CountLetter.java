package com.company;

import java.io.*;
import java.nio.file.*;

class CountLetter {
    private char lookFor;
    private Path file;

    CountLetter(char lookFor, Path file) {
        this.lookFor = lookFor;
        this.file = file;
    }

    int count() throws IOException {
        int count = 0;
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (lookFor == line.charAt(i)) {
                        count++;
                    }
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return count;
    }

    static void usage() {
        System.out.println("usage: java CountLetter <letter>");
        System.exit(-1);
    }
}