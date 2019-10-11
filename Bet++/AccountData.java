import java.util.*;
/**
 * Write a description of class AccountData here.
 *
 * Justin Cabral
 * 1.0.0
 */

public class AccountData
{
    // instance variables 
    private String username;
    private String password;
    private double balance;
    
    private ArrayList<String> usernames;
    private ArrayList<String> passwords;
    
    
    /** Public accessor / mutator methods 
     * 
     */
    
    public void setUsername (String username) {
        this.username = username; 
    }
    
    public String getUserName() {
        return this.username;
    }
    
    public void setPassword (String password) {
        this.password = password;
    }
    
    public String getPassword () {
        return this.password;
    }
    
    public void setBalance(double funds) {
        this.balance = funds;
    }
    
    public double getBalance() {
        return this.balance;
    }

    /**
     * Constructor for objects of class AccountData
     */
    public AccountData(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.balance = 100.00;   
    }
    
    public boolean checkIfUserExists(String username) {
        // Check if username exists by reading the text file, assinging usernames to arraylist, and search the list
        return true;
    }
    
    public boolean checkIfPasswordIsCorrect(String password) {
        // Check if password is correct by reading the text file, assinging passwords to arraylist, and search the list
        return true;
    }
    
    public void saveAccountData() {
        // Write account data to file
    }

    
}
