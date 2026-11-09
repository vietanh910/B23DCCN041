package WS;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class QuanLyDuAn {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN010", qCode = "R6UOuyyE";
        ObjectService service = new ObjectService();
        SoapObjectService port = service.getSoapObjectServicePort();
        List<Project>a = (List<Project>)port.requestListProject(msv, qCode);
        for(Project p: a) System.out.println(p);
        System.out.println();
        List<Project> send = new java.util.ArrayList<>();
        LocalDate today = LocalDate.now();
        for(Project x : a){
            String t = x.getDueDate().toString();
            t = t.substring(0, 10);
            LocalDate future = LocalDate.parse(t);
            long ngay = ChronoUnit.DAYS.between(today, future);
            if(ngay <=15 && ngay >=0 && x.getCompletionPercentage() >=80.00) send.add(x);
        }
        port.submitListProject(msv, qCode, send);
        for(Project p: send) System.out.println(p);
    }
}