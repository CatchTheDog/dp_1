package algorithms4.chapter1;

public class ThreeSum {
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					if (a[i] + a[j] + a[k] == 0) cnt++;
				}
			}
		}
		return cnt;
	}
}
/*定义：我们用 ~f(N) 表示所有随着N饿增大除以f(N)的结果趋近于1的函数；用g(N)~f(N)表示g(N)/f(N)随着N的增大趋近于1；*/
