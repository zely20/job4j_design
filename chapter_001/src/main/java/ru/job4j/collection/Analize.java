package ru.job4j.collection;

import java.util.List;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
     return null;
    }

    public static class User {
        int id;
        String name;
    }

    public static class Info {

        int added;
        int changed;
        int deleted;

    }
}
