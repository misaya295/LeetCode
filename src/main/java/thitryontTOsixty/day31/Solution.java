


package thitryontTOsixty.day31;


import java.util.HashMap;
import java.util.Map;

/*
输入：A = [4,5,0,-2,-3,1], K = 5
输出：7
解释：
有 7 个子数组满足其元素之和可被 K = 5 整除：
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int subarraysDivByK(int[] A, int K) {


        Map<Integer, Integer> record = new HashMap<>();

        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : A) {
            sum += elem;
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);

        }
        return ans;
    }
}