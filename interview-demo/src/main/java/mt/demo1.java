package mt;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * zong
 *
 * @author zhangzichen
 * @date 2021/04/13 9:50
 */
public class demo1 {

    /**
     * 某比赛已经进入了淘汰赛阶段,已知共有n名选手参与了此阶段比赛，他们的得分分别是a_1,a_2….a_n,小美作为比赛的裁判希望设定一个分数线m，使得所有分数大于m的选手晋级，其他人淘汰。
     * 但是为了保护粉丝脆弱的心脏，小美希望晋级和淘汰的人数均在[x,y]之间。
     * 显然这个m有可能是不存在的，也有可能存在多个m，如果不存在，请你输出-1，如果存在多个，请你输出符合条件的最低的分数线。
     * <p>
     * 输入第一行仅包含三个正整数n,x,y，分别表示参赛的人数和晋级淘汰人数区间。(1<=n<=50000,1<=x,y<=n)
     * 输入第二行包含n个整数，中间用空格隔开，表示从1号选手到n号选手的成绩。(1<=|a_i|<=1000)
     * <p>
     * 输出仅包含一个整数，如果不存在这样的m，则输出-1，否则输出符合条件的最小的值。
     * <p>
     * 6 2 3
     * 1 2 3 4 5 6
     * <p>
     * 3
     */
    @Test
    public void test1() {
        int[] t = {1, 2, 3, 4, 5, 6};
        int i = outScores(6, 2, 3, t);
        System.out.println(i);
    }

    /**
     * @param n      参赛的人数
     * @param x      晋级的人数
     * @param y      淘汰的人数
     * @param scores 成绩数组
     * @return
     */
    public static int outScores(int n, int x, int y, int[] scores) {
        if (x * 2 > n || y * 2 < n) {
            return -1;
        }
        Arrays.sort(scores);
        int pre = -1;
        int preidx = -1;
        int[][] map = new int[2][scores.length];
        for (int i = scores.length - 1; i >= 0; i--) {
            if (scores[i] != pre) {
                pre = scores[i];
                preidx = i;
                map[0][i] = scores[i];
                map[1][i] = i + 1;
            } else {
                map[0][preidx] = scores[preidx];
                map[1][preidx] = preidx + 1;
            }
        }
        for (int i = x - 1; i < scores.length; i++) {
            int out = map[1][i];
            int up = scores.length - map[1][i];
            if (out >= x && out <= y && up >= x && up <= y) {
                return map[0][i];
            }
        }
        return -1;
    }

    /**
     * 我们称一个长度为n的序列为正则序列，当且仅当该序列是一个由1~n组成的排列，即该序列由n个正整数组成，取值在[1,n]范围，且不存在重复的数，同时正则序列不要求排序
     * 有一天小团得到了一个长度为n的任意序列，他需要在有限次操作内，将这个序列变成一个正则序列，每次操作他可以任选序列中的一个数字，并将该数字加一或者减一。
     * 请问他最少用多少次操作可以把这个序列变成正则序列？
     * <p>
     * 输入第一行仅包含一个正整数n，表示任意序列的长度。(1<=n<=20000)
     * 输入第二行包含n个整数，表示给出的序列，每个数的绝对值都小于10000。
     * <p>
     * 输出仅包含一个整数，表示最少的操作数量。
     * <p>
     * 5
     * -1 2 3 10 100
     * <p>
     * 103
     */
    @Test
    public void test2_1() {
        Scanner sc = new Scanner(System.in);
        //输入n个正数
        int n = sc.nextInt();
        List<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        //对集合进行排序
        Collections.sort(list);
        int res = 0;
        //对于不等于当前i+1的值，对其进行加或减操作
        for (int i = 0; i < n; i++) {
            Integer num = list.get(i);
            if (num != (i + 1)) {
                res = res + Math.abs((i + 1) - num);
            }
        }
        System.out.println(res);
    }

    @Test
    public void test2_2() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine().trim());
            String[] strSeq = br.readLine().trim().split(" ");
            int[] seq = new int[n];
            for (int i = 0; i < n; i++) {
                seq[i] = Integer.parseInt(strSeq[i]);
            }
            Arrays.sort(seq);
            int modifyTimes = 0;
            for (int i = 1; i <= n; i++) {
                modifyTimes += Math.abs(seq[i - 1] - i);
            }
            System.out.println(modifyTimes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //test2_1();
        //test2_2();
    }

}
