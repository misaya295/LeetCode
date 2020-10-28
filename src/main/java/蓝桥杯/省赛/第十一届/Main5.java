package 蓝桥杯.省赛.第十一届;


import java.math.BigInteger;

/*
试题 E: 斐波那契数列最大公约数
本题总分：15 分
【问题描述】
斐波那契数列满足 F1 = F2 = 1，从 F3 开始有 Fn = Fn 1 + Fn 2。请你计算
GCD(F2020, F520)，其中 GCD(A, B) 表示 A 和 B 的最大公约数。
【答案提交】
这是一道结果填空题，你只需要算出结果后提交即可。本题的结果为一个
整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。



6765
 */
public class Main5 {




    public static void main(String[] args) {

        long[] f = new long[3000];

        BigInteger f1 = BigInteger.ONE;
        BigInteger f2 = BigInteger.ONE;
        BigInteger fn1 = BigInteger.ZERO;
        for (int i = 3; i <= 2020; i++){
           fn1= f1.add(f2);
            f1=f2;
            f2=fn1;

        }

        BigInteger f11 = BigInteger.ONE;
        BigInteger f22 = BigInteger.ONE;
        BigInteger fn2 = BigInteger.ONE;
        for (int i = 3; i <= 520; i++){
            fn2= f11.add(f22);
            f11=f22;
            f22=fn2;

        }


        System.out.println(fn1);
        System.out.println(fn2);

        BigInteger gcd = fn1.gcd(fn2);
        System.out.println(gcd);

        //2020
        //63906981155943558665134927398528713938196200043745871355763079787265151995322001898071485437809065533306267303596007174873825024273095647974649878913616096766604248066008649395662343764260286534059003290654116126957362406745866507935366369712842138930014038888572227398490742287722358671367235709189166548965693916054419169307250217586108972590100204080980670597873094617540854443783530320723473081393553497241453257464515
        //520
        //2109055108727958115216736026700200421586510355834736601003381505407930071607408184616335724173657853423941515








    }

    static long fib(int n) {
        long x=1;
        long y=1;
        long cnt = 2;
        long ans = 0;
        while (cnt < n) {
            ans = x + y;
            y=x;
            x = ans;
            cnt += 1;
        }
        return ans;

    }

}
