package 蓝桥杯.练习系统.算法训练;

	import java.util.*;
	class Main{

		static int a,b,c,k;

		public static void main(String[] args){

			Scanner sc = new Scanner(System.in);
			a= sc.nextInt();
			b= sc.nextInt();
			c= sc.nextInt();
			int b2= b * b;
			int a4 = 4 * a * c;
			int x1, x2;
			if (b2 < a4) {
				System.out.println("NO");
			} else if (b2 ==  a4) {
				x1 = (int) ((-b + Math.sqrt(b2 - a4)) / 2 * a);
				System.out.println(x1);
			} else if (b2 > a4) {
				x1 = (int) ((-b + Math.sqrt(b2 - a4)) / 2 * a);
				x2 = (int) ((-b - Math.sqrt(b2 - a4)) / 2 * a);
				if (x1 > x2) {
					System.out.println(x1 + " " + x2);
				} else {
					System.out.println(x2 + " " + x1);
				}
			}
		}

	}