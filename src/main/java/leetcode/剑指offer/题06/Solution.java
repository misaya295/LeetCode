package leetcode.剑指offer.题06;

import java.util.*;

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
