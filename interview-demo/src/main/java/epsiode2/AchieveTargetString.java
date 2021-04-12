package epsiode2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 截取目标字符串
 *
 * @author zhangzichen
 * @date 2021/04/12 11:08
 */
public class AchieveTargetString {

    public static void main(String[] args) {
        String str = "<p id=\"text\">abcdefg</p>";
        String target = "efg";
        method_1(str,target);
        method_2(str,target);
    }

    /**
     * 利用substring
     * @param str    倍截取字符串
     * @param target 目标字符串
     */
    private static void method_1(String str, String target) {
        //获取目标字符串在源字符串中的索引位置
        int index = str.indexOf(target);
        String substring = str.substring(index, index + target.length());
        System.out.println(substring);
    }

    /**
     * 利用正则表达式
     * @param str    倍截取字符串
     * @param target 目标字符串
     */
    private static void method_2(String str, String target) {
        // 正则表达式
        String reg = "(.*)("+target+")(.*)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            //输出匹配到的值
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
    }
}
