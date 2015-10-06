package quoter;

import quoter.terminator.Quoter;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//import org.s
/**
 *
 * @author artur
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        // context.getBean(TerminatorQuoter.class).sayQuote(); плохой тон смотреть по имени класса
        // для профилирования
//        while(true) {
//            Thread.sleep(100);
//            context.getBean(Quoter.class).sayQuote();
//        }
        context.getBean(Quoter.class).sayQuote();        
        
    }
}
