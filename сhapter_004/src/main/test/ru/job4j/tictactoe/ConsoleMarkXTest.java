package ru.job4j.tictactoe;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class ConsoleMarkXTest {

    @Test
    public void print() {
        var out = new ByteArrayOutputStream();
        new ConsoleMarkX().print(out);
        assertThat(out.toString(), is("X"));
    }
}
