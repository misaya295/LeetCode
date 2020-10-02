package leetcode.力扣题.题771;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numJewelsInStones(String J, String S) {

            int n = J.length();
            int m = S.length();
            int res=0;
            HashSet<Character> set = new HashSet<Character>();
            for(int i=0;i < n;i++){
                set.add(J.charAt(i));
            }

            for(int i= 0;i < m;i++)
            {
                if(set.contains(S.charAt(i))) res++;

            }
        return res;

    }
}