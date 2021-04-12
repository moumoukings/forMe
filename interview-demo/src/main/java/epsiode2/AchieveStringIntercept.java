package epsiode2;

/**
 * 输入一个字符串和字节数，按照字节数截取字符串，但是汉子不能被截取半个
 *
 * @author zhangzichen
 * @date 2021/04/12 10:16
 */
public class AchieveStringIntercept {

    public static void main(String[] args) {
        method_1("人ABC们DEF", 7);
    }

    /**
     * @param str 被截取字符串
     * @param num 截取字节数
     */
    private static void method_1(String str, int num) {
        //不同系统汉字所占的字节数不一样
        //int len = String.valueOf('A').getBytes().length;
        //System.out.println(len);
        //已经截取的数量
        int sum = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            //每个字符的字节数
            int length = String.valueOf(str.charAt(i)).getBytes().length;
            //判断截取范围
            if (sum + length <= num) {
                sum += length;
                builder.append(str.charAt(i));
            }else {
                break;
            }
        }
        System.out.println(builder);
    }
}
