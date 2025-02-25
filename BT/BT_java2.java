
public class BT_java2 {

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

        public Node CreateTree(int node[]) { //O(N)
            idx++;
            if (node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.Left = CreateTree(node);
            newNode.Right = CreateTree(node);

            return newNode;
        }
    }
//Finding Diameter of tree

    @SuppressWarnings("unused")
     static int diameter2(Node root) { //O(N*N)
        if (root == null) {
            return 0;
        }
        int lD = diameter2(root.Left);
        int lH = height(root.Left);

        int rD = diameter2(root.Right);
        int rH = height(root.Right);

        int selD = lH + rH + 1;

        return Math.max(selD, Math.max(lD, rD));
    }

     static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.Left);
        int rightHeight = height(root.Right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

//2nd Approach
    public static class Info {

        int diam;
        int h;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.h = ht;
        }
    }

     static Info diameter(Node root) { //O(N)
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.Left);
        Info rightInfo = diameter(root.Right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.h + rightInfo.h + 1);
        int ht = Math.max(leftInfo.h, rightInfo.h) + 1;

        return new Info(diam, ht);
    }
//Finding Diameter of tree

//Subtree of another Tree
     static boolean isSubtree(Node root , Node subRoot) {
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root , subRoot)){
                return true;
            }
        }

        return isSubtree(root.Left, subRoot)||isSubtree(root.Right, subRoot);

    }

     static boolean isIdentical(Node node , Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }else if(node ==null || subRoot ==null || node.data!= subRoot.data){
            return false ; 
        }

        if(!isIdentical(node.Left, subRoot.Left)){
            return false;
        }
        
        if(!isIdentical(node.Right, subRoot.Right)){
            return  false;
        }

        return true;
    }
//Subtree of another Tree

    public static void main(String[] args) {
        int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree t1 = new BinaryTree();
        Node root = t1.CreateTree(node);

        System.out.println(diameter(root).diam);

        Node subRoot = new Node(2);
        subRoot.Left = new Node(4);
        subRoot.Right = new Node(5);

        System.out.println(isSubtree(root, subRoot));

    }
}
