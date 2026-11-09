package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class LonNhoThuK {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN003", qCode = "WpaUTFMu"; 
        DataService service = new DataService();
        SoapDataService port = service.getSoapDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        int k = a.get(0); a.remove(0);
        System.out.println(a + " " + k);
        Collections.sort(a);
        int nhoThuK = a.get(k - 1), lonThuK = a.get(a.size() - k);
        List<Integer>ans = new java.util.ArrayList<>(Arrays.asList(lonThuK, nhoThuK));
        port.submitDataIntArray(msv, qCode, ans);
    }
}
