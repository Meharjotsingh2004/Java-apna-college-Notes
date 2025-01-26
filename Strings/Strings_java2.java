
import java.util.Scanner;

public class Strings_java2 {

//Converting Lower Case aplhets to uppercase  O(n)
    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

//String Compression
     

     public static String compressString(String str) {
        String newStr = "";

        for(int i=0 ;i< str.length() ; i++){
            Integer count=1;
           while( i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
            count++;
            i++;
           }
           newStr+= str.charAt(i);

           if(count > 1){
            newStr += count.toString();
           }
           
        }
        return newStr;
     }


    public static void main(String[] args) {
        //Strings are immutable due to concept of terning
        //String Builder

        int a = 10;
        Integer b = a;

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder("Meharjot Singh");
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch); //O(n)
        }

        System.out.println(toUpperCase("hi, my name is meharjot"));

        //String compression
        System.out.println(compressString("aabbccddd"));

     

    
       
        
    }

}
 