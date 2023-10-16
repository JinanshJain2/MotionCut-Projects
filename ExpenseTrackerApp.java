import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTrackerApp {
    private List<Expense> expenses = new ArrayList<>();
    private JFrame frame;
    private DefaultListModel<Expense> listModel;
    private JList<Expense> expenseList;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ExpenseTrackerApp().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Expense Tracker App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        expenseList = new JList<>(listModel);
        frame.add(new JScrollPane(expenseList), BorderLayout.CENTER);

        JPanel expensePanel = new JPanel(new GridLayout(3, 2));
        frame.add(expensePanel, BorderLayout.SOUTH);

        JTextField descriptionField = new JTextField("Description");
        JTextField amountField = new JTextField("Amount");
        JTextField categoryField = new JTextField("Category");
        JButton addButton = new JButton("Add Expense");

        expensePanel.add(descriptionField);
        expensePanel.add(amountField);
        expensePanel.add(categoryField);
        expensePanel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = descriptionField.getText();
                double amount;
                try {
                    amount = Double.parseDouble(amountField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a valid number.");
                    return;
                }
                String category = categoryField.getText();
                Expense expense = new Expense(description, amount, category);
                expenses.add(expense);
                listModel.addElement(expense);
                clearFields(descriptionField, amountField, categoryField);
            }
        });

        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private void clearFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }
}

class Expense {
    private String description;
    private double amount;
    private String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    @Override
    public String toString() {
        return description + " - $" + amount + " (" + category + ")";
    }
}
