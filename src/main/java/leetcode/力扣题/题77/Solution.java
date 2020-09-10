package leetcode.力扣题.题77;

import java.util.ArrayList;
import java.util.List;

/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    List<List<Integer>> res= new ArrayList<List<Integer>>();
    public  List<List<Integer>> combine(int n, int k) {
        int[] way= new int[n+1];
        dfs(1, 1, n, k, way);
        return res;
    }
    private  void dfs(int u, int start, int n, int m,  int[] way) {
        List<Integer> ll = new ArrayList<Integer>();
        if (u == m + 1) {
            for (int i = 1; i <= m; i++) {
                ll.add(way[i]);
            }
            res.add(ll);
            return;
        }
        for (int i = start; i <= n; i++) {
            way[u] = i;
            dfs(u + 1, i + 1, n, m,  way);
            way[u] = 0;
        }
    }
}