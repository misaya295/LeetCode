package leetcode.周赛.周赛203.第二题;



import java.util.Arrays;

class Solution {


    public   int maxCoins(int[] piles) {

        int res=0;
        Arrays.sort(piles);
        for (int i = 0, j = piles.length; i < j; i++, j -= 2) {
            res += piles[j - 1];
        }

        return res;
    }
}