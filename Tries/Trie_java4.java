
public class Trie_java4 {

    public static class Node {

        Node Children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                Children[i] = null;
            }
        }

    }
    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.Children[idx] == null) {
                curr.Children[idx] = new Node();
            }
            curr = curr.Children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.Children[idx] != null) {
                curr = curr.Children[idx];
            } else if (curr.Children[idx] == null) {
                return false;
            }
        }
        return curr.eow;
    }
//Start with Problem (Check for word given as prefix in words inserted)

    public static boolean searchStartWith(String prefix) { //O(L)
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.Children[idx] != null) {
                curr = curr.Children[idx];
            } else if (curr.Children[idx] == null) {
                return false;
            }
        }
        return true;
    }
//count Unique Substrings

    public static int countNode(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.Children[i] != null) {
                count += countNode(root.Children[i]);
            }
        }
        return count + 1;
    }

//Longest Word with all Prefixes
    public static String ans = "";

    public static void searchLongestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.Children[i] != null && root.Children[i].eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                searchLongestWord(root.Children[i], temp);
                temp.deleteCharAt(temp.length() - 1); //backtracking
            }
        }
    }

    public static void main(String[] args) {
        // insert("apple");
        // insert("moon");
        // insert("mehar");
        // insert("iphone");
        // insert("singing");
        // System.out.println(searchStartWith("moon"));
        // System.out.println(searchStartWith("ip"));

        //count Unique Substrings=====>
        // String str = "ababa"; //ans = 10
        // for (int i = 0; i < str.length(); i++) {
        //     insert(str.substring(i));
        // }
        //System.out.println(countNode(root));
        //Longest Word with all Prefixes
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        searchLongestWord(root, new StringBuilder(""));
        System.out.println(ans);

    //Random Practice Code 
        String a = "Hello my name is meharjot Singh";
        String b = a + "b";
        System.out.println(b);
        String c = "";

       // System.out.println();
       //Reverse the Words of Strings 
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == ' ' || i == 0) {
                if (i == 0 && a.charAt(i) != ' ') {
                    c = c + a.charAt(i);
                }
                for (int j = c.length() - 1; j >= 0; j--) {
                    System.out.print(c.charAt(j));
                }
                if(i!=0){
                    System.out.print(" ");
                }
               
                c = "";
            } else {
                c = c + a.charAt(i);
            }

        }
    //Random Practice Code 

    }
}
