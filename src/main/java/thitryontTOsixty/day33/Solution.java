package thitryontTOsixty.day33;


/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];


        //answer[i] ，表示索引i左侧所有元素的乘积
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        //R为右侧所有元素的乘积
        //刚开始右边没有元素，所以R=1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            //对于索引i，左边的乘积为answer[i],右边乘积为R
            answer[i] = answer[i] * R;
            //R需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到R上
            R *= nums[i];
        }
        return answer;



    }
}