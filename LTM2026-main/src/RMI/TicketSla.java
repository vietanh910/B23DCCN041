package RMI;

import java.io.Serializable;

public class TicketSla implements Serializable {

    private static final long serialVersionUID = 20260517L;

    public String ticketId;
    public String priority;
    public int openedHoursAgo;
    public boolean breached;
    public String action;

    public String getPriority() {
        return priority;
    }

    public int getOpenedHoursAgo() {
        return openedHoursAgo;
    }

    public void setBreached(boolean breached) {
        this.breached = breached;
    }

    public void setAction(String action) {
        this.action = action;
    }
}