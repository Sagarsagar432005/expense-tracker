package daoimpl;

import dao.ExpenseDAO;
import model.Expense;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAOImpl implements ExpenseDAO {

    private Connection conn;

    public ExpenseDAOImpl() {
        conn = DBConnection.getConnection();
    }

    // Add Expense
    @Override
    public void addExpense(Expense expense) {
        try {
            String sql = "INSERT INTO expenses (name, amount) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, expense.getName());
            ps.setDouble(2, expense.getAmount());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get All Expenses
    @Override
    public List<Expense> getAllExpenses() {
        List<Expense> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM expenses";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Expense e = new Expense();

                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setAmount(rs.getDouble("amount"));

                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}