package epsiode2;

/**
 * 统计手机号各个数字个数，按照升序输出
 *
 * @author zhangzichen
 * @date 2021/04/12 10:06
 */
public class AchievePhoneNumber {

    public static void main(String[] args) {
        String mobile = "13677932224";
        method_1(mobile);
    }

    /**
     * 利用桶排序的思想
     *
     * @param mobile
     */
    private static void method_1(String mobile) {
        int[] count = new int[10];
        for (int i = 0; i < mobile.length(); i++) {
            char c = mobile.charAt(i);
            //减0转为整数
            count[c - '0']++;
        }

        for (int i = 0; i < count.length; i++) {
            //大于0说该数字有出现过
            if (count[i] > 0) {
                System.out.println(i + "出现了" + count[i]);
            }
        }
    }
}
