


public class Trie_java3 {

    public static class Node {

        Node[] children = new Node[26];
        boolean eow = false; //end of word
        int freq;

        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {

        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
//Prefix Problem Code 
    public static void findPrefix(Node root , String ans ) { //O(L) L = longest word 
        
        if(root == null){
            return;
        }
        if(root.freq ==1){
            System.out.println(ans);
            return;
        }
        for(int i=0 ; i< root.children.length ; i++){
            if(root.children[i]!= null){
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }

    public static void main(String[] args) {

        String a [] = {"zebra" , "dog" , "duck" , "dove"};
        for(int i = 0 ; i< a.length ; i++){
            insert(a[i]);
        }
       root.freq = -1;

       //findPrefix(root, "");
      
    }
}


