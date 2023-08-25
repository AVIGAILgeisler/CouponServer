package com.avigail.coupons.dto;

public class Category {
    private long id;
    private String name;
    public Category(long categoryId, String name) {
        this.id = categoryId;
        this.name = name;
    }
    public Category(String name) {
        this.name = name;
    }
    public Category() {
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
