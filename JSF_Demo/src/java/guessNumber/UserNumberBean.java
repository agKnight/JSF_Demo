/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guessNumber;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Random;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author agknight
 */
@Named(value = "UserNumberBean")
@SessionScoped
public class UserNumberBean implements Serializable {

    Integer randomInt;
    private Integer userNumber;
    private String response;
    /**
     * Creates a new instance of UserNumberBean
     */
    public UserNumberBean() {
        Random randomGR = new Random();
        randomInt = randomGR.nextInt(10);
        System.out.println("Dukes number: " + randomInt);
        
    }

    /**
     * @return the userNumber
     */
    public Integer getUserNumber() {
        return userNumber;
    }

    /**
     * @param userNumber the userNumber to set
     */
    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        if((userNumber != 1 ) && (userNumber.compareTo(randomInt) == 0)){
            //Invalidate user session
            
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();
            
            return "Yay! You got it!";
        }else{
            return "<p>Sorry, " + userNumber + "isn't it.</p>" + "<p>Guess Again...</p>";
        }
    }
    
}
