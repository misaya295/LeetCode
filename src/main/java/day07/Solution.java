package day07;


/**
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「」的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // arr[i]代表nums数组中的下标到arr[i]为止有i个奇数

        int len = nums.length, res = 0, feed = 0, arr[] = new int[len + 2];
        for (int i = 0; i < len; i++) {


            if ((nums[i] & 1) == 1) {

                //只有出现奇数feed才会增加，arr数组的下标feed代表nums数组中到下标arr[feed]为止出现了feed个奇数

                arr[++feed] = i;
            }
        }

        //left border
        arr[0] = -1;

        //right border
        arr[feed + 1] = len;
        for (int i = 1; i + k < feed + 2; i++) {

            // arr[i]代表nums数组中从0开始累积出现i个奇数的下标是多少.设为a
            // arr[i + k] 代表nums数组中出现i + k个奇数的下标是多少，设为b。
            // arr[i - 1]代表nums数组中出现i - 1个奇数的下标是多少，设为c
            // arr[i + k - 1] 代表nums数组中出现i + k - 1个奇数的下标是多少，设为d。（i+ k - 1） - i + 1就等于k个奇数
            // 那么 (a - c)就是第i个奇数和第i-1个奇数之间有多少个偶数 +1(1指自己)
            // (b - d)就是第i + k个奇数和第i + k - 1个奇数之间有多少个偶数 +1
            //arr[0]永远是-1
            // arr[feed +1] 永远是nums.length,这个为了方便计算设定的边界
            //答主上面解释了(a - c) * (b - d)是说以a、d为边界且包含k个奇数且长度为k的窗口，c就是向左最左能延伸到何处，
            // b就是向右最右能延伸到何处
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }

        return res;
    }
}