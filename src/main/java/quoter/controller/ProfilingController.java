package quoter.controller;

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
