package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class DecToBin {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN021", qCode = "2jS1DTpU"; 
        DataService service = new DataService();
        SoapDataService port = service.getSoapDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a) ans.add(Integer.toBinaryString(x));
        System.out.println(ans);
        port.submitDataStringArray(msv, qCode, ans);
    }
}