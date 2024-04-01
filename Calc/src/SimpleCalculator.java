import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JApplet;

/**
 *
 * @author siddh
 */
public class SimpleCalculator extends JApplet {

    private JTextField textField;
    private double num1, num2, result;
    private String operator;

    public void init() {
        textField = new JTextField(10);
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("C")) {
                textField.setText("");
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }
                textField.setText(String.valueOf(result));
            } else {
                textField.setText(textField.getText() + command);
                if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                    num1 = Double.parseDouble(textField.getText().substring(0, textField.getText().length() - 1));
                    operator = command;
                    textField.setText("");
                }
            }
        }
    }

}
