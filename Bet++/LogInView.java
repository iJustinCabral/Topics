import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Write a description of class LogInView here.
 *
 * Justin Cabral
 * 1.0.0
 */

public class LogInView extends Observable implements ActionListener {
    
    // instance variables
    private JFrame frame;
    private JLabel userNameLabel, passwordLabel, messageLabel, welcomeLabel;
    private JButton loginButton;
    private JButton signupButton;
    private JTextField userNameTextField;
    private JPasswordField passwordField;
    private AccountData account;
    
    public void setMessageLabelText(String message) {
        this.messageLabel.setText(message);
    }
    
    /**
     * Constructor for objects of class LogInView
     */
    public LogInView()
    {
        
       this.createViews();
       this.setUpViews();
       this.addViews();
    }
    
    public void createViews() {
        
        this.frame = new JFrame("Bet++");
        this.welcomeLabel = new JLabel("Welcome to Bet++");
        this.userNameLabel = new JLabel("Username");
        this.passwordLabel = new JLabel("Password");
        this.messageLabel = new JLabel("");
        this.loginButton = new JButton("Login");
        this.signupButton = new JButton("Sign-Up");
        this.userNameTextField = new JTextField();
        this.passwordField = new JPasswordField();
        
    }
    
    public void setUpViews() {
        
        this.welcomeLabel.setFont(new Font("Serif", Font.BOLD, 30));
        this.frame.setForeground(Color.blue);
        this.frame.setFont(new Font("Serif", Font.BOLD, 20));
        this.frame.setSize(500,300);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
           
        this.welcomeLabel.setBounds(160,20,300,40);
        this.userNameLabel.setBounds(80,70,200,30);
        this.passwordLabel.setBounds(80,110,200,30);
        this.messageLabel.setBounds(80,200,300,30);
        
        this.userNameTextField.setBounds(180,70,200,30);
        this.passwordField.setBounds(180,110,200,30);
        this.loginButton.setBounds(170,160,100,30);
        this.signupButton.setBounds(290,160,100,30);
        
        this.loginButton.addActionListener(this);
        this.signupButton.addActionListener(this);
        
    }
    
    public void addViews() {
        
        this.frame.add(this.welcomeLabel);
        this.frame.add(this.userNameLabel);
        this.frame.add(this.passwordLabel);
        this.frame.add(this.messageLabel);
        this.frame.add(this.userNameTextField);
        this.frame.add(this.passwordField);
        this.frame.add(this.loginButton);
        this.frame.add(this.signupButton);
    }
    
    
    public void actionPerformed(ActionEvent action) {
            
        if (action.getSource() == this.signupButton) {
            // Check if user exists, if it does, give error, if not create new account
          
        }
        else if (action.getSource() == this.loginButton) {
            // Check if the username and password are correct, if yes go to main menu, if not give error
         
        }
            
    }
    
}