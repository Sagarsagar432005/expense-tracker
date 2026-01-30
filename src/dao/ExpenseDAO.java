package dao;

import java.util.List;
import model.Expense;

public interface ExpenseDAO {
    void addExpense(Expense expense);
    List<Expense> getAllExpenses();
    List<Expense> getByCategory(String category);
    void deleteExpense(int id);
}
