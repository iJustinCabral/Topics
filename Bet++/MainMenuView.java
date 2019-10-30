import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * Write a description of class MainMenuView here.
 *
 * Justin Cabral
 * 1.0.0
 */

public class MainMenuView implements ActionListener
{

    private JFrame frame;
    private JLabel usernameLabel, balanceLabel, baseballLabel, basketballLabel,footballLabel,hockeyLabel;
    private JButton accountButton, logoutButton, baseballButton, footballButton, basketballButton, hockeyButton;

    /**
     * Constructor for objects of class MainMenuView
     */
    public MainMenuView()
    {
        this.createViews();
        this.setUpViews();
        this.addViews();
    }
    
    public void createViews() {
        
        this.frame = new JFrame("Bet++");
        this.accountButton = new JButton("Account");
        this.logoutButton = new JButton("Log Out");
        this.usernameLabel = new JLabel("JCabral  : "); // Temporary, will pull from AccountData later
        this.balanceLabel = new JLabel("$100.00"); // Temporary, will pull from AccountData later
        this.baseballLabel = new JLabel("Baseball");
        this.basketballLabel = new JLabel("Basketball");
        this.footballLabel = new JLabel("Football");
        this.hockeyLabel = new JLabel("Hockey");
        this.baseballButton = new JButton();
        this.basketballButton = new JButton();
        this.footballButton = new JButton();
        this.hockeyButton = new JButton();
    }
    
    public void setUpViews() {
        
        this.frame.setForeground(Color.blue);
        this.frame.setFont(new Font("Serif", Font.BOLD, 20));
        this.frame.setSize(610,300);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);

        
        this.accountButton.setBounds(10,10,100,30);
        this.logoutButton.setBounds(100,10,100,30);
        this.baseballButton.setBounds(80,100,100,100);
        this.basketballButton.setBounds(190,100,100,100);
        this.footballButton.setBounds(300,100,100,100);
        this.hockeyButton.setBounds(410,100,100,100);
        this.baseballLabel.setBounds(104,200,100,30);
        this.basketballLabel.setBounds(206,200,100,30);
        this.footballLabel.setBounds(324,200,100,30);
        this.hockeyLabel.setBounds(436,200,100,30);
        
        
        try {
            Image image = ImageIO.read(getClass().getResource("./resources/MLB.png"));
            Image scaledImage = image.getScaledInstance(90,90, java.awt.Image.SCALE_SMOOTH);
            this.baseballButton.setIcon(new ImageIcon(scaledImage));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        try {
            Image image = ImageIO.read(getClass().getResource("./resources/NBA.png"));
            Image scaledImage = image.getScaledInstance(90,90, java.awt.Image.SCALE_SMOOTH);
            this.basketballButton.setIcon(new ImageIcon(scaledImage));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        try {
            Image image = ImageIO.read(getClass().getResource("./resources/NFL.png"));
            Image scaledImage = image.getScaledInstance(90,90, java.awt.Image.SCALE_SMOOTH);
            this.footballButton.setIcon(new ImageIcon(scaledImage));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        try {
            Image image = ImageIO.read(getClass().getResource("./resources/NHL.png"));
            Image scaledImage = image.getScaledInstance(90,90, java.awt.Image.SCALE_SMOOTH);
            this.hockeyButton.setIcon(new ImageIcon(scaledImage));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
        this.usernameLabel.setBounds(420,10,100,30);
        this.usernameLabel.setFont(new Font("Sans", Font.BOLD, 16));
        this.balanceLabel.setBounds(500,10,100,30);
        this.balanceLabel.setFont(new Font("Sans", Font.BOLD, 16));
        
        this.accountButton.addActionListener(this);
        this.logoutButton.addActionListener(this);
        this.baseballButton.addActionListener(this);
        this.basketballButton.addActionListener(this);
        this.footballButton.addActionListener(this);
        this.hockeyButton.addActionListener(this);
    }
    
    public void addViews() {
        
        this.frame.add(this.accountButton);
        this.frame.add(this.logoutButton);
        this.frame.add(this.usernameLabel);
        this.frame.add(this.balanceLabel);
        this.frame.add(this.baseballButton);
        this.frame.add(this.basketballButton);
        this.frame.add(this.footballButton);
        this.frame.add(this.hockeyButton);
        this.frame.add(this.baseballLabel);
        this.frame.add(this.basketballLabel);
        this.frame.add(this.footballLabel);
        this.frame.add(this.hockeyLabel);
        
    }
    
    public void actionPerformed(ActionEvent action) {
       
        if (action.getSource() == this.baseballButton) {
        
        }
        else if (action.getSource() == this.basketballButton) {
            
        }
        else if (action.getSource() == this.footballButton) {
            BetView betView = new BetView();
            this.frame.setVisible(false);
        }
        else if (action.getSource() == this.hockeyButton) {
            
        }
        else if (action.getSource() == this.accountButton) {
            
        }
        else if (action.getSource() == this.logoutButton) {
            
            LogInView loginView = new LogInView();
            this.frame.setVisible(false);
            
        }
    }
}
