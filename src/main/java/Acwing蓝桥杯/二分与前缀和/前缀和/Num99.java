package Acwing蓝桥杯.二分与前缀和.前缀和;


import java.util.Scanner;

/*
地图上有 N 个目标，用整数Xi,Yi表示目标在地图上的位置，每个目标都有一个价值Wi。

注意：不同目标可能在同一位置。

现在有一种新型的激光炸弹，可以摧毁一个包含 R×R 个位置的正方形内的所有目标。

激光炸弹的投放是通过卫星定位的，但其有一个缺点，就是其爆炸范围，即那个正方形的边必须和x，y轴平行。

求一颗炸弹最多能炸掉地图上总价值为多少的目标。

输入格式
第一行输入正整数 N 和 R ,分别代表地图上的目标数目和正方形的边长，数据用空格隔开。

接下来N行，每行输入一组数据，每组数据包括三个整数Xi,Yi,Wi,分别代表目标的x坐标，y坐标和价值，数据用空格隔开。

输出格式
输出一个正整数，代表一颗炸弹最多能炸掉地图上目标的总价值数目。

数据范围
0≤R≤109
0<N≤10000,
0≤Xi,Yi≤5000
0≤Wi≤1000
输入样例：
2 1
0 0 1
1 1 1
输出样例：
1
 */

public class Num99 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();//输入目标数
        int R = scan.nextInt();//输入范围的边长
        int[][] S = new int[5010][5010];
        //输入数据
        int m = R;//记录最大矩阵的长
        int n = R;//记录最大矩阵的宽
        for(int i = 0,w;i < N;i++)
        {

            int x = scan.nextInt() + 1;//边界从1开始
            int y = scan.nextInt() + 1;
            w = scan.nextInt();
            m = Math.max(m, x);
            n = Math.max(n, y);
            S[x][y] = w;
        }
        //求A的二维前缀和S S[i,j] = S[i - 1,j] + S[i,j - 1] - S[i - 1,j - 1] + A[i,j]
        for(int i = 1;i <= m;i++)
            for(int j = 1;j <= n;j++)
            {
                S[i][j] += S[i-1][j] + S[i][j-1] - S[i-1][j-1];
            }
        //遍历所有边长为R的形的前缀和数组，找最大的那一个
        //A[x,y] = S[i,j] - S[i - R,j] - S[i,j-R] + S[i - R,j - R]
        int res = 0;
        for(int i = R;i <= m;i++)
            for(int j = R;j <= n;j++)
            {
                res = Math.max(res, S[i][j] - S[i - R][j] - S[i][j - R] + S[i - R][j - R]);
            }
        System.out.println(res);
    }
}

