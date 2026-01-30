package main;

import daoimpl.ExpenseDAOImpl;
import model.Expense;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class ExpenseApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseDAOImpl dao = new ExpenseDAOImpl();

        while (true) {
            System.out.println("\n--- SMART EXPENSE TRACKER ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View By Category");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Category: ");
                    String category = sc.nextLine();
                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();
                    dao.addExpense(new Expense(title, category, amount, new Date(System.currentTimeMillis())));
                    break;

                case 2:
                    List<Expense> list = dao.getAllExpenses();
                    list.forEach(e ->
                        System.out.println(e.getId()+" "+e.getTitle()+" "+e.getCategory()+" "+e.getAmount()+" "+e.getDate())
                    );
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Category: ");
                    String cat = sc.nextLine();
                    dao.getByCategory(cat).forEach(e ->
                        System.out.println(e.getId()+" "+e.getTitle()+" "+e.getAmount())
                    );
                    break;

                case 4:
                    System.out.print("Expense ID: ");
                    dao.deleteExpense(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
