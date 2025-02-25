
public class BT_java4 {

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


    public static int kthAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);

        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }


    public static int transform(Node root){

        if(root == null){
            return 0;
        }
        int leftChild  = transform(root.left);
        int rigthChild  = transform(root.right);

        int data = root.data;
        
        int newLeft  = root.left ==null ? 0: root.left.data;
        int newRight  = root.right ==null ? 0: root.right.data;


        root.data = newLeft + leftChild + newRight+ rigthChild;
        return data;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
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

        kthAncestor(root, 6, 2);
        transform(root);
        preOrder(root);

    }
}
