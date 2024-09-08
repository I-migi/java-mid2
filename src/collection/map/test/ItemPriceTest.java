package collection.map.test;

import java.util.*;

public class ItemPriceTest {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>(); map.put("사과", 500);
        map.put("바나나", 500);
        map.put("망고", 1000);
        map.put("딸기", 1000); // 코드 작성

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        for (Map.Entry<String, Integer> entry : list) {
            if(entry.getValue().equals(1000)) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }

    }
}
