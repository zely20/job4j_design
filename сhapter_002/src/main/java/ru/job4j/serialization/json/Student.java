package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

public class Student {
    private int age;
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
        JSONObject jsonStudent = new JSONObject();
        jsonStudent.put("age", student.getAge());
        jsonStudent.put("firstName", student.getFirstName());
        jsonStudent.put("secondName", student.getSecondName());
        jsonStudent.put("isStudy", student.isStudy);
        jsonStudent.put("course", student.getCourse());
        System.out.println(jsonStudent);

        System.out.println(new JSONObject(student).toString());
        /*final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(student));

        final String jSon = "{" +
                "\"age\":25," +
                "\"firstName\":\"Zelenko\"," +
                "\"secondName\":\"Alex\"," +
                "\"isStudy\":true," +
                "\"course\":1}";
        final Student student2 = gson.fromJson(jSon,Student.class);
        System.out.println(student2);*/
    }
}
