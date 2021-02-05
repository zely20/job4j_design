package ru.job4j.tictactoe;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ConsoleMarkX implements Mark<OutputStream> {
    @Override
    public void print(OutputStream screen) {
        try {
            screen.write("X".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
