package ru.job4j.gc;

import java.lang.instrument.Instrumentation;

public class User {
    private String name; // 24 byte
    private int age;   // 4 byte
    private String address; // 24 byte

    public User(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s %s%n", age, name, address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();


    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }
    public static void main(String[] args) {
        info();

        for (int i = 0; i < 10000; i++) {
            new User("Alex", 25, "Minsk");
        }
        //System.gc();
        info();
    }
}
