package sort;

/**
 * 冒泡排序 O(n²)
 *
 * @author zhangzichen
 * @date 2021/04/09 16:04
 */
public class Sort1 {

    public static void main(String[] args) {
        int array[] = {5, 69, 12, 3, 56, 789, 2, 5648, 23};

        //外层循环，遍历次数
        for (int i = 0; i < array.length; i++) {
            //内层循环，升序（如果前一个值比后一个值大，则交换
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
                // 打印每趟排序结果
                for (int m = 0; m <= array.length - 1; m++) {
                    System.out.print(array[m] + "\t");
                }
                System.out.println();
            }
        }

        for (int m = 0; m <= array.length - 1; m++) {
            System.out.print(array[m] + "\t");
        }
    }
}
