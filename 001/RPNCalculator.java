import java.util.Scanner;
import java.util.Stack;

/**
 * RPNCalculator.java
 * 
 * Implement an RPN calculator that takes an expression 
 * like 19 2.14 + 4.5 2 4.3 / - * which is usually expressed 
 * as (19 + 2.14) * (4.5 - 2 / 4.3) and responds with 85.2974. 
 * The program should read expressions from standard input and 
 * print the top of the stack to standard output when a newline 
 * is encountered. The program should retain the state of the 
 * operand stack between expressions.
 * 
 * @author rdsandeep
 * @version 1.1 10/26/13
 */

public class RPNCalculator {

    public static void main(String args[]) { 
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        evaluate(expression);
    }
    
    public static void evaluate(String expression) {
        if (expression.length() == 0) {
            System.exit(0);
        }
        String[] splitExpr = expression.trim().split("\\s+");
        Stack<Double> stack = new Stack<Double>();
        Double d = 0.0;
        for (String s : splitExpr) {
            try {
                d = Double.valueOf(s);
            } catch (NumberFormatException e) { 
                Double b = stack.pop();
                Double a = stack.pop();
                switch (s) {
                    case "+": d = a + b; break;
                    case "-": d = a - b; break;
                    case "*": d = a * b; break;
                    case "/": d = a / b; break;
                    default: 
                        System.out.println("Unknown operator");
                        System.exit(-1);
                }
            }
            stack.push(d);
        }
        System.out.println(stack.peek());
    }
}
        