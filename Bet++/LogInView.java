import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class LogInView here.
 *
 * Justin Cabral
 * 1.0.0
 */

public class LogInView extends JFrame {
    
    // instance variables
    private JFrame frame;
    private JLabel userNameLabel, passwordLabel;
    private JButton loginButton;
    private JButton signupButton;
    private JTextField userNameTextField;
    private JPasswordField passwordField;
   
    /**
     * Constructor for objects of class LogInView
     */
    public LogInView()
    {
        
        this.frame = new JFrame("Bet++");
        this.userNameLabel = new JLabel("Username");
        this.passwordLabel = new JLabel("Password");
        this.loginButton = new JButton("Login");
        this.signupButton = new JButton("Sign-Up");
        this.userNameTextField = new JTextField();
        this.passwordField = new JPasswordField();
        
        this.frame.setForeground(Color.blue);
        this.frame.setFont(new Font("Serif", Font.BOLD, 20));
        this.frame.setSize(500,300);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        
        this.userNameLabel.setBounds(80,70,200,30);
        this.passwordLabel.setBounds(80,110,200,30);
        
        this.userNameTextField.setBounds(180,70,200,30);
        this.passwordField.setBounds(180,110,200,30);
        this.loginButton.setBounds(160,160,100,30);
        this.signupButton.setBounds(290,160,100,30);
        
        this.loginButton.addActionListener(new LoginActionListener());
        this.signupButton.addActionListener(new SignupActionListener());
        
        this.frame.add(this.userNameLabel);
        this.frame.add(this.passwordLabel);
        this.frame.add(this.userNameTextField);
        this.frame.add(this.passwordField);
        this.frame.add(this.loginButton);
        this.frame.add(this.signupButton);

    }
    
    public JFrame getLogIn(){return this.frame;}
    
    public void actionPerformed(ActionEvent action) {
        
        String username = this.userNameTextField.getText();
        String password = this.passwordField.getText();
        
        
    }
    
    class SignupActionListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            
        }
    }
    
    class LoginActionListener implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            
        }
    }

}