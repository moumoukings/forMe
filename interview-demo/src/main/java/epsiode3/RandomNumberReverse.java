package epsiode3;

import java.util.Random;

/**
 * 1-100随机数逆序输出
 *
 * @author zhangzichen
 * @date 2021/04/12 12:58
 */
public class RandomNumberReverse {
    /**
     * 从小到大输出
     * 并输出相应的序号
     */
    public static void main(String[] args) {
        //随机10个数
        Random random = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100) + 1;
        }
        System.out.println("打印十个1-100的随机数:");
        printArray(a);
        bubble(a);
        System.out.println("对这十个数顺序输出:");
        printArray(a);
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序 从小到大
     *
     * @param array
     */
    public static void bubble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
