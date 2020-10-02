package Acwing蓝桥杯.递推与递归.练习;


import java.io.PrintWriter;
import java.util.Scanner;

/**
 * “飞行员兄弟”这个游戏，需要玩家顺利的打开一个拥有16个把手的冰箱。
 *
 * 已知每个把手可以处于以下两种状态之一：打开或关闭。
 *
 * 只有当所有把手都打开时，冰箱才会打开。
 *
 * 把手可以表示为一个4х4的矩阵，您可以改变任何一个位置[i,j]上把手的状态。
 *
 * 但是，这也会使得第i行和第j列上的所有把手的状态也随着改变。
 *
 * 请你求出打开冰箱所需的切换把手的次数最小值是多少。
 *
 * 输入格式
 * 输入一共包含四行，每行包含四个把手的初始状态。
 *
 * 符号“+”表示把手处于闭合状态，而符号“-”表示把手处于打开状态。
 *
 * 至少一个手柄的初始状态是关闭的。
 *
 * 输出格式
 * 第一行输出一个整数N，表示所需的最小切换把手次数。
 *
 * 接下来N行描述切换顺序，每行输入两个整数，代表被切换状态的把手的行号和列号，数字之间用空格隔开。
 *
 * 注意：如果存在多种打开冰箱的方式，则按照优先级整体从上到下，同行从左到右打开。
 *
 * 数据范围
 * 1≤i,j≤4
 * 输入样例：
 * -+--
 * ----
 * ----
 * -+--
 * 输出样例：
 * 6
 * 1 1
 * 1 3
 * 1 4
 * 4 1
 * 4 3
 * 4 4
 */

class PIIS {
    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public PIIS(int x, int y) {

        this.x = x;
        this.y = y;

    }
}
public class Num116 {

    /*
    第二版
     */

    static int N = 5;
    static char[][] g = new char[N][N];
    static char[][] backup = new char[N][N];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            g[i] = scanner.next().toCharArray();
        }
















    }

















    /*
    第一版本
     */
//    static int[][] arr = new int[4][4];
//    static int[][] backup = new int[4][4];
//    static int MinCount = Integer.MAX_VALUE;
//    static int POS;
//    static PrintWriter writer = new PrintWriter(System.out);
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = 4;
//        for (int i = 0; i < 4; i++) {
//            String str = in.next();
//            for (int j = 0; j < 4; j++) {
//                if (str.charAt(j) == '-') {
//                    arr[i][j] = 1;
//                }else arr[i][j] = 0;
//            }
//        }
//
//
//        for(int k=0;k<1<<16;k++){
//            int ans = 0;
//            backup = new int[4][4];
//            for(int i=0;i<4;i++){
//                for(int j=0;j<4;j++){
//                    backup[i][j]=arr[i][j];
//                }
//            }
//            for(int j=0;j<16;j++){
//                if(((k>>j)&1)==1) {
//                    int x = j /4;
//                    int y = j % 4;
//                    ans ++;
//                    change(x,y);
//                }
//            }
//            if(check()){
//                if(MinCount>ans){
//                    MinCount = ans;
//                    POS = k;
//                }
//            }
//        }
//        writer.println(MinCount);
//        for(int k=0;k<16;k++){
//            if(((POS>>k)&1)==1){
//                int a = k/4 +1;
//                int b = k%4 +1;
//                writer.println(a+" "+b);
//            }
//        }
//        writer.flush();
//    }
//
//    static void change(int x, int y) {
//        int row = x;
//        int col = y;
//        for(int i=0;i<4;i++){
//            backup[row][i]^=1;
//            backup[i][col]^=1;
//        }
//        backup[x][y]^=1;
//    }
//
//    static boolean check(){
//        for(int i=0;i<4;i++){
//            for(int j=0;j<4;j++){
//                if(backup[i][j]!=1) return false;
//            }
//        }
//        return true;
//    }
}

