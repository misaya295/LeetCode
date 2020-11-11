package 蓝桥杯.国赛.guosai_2018;


/*
 1.标题：三角形面积

已知三角形三个顶点在直角坐标系下的坐标分别为：
(2.3, 2.5)
(6.4, 3.1)
(5.1, 7.2)

求该三角形的面积。

注意，要提交的是一个小数形式表示的浮点数。
要求精确到小数后3位，如不足3位，需要补零。




8.795
 */
public class Main1 {

    public static void main(String[] args) {
        double x1 = 2.3;
        double y1 = 2.5;
        double x2 = 6.4;
        double y2 = 3.1;
        double x3 = 5.1;
        double y3 = 7.2;


        double s = ((x1 * y2 - x2 * y1) + (x2 * y3 - x3 * y2) + (x3 * y1 - x1 * y3)) / 2;


        System.out.printf("%.3f",s);
    }

}
