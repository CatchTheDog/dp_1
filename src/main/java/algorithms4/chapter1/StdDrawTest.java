package algorithms4.chapter1;

import algorithms4.utils.StdDraw;
import algorithms4.utils.StdRandom;

/**
 * 画图测试
 */
public class StdDrawTest {
	public static void main(String[] args) {
		test3();
	}

	public static void test1() {
		int N = 100;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N * N);
		StdDraw.setPenRadius(0.01);
		for (int i = 1; i <= N; i++) {
			StdDraw.point(i, i);
			StdDraw.point(i, i * i);
			StdDraw.point(i, i * Math.log(i));
		}
	}

	public static void test2() {
		int N = 50;
		double[] a = new double[N];
		for (int i = 0; i < N; i++)
			a[i] = StdRandom.random();
		for (int i = 0; i < N; i++) {
			double x = 1.0 * i / N;
			double y = a[i] / 2.0;
			double rw = 0.5 / N;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}

	public static void test3() {
		//StdDraw.point(10,10);
		StdDraw.line(1, 1, 2, 2);
		//StdDraw.circle(1,1,2);
		//StdDraw.square(1,1,2);
		//double [] x = {1,2,3,4};
		//double [] y = {5,6,7,8};
		//StdDraw.polygon(x,y);
	}
}
