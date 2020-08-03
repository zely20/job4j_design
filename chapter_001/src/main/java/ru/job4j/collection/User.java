package ru.job4j.collection;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(){

    }

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
class Main2 {
    public static void main(String[] args) {
        User user1 = new User("Alex", 5, new GregorianCalendar(1984,Calendar.JUNE, 14));
        User user2 = new User("Alex", 5, new GregorianCalendar(1984,Calendar.JUNE, 14));


        Map<User,Object> map = new HashMap<>();
        map.put(user1, null);
        map.put(user2, null);
        System.out.println(user1.equals(user2));
        System.out.println(map);
    }
}