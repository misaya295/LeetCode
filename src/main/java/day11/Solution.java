package day11;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {


        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (len == 0) {
            return res;
        }


        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[len];


        dfs(nums, len, 0, path, used, res);


        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {


        if (depth == len) {
            res.add(new ArrayList<Integer>(path));

            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);

            path.removeLast();
            used[i] = false;



        }

    }
}