package leetcode.周赛.周赛205.第三题;



/*
5509. 避免重复字母的最小删除成本 显示英文描述
通过的用户数1538
尝试过的用户数1748
用户总通过次数1561
用户总提交次数2696
题目难度Medium
给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。

返回使字符串任意相邻两个字母不相同的最小删除成本。

请注意，删除一个字符后，删除其他字符的成本不会改变。



示例 1：

输入：s = "abaac", cost = [1,2,3,4,5]
输出：3
解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）。
示例 2：

输入：s = "abc", cost = [1,2,3]
输出：0
解释：无需删除任何字母，因为字符串中不存在相邻两个字母相同的情况。
示例 3：

输入：s = "aabaa", cost = [1,2,3,4,1]
输出：2
解释：删除第一个和最后一个字母，得到字符串 ("aba") 。
 */
class Solution {
    public int minCost(String s, int[] cost) {
        int res=0;
        int tmp;
        for (int i = 0; i <s.length()-1 ; i++) {
            if (s.charAt(i)==s.charAt(i+1)){
//                我们把连续字符中最大的留下来就可以了
                res+=Math.min(cost[i],cost[i+1]);
//                把两个数中较大的移到后面,方便比较
                if (cost[i]>cost[i+1]){
                    cost[i+1]=cost[i];
                }
            }
        }
        return res;
    }
}
