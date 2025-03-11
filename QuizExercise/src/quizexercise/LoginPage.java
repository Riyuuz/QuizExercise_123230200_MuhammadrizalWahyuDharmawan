/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizexercise;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Rijal
 */
public class LoginPage extends BasePage implements ActionListener {
    JLabel tulisan = new JLabel("LOGIN PAGE");
    JLabel usernameLabel = new JLabel("Username : ");
    JLabel passwordLabel = new JLabel("Password : ");
    JTextField usernameTextField = new JTextField();
    JPasswordField passTextField = new JPasswordField();

    JButton loginButton = new JButton("Login");
    
    public LoginPage() {
        super("Login Page");
        initComponents();
    }
    
    @Override
    public void initComponents() {
        setVisible(true);
        setSize(720, 480);
        setTitle("Title: Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setLayout(null);
        
        add(tulisan);
        add(usernameLabel);
        add(passwordLabel);
        add(usernameTextField);
        add(passTextField);
        add(loginButton);
        
        tulisan.setBounds(210, 20, 150, 24);
        usernameLabel.setBounds(20, 84, 440, 12);
        passwordLabel.setBounds(20, 152, 440, 12);
        usernameTextField.setBounds(18, 100, 440, 32);
        passTextField.setBounds(18, 170, 440, 32);
        loginButton.setBounds(50, 220, 200, 32);
        
        loginButton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == loginButton) {
                //code yang dijalankan jika click tombol button
                String username = usernameTextField.getText();
                char[] passChar = passTextField.getPassword();
                String password = new String(passChar);
            
            if (username.equals("adm") && password.equals("adm")) {
                System.out.println("Login Success");
                new MainMenuPage().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Wrong Username or Pass");
            }
        }
    }catch (Exception error) {

    }
}
}
