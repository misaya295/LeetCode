package 蓝桥杯.国赛.国赛_2019;


import java.util.Scanner;

/*
对于一个字母矩阵，我们称矩阵中的一个递增序列是指在矩阵中找到两个
字母，它们在同一行，同一列，或者在同一 45 度的斜线上，这两个字母从左向
右看、或者从上向下看是递增的。
例如，如下矩阵中

LANN
QIAO

有LN、LN、AN、AN、IO、AO、LQ、AI、NO、NO、AQ、IN、AN 等 13 个
递增序列。注意当两个字母是从左下到右上排列时，从左向右看和从上向下看
是不同的顺序。
对于下面的 30 行 50 列的矩阵，请问总共有多少个递增序列？（如果你把
以下文字复制到文本文件中，请务必检查复制的内容是否与文档中的一致。在
试题目录下有一个文件 inc.txt，内容与下面的文本相同）

【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class Main1 {
    static int n=30, m=50;
    static char[][] g = new char[n][m];
    static int[] dx = {-1, 0, 1, 1, 1};
    static int[] dy = {1, 1, -1, 0, 1};
    static boolean[][] st = new boolean[n][m];
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) g[i] = sc.next().toCharArray();
        for(int i=0;i< n;i++){
            for (int j = 0; j < m; j++) {
                char c = g[i][j];
                for (int k = 0; k < 5; k++) {
                    int x = i;
                    int y = j;
                    while (true) {
                        x += dx[k];
                        y += dy[k];
                        if(x < 0|| x>= n ||y < 0|| y>=m) break;

                        if(g[x][y] > c) {
                            ans++;
                        }
                    }

                }

            }
        }
        System.out.println(ans);
    }

}
