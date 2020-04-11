package day02


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
object Solution {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {


    var flag = 0;
    var reminder = 0;
    val sum = new ListNode()
    var next = sum
    var lefe = l1
    var right = l2

    while (lefe != null || right != null) {




      var leftValue = 0
      if (lefe != null) {


        leftValue = lefe.x
        lefe = lefe.next

      }

      var rightValue = 0
      if (right != null) {

        rightValue = right.x
        right = right.next

      }


      val s = leftValue + rightValue + flag
      flag =  s / 10
      reminder = s % 10
      println(reminder)
      next.next = new ListNode(reminder)
      next = next.next



      if (flag == 1) {

        println(flag)
        next.next =  new ListNode(flag)
        next = next.next
      }




    }

      return sum.next

  }


}
