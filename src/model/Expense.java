package model;

public class Expense {

    private int id;
    private String name;
    private double amount;

    // Default Constructor
    public Expense() {
    }

    // Parameterized Constructor (optional but useful)
    public Expense(int id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Setter for ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Setter for Name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for Amount
    public double getAmount() {
        return amount;
    }

    // Setter for Amount
    public void setAmount(double amount) {
        this.amount = amount;
    }
}