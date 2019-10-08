import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Write a description of class LogInViewController here.
 *
 * Justin Cabral
 * 1.0.0
 */


public class LogInViewController implements Observer
{
    private LogInView logInView;
    private AccountData accountData;
    
    public LogInViewController() {
        
        this.logInView = new LogInView();
    }
    
    public void update(Observable sender, Object sentObject) {
        
        Map data = (Map)sentObject;
        
        String username = ((String)data.get("username"));
        String password = ((String)data.get("password"));
        String isNewUser = ((String)data.get("newuser"));
        
        this.accountData = new AccountData(username,password);

        if (isNewUser == "yes") {
            if (this.accountData.checkIfUserExists(username) == false) {
                this.accountData.saveAccountData();
            }
            else {
                this.logInView.setMessageLabelText("Sign up failed. Username already exists.");
            }
        }
        else {
            if (this.accountData.checkIfUserExists(username)) {
                // Open up the menu menu view here
            }
            else{
                this.logInView.setMessageLabelText("Login failed. Username or Password is incorrect");
            }
        }
        
    }

}
