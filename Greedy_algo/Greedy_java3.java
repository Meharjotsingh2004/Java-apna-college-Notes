
import java.util.*;

public class Greedy_java3 {

    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int h = 0, v = 0;
        int hP = 1, vP = 1; //vertical and horizontal pieces

        int cost = 0;
        while (h < costHor.length && v < costVer.length) {
            if (costHor[h] >= costVer[v]) { //horizontal cut
                cost += (costHor[h] * vP);
                hP++;
                h++;
            } else { // vertical cut
                cost += (hP * costVer[v]);
                v++; 
                vP++;

            }

        }
        while (h < costHor.length) {
            cost += (costHor[h] * vP);
            hP++;
            h++;
        }
        while (v < costVer.length) {
            cost += (hP * costVer[v]);
            v++;
            vP++;
        }
        System.out.println("min cost of cuts : " + cost);

    }
}
