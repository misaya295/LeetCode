package Acwing蓝桥杯.贪心;

/*
在游戏《星际争霸 II》中，高阶圣堂武士作为星灵的重要 AOE 单位，在游戏的中后期发挥着重要的作用，其技能”灵能风暴“可以消耗大量的灵能对一片区域内的敌军造成毁灭性的伤害。

经常用于对抗人类的生化部队和虫族的刺蛇飞龙等低血量单位。

你控制着 n 名高阶圣堂武士，方便起见标为 1,2,···,n。

每名高阶圣堂武士需要一定的灵能来战斗，每个人有一个灵能值 ai 表示其拥有的灵能的多少（ai 非负表示这名高阶圣堂武士比在最佳状态下多余了 ai 点灵能，ai 为负则表示这名高阶圣堂武士还需要 −ai 点灵能才能到达最佳战斗状态）。

现在系统赋予了你的高阶圣堂武士一个能力，传递灵能，每次你可以选择一个 i∈[2,n−1]，若 ai≥0 则其两旁的高阶圣堂武士，也就是 i−1、i+1 这两名高阶圣堂武士会从 i 这名高阶圣堂武士这里各抽取 ai 点灵能；若 ai<0 则其两旁的高阶圣堂武士，也就是 i−1,i+1 这两名高阶圣堂武士会给 i 这名高阶圣堂武士 −ai 点灵能。

形式化来讲就是 ai−1+=ai,ai+1+=ai,ai−=2ai。

灵能是非常高效的作战工具，同时也非常危险且不稳定，一位高阶圣堂武士拥有的灵能过多或者过少都不好，定义一组高阶圣堂武士的不稳定度为 maxni=1|ai|，请你通过不限次数的传递灵能操作使得你控制的这一组高阶圣堂武士的不稳定度最小。

输入格式
本题包含多组询问。输入的第一行包含一个正整数 T 表示询问组数。

接下来依次输入每一组询问。

每组询问的第一行包含一个正整数 n，表示高阶圣堂武士的数量。

接下来一行包含 n 个数 a1,a2,···,an。

输出格式
输出 T 行。

每行一个整数依次表示每组询问的答案。

数据范围
1≤T≤3,3≤n≤300000,|ai|≤109,
每个评测用例的限制如下：

QQ截图20191205220735.png

输入样例1：
3
3
5 -2 3
4
0 0 0 0
3
1 2 3
输出样例1：
3
0
3
输入样例2：
3
4
-1 -2 -3 7
4
2 3 4 -8
5
-1 -1 6 -1 -1
输出样例2：
5
7
4
样例解释
样例一
对于第一组询问：
对 2 号高阶圣堂武士进行传输操作后 a1=3，a2=2，a3=1。答案为 3。
对于第二组询问：
这一组高阶圣堂武士拥有的灵能都正好可以让他们达到最佳战斗状态。
 */
import java.io.*;
import java.util.*;

class Num1248{
    static int N = 300010;
    static long[] s = new long[N];
    static long[] a = new long[N]; //保存最终的序列
    static boolean[] st = new boolean[N]; //用于判断某个点是否被访问过了
    static int T;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(in.readLine());

        while(T -- > 0){
            int n = Integer.parseInt(in.readLine());

            String[] arr = in.readLine().split(" ");
            s[0] = 0;
            for(int i=1; i<=n; i++) s[i] = s[i-1] + Long.parseLong(arr[i-1]);
            //初始化s0和sn
            long s0 = s[0]; long sn = s[n];
            if(s0 > sn){ //如果s0的值大于sn，就交换两者的值
                long tmp = s0;
                s0 = sn;
                sn = tmp;
            }
            Arrays.sort(s, 0, n+1);

            //寻找s0的位置
            for(int i=0; i<=n; i++){
                if(s[i] == s0){
                    s0 = i;
                    break;
                }
            }

            //寻找sn的位置
            for(int i=0; i<=n; i++){
                if(s[i] == sn){
                    sn = i;
                    break;
                }
            }

            Arrays.fill(st, false); //初始化st数组
            int l = 0;
            int r = n;
            for(int i=(int)s0; i>=0; i-=2){
                a[l ++] = s[i];
                st[i] = true;
            }
            for(int i=(int)sn; i<=n; i+=2){
                a[r --] = s[i];
                st[i] = true;
            }
            for(int i=0; i<=n; i++){
                if(!st[i]){
                    a[l ++] = s[i];
                }
            }

            long res = 0;
            for(int i=1; i<=n; i++) res = Math.max(res, Math.abs(a[i] - a[i-1]));

            System.out.println(res);
        }
    }
}

