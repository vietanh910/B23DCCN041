package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class PhanLoaiHocLuc {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN003", qCode = "qNfIMvid"; // Mã câu hỏi
        ObjectService service = new ObjectService();
        SoapObjectService port = service.getSoapObjectServicePort();
        List<Student> a = (List<Student>) port.requestListStudent(msv, qCode);
        for(Student x: a) System.out.println(x);
        System.out.println();
        List<Student>ans = new java.util.ArrayList<>();
        for(Student x: a){
            if(x.getScore() >=8.0) ans.add(x);
            else if (x.getScore() < 5) ans.add(x);
        }
        for(Student x: ans) System.out.println(x);
        port.submitListStudent(msv, qCode, ans);
    }
}