package algorithms4.chapter1.exercises;


import algorithms4.utils.StdOut;

import java.util.Scanner;

public class Exercise_1 {
	public static void main(String[] args) {
		//StdOut.println(int2Binary(8));
		//StdOut.println(mystery(3,11));
		StdOut.println(factorial(5));
		print();
	}

	public static String int2Binary(Integer N) {
		String s = "";
		for (; N > 0; N /= 2)
			s = (N % 2) + s;
		return s;
	}

	public static int mystery(int a, int b) {
		if (b == 0) return 0;
		if (b % 2 == 0) return mystery(a + a, b / 2);
		return mystery(a + a, b / 2) + a;
	}

	public static int factorial(int N) {
		if (N == 0) return 0;
		if (N == 1) return 1;
		return N * factorial(N - 1);
	}


	public static void print() {
		System.out.printf("%-20s%-20s%-20s%-20s%n", "姓名", "得分1", "得分2", "命中率");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String inputStr = sc.nextLine();
			if (null != inputStr && inputStr.length() > 0) {
				String[] tempStr = inputStr.split(" ");
				if (null != tempStr && tempStr.length > 0) {
					String name = tempStr[0];
					Double score1 = Double.parseDouble(tempStr[1]);
					Double score2 = Double.parseDouble(tempStr[2]);
					Double percent = score1 / score2;
					System.out.printf("%-20s%-20.3f%-20.3f%-20.3f%n", name, score1, score2, percent);
				}
			}
		}
	}


}
