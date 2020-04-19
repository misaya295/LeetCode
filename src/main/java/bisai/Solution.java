package bisai;

class Solution {
    public static void main(String[] args) {


        int[] a = new int[3];
        a[0]= 2;
        a[1]=3;
        a[2] =10;



        Solution solution = new Solution();

        int b =solution.minCount(a);

        System.out.println(b);
    }
    public int minCount(int[] coins) {


        int  sum = 0 ;


        for (int i = 0; i <= coins.length-1; i++) {



            if(coins[i] % 2 == 0){


                sum = sum + (coins[i]/2);

            }else if (coins[i] %2  != 0){



                sum = sum + 1 + (coins[i]/2);


            }
        }
//        System.out.println("sum=" + sum);

        return sum;

    }

}