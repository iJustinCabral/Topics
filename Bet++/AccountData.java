
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
    private double funds;
    
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
    
    public void setFunds(double funds) {
        this.funds = funds;
    }
    
    public double getFunds() {
        return this.funds;
    }

    /**
     * Constructor for objects of class AccountData
     */
    public AccountData(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.funds = 100.00;   
    }

    
}
