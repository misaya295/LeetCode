package one2thirty.day16;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {


        Set<Integer> seen = new HashSet<>();

        seen.add(n);
        while (n != 1) {
            n = bitSquareSum(n);
            if (!seen.add(n)) {
                return false;
            }
        }

        return true;


    }

    private int bitSquareSum(int x) {
        int sum  = 0 ,cur;
        while (x > 0) {
            cur = x % 10;
            System.out.println("cur="+cur);
            sum += cur * cur;
            System.out.println("sum="+sum);
            x = x / 10;
            System.out.println(x);
        }

        return sum;


    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.isHappy(19);

    }
}