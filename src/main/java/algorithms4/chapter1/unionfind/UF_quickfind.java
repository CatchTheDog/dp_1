package algorithms4.chapter1.unionfind;

/**
 * 动态连通性问题：输入是一列整数对，其中每个整数都表示一个某种类型的对象，一对整数p,q可以理解为“p和q是相连的”。假设相连是一种等价关系，其有以下属性：
 *  自反性：p和p是相连的
 *  对称性：若p与q相连，则q与p也是相连的
 *  传递性：若p与q相连，q与r相连，则p与r相连
 *  应用：处理网络连接连通性问题，检测元素是否属于同一集合
 *  算法复杂度O(n^2)
 *
 */
public class UF_quickfind {

    private int [] id; //分量id(以触点作为索引)

    private int count; //分量数量

    /**
     * 以整数标识（0到N-1）初始化N个触点
     * @param N
     */
    public UF_quickfind(int N) {
        //初始化分量id数组
       count = N;
       id = new int [N];
       for(int i =0;i<N;i++) id[i] = i;
    }

    /**
     * 在p和q之间添加一条连接
     * @param p
     * @param q
     */
    public void union(int p,int q){
        int pID = find(p);
        int qID = find(q);
        if(pID == qID) return;
        for(int i=0;i<id.length;i++)
            if(id[i] == pID) id[i] = qID;
        count --;
    }

    /**
     * p(0~N-1)所在分量的标志符
     * @param p
     * @return
     */
    public int find(int p){
        return id[p];
    }

    /**
     * 如果p和q存在同一个分量中则返回true
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p,int q){
         return find(p) == find(q);
    }

    /**
     * 连通分量的数量
     * @return
     */
    public int count(){
        return count;
    }
}
