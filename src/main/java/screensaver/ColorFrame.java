package screensaver;

import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author artur
 */
@Component
public abstract class ColorFrame extends JFrame{
    
    // @Autowired
    // private ApplicationContext context; //1 плохое решение
    // @Autowired
    // private Color color; // 2 не очень работает
    public ColorFrame () {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        getContentPane().setBackground(getColor());
        // getContentPane().setBackground(color); 2 не очень работает
        // getContentPane().setBackground(context.getBean(Color.class)); //1 плохое решение
        
        repaint();
    }

    protected abstract Color getColor();
}
