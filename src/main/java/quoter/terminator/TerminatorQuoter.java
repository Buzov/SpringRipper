package quoter.terminator;

import quoter.annotation.PostProxy;
import quoter.annotation.InjectRandomInt;
import quoter.annotation.Profiling;
import javax.annotation.PostConstruct;
import quoter.annotation.DeprecatedClass;


/**
 *
 * @author artur
 */
@Profiling
@DeprecatedClass(newImpl = T1000.class)
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
    public void sayQuote() {
        
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

    @Override
    @PostProxy
    public void say() {
        System.out.println("Phase 3");
    }

    /**
     * @param repeat the repeat to set
     */
    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }
    
    
    
}
