package algorithms4.chapter1;

import algorithms4.utils.StdOut;
import algorithms4.utils.StdRandom;
import algorithms4.utils.Stopwatch;

public class DoublingTest {
	public static double timeTrial(int N) {
		int Max = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = StdRandom.uniform(-Max, Max);
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		return timer.elapsedTime();
	}

	public static void main(String[] args) {
		for (int N = 250; true; N++) {
			double time = timeTrial(N);
			StdOut.printf("%7d %5.1f\n", N, time);
		}
	}
}
