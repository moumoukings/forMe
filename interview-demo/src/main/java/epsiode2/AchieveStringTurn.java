package epsiode2;

/**
 * 写一个函数，反转字符串中每个字符的顺序，同时保留单词和空格的初始位置
 *
 * @author zhangzichen
 * @date 2021/04/12 11:08
 */
public class AchieveStringTurn {

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        String sep = " ";
        method_1(str, sep);
    }

    /**
     * 利用substring
     *
     * @param in  被截取字符串
     * @param sep 分割符号
     */
    private static void method_1(String in, String sep) {
        StringBuilder builder = new StringBuilder();
        //先对每个字符串分割
        String[] arrays = in.split(sep);
        //遍历每个字符，将它反转
        for (int i = 0; i < arrays.length; i++) {
            String array = arrays[i];
            String s = method_2(array);
            builder.append(s).append(sep);
        }
        System.out.println(builder);
    }

    /**
     * 利用字符串的char数组
     *
     * @param str 字符串
     */
    private static String method_2(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }
}
