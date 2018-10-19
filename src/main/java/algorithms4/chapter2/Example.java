package algorithms4.chapter2;

import algorithms4.utils.In;
import algorithms4.utils.StdOut;

public abstract class Example implements SortInterface {

    /**
     * 元素比较
     *
     * @param v
     * @param w
     * @return
     */
    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 将元素交换位置
     *
     * @param a
     * @param i
     * @param j
     */
    protected void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 打印字符串
     *
     * @param a
     */
    protected void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i] + " ");
        }
        StdOut.println();
    }

    /**
     * 检测集合是否有序
     *
     * @param a
     * @return
     */
    protected boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    protected void test(Comparable[] a) {
        sort(a);
        assert (isSorted(a));
        show(a);
    }

    private Integer[] getInt(String[] a) {
        Integer[] b = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = Integer.valueOf(a[i]);
        }
        return b;
    }

    protected void test_2() {
        Integer[] a = getInt(In.readStrings());
        sort(a);
        assert isSorted(a);
        show(a);
    }


}
