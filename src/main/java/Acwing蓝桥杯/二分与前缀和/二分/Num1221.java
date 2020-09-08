package Acwing蓝桥杯.二分与前缀和.二分;



/**
 * 四平方和定理，又称为拉格朗日定理：
 * <p>
 * 每个正整数都可以表示为至多 4 个正整数的平方和。
 * <p>
 * 如果把 0 包括进去，就正好可以表示为 4 个数的平方和。
 * <p>
 * 比如：
 * <p>
 * 5=02+02+12+22
 * 7=12+12+12+22
 * 对于一个给定的正整数，可能存在多种平方和的表示法。
 * <p>
 * 要求你对 4 个数排序：
 * <p>
 * 0≤a≤b≤c≤d
 * 并对所有的可能表示法按 a,b,c,d 为联合主键升序排列，最后输出第一个表示法。
 * <p>
 * 输入格式
 * 输入一个正整数 N。
 * <p>
 * 输出格式
 * 输出4个非负整数，按从小到大排序，中间用空格分开。
 * <p>
 * 数据范围
 * 0<N<5∗106
 * 输入样例：
 * 5
 * 输出样例：
 * 0 0 1 2
 * 难度：简单
 * 时/空限制：1s / 64MB
 * 总通过数：1042
 * 总尝试数：3513
 * 来源：第七届蓝桥杯省赛C++A/B组
 * 算法标签
 * 二分哈希
 */
import java.util.Arrays;
import java.util.Scanner;



class Sum implements Comparable<Sum>{
    int s,x,y;
    Sum(int s,int x,int y){
        this.s = s;
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Sum o) {
        // TODO Auto-generated method stub
        return this.s - o.s;
    }

}
public class Num1221 {
    static Scanner sc = new Scanner(System.in);
    static int[]a = new int[2500010];
    static int n;
    public static void main(String[] args) {
        n = sc.nextInt();
        Sum[] a = new Sum[2500010];
        int total = 0;
        for(int c = 0; c*c <= n; c++) {
            for(int d = c; d*d + c*c <= n; d++) {
                a[total++] = new Sum(c*c + d*d, c, d);
            }
        }
        Arrays.sort(a,0,total);

        for(int x = 0; x*x <= n; x++) {
            for(int y = 0; y*y + x*x <= n; y++) {
                int t = n - x*x - y*y;
                int l = 0, r = total - 1;
                while(l < r) {
                    int mid = l + r>> 1;
                    if(a[mid].s >= t) {
                        r = mid;
                    }else l = mid + 1;
                }

                if(a[l].s == t) {
                    System.out.println(x + " " + y + " " + a[l].x + " " + a[l].y);
                    System.exit(0);
                }
            }
        }

    }
}


