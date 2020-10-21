package 剑指;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*

 */
public class Lc06_ac17 {

    static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }



    public int[] reversePrint(ListNode head) {

        List<Integer> stack = new ArrayList<>();
        while(head != null)
        {
            stack.add(head.val);
            head = head.next;

        }
        int[] res = new int[stack.size()];
        Collections.reverse(stack);
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i);

        }


        return res;
    }
}
