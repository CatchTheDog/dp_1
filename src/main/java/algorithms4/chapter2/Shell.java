package algorithms4.chapter2;

import java.util.Random;

public class Shell extends Example{
    public void sort(Comparable [] a){
        int N = a.length;
        int h = 1;
        while(h<N/3) h= 3*h +1;
        while(h >= 1){
            for(int i = h;i<N;i++){
                //将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...之中
                for(int j = i;j >= h && less(a[j],a[j-h]);j -= h){
                    exch(a,j,j-h);
                }
            }
            h = h/3;
        }
    }

    public static void main(String []args){
        Shell shell = new Shell();
        Integer [] a = new Integer [10];
        System.out.println("=========================排序前===============================");
        for(int i = 0;i<a.length;i++){
            Random random = new Random();
            a[i] = random.nextInt(100);
        }
        for(int x : a) System.out.println(x);
        System.out.println("=========================排序后===============================");
        //insertion.insertion_x(a);
        //insertion.sort(a);
        shell.sort(a);
        shell.show(a);
    }
}
