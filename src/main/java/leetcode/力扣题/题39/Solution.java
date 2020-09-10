package leetcode.力扣题.题39;

import java.awt.peer.CanvasPeer;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 

提示：

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target == 0) {
            //找到了一组，添加到集合中
            result.add(new ArrayList<>(cur));
            return;
        }
        //相当于遍历N叉树的子节点
        for (int i = start; i < candidates.length; i++) {
            //如果当前节点大于target我们就不要选了
            if (target < candidates[i])
                continue;
            //由于在java中List是引用传递，所以这里要重新创建一个
            List<Integer> list = new ArrayList<>(cur);
            list.add(candidates[i]);
            backtrack(result, list, candidates, target - candidates[i], i);
        }
    }




}