
import java.util.*;

public class Graph_java7 {

    @SuppressWarnings("unused")
    public static class Edge {

        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
//Mst -MInimun Spanning TRee

    public static void CreateGrapgh(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {

        int v;
        int cost;

        public Pair(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; //Accensding 
        }
    }

    //O(ElogE)
    public static void primsMST(ArrayList<Edge> graph[]) { //minimum spanmning tree with Prims Algo

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0));
        int FinalCost = 0; //MST COST

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                FinalCost += curr.cost;
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }

        }
        System.out.println("Final(MINIMUM) Cost of MSt = " + FinalCost);
    }
//Mst -MInimun Spanning TRee ends

//Cheapest Flight within K Stops using Modified Djiskatra
    public static void createGraphFlight(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();

        }
        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1], flights[i][2]));
        }

    }

    static class Info {

        int v;
        int cost;
        int Stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.Stops = s;
        }
    }

    @SuppressWarnings({ "unchecked", "unused" })
    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        ArrayList<Edge> graphF[] = new ArrayList[n];
        createGraphFlight(flights, graphF);

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.Stops > k) {
                break;
            }
            for (int i = 0; i < graphF[curr.v].size(); i++) {
                Edge e = graphF[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dist[v] && curr.Stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.Stops + 1));
                }
            }
        }

        //dist[dest]
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }

    }
//Cheapest Flight within K Stops using Modified Djiskatra ends

//connecting Cititees with minimum cost - using minimum spanning tree concept
    static class EdgeC implements Comparable<EdgeC>{

        int dest ;
        int cost ;
        public EdgeC(int d , int c){
            this.dest = d;
            this.cost = c;
        }
        @Override
        public int compareTo(EdgeC e2){
            return  this.cost - e2.cost;
        }
    }

    public static int connectCitites(int cities[][]){
        PriorityQueue<EdgeC> pq =  new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];
        
        pq.add(new EdgeC(0, 0));
        int FinalCost =0;

        while(!pq.isEmpty()){
            EdgeC curr = pq.remove();
            if(!vis[curr.dest]){
                vis[curr.dest] = true;
                FinalCost += curr.cost;
                for(int i =  0 ; i< cities[curr.dest].length; i++){
                    if(cities[curr.dest][i] != 0){
                        pq.add(new EdgeC(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return FinalCost;
    }
//connecting Cititees with minimum cost - using minimum spanning tree concept ends

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //Mst -MInimun Spanning TRee
        int V = 4;//No of Vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGrapgh(graph);
        primsMST(graph);
        //Mst -MInimun Spanning TRee

        //Cheapest Flight within K Stops using Modified Djiskatra
        int n = 4;
        int Flight[][] = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int scr = 0, dest = 3, k = 1;
        System.out.println("Minimum Cost with K Stops : " + cheapestFlight(n, Flight, scr, dest, k));

        //Cheapest Flight within K Stops using Modified Djiskatra
        //connecting Cititees with minimum cost - using minimum spanning tree concept
        int cities[][] = {{0, 1, 2, 3, 4},
        {1, 0, 5, 0, 7},
        {2, 5, 0, 6, 0},
        {3, 0, 6, 0, 0},
        {4, 7, 0, 0, 0}};
        System.out.println("connecting citites with minimum cost: "+connectCitites(cities));
        //connecting Cititees with minimum cost - using minimum spanning tree concept

    }
}
