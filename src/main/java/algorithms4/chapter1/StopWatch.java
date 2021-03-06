package algorithms4.chapter1;

import algorithms4.utils.StdOut;
import algorithms4.utils.StdRandom;

public class StopWatch {
	private final long start;

	public StopWatch() {
		start = System.currentTimeMillis();
	}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform(-1000000, 1000000);
		}
		StopWatch timer = new StopWatch();
		int cnt = ThreeSum.count(a);
		double time = timer.elapsedTime();
		StdOut.println(cnt + "triples " + time + " seconds.");
	}

	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}
}
