package WS;

import ptit.dblab.judge.network.server.soap.*;
import java.util.*;

public class NguyenToVaChecksum {
    public static void main(String[] args) throws Exception {

        String msv = "B22DCCN902";
        String qCode = "y3Kr7vEG";

        // Kết nối Web Service
        DataService service = new DataService();
        SoapDataService port = service.getSoapDataServicePort();

        // Lấy dữ liệu
        List<Integer> a = port.getData(msv, qCode);

        int primeCount = 0;
        long checksum = 0;

        for (int i = 0; i < a.size(); i++) {
            int x = a.get(i);

            if (isPrime(x)) primeCount++;

            checksum = (checksum + (long)(i + 1) * x) % 100000;
        }

        String ans = "primeCount=" + primeCount + ";checksum=" + checksum;

        System.out.println(ans);

        // Gửi kết quả
        port.submitDataString(msv, qCode, ans);
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

/*Một dịch vụ web hỗ trợ SOAP version 1.1 được định nghĩa trong DataService?wsdl và triển khai tại http://<Exam_IP>:2221/DataService?wsdl.

Yêu cầu
a. Sử dụng mã sinh viên và mã câu hỏi làm tham số khi gọi các phương thức SOAP. Ví dụ: studentCode="B21DCCN001", qCode="A1B2C3D4".

b. Triệu gọi phương thức getData(studentCode, qCode) để nhận danh sách số nguyên List<Integer> từ server. Ví dụ: [11,12,13,20].

c. Đếm số nguyên tố trong danh sách và tính checksum theo công thức sum((i + 1) * value[i]) mod 100000, với i bắt đầu từ 0.

d. Triệu gọi submitDataString(studentCode, qCode, data) để gửi chuỗi primeCount=<n>;checksum=<m>. Ví dụ: primeCount=2;checksum=154.

e. Kết thúc chương trình client.*/