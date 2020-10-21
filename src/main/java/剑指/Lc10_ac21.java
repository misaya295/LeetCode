package 剑指;

/*
输入一个整数 n ，求斐波那契数列的第 n 项。

假定从0开始，第0项为0。(n<=39)

样例
输入整数 n=5

返回 5
 */
public class Lc10_ac21 {

    public int Fibonacci(int n) {
        int f1 = 0;
        int f2 = 1;
        int fn=1;
        if(n==1){
            return 1;
        } if(n==0){
            return 0;
        }

        for(int i=1;i<n;i++){
            fn=(f1+f2)% 1000000007;
            f1=f2;
            f2=fn;
        }
        if(fn== 1000000008)
        {
            return 1;

        }
        return fn ;

    }


}
