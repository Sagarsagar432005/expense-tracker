package daoimpl;

import dao.ExpenseDAO;
import model.Expense;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAOImpl implements ExpenseDAO {

    Connection con = DBConnection.getConnection();

    @Override
    public void addExpense(Expense expense) {
        String sql = "INSERT INTO expenses(title, category, amount, date) VALUES(?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, expense.getTitle());
            ps.setString(2, expense.getCategory());
            ps.setDouble(3, expense.getAmount());
            ps.setDate(4, expense.getDate());
            ps.executeUpdate();
            System.out.println("Expense Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Expense> getAllExpenses() {
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expenses";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Expense(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("category"),
                    rs.getDouble("amount"),
                    rs.getDate("date")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Expense> getByCategory(String category) {
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expenses WHERE category=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Expense(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("category"),
                    rs.getDouble("amount"),
                    rs.getDate("date")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteExpense(int id) {
        String sql = "DELETE FROM expenses WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Expense Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
