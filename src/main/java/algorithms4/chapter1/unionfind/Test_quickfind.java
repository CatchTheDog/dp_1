package algorithms4.chapter1.unionfind;

import algorithms4.utils.StdIn;
import algorithms4.utils.StdOut;

public class Test_quickfind {
    public static void main(String [] args){
        int N = StdIn.readInt();
        UF_quickfind ufQuickfind = new UF_quickfind(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(ufQuickfind.connected(p,q)) continue;
            ufQuickfind.union(q,p);
        }
        StdOut.println(ufQuickfind.count() + "components");
    }
}
