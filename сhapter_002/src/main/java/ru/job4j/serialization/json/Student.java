package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.util.Arrays;

public class Student {
    private int age;
    private String firstName;
    private String secondName;
    private boolean isStudy;
    private int course;
    private Car car;
    private String[]  disciplines;

    public Student(int age, String firstName, String secondName, boolean isStudy, int course, Car car) {
        this.age = age;
        this.firstName = firstName;
        this.secondName = secondName;
        this.isStudy = isStudy;
        this.course = course;
        this.car = car;
        disciplines = new String[]{"language", "Programing"};
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public boolean isStudy() {
        return isStudy;
    }

    public int getCourse() {
        return course;
    }

    public Car getCar() {
        return car;
    }
    public String[] getDisciplines(){
        return disciplines;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", isStudy=" + isStudy +
                ", course=" + course +
                ", car=" + car +
                ", disciplines=" + Arrays.toString(disciplines) +
                '}';
    }

    public static void main(String[] args) {
        final Student student = new Student(25,"Zelenko","Alex", true,1,
                new Car("Ferrari", "Black"));
        JSONObject jsonStudent = new JSONObject();
        jsonStudent.put("age", student.getAge());
        jsonStudent.put("firstName", student.getFirstName());
        jsonStudent.put("secondName", student.getSecondName());
        jsonStudent.put("isStudy", student.isStudy);
        jsonStudent.put("course", student.getCourse());
        jsonStudent.put("car", student.getCar());
        jsonStudent.put("disciplines", student.getDisciplines());
        System.out.println(jsonStudent);

        System.out.println(new JSONObject(student).toString());

        /*final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(student));

        final String jSon = "{" +
                "\"age\":25," +
                "\"firstName\":\"Zelenko\"," +
                "\"secondName\":\"Alex\"," +
                "\"isStudy\":true," +
                "\"course\":1," +
                "\"car\":" +
                "{\"model\":\"Ferrari\",\"color\":\"Black\"}," +
                "\"disciplines\":[\"language\",\"Programing\"]}";
        final Student student2 = gson.fromJson(jSon,Student.class);
        System.out.println(student2);*/
    }
    public static class Car {
        private String model;
        private String color;

        public Car(String model, String color) {
            this.model = model;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "model='" + model + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
