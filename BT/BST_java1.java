
public class BST_java1 {

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

//Inorder traversal Of BST
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean Search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return Search(root.left, key);
        } else {
            return Search(root.right, key);
        }

    }
//Inorder traversal Of BST

// Deleting A Node
    public static Node delete(Node root , int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }else{
            //case -1 leaf Node 
            if(root.left ==null && root.right ==null){
                return  null;
            }

            //case - 2 Single child
            if(root.left ==null){
                return root.right;
            }else if(root.right ==null){
                return root.left;
            }

            //case -3 Both Child
            Node IS = findInorderSuccesor(root.right);
            root.data = IS.data;
            root.right  = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node findInorderSuccesor(Node root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }
// Deleting A Node
//Printing  In Range In BST
    public static void printInRange(Node root ,int k1 , int k2){

        if(root == null){
            return;
        }
        if(root.data >=k1 && root.data<= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }else{
            printInRange(root.right, k1, k2);
        }
    }
//Searching In Range In BST

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println(Search(root, 4));

        delete(root, 10);
        inorder(root);System.out.println();

        printInRange(root, 5, 12);

    }
}


