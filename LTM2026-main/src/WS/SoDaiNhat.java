/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package WS;

import ptit.dblab.judge.network.server.soap.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author win
 */
public class SoDaiNhat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello");
        //data_webservice ds_web= new data_webservice();
        String studentCode="B22DCCN902";
        String qCode="PKSZIrFl";
       
        DataService service = new DataService();
        List<Integer> list_numbers= service.getSoapDataServicePort().getData(studentCode,qCode);
        for (Integer number:list_numbers){
            System.out.println(number);
        }
       
        List<String> strList = new ArrayList<>();
            for (Integer num : list_numbers) {
                strList.add(String.valueOf(num));
            }

        
        Collections.sort(strList, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String s : strList) {
            sb.append(s);
        }
        String result = sb.toString();
        System.out.println(result);
       
     
        service.getSoapDataServicePort().submitDataString(studentCode, qCode, result);
       
       
    }
   
}