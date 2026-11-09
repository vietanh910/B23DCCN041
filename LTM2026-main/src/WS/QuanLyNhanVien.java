package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class QuanLyNhanVien {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN902";
        String qCode = "Bsw5aU9i";

        ObjectService service = new ObjectService();
        SoapObjectService port = service.getSoapObjectServicePort();

        List<EmployeeY> a = port.requestListEmployeeY(msv, qCode);
        if (a == null || a.isEmpty()) {
            System.out.println("No employee data received from server.");
            return;
        }

        for (EmployeeY x : a) {
            System.out.println(x);
        }

        Collections.sort(a, new Comparator<EmployeeY>(){
            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                return o1.getStartDate().compare(o2.getStartDate());
            }
        });
        System.out.println();
        for(EmployeeY x: a) System.out.println(x);
        port.submitListEmployeeY(msv, qCode, a);
    }
}