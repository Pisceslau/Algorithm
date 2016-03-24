package DataStructure;

/**
 * Created by Lunar on 2016/3/9.
 * 算法-第四版加权有向图的API
 */
public class EdgeWeightedDigraph {
    private int V;//顶点总数
    private int E;//边的总数
    private Bag<DirectedEdge>[] adj;//邻接表

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];//数组中的每个元素都是边数组类型是包类型
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    //顶点数目
    public int V() {
        return V;
    }

    //边的数目
    public int E() {
        return E;
    }

    //将e添加到该有向图中
    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);//边的起点的包
    }

    //遍历
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }
    //返回的类型是一个可以被遍历的包类型
    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v])
                bag.add(e);//包里的每一条边

        }
        return bag;
    }

}
