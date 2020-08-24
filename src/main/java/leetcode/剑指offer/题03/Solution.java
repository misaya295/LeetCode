package leetcode.剑指offer.题03;


import sun.security.util.Length;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public int findRepeatNumber(int[] nums) {


        /*
         * 最优解
         */
            int n = nums.length;


                // for(int i = 0; i < n; i++)
                // {
                //     if(nums[i] < 0 || nums[i] >= n) return -1;
                // }

                for (int i = 0; i < n; i++) {
                    if(nums[i] < 0 || nums[i] >= n) return -1;
                    while( nums[i] != i && nums[nums[i]] != nums[i])
                    {
                        int temp = nums[nums[i]];
                        nums[nums[i]] = nums[i];
                        nums[i] = temp;
                    }

                    if(i != nums[i] && nums[nums[i]] == nums[i]) return nums[i];


                }
                return -1;







        /*
         * 解法一
         */
//        Set<Integer> set = new HashSet<Integer>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!set.add(nums[i])) {
//                return nums[i];
//            }
//        }
//
//        return -1;

        /*
         * 解法二
         */
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == nums[i + 1]) {
//                return nums[i];
//            }
//
//        }

    }
}
