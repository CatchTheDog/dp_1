package algorithms4.chapter1.unionfind;

import algorithms4.utils.StdIn;
import algorithms4.utils.StdOut;

public class Test_quickunion {
    public static void main(String [] args){
        int N = StdIn.readInt();
        UF_quickunion uFquickunion = new UF_quickunion(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uFquickunion.connected(p,q)) continue;
            uFquickunion.union(q,p);
        }
        StdOut.println(uFquickunion.count() + "components");
    }
}
