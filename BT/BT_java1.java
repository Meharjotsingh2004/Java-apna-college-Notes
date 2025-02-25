
import java.util.*;


public class BT_java1 {

    static class Node {

        int data;
        Node Left;
        Node Right;

        public Node(int d) {
            this.data = d;
            this.Left = null;
            this.Right = null;
        }
    }

    static class BinaryTree {

        static int idx = -1;
//Creating A tree

        public  Node CreateTree(int node[]) { //O(N)
            idx++;
            if (node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.Left = CreateTree(node);
            newNode.Right = CreateTree(node);

            return newNode;
        }
//Traversing a tree in preorder traversal

        public  void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.Left);
            preOrder(root.Right);
        }
//traversing a tree in inorder traversal

        public  void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.Left);
            System.out.print(root.data + " ");
            inorder(root.Right);
        }
//Traversing a tree in postorder traversla

        public  void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.Left);
            postorder(root.Right);
            System.out.print(root.data + " ");
        }
//Traversing the tree in levelorder traversal
   
        public  void levelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q1 = new LinkedList<>();

            q1.add(root);
            q1.add(null);

            while (!q1.isEmpty()) {
                  Node r = q1.remove();
                  if(r==null){
                    System.out.println();
                    if(!q1.isEmpty()){
                        q1.add(null);
                    }
                  }else {
                   
                    System.out.print(r.data + " ");
                    if (r.Left != null) q1.add(r.Left);
                    if (r.Right != null) q1.add(r.Right);
                }
            }
        }
//Finding Height of Tree

      public  int heightofTree(Node root){ //O(N)
        if(root == null){
            return 0 ;
        }
        int leftHeight = heightofTree(root.Left);
        int rightHeight = heightofTree(root.Right);

        return Math.max(leftHeight ,rightHeight)+1;
      }

//Count Of Nodes
    public int countOfNodes(Node root){
        if(root ==null){
            return  0;
        }
        int leftSubtree = countOfNodes(root.Left);
        int rightSubtree = countOfNodes(root.Right);

        return leftSubtree+rightSubtree+1;
    }
//Sum of Nodes
    
    public int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumOfNodes(root.Left);
        int rightSun = sumOfNodes(root.Right);

        return leftSum+rightSun+root.data;
    }
}
    public static void main(String[] args) {
        int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree t1 = new BinaryTree();
        Node root = t1.CreateTree(node);

        t1.preOrder(root);
        System.out.println();
        t1.inorder(root);System.out.println();
        t1.postorder(root);System.out.println();
        t1.levelOrder(root);
        System.out.println(t1.heightofTree(root)); 
        System.out.println(t1.countOfNodes(root));
        System.out.println(t1.sumOfNodes(root));
        

    }
}
