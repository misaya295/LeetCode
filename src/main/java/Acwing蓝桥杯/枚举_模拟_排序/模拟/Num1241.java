package Acwing蓝桥杯.枚举_模拟_排序.模拟;




/*
“饱了么”外卖系统中维护着 N 家外卖店，编号 1∼N。

每家外卖店都有一个优先级，初始时 (0 时刻) 优先级都为 0。

每经过 1 个时间单位，如果外卖店没有订单，则优先级会减少 1，最低减到 0；而如果外卖店有订单，则优先级不减反加，每有一单优先级加 2。

如果某家外卖店某时刻优先级大于 5，则会被系统加入优先缓存中；如果优先级小于等于 3，则会被清除出优先缓存。

给定 T 时刻以内的 M 条订单信息，请你计算 T 时刻时有多少外卖店在优先缓存中。

输入格式
第一行包含 3 个整数 N,M,T。

以下 M 行每行包含两个整数 ts 和 id，表示 ts 时刻编号 id 的外卖店收到一个订单。

输出格式
输出一个整数代表答案。

数据范围
1≤N,M,T≤105,
1≤ts≤T,
1≤id≤N
输入样例：
2 6 6
1 1
5 2
3 1
6 2
2 1
6 2
输出样例：
1
样例解释
6 时刻时，1 号店优先级降到 3，被移除出优先缓存；2 号店优先级升到 6，加入优先缓存。

所以是有 1 家店 (2 号) 在优先缓存中。
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Num1241 {
    static int N = 100010;
    static int[] score = new int[N];//表示第i个店铺当前的优先级
    static int[] last = new int[N];//表示第i个店铺上一个有订单的时刻
    static boolean[] st = new boolean[N];//表示第i个店铺当前是否处于优先缓存中
    static PIIs[] PII = new PIIs[N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = reader.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int T = Integer.parseInt(s1[2]);

        for(int i = 0;i < m;i++)
        {
            String[] s2 = reader.readLine().split(" ");
            int t = Integer.parseInt(s2[0]);
            int id = Integer.parseInt(s2[1]);
            PII[i] = new PIIs(t,id);
        }
        Arrays.sort(PII,0,m);
        for(int i = 0;i < m;)
        {
            int j = i;
            while(j < m && PII[i].t == PII[j].t && PII[i].id == PII[j].id) j ++;
            int t = PII[i].t, id = PII[i].id,cnt = j - i;
            i = j;

            score[id] -= t - last[id] - 1;
            if(score[id] < 0) score[id] = 0;
            if(score[id] <= 3) st[id] = false;//处理t时刻之前的信息

            score[id] += cnt * 2;
            if(score[id] > 5) st[id] = true;

            //更新
            last[id] = t;
        }
        for(int i = 1;i <= n;i++)
        {
            if(last[i] < T)
            {
                score[i] -= T - last[i];
                if(score[i] <= 3) st[i] = false;
            }
        }
        int res = 0;
        for(int i = 1;i <= n;i++)
        {
            if(st[i])
            {
                res ++;
            }

        }
        System.out.println(res);
    }
}
class PIIs implements Comparable<PIIs>
{
    public int t;
    public int id;
    public PIIs(int t,int id)
    {
        this.t = t;
        this.id = id;
    }
    @Override
    public int compareTo(PIIs o) {
        // TODO 自动生成的方法存根
        return t != o.t ? Integer.compare(t,o.t) : Integer.compare(id,o.id);
    }

}

