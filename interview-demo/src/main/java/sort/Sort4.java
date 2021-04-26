package sort;

/**
 * 二分查找
 *
 * @author zhangzichen
 * @date 2021/04/21 14:19
 */
public class Sort4 {

    public static int biSearch(int[] array, int a) {
        //第一个值
        int lo = 0;
        //最后一个值
        int hi = array.length - 1;
        //中间值
        int mid;
        while (lo <= hi) {
            //中间位置
            mid = (lo + hi) / 2;
            if (array[mid] == a) {
                return mid;
            } else if (array[mid] < a) {
                //向右查询
                lo = mid + 1;
            } else {
                //向左查询
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrray = {1, 2, 3, 4, 5};
        int a = 4;
        int i = biSearch(arrray, a);
        System.out.println(i);
    }
}
