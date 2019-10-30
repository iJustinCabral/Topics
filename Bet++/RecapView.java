import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Write a description of class RecapView here.
 *
 * @auther Justin Cabral
 * @version 1.0.0
 */
public class RecapView implements ActionListener
{
    private JFrame frame;
    private JLabel betsLabel, betsWonLabel, betsLostLabel, moneyLabel;
    private JButton doneButton;
    
    public RecapView()
    {
        this.createViews();
        this.setUpViews();
        this.addViews();
    }
    
    public void createViews() {
        this.frame = new JFrame("Recap");
        
        this.betsLabel = new JLabel("Bets Placed: 3");
        this.betsWonLabel = new JLabel("Bets Won: 2"); // TEMP
        this.betsLostLabel = new JLabel("Bets Lost: 1"); // TEMP
        this.moneyLabel = new JLabel("Winnings: $240.00"); // TEMP
        
        this.doneButton = new JButton("Done");
        
    }
    
    public void setUpViews() {
        
        this.frame.setSize(300,200);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        
        this.betsLabel.setFont(new Font("Sans", Font.BOLD, 16));
        this.betsLabel.setBounds(100,10,160,30);
        
        this.betsWonLabel.setFont(new Font("Sans", Font.BOLD, 12));
        this.betsWonLabel.setBounds(20,50,100,30);
        
        this.betsLostLabel.setFont(new Font("Sans", Font.BOLD, 12));
        this.betsLostLabel.setBounds(20,80,100,30);
        
        this.moneyLabel.setFont(new Font("Sans", Font.BOLD, 12));
        this.moneyLabel.setBounds(20,110,160,30);
        
        this.doneButton.setBounds(100,140,100,30);
        this.doneButton.addActionListener(this);
    }
    
    public void addViews() {
       this.frame.add(betsLabel);
       this.frame.add(betsWonLabel);
       this.frame.add(betsLostLabel);
       this.frame.add(moneyLabel);
       this.frame.add(doneButton);
    }
    
    public void actionPerformed(ActionEvent action) { 
        
        if (action.getSource() == this.doneButton) {
            this.frame.setVisible(false);
        }
    }

}
