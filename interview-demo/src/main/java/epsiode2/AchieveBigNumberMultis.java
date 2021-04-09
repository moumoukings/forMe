package epsiode2;

/**
 * 两个大数求积
 *
 * @author zhangzichen
 * @date 2021/04/08 14:49
 */
public class AchieveBigNumberMultis {
    /**
     * 例如：
     * String a="123456777....." a.size 大于1000位
     * String b="345678999....." b.size 大于1000位
     * <p>
     * 当一个n位数*m位数结果最高位数一般为    n+m，两个数的位数之和
     * <p>
     * 思路：
     * 1、区分出两个大数的大小
     * 2、将两个大数分别存入char数组
     * 3、将大的char数组长度加1，最终结果位数为大char数组长度+小char数组长度
     * 4、将大char数组反向遍历，内部反向遍历小char数组，分别获取最后一位，相乘的值累加给int数组（数组大小为最终结果数）
     * 5、正序遍历int数组，位置值大于9，进行判断进位，及后一位加前一位对10取余的值，前一位值对10求模的值
     * 6、反序拼接int数组，获取大数的和
     * 7、对结果的最高位判断是否为0，是的话需要截取了
     * 8、返回最后截取结果
     */
    public static void main(String[] args) {
        System.out.println(99 * 993);
        String a = "99";
        String b = "993";
        //大数组
        char[] large = null;
        char[] small = null;
        //将大数和小数区分开
        if (a.length() > b.length()) {
            large = a.toCharArray();
            small = b.toCharArray();
        } else {
            large = b.toCharArray();
            small = a.toCharArray();
        }
        //最终结果的位数
        int[] multi = new int[large.length + small.length];

//        for (int i = small.length - 1; i >= 0; i--) {
//            for (int j = large.length - 1; j >= 0; j--) {
//                int num1 = small[i] - '0';
//                int num2 = large[j] - '0';
//                multi[(large.length-1-j)+(small.length-1-i)] += num1 * num2;
//            }
//        }
        for (int i = large.length - 1; i >= 0; i--) {
            for (int j = small.length - 1; j >= 0; j--) {
                //获取最后一位
                int num1 = large[i] - '0';
                int num2 = small[j] - '0';
                multi[(large.length-1-j)+(small.length-1-i)] += num1 * num2;
            }
        }

        for (int i = 0; i < multi.length - 1; i++) {
            //当前位置值大于9需要进位
            if (multi[i] > 9) {
                multi[i + 1] += multi[i] / 10;
                multi[i] %= 10;
            }
        }

        //拼接处理好的大数和 todo 从后往前
        StringBuilder builder = new StringBuilder();
        for (int i = multi.length - 1; i >= 0; i--) {
            builder.append(multi[i]);
        }

        //判断最高位有没有进位,如果最高位是0说明没有进位
        String result = builder.toString();
        if (result.startsWith("0")) {
            result.substring(1);
        }
        System.out.println(result);
    }
}
