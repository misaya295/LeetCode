package 蓝桥杯.shengsai_2019;


import javafx.util.Pair;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 试题 G: 外卖店优先级
 * 时间限制: 1.0s 内存限制: 512.0MB 本题总分：20 分
 * 【问题描述】
 * “饱了么”外卖系统中维护着 N 家外卖店，编号 1 ∼ N。每家外卖店都有
 * 一个优先级，初始时 (0 时刻) 优先级都为 0。
 * 每经过 1 个时间单位，如果外卖店没有订单，则优先级会减少 1，最低减
 * 到 0；而如果外卖店有订单，则优先级不减反加，每有一单优先级加 2。
 * 如果某家外卖店某时刻优先级大于 5，则会被系统加入优先缓存中；如果
 * 优先级小于等于 3，则会被清除出优先缓存。
 * 给定 T 时刻以内的 M 条订单信息，请你计算 T 时刻时有多少外卖店在优
 * 先缓存中。
 * 【输入格式】
 * 第一行包含 3 个整数 N、M 和 T。
 * 以下 M 行每行包含两个整数 ts 和 id，表示 ts 时刻编号 id 的外卖店收到
 * 一个订单。
 * 【输出格式】
 * 输出一个整数代表答案。
 * 【样例输入】
 * 2 6 6
 * 1 1
 * 5 2
 * 3 1
 * 6 2
 * 2 1
 * 6 2
 * 试题G: 外卖店优先级 10
 * 第十届蓝桥杯大赛软件类省赛 Java 大学 B 组
 * 【样例输出】
 * 1
 * 【样例解释】
 * 6 时刻时，1 号店优先级降到 3，被移除出优先缓存；2 号店优先级升到 6，
 * 加入优先缓存。所以是有 1 家店 (2 号) 在优先缓存中。
 * 【评测用例规模与约定】
 * 对于 80% 的评测用例，1 ≤ N, M, T ≤ 10000。
 * 对于所有评测用例，1 ≤ N, M, T ≤ 100000，1 ≤ ts ≤ T，1 ≤ id ≤ N。
 */
public class Main7 {



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int shops = input.nextInt();//店铺数量
        int orders = input.nextInt();//订单数量
        int time = input.nextInt();//T时刻
        int[][] orderTable = new int[shops+1][time+1];//存储各店铺各时刻的订单数量
        int[] shopCounts = new int[shops+1];//T时刻，店铺的优先级数
        HashMap<Integer,Integer> shopMap = new HashMap();//作为优先缓存
        for (int i = 0; i < orders; i++) {
            int ts = input.nextInt();//订单时刻
            int id = input.nextInt();//接收订单的店铺

            if (ts <= time)//在T时刻表中的订单状态
            {
                orderTable[id][ts]++;
            }
        }

        for (int i = 1; i <= shops; i++) {
            for (int j = 1; j <= time; j++) {
                if (orderTable[i][j] == 0) {
                    shopCounts[i] = Math.max(0, shopCounts[i] - 1);//当店铺i在j时刻，无订单且优先级数不为零时自减1
                } else {
                    shopCounts[i] += orderTable[i][j] * 2;//当店铺i在j时刻，有订单则将此时刻该店铺的订单数量×2
                }
                //判断优先级数，确定是否加入优先缓存
                if (shopCounts[i] > 5) {
                    shopMap.put(i, 1);
                } else if (shopCounts[i] <= 3 && shopMap.containsKey(i)){//当店铺已经加入到优先缓存且优先级数小于等于3时，剔除出去
                    shopMap.remove(i);
                }

            }
        }
        System.out.println(shopMap.size());//此时map的大小即为优先缓存中的店铺数量

    }

























}
