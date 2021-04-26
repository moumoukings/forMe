package 算法;

/**
 * 算星期几
 *
 * @author zhangzichen
 * @date 2021/04/21 15:24
 */
public class demo3 {
    public static String[] week = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
    public static int i = 0;
    //非闰年
    public static int[] monthday1 = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    //闰年
    public static int[] monthday2 = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static String distance(int year, int month, int day, int weekDay, int newMonth, int newDay) {
        //设定初始距离天数
        int sum = weekDay;
        //是否超过一年
        if (month + newMonth > 12) {
            int yearCount = newMonth / 12;
            //判断是否是闰年
            if (((year + yearCount) % 4 == 0 && (year + yearCount) % 100 != 0) || (year + yearCount) % 400 == 0) {
                sum += 366 + newDay;
                for (int i = 0; i < newMonth - 12; i++) {
                    sum += monthday2[month + i];
                }
            } else {
                sum += 365 + newDay;
                for (int j = 0; j < newMonth - 12; j++) {
                    sum += monthday1[month + j];
                }
            }
        } else {
            for (int i = 0; i < newMonth; i++) {
                sum += monthday1[month + i];
            }
            sum += newDay;
        }
        //sum = sum + weekDay;
        return week[sum % 7];
    }

    public static void main(String[] args) {
//        System.out.println(26/12);
        String distance = distance(2023, 3, 1, 3, 13, 6);
        System.out.println(distance);

    }
}
