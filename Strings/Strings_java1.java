
public class Strings_java1 {

//Checking for Palindrome
    public static boolean isPalindrome(String a) {
        for (int i = 0; i < a.length() / 2; i++) {
            int n = a.length();
            if (a.charAt(i) == a.charAt(n - 1 - i)) {

            } else {
                return false;
            }
        }
        return true;
    }

    public static float getSHortestPAth(String a) {
        int x = 0, y = 0;

        for (int i = 0; i < a.length(); i++) {

            if (a.charAt(i) == 'N') {
                y++;
            } else if (a.charAt(i) == 'S') {
                y--;
            } else if (a.charAt(i) == 'E') {
                x++;
            } else {
                x--;
            }
        }
        int x2 = x * x;
        int y2 = y * y;
        return (float) Math.sqrt(x2 + y2);
    }

    public static String subString(String a, int si, int ei) {
        String subStr = "";
        for(int i=si ; i < ei ; i++){
            subStr += a.charAt(i);
        }

        return subStr;
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        // String a = sc.nextLine();
        // String fullname = "Tony Start";
        //System.out.println(fullname.length()); 
        //Concatenation
        // String firString = "meharjot";
        // String firString2 = "Singh";
        // String fullName = firString +" "+ firString2;
        // System.out.println(fullName);
        //CharAt Function
        //Check For palindrome
        System.out.println(isPalindrome("meha"));

        //Shortest Path
        String dirc = "WNEENESENNN";
        System.out.println("Shortest Path : " + getSHortestPAth(dirc));

        //String Comparison
        String str = "Tony";
        String str2 = "Tony";

        if (str.equals(str2)) {
            System.out.println("Stirng is equal");
        }

        //SubString
        String name = "HEllo World";
        System.out.println(subString(name, 0, 5)); //oR
        System.out.println(name.substring(0, 6+1));


        
       //Finding larget String in Lexicographical MAnner

        String fruits[] = {"apple", "mango", "banana"};

        String largest = fruits[0];

        for(int i= 1; i< fruits.length ; i++){
            if(largest.compareToIgnoreCase(fruits[i]) <0){
                largest = fruits[i];
            }
        }
        System.out.println(largest);
    }
}
