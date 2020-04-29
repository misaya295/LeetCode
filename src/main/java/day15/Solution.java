package day15;

/**
 * （这是一个 交互式问题 ）
 *
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 *
 * 如果不存在这样的下标 index，就请返回 -1。
 *
 *  
 *
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 *
 * 首先，A.length >= 3
 *
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 *
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *  
 *
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 *
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 *  
 *
 * 注意：
 *
 * 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
 *
 * 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-in-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */



class Solution {

    interface MountainArray {
        public int get(int index);

        public int length();
    }


    static class MountainArrayImpl implements MountainArray {
        private int[] arr;
        private int size;

        public MountainArrayImpl(int[] arr) {
            this.arr = arr;
            this.size = this.arr.length;
        }

        @Override
        public int get(int index) {
            return this.arr[index];
        }

        @Override
        public int length() {
            return this.size;
        }

    }

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int size = mountainArr.length();
        //步骤1，先找到山顶元素所在索引
        int mountaintop = findInMountaintop(mountainArr, 0, size - 1);

        //步骤2 在前有序且升序数组中找target，所在索引
        int res = findFromSortedArr(mountainArr, 0, mountaintop, target);


        if (res != -1) {
            return res;
        }
        //步骤3： 如果步骤二找不到，就在后有序且降序数组中找target所在的索引
        return findFromInversedArr(mountainArr, mountaintop + 1, size - 1, target);

    }

    private int findFromInversedArr(MountainArray mountainArr, int l, int r, int target) {

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (mountainArr.get(mid) > target) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }


        if (mountainArr.get(l) == target) {
            return l;
        }
        return -1;

    }



    private int findFromSortedArr(MountainArray mountainArr, int l, int r, int target) {

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) < target) {
                l = mid + 1;

            } else {
                r = mid;
            }

        }

        if (mountainArr.get(l) == target) {
            return l;
        }
        return -1;

    }

    private int findInMountaintop(MountainArray mountainArr, int l, int r) {

        while (l < r) {
            int mid = l + (r - l) / 2;
            //取左中位数，因为进入循环，数组一定至少有两个元素
            // 因此，左中位数一定有右边元素，数组下标不会发生越界

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }

        return l;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        MountainArray mountainArray = new MountainArrayImpl(arr);

        Solution solution = new Solution();
        int res = solution.findInMountainArray(target, mountainArray);
        System.out.println(res);
    }



}