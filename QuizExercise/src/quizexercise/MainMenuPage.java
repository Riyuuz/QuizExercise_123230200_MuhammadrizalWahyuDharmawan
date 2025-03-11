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
public class MainMenuPage extends BasePage implements ActionListener {
    private JButton btnSmallRoom, btnLargeRoom;
    public static final double SMALL_ROOM_PRICE = 50.0;
    public static final double LARGE_ROOM_PRICE = 80.0;
    
    public MainMenuPage() {
        super("Main Menu");
        initComponents();
    }
    
    @Override
    public void initComponents() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Display pricing and instructions
        JLabel lblPricing = new JLabel("Select Room Type (Pricing Information):", SwingConstants.CENTER);
        
        // Create room selection buttons
        JPanel btnPanel = new JPanel(new FlowLayout());
        btnSmallRoom = new JButton("Small Room - $" + SMALL_ROOM_PRICE + " per night");
        btnSmallRoom.addActionListener(this);
        btnLargeRoom = new JButton("Large Room - $" + LARGE_ROOM_PRICE + " per night");
        btnLargeRoom.addActionListener(this);
        btnPanel.add(btnSmallRoom);
        btnPanel.add(btnLargeRoom);
        
        panel.add(lblPricing);
        panel.add(btnPanel);
        
        add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String roomType = "";
            double roomPrice = 0.0;
            if (e.getSource() == btnSmallRoom) {
                roomType = "Small Room";
                roomPrice = SMALL_ROOM_PRICE;
            } else if (e.getSource() == btnLargeRoom) {
                roomType = "Large Room";
                roomPrice = LARGE_ROOM_PRICE;
            }
            // Open Booking Page with the selected room type and price
            BookingPage bookingPage = new BookingPage(roomType, roomPrice);
            bookingPage.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}