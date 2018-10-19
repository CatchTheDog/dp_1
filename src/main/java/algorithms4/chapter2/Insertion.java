package algorithms4.chapter2;

import algorithms4.utils.In;
import algorithms4.utils.StdOut;

import java.util.Date;
import java.util.Random;

/**
 * 插入排序：将每一张牌插入到其他已经有序的序列的适当位置。
 *
 */
public class Insertion extends Example{
    /**
     * 插入排序
     * @param a
     */
    public void sort(Comparable[] a) {

    }

    public void insertion_x(Integer a []){
        for(int i = 0;i<a.length-1;i++){
            for(int j = i+1;j<a.length;j++){
                int n = a[j];
                //在前面子串中寻找a[j]的位置，并插入
                int position = j;
                for(int k=0;k<j;k++){
                    if(less(a[j],a[k])) {
                        position = k;
                        break;
                    }
                }
                //将k 到 i(包含a[i])的每个元素向后移动一位，将a[j]放入k处
                for(int m = j;m>position;m--){
                    a[m] = a[m-1];
                }
                a[position] = n;
            }
        }
    }

    public static void main(String []args){
        Insertion insertion = new Insertion();
        Integer [] a = new Integer [100];
        for(int i = 0;i<100;i++){
            Random random = new Random();
            a[i] = random.nextInt(100);
        }
        for(int x : a) System.out.println(x);
        insertion.insertion_x(a);
        insertion.show(a);
    }
}
