package 算法;

import java.util.Arrays;

/**
 * 数组乱序
 *
 * @author zhangzichen
 * @date 2021/04/21 15:23
 */
public class demo2 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < a.length - 1; i++) {
//			System.out.println("第"+(i+1)+"次遍历");

//			System.out.println("本次参与排序的范围为：1~"+(a.length-i));
            //随机得到一个下标，每次下标获取的范围随着遍历减一
            int random = (int) (Math.random() * (a.length - i));
            //将下标对应的元素与范围最大值对应元素交换位置
            //(第一次范围最大值为第10，第二次范围最大值为第9……)

//			System.out.println("本次以随机数"+random+"为下标所对应的元素"+a[random]+"与最后一个元素"+a[a.length-1-i]+"交换位置");
            int last = a[a.length - 1 - i];
            a[a.length - 1 - i] = a[random];
            a[random] = last;
//			System.out.println("本次遍历后的数组："+Arrays.toString(a));
//			System.out.println();
        }
        System.out.println("随机排序后的a数组："+ Arrays.toString(a));
    }
}
