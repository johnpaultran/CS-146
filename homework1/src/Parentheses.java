import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    // Return true if s has matching parentheses, and false otherwise.
    public static boolean match(String s) {
        Stack<Character> stack = new Stack<Character>(); // create a stack to push/pop string
        for (int i = 0; i < s.length(); i++) // for each character in the string
        {
            // push each opening parentheses into stack
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == '[') {
                stack.push('[');
            } else if (s.charAt(i) == '{') {
                stack.push('{');
            }
            // check if closing parentheses match corresponding opening parentheses in stack
            if (s.charAt(i) == ')') {
                if (stack.isEmpty())    // nothing in stack to match with
                {
                    return false;
                }
                if (stack.pop() != '(') // no matching opening parenthesis from stack
                {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty())    // nothing in stack to match with
                {
                    return false;
                }
                if (stack.pop() != '[') // no matching opening parenthesis from stack
                {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (stack.isEmpty())    // nothing in stack to match with
                {
                    return false;
                }
                if (stack.pop() != '{') // no matching opening parenthesis from stack
                {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) // reached the end of string with all matching parenthesis
        {
            return true;
        } else              // still unmatched parentheses
        {
            return false;
        }
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        StdOut.println(match(StdIn.readAll().trim()));
    }
}
