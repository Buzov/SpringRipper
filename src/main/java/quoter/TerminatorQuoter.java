/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoter;

import javax.annotation.PostConstruct;


/**
 *
 * @author artur
 */
@Profiling
public class TerminatorQuoter implements Quoter{

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;
    
    private String message;
    
    @PostConstruct
    public void init() {
        System.out.println("Phase 2");
        System.out.println(repeat);
    }
    
    public TerminatorQuoter() {
        System.out.println("Phase 1");
        System.out.println(repeat);
    }
    
    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3");
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
