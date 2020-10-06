package Acwing.题24;


import java.util.LinkedList;
import java.util.Queue;

/*
24. 机器人的运动范围
   题目
   提交记录
   讨论
   题解
   视频讲解

地上有一个 m 行和 n 列的方格，横纵坐标范围分别是 0∼m−1 和 0∼n−1。

一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格。

但是不能进入行坐标和列坐标的数位之和大于 k 的格子。

请问该机器人能够达到多少个格子？

样例1
输入：k=7, m=4, n=5

输出：20
样例2
输入：k=18, m=40, n=40

输出：1484

解释：当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
      但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
注意:

0<=m<=50
0<=n<=50
0<=k<=100
 */
class Solution {
    private static class Node {
        int first;
        int second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private boolean[][] visited = new boolean[55][55];
    private static final int[][] nxt = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 1 || cols < 1)
            return 0;

        Queue<Node> que = new LinkedList<>();
        visited[0][0] = true;
        que.add(new Node(0, 0));
        int res = 0;

        while (!que.isEmpty()) {
            Node popNode = que.poll();
            res++;

            for (int i = 0; i < nxt.length; i++) {
                int fx = popNode.first + nxt[i][0], fy = popNode.second + nxt[i][1];
                if (fx >= 0 && fy >= 0 && fx < rows && fy < cols && getSum(fx, fy) <= threshold && !visited[fx][fy]) {
                    que.add(new Node(fx, fy));
                    visited[fx][fy] = true;
                }
            }
        }

        return res;
    }

    private int getSum(int rows, int cols) {
        int s = 0;
        while (rows > 0) {
            s += rows % 10;
            rows /= 10;
        }

        while (cols > 0) {
            s += cols % 10;
            cols /= 10;
        }

        return s;
    }
}

