/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoter;

/**
 *
 * @author artur
 */
public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled;

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    
}
