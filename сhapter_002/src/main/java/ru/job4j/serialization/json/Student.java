package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Student {
    private int age = 0;
    private String firstName;
    private String secondName;
    private boolean isStudy;
    private int course;

    public Student(int age, String firstName, String secondName, boolean isStudy, int course) {
        this.age = age;
        this.firstName = firstName;
        this.secondName = secondName;
        this.isStudy = isStudy;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", isStudy=" + isStudy +
                ", course=" + course +
                '}';
    }

    public static void main(String[] args) {
        final Student student = new Student(25,"Zelenko","Alex", true,1);
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(student));

        final String jSon = "{" +
                "\"age\":25," +
                "\"firstName\":\"Zelenko\"," +
                "\"secondName\":\"Alex\"," +
                "\"isStudy\":true," +
                "\"course\":1}";
        final Student student2 = gson.fromJson(jSon,Student.class);
        System.out.println(student2);
    }
}
