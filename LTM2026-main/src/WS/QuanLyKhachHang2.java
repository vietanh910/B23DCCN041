package WS;

import ptit.dblab.judge.network.server.soap.*;
import java.util.*;

public class QuanLyKhachHang2 {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN902";
        String qCode = "yfyrOJUP";

        ObjectService service = new ObjectService();
        SoapObjectService port = service.getSoapObjectServicePort();

        List<Customer> list = port.requestListCustomer(msv, qCode);

        if (list == null || list.isEmpty()) {
            System.out.println("No customer data received.");
            return;
        }

        List<Customer> ans = new ArrayList<>();

        // Lọc
        for (Customer c : list) {
            if (c.getPurchaseCount() >= 6 && c.getTotalSpent() >= 4000) {
                ans.add(c);
            }
        }

        // Sắp xếp
        Collections.sort(ans, new Comparator<Customer>() {
            @Override
            public int compare(Customer a, Customer b) {
                if (a.getTotalSpent() != b.getTotalSpent()) {
                    return Float.compare(b.getTotalSpent(), a.getTotalSpent()); // giảm dần
                }
                return a.getCustomerId().compareTo(b.getCustomerId()); // tăng dần
            }
        });

        // Gửi kết quả
        port.submitListCustomer(msv, qCode, ans);
    }
}
