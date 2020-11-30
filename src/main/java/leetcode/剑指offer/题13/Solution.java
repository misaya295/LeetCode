package leetcode.剑指offer.题13;

import java.security.interfaces.RSAKey;
import java.util.LinkedList;
import java.util.Queue;

/*
剑指 Offer 13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？



示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20

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
