package screensaver;

import static java.time.LocalTime.now;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 *
 * @author artur
 */
public class PeriodicalScopeConfigurer implements Scope {
    
    Map<String, Pair<LocalTime, Object>> map = new HashMap<>();
   
    @Override
    public Object get(String name, ObjectFactory<?> of) {
        if(map.containsKey(name)) {
            Pair<LocalTime, Object> pair = map.get(name);
            
            int secondsSinceLastRequest = now().getSecond() - pair.getKey().getSecond();
            if(secondsSinceLastRequest > 1) {
                map.put(name, new Pair(now(), of.getObject()));
            }
        } else if (!map.containsKey(name)){
            map.put(name, new Pair(now(), of.getObject()));
        }
        return map.get(name).getValue();
    }

    @Override
    public Object remove(String string) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String string, Runnable r) {
        
    }

    @Override
    public Object resolveContextualObject(String string) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
    
}
