package Acwing蓝桥杯.递推与递归.练习;


import java.util.Scanner;

/**
 * 你玩过“拉灯”游戏吗？25盏灯排成一个5x5的方形。每一个灯都有一个开关，游戏者可以改变它的状态。每一步，游戏者可以改变某一个灯的状态。游戏者改变一个灯的状态会产生连锁反应：和这个灯上下左右相邻的灯也要相应地改变其状态。
 * <p>
 * 我们用数字“1”表示一盏开着的灯，用数字“0”表示关着的灯。下面这种状态
 * <p>
 * 10111
 * 01101
 * 10111
 * 10000
 * 11011
 * 在改变了最左上角的灯的状态后将变成：
 * <p>
 * 01111
 * 11101
 * 10111
 * 10000
 * 11011
 * 再改变它正中间的灯后状态将变成：
 * <p>
 * 01111
 * 11001
 * 11001
 * 10100
 * 11011
 * 给定一些游戏的初始状态，编写程序判断游戏者是否可能在6步以内使所有的灯都变亮。
 * <p>
 * 输入格式
 * 第一行输入正整数n，代表数据中共有n个待解决的游戏初始状态。
 * <p>
 * 以下若干行数据分为n组，每组数据有5行，每行5个字符。每组数据描述了一个游戏的初始状态。各组数据间用一个空行分隔。
 * <p>
 * 输出格式
 * 一共输出n行数据，每行有一个小于等于6的整数，它表示对于输入数据中对应的游戏状态最少需要几步才能使所有灯变亮。
 * <p>
 * 对于某一个游戏初始状态，若6步以内无法使所有灯变亮，则输出“-1”。
 * <p>
 * 数据范围
 * 0<n≤500
 * 输入样例：
 * 3
 * 00111
 * 01011
 * 10001
 * 11010
 * 11100
 * <p>
 * 11101
 * 11101
 * 11110
 * 11111
 * 11111
 * <p>
 * 01111
 * 11111
 * 11111
 * 11111
 * 11111
 * 输出样例：
 * <p>
 * 3
 * 2
 * -1
 */
public class Num95 {


    static int N = 5;
    static int[][] g = new int[N][N];
    static int[][] backup = new int[N][N];

    static int[] dx = {0,-1,0,1,0};
    static int[] dy = {0,0,1,0,-1};

    private static void turn(int x, int y) {


        for (int i = 0; i < 5; i++) {

            int a = x + dx[i], b = y + dy[i];
            if(a >= 0 && a < 5 && b >= 0 && b < 5)
            {
                g[a][b] ^= 1;
            }
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();


        int n = scanner.nextInt();

        while (n-- > 0) {
            for(int i = 0;i < 5;i++)
            {
                String s = scanner.next();
                for (int j = 0; j < 5; j++) {
                    g[i][j] = s.charAt(j) - '0';
                }



            }
            System.out.println(dfs());
        }

//        for (int i = 0; i < g.length;i++ ) {
//            for (int j = 0; j < g.length; j++) {
//                System.out.print(g[i][j]);
//            }
//            System.out.println();
//        }


    }
    private  static int  dfs() {
        int res = 10;


        for (int op = 0; op < 32; op++) {


            int step = 0;

            //备份
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    backup[i][j] = g[i][j];
                }
            }

            for (int i = 0; i < 5; i++) {

                if (((op >> i) & 1) == 1) {
                    step++;
                    turn(0, i);
                }

            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 5; j++) {
                    if (g[i][j] == 0) {
                        step++;
                        turn(i + 1, j);
                    }
                }
            }

            boolean dark = false;
            for (int i = 0; i < 5; i++) {
                if (g[4][i] == 0) {
                    dark = true;
                    break;
                }
            }
            if (!dark) res = Math.min(res, step);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    g[i][j] = backup[i][j];
                }
            }
        }


        if (res > 6) res = -1;
        return res;
    }




}
