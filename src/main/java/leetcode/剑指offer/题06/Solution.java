package leetcode.剑指offer.题06;

import java.util.*;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Solution {

    public static void main(String[] args) {

        int[] k = {1, 2, 3};
        for (int j = k.length-1; j >=0; j--) {

            System.out.println(k[j]);
        }
    }



    public int[] reversePrint(ListNode head) {


        LinkedList<Integer> stack = new LinkedList<>();

        while (head != null) {

            stack.addLast(head.val);
            head = head.next;

        }
        int[] res = new int[stack.size()];

        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }







    public class ListNode { int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


}
