package algorithms4.chapter2;

import java.util.Random;

/**
 * 插入排序：将每一张牌插入到其他已经有序的序列的适当位置。
 * 插入排序需要的交换操作和数组中倒置的数量相同，需要的比较次数大于等于倒置的数量，小于等于倒置的次数加上数组的大小再减一。
 * 优化方法：在内循环中将较大的元素都向右移动而不总是交换两个元素。
 *          希尔排序
 *          二分搜索插入排序
 * 插入排序对于部分有序的数组十分高效，也很适合小规模数组。
 *
 */
public class Insertion extends Example{
    /**
     * 插入排序
     * @param a
     */
    public void sort(Comparable[] a) {
        int N = a.length;
        for(int i = 1;i<N;i++){
            //将a[i]插入到a[i-1],a[i-2],a[i-3]...之中
            //比较、交换在一次遍历中完成。
            for(int j = i;j>0 && less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }

    /**
     * 优化，在内层循环中将较大的元素向右端移动，将较小元素向左端移动。
     * @param a
     */
    public void sort_2(Comparable [] a){
        int N = a.length;
        for(int i = 1;i<N;i++){
            //将较小元素向左端移动
            for(int j=i;j>0 && less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
            //将较大的元素向右端移动
            for(int k = N-1;k>0 && less(a[k],a[k-1]);k--){
                exch(a,k,k-1);
            }
        }
    }

    public void sort_3(Comparable [] a){
        int N = a.length;
        for(int i = 1;i<N;i++){
            //二分法获取
            int start = 0;
            int end = i;
            int mid = 0;
            while(start<=end){
                mid = start + (end-start)/2;
                if(a[i].compareTo(a[mid])<0) end = mid-1;
                else if(a[i].compareTo(a[mid])>0) start = mid +1;
                else{
                    break;
                }
            }
            //将该元素插入到右端适当位置
            for(int k = i;k>mid;k--){
                exch(a,k,k-1);
            }

        }

    }

    /**
     * 比较、交换在两个循环中完成
     * @param a
     */
    public void insertion_x(Integer a []){
        for(int j = 1;j<a.length;j++){
            int n = a[j];
            int position = j;
            for(int k=0;k<j;k++){
                if(less(a[j],a[k])) {
                    position = k;
                    break;
                }
            }
            for(int m = j;m>position;m--){
                a[m] = a[m-1];
            }
            a[position] = n;
        }

    }

    public static void main(String []args){
        Insertion insertion = new Insertion();
        Integer [] a = new Integer [100];
        System.out.println("=========================排序前===============================");
        for(int i = 0;i<100;i++){
            Random random = new Random();
            a[i] = random.nextInt(100);
        }
        for(int x : a) System.out.println(x);
        System.out.println("=========================排序后===============================");
        //insertion.insertion_x(a);
        //insertion.sort(a);
        //insertion.sort_2(a);
        insertion.sort_3(a);
        insertion.show(a);
    }
}
