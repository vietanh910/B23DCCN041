package RMI.B22DCCN902;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.TicketSla;

public class RMI_Object_TicketSla {

    public static void main(String[] args) throws Exception {

        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("36.50.135.242", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");

        TicketSla t = (TicketSla) sv.requestObject("B22DCCN902", "4HT0We7x");

        // b. Xử lý
        boolean breached = false;

        String priority = t.getPriority();
        int hours = t.getOpenedHoursAgo();

        if (priority.equals("CRITICAL") && hours > 2)
            breached = true;
        else if (priority.equals("HIGH") && hours > 8)
            breached = true;
        else if (priority.equals("MEDIUM") && hours > 24)
            breached = true;
        else if (priority.equals("LOW") && hours > 72)
            breached = true;

        t.setBreached(breached);

        if (!breached) {
            t.setAction("MONITOR");
        } else {
            if (priority.equals("CRITICAL") || hours > 96)
                t.setAction("ESCALATE_L2");
            else
                t.setAction("ESCALATE_L1");
        }

        // c. Gửi kết quả
        sv.submitObject("B22DCCN902", "4HT0We7x", t);
    }
}