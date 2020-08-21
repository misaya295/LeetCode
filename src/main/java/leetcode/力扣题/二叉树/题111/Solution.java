package leetcode.力扣题.二叉树.题111;

/**
 给定一个二叉树，找出其最小深度。

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回它的最小深度  2.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);

        if (root.left == null || root.right == null) {
            return m1 + m2 + 1;
        }

        return  Math.min(m1,m2) + 1;

    }

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
}