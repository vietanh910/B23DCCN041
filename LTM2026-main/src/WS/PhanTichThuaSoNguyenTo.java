package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class PhanTichThuaSoNguyenTo {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "TwZpbqUg"; 
        DataService service = new DataService();
        SoapDataService port = service.getSoapDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a){
            String tmp = "";
            for(int i = 2;i*i<=x;i++){
                while(x%i==0){
                    x/=i;
                    tmp+=String.format("%d, ", i);
                }
            }
            if(x > 1) tmp+=String.format("%d, ", x);
            tmp = tmp.trim();
            tmp = tmp.substring(0, tmp.length() - 1);
            ans.add(tmp);
            System.out.println(tmp);
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}
