
import java.util.*;


public class Graph_java1 {

    static class Edge {

        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void main(String[] args) {
        int V = 5; //Vertices  
        ArrayList<Edge>[] graph = new ArrayList[V]; //null - not defined what is stored

        for(int i=0 ; i<V ; i++){
            graph[i] = new ArrayList<>();
        }

        //For 0--vertex
        graph[0].add(new Edge(0, 1, 5));

        //For 1--vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
      
        //2 Vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        //3 vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        //4 Vertex
        graph[4].add(new Edge(4, 2, 2));


        //2's Neigbour
        for(int i=0 ; i< graph[2].size() ;i++){
            Edge e = graph[2].get(i) ; //src ,dest ,wt
            System.out.println(e.dest);
        }

    }
}
