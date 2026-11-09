package WS;
import ptit.dblab.judge.network.server.soap.*;
import java.util.*;
public class QuanLySanPham {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN902", qCode = "SwiEmI9T"; // Mã câu hỏi
        ObjectService service = new ObjectService();
        SoapObjectService port = service.getSoapObjectServicePort();
        ProductY product = (ProductY) port.requestProductY(msv, qCode);
        System.out.println(product);
        float price = product.getPrice(), taxRate = product.getTaxRate(),discount = product.getDiscount();
        float finalPrice = price * (1 + taxRate / 100) * (1 - discount / 100);
        product.setFinalPrice(finalPrice);
        System.out.println(product);
        port.submitProductY(msv, qCode, product);
    }
}