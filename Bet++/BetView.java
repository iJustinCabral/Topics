import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * Write a description of class BetView here.
 *
 * Justin Cabral
 * 1.0.0
 */
public class BetView implements ActionListener
{
    // GUI Variables
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JTextField betTextField;
    private JLabel tableTitleLabel, titleLabel, accountLabel, winningsLabel;
    private JButton menuButton,accountButton,sportsButton,betButton, simulateButton;
    private AccountData userData;
    private int sportsNumber;
    private int betsPlaced = 0, betTotal = 0;
    
    // TEMP: Pull data from sports data object to set these values
    private SportsData sportsData = new SportsData();
    private String[] tableColumnNames = {"Date","Teams","Points","Odds"};
   
    
    /**
     * Constructor for objects of class BetView
     */
    public BetView(AccountData userData, int sportNumber)
    {
        this.userData = userData;
        this.sportsNumber = sportNumber;
        
        this.createViews();
        this.setUpViews();
        this.addViews();
        
    }
    
    private void createViews() {
        
        this.frame = new JFrame("Bet++");

        this.menuButton = new JButton("Main Menu");
        this.accountButton = new JButton("Account");
        this.sportsButton = new JButton();
        this.betButton = new JButton("Place Bet");
        this.simulateButton = new JButton("Simulate");
   
        this.accountLabel = new JLabel(this.userData.getUserName() + " : "+ "$"+ String.format("%.2f", userData.getBalance()));
        this.tableTitleLabel = new JLabel("Date                    Home / Away                     Points                         Odds");
        this.betTextField = new JTextField();
        
        this.tableModel = new DefaultTableModel(this.sportsData(), this.tableColumnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
              
        this.table = new JTable(this.tableModel);
        this.scrollPane = new JScrollPane(this.table);

    }
    
    private void setUpViews() {
        
        this.frame.setForeground(Color.blue);
        this.frame.setFont(new Font("Serif", Font.BOLD, 18));
        this.frame.setSize(800,600);
        this.frame.setLayout(null);
        this.frame.setResizable(false);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
        
        this.menuButton.setBounds(10,10,100,30);
        this.sportsButton.setBounds(360,40,80,80);
        this.betButton.setBounds(420,500,100,30);
        this.simulateButton.setBounds(520,500,100,30);
        
        this.accountLabel.setBounds(610,14,160,30);
        this.accountLabel.setFont(new Font("Serif", Font.BOLD, 20));
        this.tableTitleLabel.setBounds(164,146,560,30);
        this.tableTitleLabel.setFont(new Font("Serif", Font.BOLD, 16));
        
        this.betTextField.setBounds(200,500,200,30);
        this.betTextField.setText("");
        
        this.table.setBounds(100,180,600,300);
        this.table.setVisible(true);
        this.table.setFillsViewportHeight(true);
        this.table.setRowHeight(40);
        this.table.setPreferredScrollableViewportSize(new Dimension(600,300));
        this.scrollPane.setPreferredSize(new Dimension(600,300));
        
        this.menuButton.addActionListener(this);
        this.betButton.addActionListener(this);
        this.simulateButton.addActionListener(this);
        
        if (sportsNumber == 0){ this.processImageForButton(this.sportsButton, "./resources/MLB.png"); }
        else if (sportsNumber == 1){ this.processImageForButton(this.sportsButton, "./resources/NBA.png"); }
        else if (sportsNumber == 2){ this.processImageForButton(this.sportsButton, "./resources/NFL.png"); }
        else if (sportsNumber == 3){ this.processImageForButton(this.sportsButton, "./resources/NHL.png"); }

    }
    
    private void addViews() {
        this.frame.add(this.menuButton);
        this.frame.add(this.sportsButton);
        this.frame.add(this.betButton);
        this.frame.add(this.simulateButton);
        this.frame.add(this.accountLabel);
        this.frame.add(this.tableTitleLabel);
        this.frame.add(this.table);
        this.frame.add(this.betTextField);
        

    }
    
    
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.menuButton) {
            
            MainMenuView menuView = new MainMenuView(this.userData);
            this.frame.setVisible(false);
            
        }
        else if (action.getSource() == this.betButton) {
            this.placeBet(this.betTextField.getText());
            this.betTextField.setText("");
        }
        else if (action.getSource() == this.simulateButton) {
            
            if (this.betsPlaced !=0) {
                RecapView recapView = new RecapView(this.sportsNumber, this.betsPlaced, this.betTotal, this.userData);
                this.frame.setVisible(false);
            }
        }
        
    }
    
    private void setJTableColumnsWidth(JTable table, int tableWidth, int... widths) {
        
        int total = 0;
        TableColumn column = null;
        
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += widths[i];
        }
        
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) tableWidth * (widths[i] / total));
        }
    }
    
    private Object[][] sportsData() {
        
        switch(this.sportsNumber) {
            case 0:
                return this.sportsData.getBaseballData();
            case 1:
                return this.sportsData.getBasketballData();
            case 2:
                return this.sportsData.getFootballData();
            case 3:
                return this.sportsData.getHockeyData();
        }
        
        return null;
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
    
    private void placeBet(String betTotal) {
        
        Double bet = Double.valueOf(betTotal);
        Double currentBalance = this.userData.getBalance();
        
        if (currentBalance != 0) {
            this.betTotal += bet;
            this.userData.setBalance(currentBalance - bet);
            this.accountLabel.setText(this.userData.getUserName() + " : "+ "$"+ String.format("%.2f", userData.getBalance()));
            this.betsPlaced++;
        }

    }
    
}
