package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class QuanLyKhachHang {
    public static void main(String[] args) throws Exception{
        String msv = "B22DCCN902", qCode = "yfyrOJUP"; 
        ObjectService service = new ObjectService();
        SoapObjectService port = service.getSoapObjectServicePort();
        List<Customer> a = port.requestListCustomer(msv, qCode);
        if (a == null || a.isEmpty()) {
            System.out.println("No customer data received from server.");
            return;
        }

        for (Customer x : a) {
            System.out.println(x);
        }

        List<Customer> ans = new ArrayList<>();
        for (Customer x : a) {
            if (x.getTotalSpent() > 500 && x.getPurchaseCount() >= 3) {
                ans.add(x);
            }
        }

        System.out.println();
        for (Customer x : ans) {
            System.out.println(x);
        }

        port.submitListCustomer(msv, qCode, ans);
    }
}