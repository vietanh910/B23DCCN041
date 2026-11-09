package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class TongCacSo {
    public static void main(String[] args) throws Exception{
        String msv = "B22DCCN902", qCode = "fYtQUF1g"; 
        DataService service = new DataService();
        SoapDataService port = service.getSoapDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int tong = 0;
        for(int x: a) tong+=x;
        System.out.println(tong);
        port.submitDataInt(msv, qCode, tong);
    }
}
