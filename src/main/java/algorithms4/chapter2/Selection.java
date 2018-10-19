package algorithms4.chapter2;

/**
 * 选择排序：
 * 首先，找到当前序列中最小的元素；其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）
 * 再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置；
 * 如此往复，知道将整个数组排序。
 * 特点：交换次数：每个元素交换一次，所以交换N次；
 * 比较次数，比较N^2/2次
 * 运行时间与输入无关：无论输入的有序程度如何，选择排序的速度总是只与输入规模相关。
 * 数据移动最少：每个元素只移动一次。
 */
public class Selection extends Example {
    public static void main(String[] args) {
        Selection selection = new Selection();
        //selection.test_2();
        selection.test_3();
    }

    /**
     * 排序
     *
     * @param a
     */
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    public void test_3() {
        Character[] chars = {'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        sort(chars);
        show(chars);
    }
}
