import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField textField;
    private double firstNumber = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;

    public Calculator() {
        
        setPreferredSize(new Dimension(300, 400));
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/","4", "5", "6", "*","1", "2", "3", "-","0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (Character.isDigit(command.charAt(0)) || command.equals(".")) {
                if (isOperatorClicked) {
                    textField.setText("");
                    isOperatorClicked = false;
                }
                textField.setText(textField.getText() + command);
            } else if (command.equals("=")) {
                double secondNumber = Double.parseDouble(textField.getText());
                double result = performOperation(firstNumber, secondNumber, operator);
                textField.setText(String.valueOf(result));
                isOperatorClicked = true;
            } else {
                firstNumber = Double.parseDouble(textField.getText());
                operator = command;
                isOperatorClicked = true;
            }
        }
    }

    private double performOperation(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Error: Division by zero!");
                    return 0;
                }
            default:
                return num2;
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
