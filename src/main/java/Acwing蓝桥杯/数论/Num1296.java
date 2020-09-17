package Acwing蓝桥杯.数论;

import java.util.Scanner;

/*
城市中人们总是拿着号码牌，不停寻找，不断匹配，可是谁也不知道自己等的那个人是谁。

可是燕姿不一样，燕姿知道自己等的人是谁，因为燕姿数学学得好！

燕姿发现了一个神奇的算法：假设自己的号码牌上写着数字 S，那么自己等的人手上的号码牌数字的所有正约数之和必定等于 S。

所以燕姿总是拿着号码牌在地铁和人海找数字（喂！这样真的靠谱吗）。

可是她忙着唱《绿光》，想拜托你写一个程序能够快速地找到所有自己等的人。

输入格式
输入包含 k 组数据。

对于每组数据，输入包含一个号码牌 S。

输出格式
对于每组数据，输出有两行。

第一行包含一个整数 m，表示有 m 个等的人。

第二行包含相应的 m 个数，表示所有等的人的号码牌。

注意：你输出的号码牌必须按照升序排列。

数据范围
1≤k≤100,
1≤S≤2×109
输入样例：
42
输出样例：
3
20 26 41
 */
import java.io.*;
import java.util.*;
class Num1296{
    static int N = 500010;
    static int[] primes = new int[N];
    static boolean[] st = new boolean[N];
    static int[] ans = new int[N];
    static int len; //  ans数组的下标
    static int cnt;

    //  试除法判断质数
    static boolean isPrimes(int x){

        if(x < N) return !st[x];
        for(int i=2; i<=x/i; i++){
            if(x % i == 0) return false;
        }
        return true;
    }

    //  获得1-500010之间的所有质数
    static void get_primes(int x){

        for(int i=2; i<=x; i++){
            if(!st[i]) primes[cnt ++] = i;
            for(int j=0; primes[j]*i<=x; j++){
                st[primes[j] * i] = true;
                if(i % primes[j] == 0) break;
            }
        }
    }

    //  idx记录上一个素数取到哪个位置
    //  cur记录当前数的值
    //  num指的就是原数
    static void dfs(int idx, int cur, int num){
        if(num == 1){
            ans[len ++] = cur;
            return;
        }

        //  第一种情况，如果当前数字减1为质数并且严格大于上一个质数，再把它加到答案中
        if((num - 1) > (idx < 0 ? 1 : primes[idx]) && isPrimes(num - 1))
            ans[len ++] = cur * (num - 1);


        //  第二种情况
        for(int i=idx+1; primes[i]<=num/primes[i]; i++){
            // 获取当前质数
            int p = primes[i];
            for(int j=1+p, t=p; j<=num; t*=p, j+=t){
                if(num % j == 0){
                    dfs(i, cur*t, num/j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cur = "";

        get_primes(N - 1);

        while((cur = in.readLine()) != null){
            int num = Integer.parseInt(cur);

            len = 0;
            dfs(-1, 1, num);

            System.out.println(len);
            if(len!=0){
                Arrays.sort(ans, 0, len);
                for(int i=0; i<len; i++) System.out.print(ans[i] + " ");
                System.out.println();
            }
        }
    }
}

