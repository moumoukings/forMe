package sort;

import java.util.Arrays;

/**
 * 插入排序 O(n)
 *
 * @author zhangzichen
 * @date 2021/04/09 16:22
 */
public class Sort3 {
    public static void main(String[] args) {
        int array[] = {5, 69, 12, 3, 56, 789, 2, 5648, 23};

        //外层循环，从第二个开始比较
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                } else {
                    //如果不小于，说明插入完毕，退出内层循环
                    break;
                }
            }
            // 打印每趟排序结果
            for (int m = 0; m <= array.length - 1; m++) {
                System.out.print(array[m] + "\t");
            }
            System.out.println();
        }

        // 打印每趟排序结果
        for (int m = 0; m <= array.length - 1; m++) {
            System.out.print(array[m] + "\t");
        }
        System.out.println();
        int[] ints = sort6(array);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] sort6(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
        return array;
    }
}
