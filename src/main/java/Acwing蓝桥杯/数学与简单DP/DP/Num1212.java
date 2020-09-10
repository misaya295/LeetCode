package Acwing蓝桥杯.数学与简单DP.DP;


/*
X 国王有一个地宫宝库，是 n×m 个格子的矩阵，每个格子放一件宝贝，每个宝贝贴着价值标签。

地宫的入口在左上角，出口在右下角。

小明被带到地宫的入口，国王要求他只能向右或向下行走。

走过某个格子时，如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，小明就可以拿起它（当然，也可以不拿）。

当小明走到出口时，如果他手中的宝贝恰好是 k 件，则这些宝贝就可以送给小明。

请你帮小明算一算，在给定的局面下，他有多少种不同的行动方案能获得这 k 件宝贝。

输入格式
第一行 3 个整数，n,m,k，含义见题目描述。

接下来 n 行，每行有 m 个整数 Ci 用来描述宝库矩阵每个格子的宝贝价值。

输出格式
输出一个整数，表示正好取 k 个宝贝的行动方案数。

该数字可能很大，输出它对 1000000007 取模的结果。

数据范围
1≤n,m≤50,
1≤k≤12,
0≤Ci≤12
输入样例1：
2 2 2
1 2
2 1
输出样例1：
2
输入样例2：
2 3 2
1 2 3
2 1 5
输出样例2：
14
 */
import java.util.Scanner;
public class Num1212 {


    static int N = 55;
    static int M = 15;
    static int MOD = 1000000007;
    static int n , m , c;
    static int[][] a = new int[N][N];
    static int[][][][] f = new int[N][N][M][M];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        c = input.nextInt();
        for(int i = 1; i <= n ; i++)
            for(int j = 1; j <= m ; j++) {
                a[i][j] = input.nextInt();
                a[i][j] ++;
            }
        f[1][1][0][0] = 1;
        f[1][1][1][a[1][1]] = 1;
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                for(int cnt = 0; cnt <= c; cnt++)
                    for(int k = 0; k < M; k++){
                        //不拿物品
                        f[i][j][cnt][k] = (f[i][j][cnt][k] + f[i - 1][j][cnt][k]) % MOD;
                        f[i][j][cnt][k] = (f[i][j][cnt][k] + f[i][j - 1][cnt][k]) % MOD;

                        //可以拿
                        if(cnt>0&&k == a[i][j]){
                            for(int s = 0; s < a[i][j]; s++){
                                f[i][j][cnt][k] = (f[i][j][cnt][k] + f[i - 1][j][cnt - 1][s]) % MOD;
                                f[i][j][cnt][k] = (f[i][j][cnt][k] + f[i][j - 1][cnt - 1][s]) % MOD;
                            }
                        }
                    }


        int res = 0;
        for(int i = 1; i < M ; i++){
            res = (res + f[n][m][c][i])%MOD;
        }
        System.out.println(res);
    }



}
