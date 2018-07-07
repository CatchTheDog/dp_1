package algorithms4.chapter1;

public class ArrayUtil {

	public static int getMax(int [] array){
		int max = array[0];
		for(int i = 1;i<array.length;i++){
			max = array[i]>max ? array[i] : max;
		}
		return max;
	}
	public static int getMin(int [] array){
		int min = array[0];
		for(int i = 1;i<array.length;i++){
			min = array[i]<min ? array[i] : min;
		}
		return min;
	}
	public static int getAvg(int [] array){
		int sum = 0;
		for(int ele : array) sum += ele;
		return sum/array.length;
	}

	public static int [] getCopy(int [] array){
		int [] b = new int [array.length];
		for(int i = 0;i<array.length;i++){
			b[i] = array[i];
		}
		return b;
	}

	/**
	 * 颠倒数组元素
	 * @param array
	 * @return
	 */
	public static int [] getUpside(int [] array){
		int N = array.length;
		for(int i =0;i<N/2;i++){
			int temp = array[i];
			array[i] = array[N-1-i];
			array[N-1-i] = temp;
		}
		return array;
	}

	/**
	 * 矩阵相乘
	 * 两个矩阵只有在第一个矩阵的列数等于第二个矩阵的行数时才能相乘；
	 *
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] [] MatrixMutiply(int [] [] a,int [] [] b){
		int N = a.length;
		int [] [] c = new int [N][N];
		for(int i = 0;i<N;i++){
			for(int j =0;j<N;j++){
				for(int k = 0;k<N;k++){
					//第一个矩阵的i行的各个元素分别与第二个矩阵的j列上的对应元素乘积之和
					c[i][j] += a[i][k]*b[k][j];
				}
			}
		}
		return c;
	}
}
