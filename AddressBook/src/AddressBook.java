import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/**
 *
 * @author siddh
 */
public class AddressBook extends JApplet {
private ArrayList<Entry> addressBook = new ArrayList<>();
    private JTextField nameField, addressField, emailField, phoneField;

    public void init() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEntry();
            }
        });
        buttonPanel.add(addButton);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateEntry();
            }
        });
        buttonPanel.add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteEntry();
            }
        });
        buttonPanel.add(deleteButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addEntry() {
        String name = nameField.getText();
        String address = addressField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        Entry entry = new Entry(name, address, email, phone);
        addressBook.add(entry);
        clearFields();
    }

    private void updateEntry() {
        String name = nameField.getText();
        for (Entry entry : addressBook) {
            if (entry.getName().equals(name)) {
                entry.setAddress(addressField.getText());
                entry.setEmail(emailField.getText());
                entry.setPhone(phoneField.getText());
                break;
            }
        }
        clearFields();
    }

    private void deleteEntry() {
        String name = nameField.getText();
        for (Entry entry : addressBook) {
            if (entry.getName().equals(name)) {
                addressBook.remove(entry);
                break;
            }
        }
        clearFields();
    }

    private void clearFields() {
        nameField.setText("");
        addressField.setText("");
        emailField.setText("");
        phoneField.setText("");
    }

    private class Entry {
        private String name;
        private String address;
        private String email;
        private String phone;

        public Entry(String name, String address, String email, String phone) {
            this.name = name;
            this.address = address;
            this.email = email;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhone() {
            return phone;
        }
    }

}
