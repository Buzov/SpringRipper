/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoter;

/**
 *
 * @author artur
 */
public class TerminatorQuoter implements Quoter{

    private String message;
    
    @Override
    public void sayQuote() {
        System.out.println(message);
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
