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
    
    // TEMP: Pull data from sports data object to set these values
    private SportsData sportsData;
    private String[] tableColumnNames = {"Date","Teams","Points","Odds"};
    private Object[][] tableRowData = {{"October 20th","Ravens vs.\n Bills","+4 : -4", "-115 : -105"},
                                       {"October 20th","Saints vs.\n Bears","+4 : -4", "-120 : +100"},
                                       {"October 20th","Eagles vs.\n Cowboys","+3 : -3", "-115 : -105"},
                                       {"October 20th","Rams vs.\n Falcons","-3 : +3", "-110 : +110"},
                                       {"October 21st","Patriots vs.\n Jets","-10 : +10","-105 : +105"},
                                       {"October 20th","Packers vs Jaguars", "+10  -10","-110 : +110"},
                                       {"October 10th","Bengals vs 49ers", "-3 : +3", "-105 : +105"}};
    
    /**
     * Constructor for objects of class BetView
     */
    public BetView()
    {
        this.createViews();
        this.setUpViews();
        this.addViews();
        
    }
    
    public void createViews() {
        
        this.frame = new JFrame("Bet++");

        this.menuButton = new JButton("Main Menu");
        this.accountButton = new JButton("Account");
        this.sportsButton = new JButton();
        this.betButton = new JButton("Place Bet");
        this.simulateButton = new JButton("Simulate");
        
        this.titleLabel = new JLabel("Betting Lines: Football"); // TEMP: Pass in data from main menu to set this label
        this.accountLabel = new JLabel("JCabral : $100.00"); // TEMP: Pass in data from Account Data to set this label
        this.tableTitleLabel = new JLabel("Date                    Home / Away                     Points                         Odds");
        this.betTextField = new JTextField();
        
        this.tableModel = new DefaultTableModel(this.tableRowData, this.tableColumnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
              
        this.table = new JTable(this.tableModel);
        this.scrollPane = new JScrollPane(this.table);

    }
    
    public void setUpViews() {
        
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
        this.betTextField.setText("0.00");
        
        this.table.setBounds(100,180,600,300);
        this.table.setVisible(true);
        this.table.setFillsViewportHeight(true);
        this.table.setRowHeight(40);
        this.table.setPreferredScrollableViewportSize(new Dimension(600,300));
        this.scrollPane.setPreferredSize(new Dimension(600,300));
        
        this.menuButton.addActionListener(this);
        this.betButton.addActionListener(this);
        this.simulateButton.addActionListener(this);
        
        try {
            Image image = ImageIO.read(getClass().getResource("./resources/NFL.png"));
            Image scaledImage = image.getScaledInstance(90,90, java.awt.Image.SCALE_SMOOTH);
            this.sportsButton.setIcon(new ImageIcon(scaledImage));
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
    
    public void addViews() {
        this.frame.add(this.menuButton);
        this.frame.add(this.sportsButton);
        this.frame.add(this.betButton);
        this.frame.add(this.simulateButton);
        this.frame.add(this.accountLabel);
        this.frame.add(this.tableTitleLabel);
        this.frame.add(this.table);
        this.frame.add(this.betTextField);
        

    }
    
    public void loadSportsDataFromFile() {
    
    }
    
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == this.menuButton) {
            
            MainMenuView menuView = new MainMenuView();
            this.frame.setVisible(false);
            
        }
        else if (action.getSource() == this.betButton) {
        }
        else if (action.getSource() == this.simulateButton) {
            RecapView recapView = new RecapView();
        }
        
    }
    
    public void setJTableColumnsWidth(JTable table, int tableWidth, int... widths) {
        
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
    
}
