import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class AccountView here.
 *
 * Jonathan Duran
 * 10/8/19
 */
public class AccountView implements ActionListener
{
    // instance variables 
    private JFrame frame;
    private JLabel userNameLabel, cashLabel,userName,accountBalance;
    private JButton addCashButton,removeCashButton,backButton;
    private JTextArea textArea;
    private double balance;
    private final double MAXBALANCE = 10000000;
    private String labelBalan;
    /**
     * Constructor for objects of class AccountView
     */
    public AccountView()
    {
        this.balance = 0.0;
        String labelBalan = Double.toString(balance);
        
        this.textArea = new JTextArea(5,40);
     
        this.frame = new JFrame("AccountMenu");
        this.userNameLabel = new JLabel("Username: ");
        this.cashLabel = new JLabel("Account Balance: ");
        this.userName = new JLabel("John");
        this.accountBalance = new JLabel(labelBalan);
        this.addCashButton = new JButton("Add Funds");
        this.removeCashButton = new JButton("Remove Funds");
        this.backButton = new JButton("Back");
        this.textArea = new JTextArea();
        
        this.frame.setForeground(Color.blue);
        this.frame.setFont(new Font("Serif", Font.BOLD, 20));
        this.frame.setSize(500,300);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        
        //Labels
        this.userNameLabel.setBounds(80,70,200,30);
        this.cashLabel.setBounds(80,110,200,30);
        //Fields for account data
        this.userName.setBounds(150,70,200,30);
        this.accountBalance.setBounds(190,110,200,30);
        //Actions Buttons
        this.addCashButton.setBounds(70,150,150,30);
        this.removeCashButton.setBounds(250,150,150,30);
        this.backButton.setBounds(10,10,100,30);
        //TextArea
        this.textArea.setBounds(150,190,150,30);
        
        this.frame.add(this.userNameLabel);
        this.frame.add(this.cashLabel);
        this.frame.add(this.userName);
        this.frame.add(this.accountBalance);
        this.frame.add(this.addCashButton);
        this.frame.add(this.removeCashButton);
        this.frame.add(this.backButton);
        this.frame.add(this.textArea);
        
        this.addCashButton.addActionListener(this);
        this.removeCashButton.addActionListener(this);
        this.backButton.addActionListener(this);
        
        textArea.setLineWrap(true);
    }

public JFrame getAccView(){
        return this.frame;
}    
//@Override
public void actionPerformed(ActionEvent action){
   
    if(action.getSource() == this.addCashButton){
        
        String text = this.textArea.getText();
        if(Double.valueOf(text) >=0){
        if(this.balance + Double.valueOf(text) <= MAXBALANCE-1)
        this.balance += Double.valueOf(text);}
        
        this.labelBalan = Double.toString(this.balance);
        this.accountBalance.setText(this.labelBalan);
    }
    
    else if (action.getSource() == this.removeCashButton){
        String text = this.textArea.getText();
        if(this.balance >= 0 && Double.valueOf(text) >=0 && (this.balance - Double.valueOf(text)>=0))
        this.balance -= Double.valueOf(text);
        
        
        this.labelBalan = Double.toString(balance);
        this.accountBalance.setText(labelBalan);
    
    }
    
    else if (action.getSource() == this.backButton){
        
        
        this.frame.setVisible(false);
        MainMenuView prev = new MainMenuView();
        this.frame.dispose();
        
    }
    else{}
}
    
}
