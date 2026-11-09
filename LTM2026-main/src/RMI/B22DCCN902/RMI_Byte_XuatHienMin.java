package RMI.B22DCCN902;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;
public class RMI_Byte_XuatHienMin {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("36.50.135.242", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN902", "aO4vKK1v");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. Đếm
        int[] cnt = new int[10005]; 
        for (byte x : a) cnt[x]++;
        byte ptuMin = a[0]; 
        int slMin = cnt[a[0]];
        for (byte x : a) {
            if (cnt[x] < slMin) {
                ptuMin = x;
                slMin = cnt[x];
            }
        }
        System.out.println(ptuMin + " " + slMin);
        // c. Gửi
        byte[] res = {ptuMin, (byte)slMin};
        sv.submitData("B21DCCN902", "aO4vKK1v", res);
    }
}