package epsiode2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 在字符串中查出第一个只出现一次的字符 todo 不完善
 *
 * @author zhangzichen
 * @date 2021/04/08 17:23
 */
public class AchieveGetOnlyAppearsOnceStr {

    public static void main(String[] args) {
        String str = "dsadasdwaafasdcdc";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer count = map.get(c);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(c, count);
        }

        LinkedHashMap<Character, Integer> linkedHashMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        linkedHashMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        System.out.println("字符串中查出第一个只出现一次的字符:" + linkedHashMap.keySet().stream().findFirst());

    }
}
