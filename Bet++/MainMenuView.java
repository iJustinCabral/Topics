import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * Write a description of class MainMenuView here.
 *
 * Justin Cabral/Jonathan Duran
 * 1.0.0
 */

public class MainMenuView implements ActionListener
{

    private JFrame frame;
    private JLabel accountLabel, baseballLabel, basketballLabel,footballLabel,hockeyLabel;
    private JButton accountButton, logoutButton, baseballButton, footballButton, basketballButton, hockeyButton;
    private AccountData user;
    private SportsData sportsData;
    private final int BASEBALL = 0, BASKETBALL = 1, FOOTBALL = 2, HOCKEY = 3;
    /**
     * Constructor for objects of class MainMenuView
     */
    public MainMenuView( AccountData usr)
    {
        this.user = usr;
        
        this.createViews();
        this.setUpViews();
        this.addViews();
        
    }
    
     public MainMenuView(AccountData usr, SportsData sportsData)
    {
        this.user = usr;
        this.sportsData = sportsData;
        
        this.createViews();
        this.setUpViews();
        this.addViews();
        
    }
    
    private void createViews() {
        
        String userBalance = Double.toString(user.getBalance());
        this.frame = new JFrame("Bet++");
        this.accountButton = new JButton("Account");
        this.logoutButton = new JButton("Log Out");
        this.accountLabel = new JLabel(user.getUserName() + " : "+ "$" + String.format("%.2f", user.getBalance())); // Temporary, will pull from AccountData later
        this.baseballLabel = new JLabel("Baseball");
        this.basketballLabel = new JLabel("Basketball");
        this.footballLabel = new JLabel("Football");
        this.hockeyLabel = new JLabel("Hockey");
        this.baseballButton = new JButton();
        this.basketballButton = new JButton();
        this.footballButton = new JButton();
        this.hockeyButton = new JButton();
    }
    
    private void setUpViews() {
        
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
        
        
        processImageForButton(this.baseballButton, "./resources/MLB.png");
        processImageForButton(this.basketballButton, "./resources/NBA.png");
        processImageForButton(this.footballButton, "./resources/NFL.png");
        processImageForButton(this.hockeyButton, "./resources/NHL.png");
        
        this.accountLabel.setBounds(420,10,150,30);
        this.accountLabel.setFont(new Font("Sans", Font.BOLD, 16));
        
        this.accountButton.addActionListener(this);
        this.logoutButton.addActionListener(this);
        this.baseballButton.addActionListener(this);
        this.basketballButton.addActionListener(this);
        this.footballButton.addActionListener(this);
        this.hockeyButton.addActionListener(this);
    }
    
    private void addViews() {
        
        this.frame.add(this.accountButton);
        this.frame.add(this.logoutButton);
        this.frame.add(this.accountLabel);
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
            BetView betView = new BetView(this.user, BASEBALL);
            this.frame.setVisible(false);
        }
        else if (action.getSource() == this.basketballButton) {
            BetView betView = new BetView(this.user, BASKETBALL);
            this.frame.setVisible(false);
        }
        else if (action.getSource() == this.footballButton) {
            BetView betView = new BetView(this.user, FOOTBALL);
            this.frame.setVisible(false);
        }
        else if (action.getSource() == this.hockeyButton) {
            BetView betView = new BetView(this.user, HOCKEY);
            this.frame.setVisible(false);
        }
        else if (action.getSource() == this.accountButton) {
            this.frame.setVisible(false);
            AccountView accountView = new AccountView(this.frame , this.user);
            this.frame.dispose();
            
        }
        else if (action.getSource() == this.logoutButton) {      
            
            this.frame.setVisible(false);
            new LogInView();
            this.frame.dispose();
            
        }
    }
    
    private void processImageForButton(JButton button, String path) {
        try {
            Image image = ImageIO.read(getClass().getResource(path));
            Image scaledImage = image.getScaledInstance(90,90, java.awt.Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledImage));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}
