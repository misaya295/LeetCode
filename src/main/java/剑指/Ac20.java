package 剑指;


/*

请用栈实现一个队列，支持如下四种操作：

push(x) – 将元素x插到队尾；
pop() – 将队首的元素弹出，并返回该元素；
peek() – 返回队首元素；
empty() – 返回队列是否为空；
注意：

你只能使用栈的标准操作：push to top，peek/pop from top, size 和 is empty；
如果你选择的编程语言没有栈的标准库，你可以使用list或者deque等模拟栈的操作；
输入数据保证合法，例如，在队列为空时，不会进行pop或者peek等操作；
样例
MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false


  MyQueue obj = new MyQueue();
  obj.push(x);
  int param_2 = obj.pop();
  int param_3 = obj.peek();
  boolean param_4 = obj.empty();
 */
import java.util.Stack;
public class Ac20 {



        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        /** Initialize your data structure here. */
        public Ac20() {


        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (!stack1.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
                int popValue = stack2.pop();
                while (!stack2.empty()) {
                    stack1.push(stack2.pop());
                }
                return popValue;
            }
            return 0;
        }

        /** Get the front element. */
        public int peek() {
            if (!stack1.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
                int popValue = stack2.peek();
                while (!stack2.empty()) {
                    stack1.push(stack2.pop());
                }
                return popValue;
            }
            return 0;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.empty();
        }






}
