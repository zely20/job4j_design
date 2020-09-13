package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RepeatFile implements FileVisitor<Path> {

    private Map<Long, List<Path>> map = new HashMap<>();
    public List<Path> list = new LinkedList<>();

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Long id = file.toFile().length();
        if (map.containsKey(id)) {
            List<Path> tempFromMap = map.get(id);
            for (Path path : tempFromMap) {
                if (path.toFile().getName().equals(file.toFile().getName())) {
                    list.add(file);
                } else {
                    List<Path> temp = map.get(id);
                    temp.add(file);
                    map.put(id, temp);
                }
            }
        } else {
            List<Path> inMap = new LinkedList<>();
            inMap.add(file);
            map.put(file.toFile().length(), inMap);
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
