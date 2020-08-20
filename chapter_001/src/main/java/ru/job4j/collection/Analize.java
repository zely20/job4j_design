package ru.job4j.collection;

import java.util.List;
import java.util.Objects;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int c = previous.size() - current.size();
        Info info = new Info();
        if (c < 0) {
            info.added = Math.abs(c);
            info.changed = countChanged(previous, current);
        } else if (c > 0) {
            info.deleted = c;
            info.changed = countChanged(current, previous);
        } else {
            info.changed = countChanged(previous, current);
        }
        return info;
    }

    private int countChanged(List<User> previous, List<User> current) {
        int result = 0;
        for (User us : previous) {
            result += current.stream()
                    .anyMatch(u -> u.id == us.id && !Objects.equals(u.name, us.name)) ? 1 : 0;
        }
        return result;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {

        int added = 0;
        int changed = 0;
        int deleted = 0;

        @Override
        public String toString() {
            return "Info{" +
                    "added=" + added +
                    ", changed=" + changed +
                    ", deleted=" + deleted +
                    '}';
        }
    }
}
