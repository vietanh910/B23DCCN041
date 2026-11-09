package RMI.B22DCCN902;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;
public class RMI_Byte_XuatHienMax {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("36.50.135.242", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN902", "821mCx3h");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. Đếm
        int[] cnt = new int[128]; 
        for (byte x : a) cnt[x]++;
        byte ptuMax = a[0];
        int slMax = cnt[ptuMax];
        for (byte x : a) {
            if (cnt[x] > slMax) {
                ptuMax = x;
                slMax = cnt[x];
            }
        }
        System.out.println(ptuMax + " " + slMax);
        // c. Gửi
        byte[] res = {ptuMax, (byte) slMax};
        sv.submitData("B22DCCN902", "821mCx3h", res);
    }
}