/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressionvalidation;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author 92019179
 */
public class ExpressionValidation {

    public static Scanner s = new Scanner(System.in);
    public static String expression;

    public static Stack<Character> bStack = new Stack();

    // Checks to see if there are pairs and retuens true or false
    public static boolean Pairs(char opening, char closing) {
        if (opening == '(' && closing == ')') {
            return true;
        } else if (opening == '{' && closing == '}') {
            return true;
        } else if (opening == '[' && closing == ']') {
            return true;
        } else if (opening == '<' && closing == '>') {
            return true;
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Welcome to the expression validating program.");
        System.out.println("Enter your expression");
        expression = s.next();
// each charater is checked to see if is a Expression then it is pushed to the stack or pop from the stack. 
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == '<' || expression.charAt(i) == '[' || expression.charAt(i) == '{') {
                bStack.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')' || expression.charAt(i) == '>' || expression.charAt(i) == ']' || expression.charAt(i) == '}') {
                if (!bStack.empty()) {
                    if (Pairs(bStack.peek(), expression.charAt(i))) {
                        bStack.pop();
                    } else {
                        bStack.push(expression.charAt(i));
                        break;
                    }
                } else {
                    bStack.push(expression.charAt(i));
                }
            }
        }
        System.out.println("Validation: " + (bStack.empty() ? "True" : "False"));
    }

}
