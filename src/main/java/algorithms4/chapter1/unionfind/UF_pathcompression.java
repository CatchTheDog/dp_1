package algorithms4.chapter1.unionfind;

/**
 * UF最优算法
 * 在加权quick-union的基础上，增加路径压缩：
 *     在检查节点的同时将它们直接连接到根节点上，降低树的深度，减少union遍历的节点数
 */
public class UF_pathcompression {

    private int[] id;
    private int[] sz;
    private int count;

    public UF_pathcompression(int N) {
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

    /**
     * 递归方式的路径压缩
     * @param p
     * @return
     */
    /*public int find(int p) {
        if (p != id[p]) {
            //如果当前节点不是根节点，则回溯寻找根节点并将该节点链接到根节点
            //回溯会产生额外的时间成本
            id[p] = find(id[p]);
        }
        return id[p];
    }*/

    /**
     * 非递归路径压缩
     * @param p
     * @return
     */
    public int find(int p) {
        int k,j,r;
        r = p; //默认根节点为当前节点
        while(r != id[r])  //查找根节点，然后保存在r中
            r = id[r];
        k = p;
        while(k!=r){
            j = id[k];   //用j暂存id[k]的父节点
            id[k] = r;   //将id[k]的父节点设置为根节点
            k = j;       //处理下一节点
        }
        return r; //返回根节点
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
