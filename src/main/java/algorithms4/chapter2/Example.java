package algorithms4.chapter2;

import algorithms4.utils.In;
import algorithms4.utils.StdOut;

public class Example {
    /**
     * 排序
     * @param a
     */
    public static void sort(Comparable [] a){}

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

    /**
     * 检测集合是否有序
     * @param a
     * @return
     */
    private static boolean isSorted(Comparable [] a){
        for(int i =0;i<a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void main(String [] args){
        String [] a = In.readStrings();
        sort(a);
        assert(isSorted(a));
        show(a);
    }
}
