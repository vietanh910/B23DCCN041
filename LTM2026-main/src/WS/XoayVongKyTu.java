package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class XoayVongKyTu {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN902", qCode = "k0mQWqJB"; 
        CharacterService service = new CharacterService();
        SoapCharacterService port = service.getSoapCharacterServicePort();
        List<Integer>a = port.requestCharacter(msv, qCode);
        int timeRot = a.get(0)%(a.size());
        Collections.rotate(a, timeRot);
        port.submitCharacterCharArray(msv, qCode, a);
    }
}
