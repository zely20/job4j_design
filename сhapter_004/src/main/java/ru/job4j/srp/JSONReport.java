package ru.job4j.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class JSONReport implements Report<Employee> {

    private Store store;

    public JSONReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> predicate) {
        Gson gson = new GsonBuilder().create();
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(predicate)) {
            text.append(gson.toJson(employee));
        }
        return text.toString();
    }
}
