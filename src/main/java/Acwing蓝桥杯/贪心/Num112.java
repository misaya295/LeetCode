package Acwing蓝桥杯.贪心;


/*
假设海岸是一条无限长的直线，陆地位于海岸的一侧，海洋位于另外一侧。

每个小岛都位于海洋一侧的某个点上。

雷达装置均位于海岸线上，且雷达的监测范围为d，当小岛与某雷达的距离不超过d时，该小岛可以被雷达覆盖。

我们使用笛卡尔坐标系，定义海岸线为x轴，海的一侧在x轴上方，陆地一侧在x轴下方。

现在给出每个小岛的具体坐标以及雷达的检测范围，请你求出能够使所有小岛都被雷达覆盖所需的最小雷达数目。

输入格式
第一行输入两个整数n和d，分别代表小岛数目和雷达检测范围。

接下来n行，每行输入两个整数，分别代表小岛的x，y轴坐标。

同一行数据之间用空格隔开。

输出格式
输出一个整数，代表所需的最小雷达数目，若没有解决方案则所需数目输出“-1”。

数据范围
1≤n≤1000
输入样例：
3 2
1 2
-3 1
2 1
输出样例：
2
 */
import java.util.Arrays;
import java.util.Scanner;
public class Num112 {
    static int N = 1010;
    static Pair[] pair = new Pair[N];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        boolean flag = true;
        for(int i = 0;i < n;i ++)
        {
            int x = scan.nextInt();
            int y = scan.nextInt();
            if(d < y) flag = false;
            else
            {
                double len = Math.sqrt(d * d - y * y);
                double l = x - len;
                double r = x + len;
                pair[i] = new Pair(l,r);
            }
        }
        if(!flag) System.out.println("-1");
        else
        {
            Arrays.sort(pair,0,n);
            double end = pair[0].r;
            int res = 1;
            for(int i = 1;i < n;i ++)
            {
                if(pair[i].l <= end) continue;
                end = pair[i].r;
                res ++;
            }
            System.out.println(res);
        }
    }
}
class Pair implements Comparable<Pair>
{
    double l,r;
    Pair(double l,double r)
    {
        this.l = l;
        this.r = r;
    }
    @Override
    public int compareTo(Pair o) {
        // TODO 自动生成的方法存根
        return Double.compare(r, o.r);
    }
}

