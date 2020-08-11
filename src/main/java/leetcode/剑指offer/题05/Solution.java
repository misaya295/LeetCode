package leetcode.剑指offer.题05;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {


        String s = s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
    private static String replaceSpace(String s) {


        //用这种就是丢人
        //String replace = s.replace(" ", "%20");
        ///return replace;

        /*
         *第二种方法
         */
        int len = s.length();


        char[] array = new char[len * 3];

        int size = 0;
        for (int i = 0; i < len; i++) {


            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';

            } else {
                array[size++] = c;
            }


        }

        String newstr = new String(array, 0, size);
        return newstr;



    }
}
