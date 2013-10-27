import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Josephus.java
 * 
 * Write a function josephus(n,m) that returns 
 * a list of n people, numbered from 0 to n-1, 
 * in the order in which they are executed, 
 * every mth person in turn, with the sole survivor 
 * as the last person in the list.
 * 
 * @author rdsandeep
 * @version 1.0 10/27/13
 */

public class Josephus {

    public static void main(String args[]) { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        josephus(n, m);
    }
    
    public static void josephus(int n, int m) {
        LinkedList<Integer> soldierList = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            soldierList.add(i);
        }
        
        Iterator iter = soldierList.iterator();
        int order = 0;
        while (n-- != 0) {
            for (int i = 0; i < m; i++) {
                if (!iter.hasNext()) {
                    iter = soldierList.iterator();
                }
                order = (Integer) iter.next();
            }
            System.out.print(order + " ");
            iter.remove();
        }
    }
}
