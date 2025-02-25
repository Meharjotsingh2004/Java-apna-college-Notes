
import java.util.*;

public class BST_java2 {

    static public class Node {

        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
        }
    }
//Inserting Values IN BST

    public static Node insert(Node root, int val) {

        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }
//Inserting Values IN BST

//Root to Leaf Paths
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();

    }

    public static void printRootToLeaf(Node root, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);

        path.remove(path.size() - 1);
    }

//Root to Leaf Paths

//Validate BST

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
//Validate BST

//Mirror BST
    public static Node mirrorBst(Node root) {
        if (root == null) {
            return null;
        }

        Node lefts = mirrorBst(root.left);
        Node rights = mirrorBst(root.right);

        root.left = rights;
        root.right = lefts;
        return root;
    }


    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
//Mirror BST

//Sorted Array to BST
    public static Node createBST(int arr[], int st, int end) {

        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, end);
        return root;
    }
//Sorted Array to BST

//bst To Balanced BST
    public static void getInoder(Node root , ArrayList<Integer> inorder){
        if(root ==null){
            return;
        }
        getInoder(root.left, inorder);
        inorder.add(root.data);
        getInoder(root.right, inorder);
    }
    public static Node createBST( ArrayList<Integer> inorder, int st, int end) {

        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }
    public static Node balancedBST(Node root) {
        //inorder Sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInoder(root, inorder);

        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }
//bst To Balanced BST


    public static void main(String[] args) {
        int values[] = {8, 5, 3, 6, 10, 11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        printRootToLeaf(root, new ArrayList<>());
        System.out.println(isValidBST(root, null, null));

//Mirror BST
        preOrder(root);
        root = mirrorBst(root);
        System.out.println();
        preOrder(root);

//Sorted Array to BST
        int arr[] = {3, 5, 6, 8, 10, 11, 12}; //basically arr given is inorder sequence
        root = createBST(arr, 0, arr.length - 1);
        System.out.println();
        preOrder(root);

//          8
//         / \
//        6   10
//       /      \
//      5        11
//     /           \
//    3             12
        Node root1 = new Node(8);
        root1.left = new Node(6);
        root1.left.left = new Node(5);
        root1.left.left.left = new Node(3);
        root1.right = new Node(10);
        root1.right.right = new Node(11);
        root1.right.right.right = new Node(12);
        
        root1 = balancedBST(root1);System.out.println();
        preOrder(root1);

    }
}
