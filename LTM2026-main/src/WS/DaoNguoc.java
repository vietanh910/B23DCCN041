package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class DaoNguoc {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B22DCCN902", qCode = "bTDaZ8iI"; 
        // Tạo đối tượng dịch vụ từ web service
        CharacterService service = new CharacterService();
		SoapCharacterService port = service.getSoapCharacterServicePort();
        // a. Triệu gọi phương thức 
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        //b.
        String ans = "";
        for(char x: s.toCharArray()){
            if(Character.isAlphabetic(x)) ans = x + ans;
        }
        System.out.println(ans);
        //c
        port.submitCharacterString(msv, qCode, ans);
    }
}