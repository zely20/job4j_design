package ru.job4j.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        char sex = 'M';
        boolean isWork = true;
        double salary = 500.00;
        LOG.debug("User info name : {}, age : {}, sex : {}, isWork : {}, salary : {}" , name, age, sex, isWork, salary);
    }
}
