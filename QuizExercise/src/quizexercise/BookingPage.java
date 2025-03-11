/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizexercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Rijal
 */
public class BookingPage extends BasePage implements ActionListener, Resettable {
    private String roomType;
    private double roomPrice;
    
    private JTextField txtName, txtStay;
    private JRadioButton rdbMale, rdbFemale;
    private ButtonGroup genderGroup;
    private JComboBox<String> cmbGuests;
    private JButton btnBook, btnReset;
    
    public BookingPage(String roomType, double roomPrice) {
        super("Booking Page");
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        initComponents();
    }
    
    @Override
    public void initComponents() {
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel lblName = new JLabel("Name:");
        txtName = new JTextField();
        
        JLabel lblGender = new JLabel("Gender:");
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rdbMale = new JRadioButton("Male");
        rdbFemale = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(rdbMale);
        genderGroup.add(rdbFemale);
        genderPanel.add(rdbMale);
        genderPanel.add(rdbFemale);
        
        JLabel lblGuests = new JLabel("Number of Guests:");
        String[] guestOptions = {"1", "2", "3", "4", "5"};
        cmbGuests = new JComboBox<>(guestOptions);
        
        JLabel lblStay = new JLabel("Length of Stay (nights):");
        txtStay = new JTextField();
        
        btnBook = new JButton("Book");
        btnBook.addActionListener(this);
        btnReset = new JButton("Reset");
        btnReset.addActionListener(this);
        
        formPanel.add(lblName);
        formPanel.add(txtName);
        formPanel.add(lblGender);
        formPanel.add(genderPanel);
        formPanel.add(lblGuests);
        formPanel.add(cmbGuests);
        formPanel.add(lblStay);
        formPanel.add(txtStay);
        formPanel.add(btnBook);
        formPanel.add(btnReset);
        
        JLabel lblRoomInfo = new JLabel("Booking for " + roomType + " at $" + roomPrice + " per night", SwingConstants.CENTER);
        
        setLayout(new BorderLayout());
        add(lblRoomInfo, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnBook) {
                String name = txtName.getText().trim();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Name is required.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                String gender = "";
                if (rdbMale.isSelected()) {
                    gender = "Male";
                } else if (rdbFemale.isSelected()) {
                    gender = "Female";
                } else {
                    JOptionPane.showMessageDialog(this, "Please select a gender.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                int guests = Integer.parseInt(cmbGuests.getSelectedItem().toString());
                int stay = 0;
                try {
                    stay = Integer.parseInt(txtStay.getText().trim());
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(this, "Length of stay must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                double totalPrice = roomPrice * stay * guests;
                
                String details = "Booking Details:\n"
                        + "Name: " + name + "\n"
                        + "Gender: " + gender + "\n"
                        + "Number of Guests: " + guests + "\n"
                        + "Length of Stay: " + stay + " nights\n"
                        + "Room Type: " + roomType + "\n"
                        + "Total Price: $" + totalPrice;
                JOptionPane.showMessageDialog(this, details, "Booking Confirmed", JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getSource() == btnReset) {
                resetFields();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void resetFields() {
        txtName.setText("");
        genderGroup.clearSelection();
        cmbGuests.setSelectedIndex(0);
        txtStay.setText("");
    }
}
