package epsiode2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 获取字符串中字符出现次数最多的字符
 *
 * @author zhangzichen
 * @date 2021/04/08 16:03
 */
public class AchieveGetMaxString {

    /**
     * 例如：
     * String a="asdsdasewa" a.size a出现：3次，s出现：3次，d出现：2次，e出现：1次，w出现：1次
     * <p>
     * 思路：
     */
    public static void main(String[] args) {
        String a = "人asds人出dasewa123addddaa";
        //双层for循环逆序输出
        test1(a);

        //利用map
        test2(a);
        //利用map逆序输出
        test3(a);
    }

    private static void test1(String a) {
        char[] str = a.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            //计数参数
            int count = 0;
            for (int j = 0; j < str.length; j++) {
                if (str[i] == str[j]) {
                    count++;
                }
                map.put(str[i], count);
            }
        }
        LinkedHashMap<Character, Integer> linkedHashMap = sortByValue(map);
        linkedHashMap.forEach((k, v) -> {
            System.out.println(k + "：" + v);
        });
    }

    private static void test2(String a) {
        char res = a.charAt(0);
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            Integer count = map.get(c);
            //字符没有出现
            if (count == null) {
                count = 1;
                //map.put(c, count);
            } else {
                count++;
                //map.put(c, count + 1);
            }
            map.put(c, count);
            if (count > max) {
                res = c;
                max = count;
            }
        }
        System.out.println(res + "出现次数最多：" + max);
    }

    private static void test3(String a) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            Integer count = map.get(c);
            //字符没有出现
            if (count == null) {
                count = 1;
                //map.put(c, count);
            } else {
                count++;
                //map.put(c, count + 1);
            }
            map.put(c, count);
        }

        LinkedHashMap<Character, Integer> linkedHashMap = sortByValue(map);
        linkedHashMap.forEach((k, v) -> {
            System.out.println(k + "：" + v);
        });
    }

    /**
     * 根据map的value值进行排序
     *
     * @param map
     * @return
     */
    private static LinkedHashMap<Character, Integer> sortByValue(Map<Character, Integer> map) {
        //naturalOrder 顺序 reverseOrder 逆序
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
    }
}
