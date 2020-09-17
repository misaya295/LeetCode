package Acwing蓝桥杯.数论;




/*
输入正整数 X，求 X 的大于 1 的因子组成的满足任意前一项都能整除后一项的严格递增序列的最大长度
，以及满足最大长度的序列的个数。

输入格式
输入包含多组数据，每组数据占一行，包含一个正整数表示 X。

输出格式
对于每组数据，输出序列的最大长度以及满足最大长度的序列的个数。

每个结果占一行。

数据范围
1≤X≤220
输入样例：
2
3
4
10
100
输出样例：
1 1
1 1
2 1
2 2
 */
import java.io.*;
class Num1295{
    static int N = (1 << 20) + 10;
    static int[] primes = new int[N];
    static boolean[] st = new boolean[N];
    static int cnt;

    static void get_primes(int x){
        for(int i=2; i<=x; i++){
            if(!st[i]) primes[cnt ++] = i;
            for(int j=0; primes[j]*i<=x; j++){
                st[primes[j] * i] = true;
                if(i % primes[j] == 0) break;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //  预处理fact数组
        long[] fact = new long[30];
        fact[0] = 1l;
        for(int i=1; i<fact.length; i++) fact[i] = fact[i-1] * i;

        //  预处理primes数组
        get_primes(N - 1);

        String str = "";
        while((str = in.readLine())!=null){
            int num = Integer.parseInt(str);

            int maxL = 0;
            long mol = 1; // 保存分子
            for(int i=0; num>1&&i<cnt; i++){
                int p = primes[i];
                int tmp = 0; // 记录此时这个质数的数量
                while(num % p == 0){
                    tmp ++;
                    maxL ++;
                    num /= p;
                }
                mol *= fact[tmp];
            }

            System.out.printf("%d %d\n", maxL, fact[maxL] / mol);
        }
    }
}

