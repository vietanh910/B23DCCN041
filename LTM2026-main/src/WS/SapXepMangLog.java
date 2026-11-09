package WS;

import ptit.dblab.judge.network.server.soap.*;
import java.util.*;

public class SapXepMangLog {
    public static void main(String[] args) throws Exception {

        String msv = "B22DCCN902";
        String qCode = "dp1n9dyx";

        // Kết nối Web Service
        CharacterService service = new CharacterService();
        SoapCharacterService port = service.getSoapCharacterServicePort();

        // Lấy danh sách từ server
        List<String> list = port.requestStringArray(msv, qCode);

        // Che email, phone và token
        List<String> result = new ArrayList<>();

        for (String s : list) {
            s = s.replaceAll("email=\\S+", "email=[EMAIL]");
            s = s.replaceAll("phone=\\S+", "phone=[PHONE]");
            s = s.replaceAll("token=\\S+", "token=[TOKEN]");
            result.add(s);
        }

        // Sắp xếp ERROR -> WARN -> INFO
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return priority(s1) - priority(s2);
            }
        });

        // Gửi lại server
        port.submitStringArray(msv, qCode, result);

        System.out.println(result);
    }

    static int priority(String s) {
        if (s.startsWith("ERROR")) return 0;
        if (s.startsWith("WARN")) return 1;
        return 2; // INFO
    }
}

/*Một dịch vụ web hỗ trợ SOAP version 1.1 được định nghĩa trong CharacterService?wsdl và triển khai tại http://<Exam_IP>:2221/CharacterService?wsdl.

Yêu cầu
a. Sử dụng mã sinh viên và mã câu hỏi làm tham số khi gọi các phương thức SOAP. Ví dụ: studentCode="B21DCCN001", qCode="BAA62945".

b. Triệu gọi phương thức requestStringArray(studentCode, qCode) để nhận danh sách chuỗi log List<String> từ server. Ví dụ một phần tử: ERROR user=a email=a@example.com phone=0123456789 token=abc.

c. Che email, số điện thoại và token trong từng dòng, sau đó sắp xếp các dòng theo mức ERROR, WARN, INFO.

d. Triệu gọi submitStringArray(studentCode, qCode, data) để gửi danh sách chuỗi đã xử lý. Ví dụ phần tử nộp lại: ERROR user=a email=[EMAIL] phone=[PHONE] token=[TOKEN].

e. Kết thúc chương trình client.*/