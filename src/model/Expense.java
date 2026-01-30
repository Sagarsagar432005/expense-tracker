package model;

import java.sql.Date;

public class Expense {
    private int id;
    private String title;
    private String category;
    private double amount;
    private Date date;

    public Expense(String title, String category, double amount, Date date) {
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public Expense(int id, String title, String category, double amount, Date date) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public Date getDate() { return date; }
}
