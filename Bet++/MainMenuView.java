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
    private JButton accountButton, baseballButton, footballButton, basketballButton, hockeyButton;

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
        this.usernameLabel = new JLabel("JCabral  : "); // Temporary, will pull from AccountData later
        this.balanceLabel = new JLabel("$100.00"); // Temporary, will pull from AccountData later
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
        
        this.accountButton.setBounds(10,10,100,30);
        this.baseballButton.setBounds(80,100,100,100);
        this.basketballButton.setBounds(190,100,100,100);
        this.footballButton.setBounds(300,100,100,100);
        this.hockeyButton.setBounds(410,100,100,100);
        
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
    }
    
    public void addViews() {
        this.frame.add(this.accountButton);
        this.frame.add(this.usernameLabel);
        this.frame.add(this.balanceLabel);
        this.frame.add(this.baseballButton);
        this.frame.add(this.basketballButton);
        this.frame.add(this.footballButton);
        this.frame.add(this.hockeyButton);
    }
    
    public void actionPerformed(ActionEvent action) {
       
        if (action.getSource() == this.baseballButton) {
        
        }
        else if (action.getSource() == this.basketballButton) {
            
        }
        else if (action.getSource() == this.footballButton) {
            
        }
        else if (action.getSource() == this.hockeyButton) {
            
        }
    }
}
