package WS;

import ptit.dblab.judge.network.server.soap.*;
import java.util.*;

public class DemChanVaLe {
    public static void main(String[] args) throws Exception {

        String msv = "B22DCCN902";
        String qCode = "BAfzuAJi";

        // Kết nối Web Service
        DataService service = new DataService();
        SoapDataService port = service.getSoapDataServicePort();

        // Lấy dữ liệu
        List<Integer> a = port.getData(msv, qCode);

        int even = 0;
        int odd = 0;

        // Đếm số chẵn và số lẻ
        for (int x : a) {
            if (x % 2 == 0)
                even++;
            else
                odd++;
        }

        // Tạo danh sách kết quả
        List<String> ans = new ArrayList<>();
        ans.add("EVEN=" + even);
        ans.add("ODD=" + odd);

        System.out.println(ans);

        // Gửi kết quả
        port.submitDataStringArray(msv, qCode, ans);
    }
}