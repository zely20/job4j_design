package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current){
        Info info = new Info();
        Map<Integer, String> temp = new HashMap<>();
        temp = current.stream()
                .collect(Collectors.toMap(el -> new Integer(el.getId()), el-> el.getName()));
        for (User us :
                previous) {
            if(temp.containsKey(us.id)){
                if(!temp.get(us.id).equals(us.name)){
                    info.changed++;
                }
            } else {
                info.deleted++;
            }
        }
        info.added = current.size() + info.deleted - previous.size();
        return info;
    }
    /*public Info diff(List<User> previous, List<User> current) {
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
    }*/

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
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
