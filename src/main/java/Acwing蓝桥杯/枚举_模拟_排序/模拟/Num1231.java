package Acwing蓝桥杯.枚举_模拟_排序.模拟;


/*
小 h 前往美国参加了蓝桥杯国际赛。

小 h 的女朋友发现小 h 上午十点出发，上午十二点到达美国，于是感叹到“现在飞机飞得真快，两小时就能到美国了”。

小 h 对超音速飞行感到十分恐惧。

仔细观察后发现飞机的起降时间都是当地时间。

由于北京和美国东部有 12 小时时差，故飞机总共需要 14 小时的飞行时间。

不久后小 h 的女朋友去中东交换。

小 h 并不知道中东与北京的时差。

但是小 h 得到了女朋友来回航班的起降时间。

小 h 想知道女朋友的航班飞行时间是多少。

对于一个可能跨时区的航班，给定来回程的起降时间。

假设飞机来回飞行时间相同，求飞机的飞行时间。

输入格式
一个输入包含多组数据。

输入第一行为一个正整数 T，表示输入数据组数。

每组数据包含两行，第一行为去程的起降时间，第二行为回程的起降时间。

起降时间的格式如下:

h1:m1:s1 h2:m2:s2
h1:m1:s1 h3:m3:s3 (+1)
h1:m1:s1 h4:m4:s4 (+2)
第一种格式表示该航班在当地时间h1时m1分s1秒起飞，在当地时间当日h2时m2分s2秒降落。

第二种格式表示该航班在当地时间h1时m1分s1秒起飞，在当地时间次日h2时m2分s2秒降落。

第三种格式表示该航班在当地时间h1时m1分s1秒起飞，在当地时间第三日h2时m2分s2秒降落。

输出格式
对于每一组数据输出一行一个时间hh:mm:ss，表示飞行时间为hh小时mm分ss秒。

注意，当时间为一位数时，要补齐前导零，如三小时四分五秒应写为03:04:05。

数据范围
保证输入时间合法（0≤h≤23,0≤m,s≤59），飞行时间不超过24小时。

输入样例：
3
17:48:19 21:57:24
11:05:18 15:14:23
17:21:07 00:31:46 (+1)
23:02:41 16:13:20 (+1)
10:19:19 20:41:24
22:19:04 16:41:09 (+1)
输出样例：
04:09:05
12:10:39
14:22:05
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Num1231 {
    static BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
    private static int get_second(int h,int m,int s)
    {
        return 3600*h+m*60+s;
    }
    private static int get_time() throws IOException
    {
        String str=buf.readLine();
        int day=0;
        if(str.charAt(str.length()-1)==')')
        {
            day=Integer.parseInt(""+str.charAt(str.length()-2));
            str=str.substring(0, str.length()-5);
        }
        String s[]=str.split(" ");
        String s1[]=s[0].split(":");
        String s2[]=s[1].split(":");
        int a1=Integer.parseInt(s1[0]);
        int a2=Integer.parseInt(s1[1]);
        int a3=Integer.parseInt(s1[2]);
        int b1=Integer.parseInt(s2[0]);
        int b2=Integer.parseInt(s2[1]);
        int b3=Integer.parseInt(s2[2]);
        return  get_second(b1, b2, b3)-get_second(a1, a2, a3)+day*24*3600;
    }
    public static void main(String args[]) throws IOException
    {
        int n=Integer.parseInt(buf.readLine());
        while(n--!=0)
        {
            int time=(get_time()+get_time())/2;
            int hour=time/3600;
            int minute=time%3600/60;
            int secound=time%60;
            System.out.printf("%02d:%02d:%02d", hour,minute,secound);
            System.out.println();
        }
    }
}
