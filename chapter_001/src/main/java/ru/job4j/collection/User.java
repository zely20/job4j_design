package ru.job4j.collection;

import java.util.*;

public class User {
    String name;
    int children;
    Calendar birthday;

    public User(){

    }

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
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
        System.out.println(map);
    }
}