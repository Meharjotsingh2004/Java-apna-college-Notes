
public class Trie_java2 {

    public static class Node {

        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {//O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean  search(String key){
        Node curr = root;
        for(int i=0 ; i< key.length() ; i++){
            int idx = key.charAt(i)-'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow ;
    }

//Word Break Problem 
    public static boolean wordBreak(String Key) { //O(L)

        if(Key.length() == 0){
            return true;
        }
        for (int i = 1; i <= Key.length(); i++) {
           if(search(Key.substring(0, i)) &&
           wordBreak(Key.substring(i))){
            return true;
           }
            
        }
        return false;
    }

    public static void main(String[] args) {
        String arr[] = {"i", "like", "sam", "samsung", "mobile", "ice"};

        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        String Key = "ilike";
        System.out.println(wordBreak(Key));
       

    }
}