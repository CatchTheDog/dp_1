package algorithms4.chapter1.exercises;


import algorithms4.utils.StdOut;

public class Exercise_1 {
	public static void main(String[] args) {
		StdOut.println(int2Binary(8));
	}

	public static String int2Binary(Integer N) {
		String s = "";
		for (; N > 0; N /= 2)
			s = (N % 2) + s;
		return s;
	}


}
