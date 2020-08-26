package leetcode.剑指offer.题07;


/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    int[] preorder;
    int[] inorder;
    HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        // * 前序遍历 preorder = [3,9,20,15,7]
        // * 中序遍历 inorder =  [9,3,15,20,7]
        // * 返回如下的二叉树：
        // *
        // *     3
        // *    / \
        // *   9  20
        // *     /  \
        // *    15   7
        // *
        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, preorder.length - 1, 0, inorder.length-1);
    }

    private TreeNode dfs(int pl, int pr, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int k = map.get(root.val);
        root.left = dfs(pl + 1, pl + k - il, il,k-1 );
        root.right = dfs(pl + k - il + 1, pr, k + 1, ir);
        return root;

    }




    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }
}