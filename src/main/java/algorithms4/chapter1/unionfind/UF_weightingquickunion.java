package algorithms4.chapter1.unionfind;

/**
 * 加权quick-union
 * 动态连通性问题：输入是一列整数对，其中每个整数都表示一个某种类型的对象，一对整数p,q可以理解为“p和q是相连的”。假设相连是一种等价关系，其有以下属性：
 * 自反性：p和p是相连的
 * 对称性：若p与q相连，则q与p也是相连的
 * 传递性：若p与q相连，q与r相连，则p与r相连
 * 应用：处理网络连接连通性问题，检测元素是否属于同一集合
 *
 * 因为在输入有序的情况下，会导致quick-union中的树退化为链表，从而使得find()的时间复杂度为O(n^2)
 * 所以在进行union过程中，考虑总是将较小的树连接到较大的树上，这样就能保证N个触点的森林中的任意节点的深度最大为lgN;加权quick-union算法的时间复杂度为O(lgN)
 */
public class UF_weightingquickunion {
    private int[] id;
    private int[] sz;
    private int count;

    public UF_weightingquickunion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        //将小树的根节点连接到大树的根节点
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}
