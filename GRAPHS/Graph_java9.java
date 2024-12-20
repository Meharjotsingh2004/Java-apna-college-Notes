
import java.util.ArrayList;
import java.util.Collections;

public class Graph_java9 {
    //KrusKals Algorithm

    static class Edge implements Comparable<Edge> {

        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    static void creteGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }
    static int n = 4; //vertices-number
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void KrusKalsMST(ArrayList<Edge> edges, int V) {
        init();
        Collections.sort(edges); //O(ElogE)
        int mstCost = 0;
        int count = 0;

        for (int i = 0; count < V - 1; i++) { //O(V
            Edge e = edges.get(i);
            //src , wt , dest
            int parA = find(e.src); //src
            int parB = find(e.dest); // dest

            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }
    //KrusKals Algorithm

    //Flood Fill Algorithm
    public static void helper(int image[][], int sr, int sc, int color, boolean vis[][], int orgColor) { //O(m*n)

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || vis[sr][sc] || image[sr][sc] != orgColor) {
            return;
        }
        vis[sr][sc] = true;
        image[sr][sc] = color;
        //left
        helper(image, sr, sc - 1, color, vis, orgColor);
        //right
        helper(image, sr, sc + 1, color, vis, orgColor);
        //up 
        helper(image, sr - 1, sc, color, vis, orgColor);
        //down
        helper(image, sr + 1, sc, color, vis, orgColor);
    }

    public static int[][] floofFill(int image[][], int sr, int sc, int color) {

        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;

    }
    public static void Print(int a[][]){
        for(int i = 0 ; i< a.length ; i++){
            for(int j =0 ; j< a[0].length ; j++){
                System.out.print(a[i][j]+" ");
            }System.out.println();
        }
       
    }

    //Flood Fill Algorithm
    public static void main(String[] args) {

        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        creteGraph(edges);
        KrusKalsMST(edges, V);

         //Flood Fill Algorithm 
         int image[][] = {{1,1,1},{1,1,0} , {1,0,1}};
         int sr = 1 ;
         int sc = 1 ;
         int color = 2;
         Print(floofFill(image, sr, sc, color));
         System.out.println(floofFill(image, sr, sc, color));
         //Flood Fill Algorithm

    }
}
