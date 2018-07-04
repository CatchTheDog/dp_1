package algorithms4.chapter1;

public class Practice1 {
	/**
	 * 欧几里得算法 计算两个非负整数的最大公约数
	 * @param p
	 * @param q
	 * @return
	 */
	public static int gcd(int p,int q){
		if(q == 0) return p;
		int r = p % q;
		return gcd(q,r);
	}
}
