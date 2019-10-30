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
    
   //List of users
    private static ArrayList<AccountData> users = new ArrayList<AccountData>();
    
    /** Public accessor / mutator methods 
     * 
     */
    public AccountData(){
        this.username = null;
        this.password = null;
        this.balance = 0.0;
    }
    
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

    //Adding user into Users arraylist will store all users
    public boolean inputUser(AccountData user){
        
        
            if(checkIfUserExists(user.getUserName()) == false && user.password != null){
                users.add(user);
                return true;
        }
        
        return false;
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
        
        for(int i=0; i< users.size();i++){
            AccountData test = users.get(i);
            if((test.getUserName().equals(username))){
                return true;}}
        return false;
    }
    
    public boolean checkIfPasswordIsCorrect(String username,String password) {
        // Check if password is correct by reading the text file, assinging passwords to arraylist, and search the list
        for(int i=0; i< users.size();i++){
            AccountData test = users.get(i);
            if(test.getPassword().equals(password)&& test.getUserName().equals(username)){
                return true;}}
        return false;
    }
}
