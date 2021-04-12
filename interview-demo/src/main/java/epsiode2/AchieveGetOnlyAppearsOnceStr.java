package epsiode2;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串中查出第一个只出现一次的字符 todo 不完善
 *
 * @author zhangzichen
 * @date 2021/04/08 17:23
 */
public class AchieveGetOnlyAppearsOnceStr {

    public static void main(String[] args) {
        String str = "dsadasdwaafasdcdc";
        method_1(str);
        method_2(str);

       /* LinkedHashMap<Character, Integer> linkedHashMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        linkedHashMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        System.out.println("字符串中查出第一个只出现一次的字符:" + linkedHashMap.keySet().stream().findFirst());*/

    }

    /**
     * 采用map的方式
     * @param str
     */
    private static void method_1(String str) {
        Map<Character, Integer> map = new HashMap<>();

        //每次字符出现的次数
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

        //查询出第一个只出现一次的字符
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                System.out.println("字符串中查出第一个只出现一次的字符:" + str.charAt(i));
                break;
            }
        }
    }

    /**
     * 采用String里的api 代码量少
     * @param str
     */
    private static void method_2(String str){
        //第一次出现的位置和最后一次是一样的，代表之出现了一次
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(str.indexOf(c) == str.lastIndexOf(c)){
                System.out.println("字符串中查出第一个只出现一次的字符:" + str.charAt(i));
                break;
            }
        }
    }
}
