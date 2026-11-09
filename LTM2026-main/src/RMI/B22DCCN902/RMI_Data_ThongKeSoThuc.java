package RMI.B22DCCN902;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import RMI.DataService;

public class RMI_Data_ThongKeSoThuc {

    public static void main(String[] args) throws Exception {

        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("36.50.135.242", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");

        String s = (String) sv.requestData("B22DCCN902", "pl8YVlmE");

        // b. Xử lý
        String[] arr = s.split(",");
        int n = arr.length;

        double[] a = new double[n];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            a[i] = Double.parseDouble(arr[i]);
            sum += a[i];
        }

        double avg = sum / n;

        double variance = 0;
        for (double x : a) {
            variance += (x - avg) * (x - avg);
        }
        double stddev = Math.sqrt(variance / n);

        Arrays.sort(a);
        int pos = (int) Math.ceil(n * 0.95) - 1;
        double p95 = a[pos];

        String res = String.format(
                "average=%.2f;stddev=%.2f;p95=%.2f",
                avg, stddev, p95);

        System.out.println(res);

        // c. Gửi kết quả
        sv.submitData("B22DCCN902", "pl8YVlmE", res);
    }
}