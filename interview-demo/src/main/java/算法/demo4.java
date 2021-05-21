package 算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * m个数中选出第n个大的数字
 *
 * @author zhangzichen
 * @date 2021/04/26 12:25
 */
public class demo4 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 12, 45, 32, 456, 23};
        int n = 6;
        System.out.println("第" + n + "大的数是：" + getMax(arr, n));
    }

    /**
     * {2,3,12,45,32,456,23}
     *
     * @param arr
     * @param n
     * @return
     */
    public static int getMax(int[] arr, int n) {
        List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int count = 1;
        Integer result = null;
        HashMap<Integer, Integer> map = new HashMap<>();
        //假设第n个大的数字，判断他前面是否刚好有n-1个数比他小
        for (int i = 0; i < arr.length; i++) {
            collect.remove(0);
            for (int j = 0; j < collect.size(); j++) {
                if (collect.get(j) < arr[i]) {
                    count++;
                    map.put(arr[i], count);
                }
            }
            collect.add(arr[i]);
            count = 1;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n) {
                result = entry.getKey();
            }
        }
        return result;
    }

}
