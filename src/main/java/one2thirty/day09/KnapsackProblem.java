package one2thirty.day09;


import static sun.swing.MenuItemLayoutHelper.max;

/**
 * @author cwk
 * 背包问题
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        /*
        物品的重量
         */
        int[] w = {1, 4, 3};
        /*
        物品的价值
         */
        int[] val = {1500, 3000, 2000};

        int m = 4;
        int n = val.length;

        //创建一个二维数组

        //v[i][j] 表示在前i个物品中能够装入容量j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];


        int[][] path = new int[n+1][m+1];

        //初始化第一行和第一列
        for (int i = 0; i < v.length; i++) {
            /*
              将第一列设置为0
             */
            v[i][0] = 0;
        }

        for (int i = 0; i < v[0 ].length; i++) {
        /*
        将第一行设置为0
         */
            v[0][i] = 0;
        }

        //根据前面得到的公式来动态规划处理
        for (int i = 1; i < v.length; i++) {
            /*
            不处理第一行，i是从1开始的
             */
            for (int j = 1; j < v[0].length; j++) {
                /*
                不处理第一列，j是从1开始的
                 */

                //公式
                if (w[i-1] > j) {
                    /*
                    因为程序从i从1开始原来公式w的i改为i-1
                     */
                    v[i][j] = v[i-1][j];


                }else {

//                    v[i][j] = max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);

                    if (v[i - 1][j] <val[i - 1] + v[i - 1][j - w[i - 1]]){

                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];

                        path[i][j] = 1;

                    }else {

                        v[i][j] = v[i - 1][j];
                    }
                }


            }
        }


        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j]+" ");
            }

            System.out.println();
        }


    }




}
