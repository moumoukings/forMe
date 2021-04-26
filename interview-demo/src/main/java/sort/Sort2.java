package sort;

/**
 * 快速排序 O(nlog2n)
 *
 * @author zhangzichen
 * @date 2021/04/09 16:10
 */
public class Sort2 {

    public static void main(String[] args) {
        int array[] = {5, 69, 12, 3, 56, 789, 2, 5648, 23};

        for (int i = 0; i < array.length; i++) {
            //默认第一个最小
            int min = array[i];
            //记录最小的下标
            int index = i;
            //通过与后面的数据进行比较得出，最小值和下标
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            //然后将最小值与本次循环的，开始值交换
            int temp = array[i];
            array[i] = min;
            array[index] = temp;
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
    }
}
