package day01;

class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    public int minJump(int[] jump) {

        if(jump.length <= 1){ return 0;}
        int maxReach = jump[0];
        int steps = jump[0];
        int jumps = 1;
        for(int i=1;i<jump.length-1;i++) {
            maxReach = Math.max(maxReach,i+jump[i]);
            steps--;
            if(steps == 0) {
                jumps++;
                steps = maxReach-i;
            }
        }
        return jumps+1;
    }


}
