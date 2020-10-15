package 蓝桥杯.第十届;


import java.util.Scanner;

/*
把2019 分解成3 个各不相同的正整数之和，并且要求每个正整数都不包
含数字2 和4，一共有多少种不同的分解方法？
注意交换3 个整数的顺序被视为同一种方法，例如1000+1001+18 和
1001+1000+18 被视为同一种。


答案 40785
 */
public class Main4 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res=0;
        for (int i = 1; i <= n; i++) {
            for(int j =i;j <= n;j++){
                for(int k =j;k <= n;k++){
                    if (check(i) && check(j) && check(k))
                        if (i + j + k == n) {
                            if (i != j && i != k&& j !=k) {
                                res++;
                            }
                        }
                    }
                }

            }


        System.out.println(res);


    }

    static boolean check(int x) {


        boolean flag = true;

        while (x>0){

            int c =x%10;
            if (c == 2 || c == 4) {
                flag = false;
            }
            x/=10;
        }

        return flag;

    }



}
