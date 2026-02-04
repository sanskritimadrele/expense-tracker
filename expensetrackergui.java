import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class expensetrackergui extends JFrame {

    private JTextField nameField, amountField, categoryField;
    private JTextArea displayArea;
    private ArrayList<expense> expenses = new ArrayList<>();

    public expensetrackergui() {
        setTitle("Expense Tracker");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel (inputs)
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        panel.add(new JLabel("Expense Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        panel.add(amountField);

        panel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        panel.add(categoryField);

        JButton addButton = new JButton("Add Expense");
        panel.add(addButton);

        add(panel, BorderLayout.NORTH);

        // Text area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Button action
        addButton.addActionListener(e -> addExpense());

        setVisible(true);
    }

    private void addExpense() {
        String name = nameField.getText().trim();
        String category = categoryField.getText().trim();
        double amount;

        if (name.isEmpty() || category.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fields cannot be empty!");
            return;
        }

        try {
            amount = Double.parseDouble(amountField.getText());
            if (amount <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid amount!");
            return;
        }

        expenses.add(new expense(name, amount, category));
        displayArea.append(name + " | " + amount + " | " + category + "\n");

        nameField.setText("");
        amountField.setText("");
        categoryField.setText("");
    }

    public static void main(String[] args) {
        new expensetrackergui();
    }
}