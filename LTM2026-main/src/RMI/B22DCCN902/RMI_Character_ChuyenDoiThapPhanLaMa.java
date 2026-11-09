package RMI.B22DCCN902;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class RMI_Character_ChuyenDoiThapPhanLaMa {
    public static void main(String[] args)throws Exception{
        Registry rg = LocateRegistry.getRegistry("36.50.135.242", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN902", "5PIJgfas");
        System.out.println(s);
        //b.
        String rm = "";
        int dec = Integer.parseInt(s);
        int[] tp = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};//thập phân
        String[] lm = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};// la mã
        for(int i = 0;i<tp.length;i++){
            while(dec >=tp[i]){
                rm+=lm[i];
                dec-=tp[i];
            }
        }
        System.out.println(rm);     
        //c.
        sv.submitCharacter("B22DCCN902", "5PIJgfas", rm);
    }
}