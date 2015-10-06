package quoter.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннонтация указывает на устаревшие классы и содержит ссылку 
 * на альтернативное решение
 * @author artur
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {
    Class newImpl();
}
