import java.util.Scanner;

/**
 * ROT13.java
 * 
 * Write a function that takes a string and 
 * returns the ROT13 version of the string; 
 * you may assume that the character set is ascii.
 * 
 * @author rdsandeep
 * @version 1.0 10/27/13
 */

public class ROT13 {

    public static void main(String args[]) { 
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        evaluate(expression);
    }
    
    public static void evaluate(String expression) {
        if (expression.length() == 0) {
            System.exit(0);
        }
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if ((c >= 65 && c < 78) || (c >= 97 && c < 110)) {
                System.out.print((char)(c + 13));
            }
            else if ((c >= 78 && c < 91) || (c >= 110 && c < 123)) {
                System.out.print((char)(c - 13));
            }
            else {
                System.out.print(c);
            }
        }
    }
}
        