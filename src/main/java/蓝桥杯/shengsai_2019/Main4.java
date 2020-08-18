package 蓝桥杯.shengsai_2019;


/*
把2019 分解成3 个各不相同的正整数之和，并且要求每个正整数都不包
含数字2 和4，一共有多少种不同的分解方法？
注意交换3 个整数的顺序被视为同一种方法，例如1000+1001+18 和
1001+1000+18 被视为同一种。
 */
public class Main4 {

    public static void main(String[] args) {
        int n = 2019;
        int res=0;
        for (int a = 1; a < n; a++) {
            for (int b = a + 1; b <= n && n - a - b >b; b++) {
                int c = n - a - b;
                if (!check(a) && !check(b) && !check(c)) {
                    res++;
                }

            }
        }
        System.out.println(res);
    }
    private static boolean check(int a) {
        while (a > 0) {
            int t = a%10;
            if (t == 2 || t == 4) {
                return true;
            }
            a/=10;
        }
        return false;
    }


    //复杂了
//    static int[] a = new int[2019 + 1];
//    public static void main(String[] args) {
//        int n = 2019;
//
//        for (int i = 1; i < a.length; i++) {
//            a[i] = 1;
//            char[] s = String.valueOf(i).toCharArray();
//            for (int b = 0; b < s.length; b++) {
//                if (s[b] == '2' || s[b] == '4') {
//                    a[i] = 0;
//                    break;
//                }
//            }
//        }
//        int count = 0;
//
//        for (int a = 1; a < n / 3 + 1; a++) {
//            if (chcek(a)) {
//                for (int b = a + 1; b < n; b++) {
//                    if (chcek(b)) {
//                        for (int c = b + 1; c < n; c++) {
//                            if (a + b + c > n) {
//                                break;
//
//                            }
//                            if (chcek(c)) {
//                                if (a + b + c == n) {
//                                    count++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(count);
//    }
//
//    public static boolean chcek(int i) {
//        if (a[i] == 1) {
//            return true;
//        } else {
//            return false;
//        }
//    }


}
