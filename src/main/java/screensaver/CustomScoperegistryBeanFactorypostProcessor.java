package screensaver;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * регистрирует новый scope 
 * @author artur
 */
@Component
public class CustomScoperegistryBeanFactorypostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory clbf) throws BeansException {
        clbf.registerScope("periodical", new PeriodicalScopeConfigurer());
    }
    
}
