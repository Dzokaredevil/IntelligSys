package com.company;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by dimav on 07.10.2017.
 * Don't copy my code. The truth must be taken.
 */

public class UnzipFind {
    private boolean count;
    private Path file;

    UnzipFind(Path file, boolean count) {
        this.file = file;
        this.count = count;
    }

    static FileSystem createZipFileSystem(Path zipFilename, boolean create) throws IOException {
        final URI uri = URI.create("jar:file:" + zipFilename.getPath());
        final Map<String, String> env = new HashMap<>();
        if (create) {
            env.put("create", "true");
        }
        return FileSystems.newFileSystem(uri, env);
    }

    private class MyFileSearch extends SimpleFileVisitor<Path> {
        List<String> patterns = new LinkedList<>();
        List<Path> files = new LinkedList<>();
        MyFileSearch addPattern(String pattern) {
            patterns.add(pattern);
            return this;
        }
        List<Path> getFoundFiles() {
            return files;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            checkPatterns(file);
            return FileVisitResult.CONTINUE;
        }
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }
        private void checkPatterns(Path file) throws IOException {
            String fileText = new String(Files.readAllBytes(file));
            for (String pattern : patterns) {
                if (fileText.contains(pattern)) {
                    files.add(file);
                }
            }
        }
    }

    public void list() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL zipFile = classloader.getResource("src.zip");
        try (FileSystem zipFileSystem = createZipFileSystem(zipFile, false)) {
            final Path root = zipFileSystem.getPath("/");
            MyFileSearch myFileSearch = new MyFileSearch().addPattern("transient").addPattern("volatile");
            Files.walkFileTree(root, myFileSearch);
            for(Path p : myFileSearch.getFoundFiles()){
                System.out.println(p.toString());
            }
        }
    }
}
