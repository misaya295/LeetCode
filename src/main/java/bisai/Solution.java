package bisai;

class Solution {
    public static void main(String[] args) {

        test();
    }

    private static void   test(){


       int c= 0;
        for (int i = 2147483647; i >= 0; i -= 2) {

            c = i *100;
            if (c >= 0 && c <= 5) {
                System.out.println("i="+i);
                System.out.println("c="+c);
            }

        }


    }

}
