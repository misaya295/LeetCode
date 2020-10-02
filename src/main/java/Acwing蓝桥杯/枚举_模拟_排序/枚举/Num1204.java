package Acwing蓝桥杯.枚举_模拟_排序.枚举;





/*
1204. 错误票据
   题目
   提交记录
   讨论
   题解
   视频讲解

某涉密单位下发了某种票据，并要在年终全部收回。

每张票据有唯一的ID号。

全年所有票据的ID号是连续的，但ID的开始数码是随机选定的。

因为工作人员疏忽，在录入ID号的时候发生了一处错误，造成了某个ID断号，另外一个ID重号。

你的任务是通过编程，找出断号的ID和重号的ID。

假设断号不可能发生在最大和最小号。

输入格式
第一行包含整数 N，表示后面共有 N 行数据。

接下来 N 行，每行包含空格分开的若干个（不大于100个）正整数（不大于100000），每个整数代表一个ID号。

输出格式
要求程序输出1行，含两个整数 m,n，用空格分隔。

其中，m表示断号ID，n表示重号ID。

数据范围
1≤N≤100
输入样例：
2
5  6  8  11  9
10  12  9
输出样例：
7 9
 */



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num1204 {
    private static List<Integer> ids = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int i = 0;
        while (sc.hasNextLine()) {
            String[] temp = sc.nextLine().trim().replaceAll("\\s+", ",").split(",");
            for (String id : temp) {
                ids.add(Integer.parseInt(id));
            }
            if (++i >= N)
                break;
        }
        ids.sort(null);
        int m = 0, n = 0;
        for (int j = 1; j < ids.size() - 1; j++) {
            int front = ids.get(j);
            int rear = ids.get(j + 1);
            if (front == rear)
                n = front;
            else if (front != rear - 1)
                m = rear - 1;
            if (m != 0 && n != 0)
                break;
        }
        System.out.println(m + " " + n);
        sc.close();
    }
}