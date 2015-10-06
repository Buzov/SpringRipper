package screensaver;

import java.awt.Color;
import java.util.Random;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author artur
 */
@Configuration
@ComponentScan(basePackages = "screensaver")
public class Config {
    @Bean
    // @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS) при каждом обращении получаем новый бин
    @Scope(value = "periodical")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));    
    }
    
    @Bean
    @Scope(value = "singleton")
    public ColorFrame frame() {
        return new ColorFrame() {

            @Override
            protected Color getColor() {
                return color();
            }
        };
    }
    
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while(true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(50);
        }
    }
}
