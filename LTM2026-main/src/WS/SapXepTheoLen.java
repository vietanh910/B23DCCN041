package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class SapXepTheoLen {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN003", qCode = "mpu9xCxR"; 
        // Tạo đối tượng dịch vụ từ web service
        CharacterService service = new CharacterService();
        SoapCharacterService port = service.getSoapCharacterServicePort();
        // a. Triệu gọi phương thức requestStringArray từ server 
        List<String> a = port.requestStringArray(msv, qCode);
        // b. Sắp xếp các chuỗi theo số lượng nguyên âm
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, a);
        System.out.println(a);
    }
}