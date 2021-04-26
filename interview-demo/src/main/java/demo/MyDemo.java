package demo;

/**
 * @author zhangzichen
 * @date 2021/04/24 18:46
 */
public class MyDemo {

    public static void main(String[] args) {
        int array[] = {5, 69, 12, 3, 56, 789, 2, 5648, 23};
        int[] ints = sort2(array);
        for (int m = 0; m <= ints.length - 1; m++) {
            System.out.print(ints[m] + "\t");
        }
        int sort = search(array, 56);
        System.out.println();
        System.out.println(sort + " : " + array[sort]);
    }

    public static int[] sort2(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

    public static int[] sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
        }
        return arr;
    }

    public static int search(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
