package com.FinalProject;

public class Transaction {
    private int id;
    private String name;
    private double amount;
    private Category category;

    public Transaction(int id, String name, double amount, Category category){
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transaction {" +
                "name=" + name +
                ", amount='" + amount + '\'' +
                ", category=" + category +
                '}';
    }
}
