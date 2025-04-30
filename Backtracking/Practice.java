import java.util.*;

public class Practice {

    public static void main(String[] args) {

        String a = "Meharjot Singh Lamba";

        List <Character> list =  new ArrayList<>();

        for(char c : a.toCharArray()){
            list.add(c);
        }
        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        for(char i:list){
            sb = sb.append(i);
        } 

        System.out.println(sb);
    }
}
