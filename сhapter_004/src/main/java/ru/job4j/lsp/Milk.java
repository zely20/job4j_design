package ru.job4j.lsp;

import java.util.Date;

public class Milk extends Food {

    public Milk() {
    }

    public Milk(String name, Date expaireDate, Date createDate, Integer price, Integer disscount) {
        super(name, expaireDate, createDate, price, disscount);
    }
}
