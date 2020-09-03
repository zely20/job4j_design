package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RepeatFile implements FileVisitor<Path> {

    HashMap<Long, Path> set = new HashMap<>();
    List<Path> list = new LinkedList<>();

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (set.containsKey(file.toFile().length())) {
            String[] temp1 = set.get(file.toFile().length()).toFile().getName().split("\\\\");
            String[] temp2 = file.toFile().getName().split("\\\\");
            if (temp1[temp1.length - 1].equals(temp2[temp2.length - 1])) {
                list.add(file);
            }
        } else {
            set.put(file.toFile().length(), file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
