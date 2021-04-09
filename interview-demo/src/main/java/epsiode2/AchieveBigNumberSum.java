package epsiode2;

/**
 * 实现两个大数之和
 *
 * @author zhangzichen
 * @date 2021/04/08 12:57
 */
public class AchieveBigNumberSum {

    /**
     * 例如：
     * String a="123456777....." a.size 大于1000位
     * String b="345678999....." b.size 大于1000位
     *
     * 思路：
     *  1、区分出两个大数的大小
     *  2、将两个大数分别存入char数组
     *  3、将大的char数组长度加1，最终结果位数为大char数组长度+1
     *  4、将大char数组正序遍历压入int数组（数组大小为最终结果数）
     *  5、正序遍历小char数组，累加小char数组值
     *  6、正序遍历int数组，位置值大于9，进行判断进位，及后一位加前一位对10取余的值，前一位值对10求模的值
     *  7、反序拼接int数组，获取大数的和
     *  8、对结果的最高位判断是否为0，是的话需要截取了
     *  9、返回最后截取结果
     */
    public static void main(String[] args) {
        System.out.println(10001+9999998);
        String a = "10001";
        String b = "9999998";
        //大数组
        char[] large = null;
        //小数组
        char[] small = null;
        //将大数和小数区分开
        if (a.length() > b.length()) {
            large = a.toCharArray();
            small = b.toCharArray();
        } else {
            large = b.toCharArray();
            small = a.toCharArray();
        }
        //大数长度加1
        //最终结果的位数 最高位可能是0 todo 默认设置第0个角标为个位
        int[] sums = new int[large.length + 1];
        for (int i = 0; i < large.length; i++) {
            //大数的位数值，从个位开始
            sums[i] = large[large.length - i - 1] - '0';
        }

        for (int i = 0; i < small.length; i++) {
            sums[i] += small[small.length - i - 1] - '0';
        }

//        for (int sum : sums) {
//            System.out.println(sum );
//        }
        //位置值大于9，进行判断进位
        for (int i = 0; i < sums.length - 1; i++) {
            //当前位置值大于9需要进位
            if (sums[i] > 9) {
                sums[i + 1] += sums[i] / 10;
                sums[i] %= 10;
            }
        }

        //拼接处理好的大数和 todo 从后往前
        StringBuilder builder = new StringBuilder();
        for (int i = sums.length - 1; i >= 0; i--) {
            builder.append(sums[i]);
        }

        //判断最高位有没有进位,如果最高位是0说明没有进位
        String result = builder.toString();
        if(result.startsWith("0")){
            result.substring(1);
        }
        System.out.println(result);
    }

}
