/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quizexercise;

import javax.swing.*;

/**
 *
 * @author Rijal
 */
public abstract class BasePage extends JFrame {
    public BasePage(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
    }
    
    public abstract void initComponents();{
        // TODO code application logic here
    }
    
}
