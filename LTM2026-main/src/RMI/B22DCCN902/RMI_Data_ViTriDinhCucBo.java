package RMI.B22DCCN902;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class RMI_Data_ViTriDinhCucBo {

    public static void main(String[] args) throws Exception {

        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("36.50.135.242", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");

        int[] a = (int[]) sv.requestData("B22DCCN902", "vC4VFknJ");

        // b. Xử lý
        List<Integer> res = new ArrayList<>();

        int n = a.length;

        if (n == 1) {
            res.add(1);
        } else {

            // Phần tử đầu
            if (a[0] > a[1])
                res.add(1);

            // Các phần tử giữa
            for (int i = 1; i < n - 1; i++) {
                if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
                    res.add(i + 1); // đánh số từ 1
                }
            }

            // Phần tử cuối
            if (a[n - 1] > a[n - 2])
                res.add(n);
        }

        // c. Gửi kết quả
        sv.submitData("B22DCCN902", "vC4VFknJ", res);
    }
}