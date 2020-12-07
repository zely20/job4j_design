package ru.job4j.lsp;

import java.util.Date;
import java.util.Objects;

public class Food {

    protected String name;
    protected Date expaireDate;
    protected Date createDate;
    protected Integer price;
    protected Integer disscount;

    public Food() {
    }

    public Food(String name, Date expaireDate, Date createDate, Integer price, Integer disscount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.disscount = disscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(Date expaireDate) {
        this.expaireDate = expaireDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDisscount() {
        return disscount;
    }

    public void setDisscount(Integer disscount) {
        this.disscount = disscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(name, food.name) &&
                Objects.equals(expaireDate, food.expaireDate) &&
                Objects.equals(createDate, food.createDate) &&
                Objects.equals(price, food.price) &&
                Objects.equals(disscount, food.disscount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expaireDate, createDate, price, disscount);
    }
}
