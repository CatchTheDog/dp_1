package algorithms4.chapter2;

import algorithms4.utils.In;
import algorithms4.utils.StdOut;

/**
 * 插入排序
 *
 */
public class Insertion {
    /**
     * 排序
     * @param a
     */
    public static void sort(Comparable [] a){
        int N = a.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }

    /**
     * 排序
     * @param a
     */
    /*public static void sort_1(Comparable [] a){
        int N = a.length;
        for(int i=1;i<N;i++){
            int j = i;
            while(j>0){
               if(less(a[j],a[j-1])){
                   exch(a,j,j-1);
               }else{
                   for(int k=j;k<N&&less(a[k],a[k-1]);k++){
                       exch(a,k,k+1);
                   }
               }
              j--;
            }
        }
    }*/

    /**
     * 元素比较
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0 ;
    }

    /**
     * 将元素交换位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable [] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j]  = t;
    }

    /**
     * 打印字符串
     * @param a
     */
    private static void show(Comparable [] a){
        for(int i = 0;i<a.length;i++){
            StdOut.println(a[i] + " ");
        }
        StdOut.println();
    }

    private static void show_1(Comparable [] a){
        for(int i = 0;i<a.length;i++){
            StdOut.println(a[i] + " ");
        }
        StdOut.println();
    }

    /**
     * 检测集合是否有序                    2
     * @param a
     * @return
     */
    private static boolean isSorted(Comparable [] a){
        for(int i =0;i<a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static Integer[] getInt(String [] a){
        Integer [] b = new Integer [a.length];
        for(int i =0;i<a.length;i++){
            b[i] = Integer.valueOf(a[i]);
        }
        return b;
    }

    public static void main(String [] args){
        Integer [] a = getInt(In.readStrings());
        sort(a);
        assert(isSorted(a));
        show(a);
    }
}
