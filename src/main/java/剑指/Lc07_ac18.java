package 剑指;


import com.sun.tools.hat.internal.model.Root;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Lc07_ac18 {



    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



    static Map<Integer, Integer> hash = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int m = inorder.length;
        for (int i = 0; i < m; i++) hash.put(inorder[i], i);
        return dfs(0, n - 1, 0, m - 1,preorder,inorder);
    }


    static TreeNode dfs(int pl, int pr, int il, int ir,int[] preorder,int[] inorder) {
        if (pl > pr) return null;

        TreeNode root = new TreeNode(preorder[pl]);

        int k = hash.get(root.val);

        TreeNode left = dfs(pl + 1, pl + k - il, il, k - 1,preorder,inorder);

        TreeNode right = dfs(pl + k - il + 1, pr, k + 1, ir,preorder,inorder);

        root.left = left;

        root.right = right;


        return root;

    }



}
