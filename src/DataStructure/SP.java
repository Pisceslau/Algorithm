package DataStructure;

/**
 * Created by Lunar on 2016/3/9.
 * 算法第四版最短路径API
 */
public class SP {
    double distTo[];
    DirectedEdge edgeTo[];

    public SP(EdgeWeightedDigraph G, int s) {

    }

    double distTo(int v) {
        //从顶点s到v的距离，如果不存在则路径为无穷大
        return distTo[v];
    }

    boolean hasPathTo(int v) {
        //是否存在从顶点s到v的路径,通过检查是否到达某点的距离为无穷大来判断是不是可以达的是否有路径的
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        //从顶点s到v的路径如果不存在则为null
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();//stack是后进先出则，是逆序而打印的
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])//e更新是由到该边的开始点为末尾点的边
            path.push(e);//不断从末尾点向着起点找边
        return path;

    }

    //边的松弛操作
    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        //如果已知的s到w的路径大于s到达v的路径加vw之间的权重，则后者为更小代价
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;//到达w的最后一条边为e;
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }
}
