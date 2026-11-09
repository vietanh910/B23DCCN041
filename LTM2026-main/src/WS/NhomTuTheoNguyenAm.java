package WS;

import ptit.dblab.judge.network.server.soap.*;
import java.util.*;

public class NhomTuTheoNguyenAm {

    public static int countVowels(String s) {
        int cnt = 0;
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        String studentCode = "B22DCCN902";
        String qCode = "fNTJSwbK";

        CharacterService service = new CharacterService();
        SoapCharacterService port = service.getSoapCharacterServicePort();

        List<String> words = port.requestStringArray(studentCode, qCode);

        if (words == null || words.isEmpty()) {
            return;
        }

        Map<Integer, List<String>> map = new LinkedHashMap<>();

        for (String word : words) {
            int vowel = countVowels(word);
            map.computeIfAbsent(vowel, k -> new ArrayList<>()).add(word);
        }

        List<String> result = new ArrayList<>();

        for (List<String> list : map.values()) {
            Collections.sort(list);
            result.add(String.join(",", list)); // có khoảng trắng
        }

        System.out.println(result);

        port.submitCharacterStringArray(studentCode, qCode, result);
    }
}