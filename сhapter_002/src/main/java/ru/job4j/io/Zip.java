package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Path> findFiles(ArgZip argZip) throws IOException {
        SearchFiles searcher = new SearchFiles(p ->!endString(p,argZip.exclude()));
        Files.walkFileTree(Path.of(argZip.directory()), searcher);
        return searcher.paths;
    }

    public static boolean endString(Path path, String str) {
        return path.toFile().getName().endsWith(str);
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        Zip zip = new Zip();
        List<File> files = zip.findFiles(argZip)
                .stream()
                .map(Path::toFile)
                .collect(Collectors.toList());
        zip.packFiles(files, new File(argZip.output()));
        for (Path st : zip.findFiles(argZip)) {
            System.out.println(st.toFile().getAbsolutePath());
        }
    }
}
