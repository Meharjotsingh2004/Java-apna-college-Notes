
import java.util.*;

public class Graph_java5 {

    public static class Edge {

        @SuppressWarnings("unused")
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

//isBipartite function coode ----->
//isBipartite function coode ----->
//isBipartite function coode ----->
    public static boolean isBipartite(ArrayList<Edge>[] graph) { //O(V+E)
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1; //no color
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { //BFS
                q.add(i);
                col[i] = 0;//yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); //neighbour == e.dest;
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false; //Not bipartite
                        }

                    }
                }
            }
        }
        return true;

    }

    ///---------> Detect cycle in directed graph
    ///---------> Detect cycle in directed graph
    ///---------> Detect cycle in directed graph

    static void createGraph2(ArrayList<Edge> graph[]) { //true case for directed graph to detect cycle

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) { //O(V+E)
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {

        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) { //cycle
                return true;
            }
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }

        }
        stack[curr] = false;
        return false;
    }

    ///////----------><----------//--> topological Sort 
    ///////----------><----------//--> topological Sort 
    ///////----------><----------//--> topological Sort 
    public static void createGraph3(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    //O(V+E)
    public static void topSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);//Modified dfs for topological sort
            }
        }
        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

//topological sort using bfs
    // Function to create a graph for demonstration
    public static void createGraph4(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topologicalSortBFS(ArrayList<Edge>[] graph) {
        int V = graph.length; // Number of vertices
        int[] indegree = new int[V]; // Array to store indegrees of vertices

        // Calculate indegrees of all vertices
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }

        // Queue to store vertices with 0 indegree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Process vertices with 0 indegree
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " "); // Print current vertex (topological order)

            // Decrease indegree of adjacent vertices
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;

                // If indegree becomes 0, add it to the queue
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        //If graph doesnt have cycle --> it is bipartite
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));

        ///////------------><------------/////////
        ///---------> Detect cycle in directed graph
 

        int V1 = 4;
        ArrayList<Edge> graph1[] = new ArrayList[V1];
        createGraph2(graph1);
        System.out.println(isCycle(graph1));

        //--> topological Sort 
        int V2 = 6;
        ArrayList<Edge> graph3[] = new ArrayList[V2];
        createGraph3(graph3);
        topSort(graph3);


 // System.out.println("Topological Sort using Kahn's Algorithm (BFS):");
        ArrayList<Edge>[] graph4 = new ArrayList[6];
        createGraph4(graph4);
        topologicalSortBFS(graph4);
    }
}
