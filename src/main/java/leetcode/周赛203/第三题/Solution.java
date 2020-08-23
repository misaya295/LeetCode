package leetcode.周赛203.第三题;

import java.util.ArrayList;
import java.util.List;

/**
 * 5497. 查找大小为 M 的最新分组
 * 给你一个数组 arr ，该数组表示一个从 1 到 n 的数字排列。有一个长度为 n 的二进制字符串，该字符串上的所有位最初都设置为 0 。
 *
 * 在从 1 到 n 的每个步骤 i 中（假设二进制字符串和 arr 都是从 1 开始索引的情况下），二进制字符串上位于位置 arr[i] 的位将会设为 1 。
 *
 * 给你一个整数 m ，请你找出二进制字符串上存在长度为 m 的一组 1 的最后步骤。一组 1 是一个连续的、由 1 组成的子串，且左右两边不再有可以延伸的 1 。
 *
 * 返回存在长度 恰好 为 m 的 一组 1  的最后步骤。如果不存在这样的步骤，请返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,5,1,2,4], m = 1
 * 输出：4
 * 解释：
 * 步骤 1："00100"，由 1 构成的组：["1"]
 * 步骤 2："00101"，由 1 构成的组：["1", "1"]
 * 步骤 3："10101"，由 1 构成的组：["1", "1", "1"]
 * 步骤 4："11101"，由 1 构成的组：["111", "1"]
 * 步骤 5："11111"，由 1 构成的组：["11111"]
 * 存在长度为 1 的一组 1 的最后步骤是步骤 4 。
 * 示例 2：
 *
 * 输入：arr = [3,1,5,4,2], m = 2
 * 输出：-1
 * 解释：
 * 步骤 1："00100"，由 1 构成的组：["1"]
 * 步骤 2："10100"，由 1 构成的组：["1", "1"]
 * 步骤 3："10101"，由 1 构成的组：["1", "1", "1"]
 * 步骤 4："10111"，由 1 构成的组：["1", "111"]
 * 步骤 5："11111"，由 1 构成的组：["11111"]
 * 不管是哪一步骤都无法形成长度为 2 的一组 1 。
 * 示例 3：
 *
 * 输入：arr = [1], m = 1
 * 输出：1
 * 示例 4：
 *
 * 输入：arr = [2,1], m = 2
 * 输出：2
 */
class Solution {
    public int findLatestStep(int[] arr, int m) {
        List<Segment> list = new ArrayList<>();
        if (m == arr.length) {
            return arr.length;
        }
        //反向思维，最开始加入整个段，后面不断拆分
        list.add(new Segment(1,arr.length));
        for (int i = arr.length - 1; i >= 0; --i) {
            int index = arr[i];
            //扫描所有分段，若没有任何分段的长度大于等于m，直接返回-1
            if (findMaxSegmentLength(list) < m) {
                return -1;
            }
            //二分搜索当前切分点所在的段
            Segment s = findWithin(list, index);
            //切分点恰好在左边界
            if (index == s.start) {
                //若该段长度大于1，则继续缩短；否则删除该段
                if (s.start < s.end) {
                    ++s.start;
                    //若找到长度满足m的段，直接返回
                    if (s.length() == m) {
                        return i;
                    }
                } else {
                    if (s.length() == m) {
                        return i;
                    }
                    list.remove(s);
                }
                //切分点恰好在右边界
            } else if (index == s.end) {
                if (s.start < s.end) {
                    --s.end;
                    if (s.length() == m) {
                        return i;
                    }
                } else {
                    if (s.length() == m) {
                        return i;
                    }
                    list.remove(s);
                }
                //切分点在该段中间位置，则拆分该段
            } else {
                //更新该段右边界
                int preEnd = s.end;
                s.end = index - 1;
                if (s.length() == m) {
                    return i;
                }
                //创建新段，插到下一个位置。注意不是插到最后，因为二分搜索需要段有序
                list.add(list.indexOf(s) + 1, new Segment(index + 1, preEnd));
                if (preEnd - index == m) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int findMaxSegmentLength(List<Segment> list) {
        int max = 0;
        for (Segment s : list) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    private Segment findWithin(List<Segment> list, int index) {
        int lo = 0;
        int hi = list.size() - 1;
        while(lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            Segment s = list.get(mid);
            if (index >= s.start && index <= s.end) {
                return s;
            }
            if (index > s.end) {
                lo = mid + 1;
            } else if (index < s.start) {
                hi = mid - 1;
            }
        }
        return null;
    }

    class Segment {
        int start;
        int end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int length() {
            return end - start + 1;
        }
    }
}
