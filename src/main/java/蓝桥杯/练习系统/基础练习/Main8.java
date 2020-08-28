package 蓝桥杯.练习系统.基础练习;


/**
 * 问题描述
 * 对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：
 * 00000
 * 00001
 * 00010
 * 00011
 * 00100
 * 请按从小到大的顺序输出这32种01串。
 *
 * 输入格式
 * 本试题没有输入。
 * 输出格式
 * 输出32行，按从小到大的顺序每行一个长度为5的01串。
 * 样例输出
 * 00000
 * 00001
 * 00010
 * 00011
 * <以下部分省略>
 */
public class Main8 {

    public static void main(String [] args){

        for(int i= 0;i<32;i++){

            getString(i);

            System.out.println();

        }



    }



    public static  void getString(int n){

        int [] Len = new int[5];

        int c = 0;

        int b = 0;

        for(int i = 0 ;i<5;i++){

            c=n%2;

            Len[i]=c;

            b=n/2;

            n=b;

        }



        for(int i=4;i>=0;i--){

            System.out.print(Len[i]);

        }

    }


}
