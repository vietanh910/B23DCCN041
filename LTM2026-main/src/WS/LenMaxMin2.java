package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class LenMaxMin2 {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN010", qCode = "sGJc3iD5"; 
        CharacterService service = new CharacterService();
		SoapCharacterService port = service.getSoapCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        String Max = a.get(0), Min = a.get(0);
        for(String x: a){
            if(x.length() > Max.length()) Max = x;
            if(x.length() < Min.length()) Min = x;
        }
        String ans = Max + ";" + Min;
        port.submitCharacterString(msv, qCode, ans);
    }
}