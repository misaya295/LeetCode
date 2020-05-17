package day26;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses == 0) {
            return new int[0];
        }
        int[] inDegress = new int[numCourses];
        //建立入度表
        for (int[] p : prerequisites) {
            /*对于有先修课的课程，计算有几门先修课
            */
            inDegress[p[0]]++;

        }
        //入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegress.length; i++) {
            if (inDegress[i] == 0) {
                queue.offer(i);
            }
        }
        /*
        记录可以学完的课程数量
         */
        int count = 0;
        /*
        可以学完的课程
         */
        int[] res = new int[numCourses];

        //根据提供的先修课列表，删除入度为0的节点
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[count++] = curr;
            for (int[] p : prerequisites) {
                if (p[1] == curr) {
                    inDegress[p[0]]--;
                    if (inDegress[p[0]] == 0){ queue.offer(p[0]);}
                }
            }
        }
        if (count == numCourses) {
            return res;
        }

        return new int[0];



    }
}