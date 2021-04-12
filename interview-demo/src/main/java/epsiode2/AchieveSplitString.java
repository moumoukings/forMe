package epsiode2;

/**
 * 写一个函数将句子按照一定的分割符，分割后返回
 *
 * @author zhangzichen
 * @date 2021/04/12 11:08
 */
public class AchieveSplitString {

    public static void main(String[] args) {
        String str = "I love the game";
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
        String[] arr = in.split(sep);
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length -1; i >= 0; i--) {
            builder.append(arr[i]).append(sep);
        }
        System.out.println(builder.substring(0, builder.length() - sep.length()));
    }
}
