package algorithms4.chapter2;

import algorithms4.utils.In;
import algorithms4.utils.StdOut;

/**
 * 选择排序：
 *      首先，找到当前序列中最小的元素；其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）
 *      再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置；
 *      如此往复，知道将整个数组排序。
 */
public class Selection {
    /**
     * 排序
     * @param a
     */
    public static void sort(Comparable [] a){
        int N = a.length;
        for(int i =0;i<N;i++){
            int min =i;
            for(int j = i+1;j<N;j++)
                if(less(a[j],a[min])) min = j;
            exch(a,i,min);
        }
    }

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
