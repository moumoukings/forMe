package epsiode2;

import java.util.HashSet;
import java.util.Set;

/**
 * 查出字符串中第一次重复出现的字符
 *
 * @author zhangzichen
 * @date 2021/04/08 17:16
 */
public class AchieveGetRecurringStr {

    public static void main(String[] args) {
        String str = "hjdsajdwxadaf";
        Set<Character> setStr = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            boolean add = setStr.add(str.charAt(i));
            //add等于true说明是第一次set，false说明已经加过
            if (!add) {
                System.out.println("字符串中第一次重复出现的字符:" + str.charAt(i));
                break;
            }
        }
    }
}
