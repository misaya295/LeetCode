package 蓝桥杯.shengsai_2018;

public class Main2 {


    /**
     * 如图p1.png所示，在二维平面上有无数个1x1的小方格。
     * https://img-blog.csdn.net/20180401224202573
     * 我们以某个小方格的一个顶点为圆心画一个半径为1000的圆。
     * 你能计算出这个圆里有多少个完整的小方格吗？
     * 注意：需要提交的是一个整数，不要填写任何多余内容。
     */

    public static void main(String[] args) {
        int r = 1000, res = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= r; j++) {
                if (i * i + j * j <= r * r) {
                    res++;
                }
            }
        }

        System.out.println(res * 4);

    }
}
