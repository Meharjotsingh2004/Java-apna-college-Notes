
import java.util.*;

public class BT_java3 {

    public static class Node {

        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {

        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        //Level Order
        Queue<Info> q = new LinkedList<>();

        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) { //first time Horizontal dist. is occurring
                    map.put(curr.hd, curr.node);
                }
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(curr.hd - 1, min);
                }

                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(curr.hd + 1, max);
                }
            }

        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }

    }
//Printing Kth Level of Tree

    static void kthLevel(Node root, int k, int level) {
        if (root == null) {
            return;
        }
        if (k == level) {
            System.out.print(root.data + " ");

        } else {
            kthLevel(root.left, k, level + 1);
            kthLevel(root.right, k, level + 1);
        }
    }
//Printing Kth Level of Tree

//Lowest common Ancestor --Approach 1
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {

        if (root == null) {
            return false;
        }
        
        path.add(root);
        if (root.data == n) {
            return true;
        }
        boolean left = getPath(root.left, n, path);
        boolean right = getPath(root.right, n, path);

        if (left || right) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) { //O(N)

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        //last common ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lca = path1.get(i - 1);

        return lca;
    }

//Lowest common Ancestor
//Lowest common Ancestor --Approach 2
     
    public static Node lca2(Node root , int n1 , int n2){ //O(N)
     
        if(root ==null ||root.data == n1 || root.data ==n2){
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if(leftLca == null ){
            return rightLca;
        }
        if(rightLca == null){
            return leftLca;
        }

        return root;
    }
//Lowest common Ancestor --Approach 2

//MIn Distance between Nodees

public static int minDistance(Node root ,int n1 , int n2){

    Node lca = lca2(root , n1, n2);
    int dist1 = lcaDist(lca , n1);
    int dist2 = lcaDist(lca , n2);


    return  dist1 + dist2;
}

public static  int lcaDist(Node root , int n){
    if(root ==null){
        return -1;
    }
    if(root.data  == n){
        return 0;
    }

    int leftDist = lcaDist(root.left, n);
    int rightDist = lcaDist(root.right, n);

    if(leftDist == -1 && rightDist ==-1){
        return  -1;
    }else if(leftDist ==-1){
        return rightDist+1;
    }else{
        return leftDist+1;
    }
}
//MIn Distance between Nodees

    public static void main(String[] args) {

        /*
      1
     / \
    2   3
   / \ / \
  4  5 6  7
         */
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

//

        topView(root);
        System.out.println();

        kthLevel(root, 3, 1);System.out.println();

        System.out.println(lca(root, 5, 4).data);
        System.out.println(lca2(root, 6, 7).data);

        System.out.println(minDistance(root, 4, 6));
        System.out.println(minDistance(root, 1, 6));

    }
}
