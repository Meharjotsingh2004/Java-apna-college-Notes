
import java.util.*;

public class Graph_java6 {

    public static class Edge {

        @SuppressWarnings("unused")
        int src;
        int dest;

        public Edge(int s, int w) {
            this.src = s;
            this.dest = w;
        }
    }
    // Printing All PAths from srouce from to dest ======>>

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(5, 0));

    }

    public static void printAllPath(ArrayList<Edge> graph[], int src, int dest, String Path) {
        if (src == dest) {
            System.out.println(Path + dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            printAllPath(graph, e.dest, dest, Path + src);
        }

    }
    // Printing All PAths from srouce from to dest =====>>>

    //Djikstra ===> code
    public static class EdgeDj {

        int src;
        int dest;
        int wt;

        public EdgeDj(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;

        }
    }

    public static void creategraph2(ArrayList<EdgeDj> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new EdgeDj(0, 1, 2));
        graph[0].add(new EdgeDj(0, 2, 4));

        graph[1].add(new EdgeDj(1, 3, 7));
        graph[1].add(new EdgeDj(1, 2, 1));

        graph[2].add(new EdgeDj(2, 4, 3));

        graph[3].add(new EdgeDj(3, 5, 1));

        graph[4].add(new EdgeDj(4, 3, 2));
        graph[4].add(new EdgeDj(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {

        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void Djikstra(ArrayList<EdgeDj> graph[], int src) { //O(V+ ELogv)
        int dist[] = new int[graph.length]; //dist[i] -> src to i

        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE; //Infinity
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0));
        //loop
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    EdgeDj e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) { //update distance of src to v;
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        //print all SOurce to vertices shorteest dist
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
//Djikstra ===> code

//Bellman Ford =====> code
    public static void createGraphBellman(ArrayList<EdgeDj> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new EdgeDj(0, 1, 2));
        graph[0].add(new EdgeDj(0, 2, 4));

        graph[1].add(new EdgeDj(1, 2, -4));

        graph[2].add(new EdgeDj(2, 3, 2));

        graph[3].add(new EdgeDj(3, 4, 4));

        graph[4].add(new EdgeDj(4, 1, -1));
    }

    public static void BellmanFord(ArrayList<EdgeDj> graph[], int src) {
        int dist[] = new int[graph.length];

        for (int i = 0; i < dist.length; i++) { //intializing distance array
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        //algorith performimng //O(V*E)
        int V = graph.length;
        for (int i = 0; i < V - 1; i++) {
            //edges-O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    EdgeDj e = graph[j].get(k);
                    //u , v, wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    //Relaxation 
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        //print 
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();

    }
    //Bellman Ford =====> code

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
// Printing All PAths from srouce from to dest =====>>>
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        int src = 5;
        int dest = 1;
        String path = "";
        printAllPath(graph, src, dest, path);
// Printing All PAths from srouce from to dest =====>>>


//Djikstra ===> code
        int V2 = 6;
        ArrayList<EdgeDj> graph2[] = new ArrayList[V2];
        creategraph2(graph2);
        int src2 = 0;
        Djikstra(graph2, src2);

//Djikstra ===> code


        //Bellman Ford =====> code
        int vB = 5;
        ArrayList<EdgeDj> graphBellan[] = new ArrayList[vB];
        createGraphBellman(graphBellan);
        BellmanFord(graphBellan, 0);
        //Bellman Ford =====> code

    }
}
