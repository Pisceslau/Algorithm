package Algorithm;

import DataStructure.DirectedEdge;
import DataStructure.EdgeWeightedDigraph;
import DataStructure.Stack;
import edu.princeton.cs.algs4.IndexMinPQ;

/**
 * Created by Lunar on 2016/3/13.
 * 《算法》第四版 最短路径的Dijkstra算法
 */
public class DijkstraSP {
    private DirectedEdge[] edgeTo;//到达某一个最后一个边
    private double[] distTo;//到达某一个顶点的路径长度从S触发
    private IndexMinPQ<Double> pq;//索引优先队列

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];//有向边数组
        distTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for (int v = 0;v<G.V();v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
            distTo[s] = 0.0;

            pq.insert(s, 0.0);
            while (!pq.isEmpty()) {
                relax(G, pq.delMin());
            }
        }

    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v]+e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
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
}
