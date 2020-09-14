package Acwing蓝桥杯.双指针_BFS_图论.图论;



/*
有 N 个瓶子，编号 1∼N，放在架子上。

比如有 5 个瓶子：

2 1 3 5 4
要求每次拿起 2 个瓶子，交换它们的位置。

经过若干次后，使得瓶子的序号为：

1 2 3 4 5
对于这么简单的情况，显然，至少需要交换 2 次就可以复位。

如果瓶子更多呢？你可以通过编程来解决。

输入格式
第一行包含一个整数 N，表示瓶子数量。

第二行包含 N 个整数，表示瓶子目前的排列状况。

输出格式
输出一个正整数，表示至少交换多少次，才能完成排序。

数据范围
1≤N≤10000,

输入样例1：
5
3 1 2 5 4
输出样例1：
3
输入样例2：
5
5 4 3 2 1
输出样例2：
2
 */
import java.util.Scanner;
public class Num1224 {

    static int N = 10010;
    static Scanner scanner = new Scanner(System.in);
    static int n = scanner.nextInt();
    static int[] b = new int[N];
    static boolean[] st = new boolean[N];


    public static void main(String[] args) {


        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextInt();
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {

            if (!st[i]) {
                cnt++;
                for (int j = i; !st[j]; j =b[j]) {
                    st[j] = true;
                }
            }
        }
        System.out.println(n - cnt);

    }



}
