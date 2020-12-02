package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportProgramming implements Report<Employee> {

    private Store store;

    public ReportProgramming(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<h1>Name; Hired; Fired; Salary;</h1>")
                     .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<p>")
                    .append(employee.getName()).append("</p>")
                    .append("<p>")
                    .append(employee.getHired()).append("</p>")
                    .append("<p>")
                    .append(employee.getFired()).append("</p>")
                    .append("<p>")
                    .append(employee.getSalary()).append("</p>");
        }
        return text.toString();
    }
}
