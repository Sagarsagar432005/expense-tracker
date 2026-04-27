package ui;

import daoimpl.ExpenseDAOImpl;
import model.Expense;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseUI extends JFrame {

    private JTextField txtName, txtAmount;
    private JTextArea outputArea;

    private ExpenseDAOImpl dao;

    public ExpenseUI() {
        dao = new ExpenseDAOImpl();

        setTitle("Expense Manager");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel (Input)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Expense Name:"));
        txtName = new JTextField();
        panel.add(txtName);

        panel.add(new JLabel("Amount:"));
        txtAmount = new JTextField();
        panel.add(txtAmount);

        JButton btnAdd = new JButton("Add Expense");
        panel.add(btnAdd);

        JButton btnView = new JButton("View Expenses");
        panel.add(btnView);

        add(panel, BorderLayout.NORTH);

        // Output Area
        outputArea = new JTextArea();
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Button Actions
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });

        btnView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewExpenses();
            }
        });
    }

    private void addExpense() {
        try {
            String name = txtName.getText();
            double amount = Double.parseDouble(txtAmount.getText());

            Expense exp = new Expense();
            exp.setName(name);
            exp.setAmount(amount);

            dao.addExpense(exp);

            JOptionPane.showMessageDialog(this, "Expense Added!");

            txtName.setText("");
            txtAmount.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void viewExpenses() {
        try {
            outputArea.setText("");

            for (Expense e : dao.getAllExpenses()) {
                outputArea.append(e.getName() + " - " + e.getAmount() + "\n");
            }

        } catch (Exception e) {
            outputArea.setText("Error: " + e.getMessage());
        }
    }
}