package RMI.B22DCCN902;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import RMI.CharacterService;

public class RMI_Character_MaHoaURL {

    public static void main(String[] args) throws Exception {

        Registry rg = LocateRegistry.getRegistry("36.50.135.242", 1099);

        CharacterService sv =
                (CharacterService) rg.lookup("RMICharacterService");

        String s = sv.requestCharacter("B22DCCN902", "vFmOFNkt");

        System.out.println(s);

        String ans = URLEncoder.encode(s, StandardCharsets.UTF_8)
                               .replace("+", "%20");

        System.out.println(ans);

        sv.submitCharacter("B22DCCN902", "vFmOFNkt", ans);
    }
}