package ru.job4j.srp;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class HREngine {

    private Store store;

    public HREngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        List<Employee> list = store.findBy(filter);
        Collections.sort(list);
        for (Employee employee : list) {
                     text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}
