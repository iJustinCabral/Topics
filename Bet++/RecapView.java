import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random;

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
    private int sportsNumber, amountBet, betsPlaced, betsWon = 0, betsLost = 0;
    private AccountData userData;
    
    public RecapView(int sportNumber, int betsPlaced, double amountBet, AccountData data)
    {
        this.sportsNumber = sportNumber;
        this.userData = data;
        this.betsPlaced = betsPlaced;
        this.createViews();
        this.setUpViews();
        this.addViews();
        this.simulateBets();
    }
    
    public void createViews() {
        this.frame = new JFrame("Recap");
        
        this.betsLabel = new JLabel("Bets Placed: " + betsPlaced);
        this.betsWonLabel = new JLabel("Bets Won: " + betsWon); // TEMP
        this.betsLostLabel = new JLabel("Bets Lost: " + betsLost); // TEMP
        this.moneyLabel = new JLabel(""); // TEMP
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
    
    private double simulateBets() {
        
        double winnings = 0;
        
        for (int i = 0; i < this.betsPlaced; i++) {
            
            int randomNumber = getRandomNumberInRange(0,2);
            
            if (randomNumber == 0) { 
                this.betsLost++; 
                this.betsLostLabel.setText("Bets Lost: " + this.betsLost);
            }
            else {
                this.betsWon++;
                this.betsWonLabel.setText("Bets Won: " + this.betsWon);
                winnings += (this.amountBet / betsPlaced) + getRandomNumberInRange(10,50);
            }
        }
        
        Double balance = this.userData.getBalance();
        this.userData.setBalance(balance + winnings);
        
        this.moneyLabel.setText("Winnings: $" + String.format("%.2f", winnings));
        return winnings;
        
    }
    
    public void actionPerformed(ActionEvent action) { 
        
        if (action.getSource() == this.doneButton) {
            BetView betView = new BetView(this.userData, this.sportsNumber);
            this.frame.setVisible(false);
        }
        
    }
    
    private int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
