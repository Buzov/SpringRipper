package quoter;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import quoter.annotation.DeprecatedClass;

/**
 * PostProcessor для замены устареших(@DeprecatedClass) классов на аналоги
 * @author artur
 */
public class DeprecationHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> beanClass = Class.forName(beanClassName);
                DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
                if(annotation != null) {
                    beanDefinition.setBeanClassName(annotation.newImpl().getName());
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DeprecationHandlerBeanFactoryPostProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
