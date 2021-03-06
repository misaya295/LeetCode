package 蓝桥杯.练习系统.入门训练;




/**
 * 试题 入门训练 Fibonacci数列
 *
 * 资源限制
 * 时间限制：1.0s   内存限制：256.0MB
 * 问题描述
 * Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。
 *
 * 当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。
 *
 * 输入格式
 * 输入包含一个整数n。
 * 输出格式
 * 输出一行，包含一个整数，表示Fn除以10007的余数。
 * 说明：在本题中，答案是要求Fn除以10007的余数，因此我们只要能算出这个余数即可，而不需要先计算出Fn的准确值，再将计算的结果除以10007取余数，直接计算余数往往比先算出原数再取余简单。
 *
 * 样例输入
 * 10
 * 样例输出
 * 55
 * 样例输入
 * 22
 * 样例输出
 * 7704
 * 数据规模与约定
 * 1 <= n <= 1,000,000。
 */
import java.util.Scanner;
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fib(n));


    }

    public static  int fib(int n) {

        int f1 = 0;
        int f2 = 1;
        int fn=1;
        if(n==1){
            return 1;
        } if(n==0){
            return 0;
        }

        for(int i=1;i<n;i++){
            fn=(f1+f2)% 10007;
            f1=f2;
            f2=fn;
        }
        return fn ;


    }


}
