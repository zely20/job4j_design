package ru.job4j.collection;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void previousLessCurrent(){
        Analize analize = new Analize();
        List<Analize.User> previous =  List.of(new Analize.User(1, "Sasha"),
                new Analize.User(2,"Pasha"));
        List<Analize.User> current = List.of(new Analize.User(1, "Sasha"),
                new Analize.User(2,"Pasha"), new Analize.User (3,"Vasya"));
        assertThat(analize.diff(previous, current).toString(), is("Info{" +
                    "added=" + 1 +
                    ", changed=" + 0 +
                    ", deleted=" + 0 +
                    '}'));
    }

    @Test
    public void previousLessCurrentAndChanged(){
        Analize analize = new Analize();
        List<Analize.User> previous =  List.of(new Analize.User(1, "Sasha"),
                new Analize.User(2,"Pasha"));
        List<Analize.User> current = List.of(new Analize.User(1, "Sasha"),
                new Analize.User(2,"Tanya"), new Analize.User (3,"Vasya"));
        assertThat(analize.diff(previous, current).toString(), is("Info{" +
                "added=" + 1 +
                ", changed=" + 1 +
                ", deleted=" + 0 +
                '}'));

    }

    @Test
    public void previousLessCurrentAndTwoChanged(){
        Analize analize = new Analize();
        List<Analize.User> previous =  List.of(new Analize.User(1, "Sasha"),
                new Analize.User(2,"Pasha"));
        List<Analize.User> current = List.of(new Analize.User(1, "Lena"),
                new Analize.User(2,"Tanya"), new Analize.User (3,"Vasya"));
        assertThat(analize.diff(previous, current).toString(), is("Info{" +
                "added=" + 1 +
                ", changed=" + 2 +
                ", deleted=" + 0 +
                '}'));
    }

    @Test
    public void currentLessPrevios(){
        Analize analize = new Analize();
        List<Analize.User> previous =  List.of(new Analize.User(1, "Sasha"),
                new Analize.User(2,"Pasha"), new Analize.User (3,"Vasya"));
        List<Analize.User> current = List.of(new Analize.User(1, "Sasha"),
                new Analize.User(2,"Pasha"));
        assertThat(analize.diff(previous, current).toString(), is("Info{" +
                "added=" + 0 +
                ", changed=" + 0 +
                ", deleted=" + 1 +
                '}'));
    }

    @Test
    public void currentLessPreviostAndTwoChanged(){
        Analize analize = new Analize();
        List<Analize.User> previous =  List.of(new Analize.User(1, "Sasha"),
                new Analize.User(2,"Pasha"), new Analize.User (3,"Vasya"));
        List<Analize.User> current = List.of(new Analize.User(1, "gfhjds"),
                new Analize.User(2,"lkf;ds"));
        assertThat(analize.diff(previous, current).toString(), is("Info{" +
                "added=" + 0 +
                ", changed=" + 2 +
                ", deleted=" + 1 +
                '}'));
    }

    @Test
    public void notChanges(){
        Analize analize = new Analize();
        List<Analize.User> previous =  List.of(new Analize.User(1, "Sasha"),
                new Analize.User(2,"Pasha"), new Analize.User (3,"Vasya"));
        List<Analize.User> current = List.of(new Analize.User(1, "Sasha"),
                new Analize.User(2,"Pasha"), new Analize.User (3,"Vasya"));
        assertThat(analize.diff(previous, current).toString(), is("Info{" +
                "added=" + 0 +
                ", changed=" + 0 +
                ", deleted=" + 0 +
                '}'));
    }

    @Test
    public void ThreeChanges(){
        Analize analize = new Analize();
        List<Analize.User> previous =  List.of(new Analize.User(1, "Sasha"),
                new Analize.User(2,"Pasha"), new Analize.User (3,"Vasya"));
        List<Analize.User> current = List.of(new Analize.User(1, "fssd"),
                new Analize.User(2,"ifoww"), new Analize.User (3,"fsdlkfjwoe"));
        assertThat(analize.diff(previous, current).toString(), is("Info{" +
                "added=" + 0 +
                ", changed=" + 3 +
                ", deleted=" + 0 +
                '}'));
    }

}