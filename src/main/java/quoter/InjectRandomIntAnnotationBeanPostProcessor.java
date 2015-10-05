/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoter;

import java.lang.reflect.Field;
import java.util.Random;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

/**
 *
 * @author artur
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String string) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if(annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int i = min + random.nextInt(max - min);
                field.setAccessible(true);
                // field.set(i); бросает исключение
                ReflectionUtils.setField(field, bean, i); // вместо field.set(i);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String string) throws BeansException {
        return bean;
    }

}
