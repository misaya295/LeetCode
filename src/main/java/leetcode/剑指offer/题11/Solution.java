package leetcode.剑指offer.题11;




/*
22. 旋转数组的最小数字
   题目
   提交记录
   讨论
   题解
   视频讲解

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。

输入一个升序的数组的一个旋转，输出旋转数组的最小元素。

例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。

数组可能包含重复项。

注意：数组内所含元素非负，若数组大小为0，请返回-1。

样例
输入：nums=[2,2,2,0,1]

输出：0
 */
class Solution {
    public int minArray(int[] nums) {

        int n = nums.length-1;

        while (n > 0 && nums[n] == nums[0]) n--;
        if (nums[n] >= nums[0]) {

            return nums[0];
        }
        int l =0;
        int r = n;
        while (l < r){

            int mid = l + r >> 1;

            if(nums[mid] < nums[0]) r = mid;
            else l = mid + 1;



        }

        return nums[l];


    }
}