package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class DonHang2 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN021", qCode = "CuW1L0ev"; 
        ObjectService service = new ObjectService();
        SoapObjectService port = service.getSoapObjectServicePort();
        List<Order>a = (List<Order>)port.requestListOrder(msv, qCode);
        for(Order x: a) System.out.println(x);
        HashMap<String, Float>mp = new HashMap<>();
        for(Order x: a){
            String maKH = x.getCustomerId(); float giaTri = x.getAmount();
            if(!mp.containsKey(maKH)) mp.put(maKH, giaTri);
            else mp.put(maKH, mp.get(maKH) + giaTri);
        }
        float maxGiaTri = 0; String maKHmax = "";
        for (String maKH: mp.keySet()) {
            float giaTri = mp.get(maKH);
            if (giaTri > maxGiaTri) {
                maxGiaTri = giaTri;
                maKHmax = maKH;
            }
        }
        List<Order>ans = new java.util.ArrayList<>();
        for(Order x: a){
            if(x.getCustomerId().equals(maKHmax)) ans.add(x);
        }
        port.submitListOrder(msv, qCode, ans);
    }
}