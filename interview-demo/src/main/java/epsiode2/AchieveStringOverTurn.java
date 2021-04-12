package epsiode2;

/**
 * 字符串翻转
 *
 * @author zhangzichen
 * @date 2021/04/12 11:08
 */
public class AchieveStringOverTurn {

    public static void main(String[] args) {
        String str = "efg";
        method_1(str);
        method_2(str);
        method_3(str);
    }

    /**
     * 利用工具类
     *
     * @param str 字符串
     */
    private static void method_1(String str) {
        StringBuilder builder = new StringBuilder(str);
        System.out.println(builder.reverse());
    }

    /**
     * 利用倒叙for
     *
     * @param str 字符串
     */
    private static void method_2(String str) {
        StringBuilder des = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            des.append(c);
        }
        System.out.println(des);
    }

    /**
     * 利用字符串的char数组
     *
     * @param str 字符串
     */
    private static void method_3(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        System.out.println(new String(chars));
    }
}
