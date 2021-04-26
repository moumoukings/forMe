package 算法;

/**
 * 是否是2的阶次方
 *
 * @author zhangzichen
 * @date 2021/04/21 15:07
 */
public class demo1 {
    public static boolean check(int sum) {
        boolean flag = true; //判断标志
        while (sum > 1) {
            if (sum % 2 == 0) {
                sum = sum / 2;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        boolean check = check(16);
        System.out.println(check);
    }
}
