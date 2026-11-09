package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class LietKeUoc {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN004", qCode = "nhFjYg0F"; 
        DataService service = new DataService();
        SoapDataService port = service.getSoapDataServicePort();
        int n = (int)port.getDataDouble(msv, qCode);
        System.out.println(n);
        List<Integer>ans = new java.util.ArrayList<>();
        for(int i = 1;i<=n;i++){
            if(n%i==0) ans.add(i);
        }
        ans.add(0, ans.size());
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}