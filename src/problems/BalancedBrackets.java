package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {

    // 1 create a stack push opening brackets there
    // 2 if you encounter closing brackets check top of stack if they are same kind
    // 3 if not return false
    // 4 if yes go on until end of str


    static boolean areBracketsBalanced(String expr) {
        //Using ArrayDequeue is faster than using stack class
        Deque<Character> stack = new ArrayDeque<Character>();

        // Traversing the expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '{' || x == '[') {
                stack.push(x);
                continue;
            }

            // If current char is not opening bracket, then it must be closing
            // So stack cannot be empty at this point
            if (stack.isEmpty()) return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[') return false;
                    break;
                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[') return false;
                    break;
                case ']':
                    check = stack.pop();
                    if (check == '{' || check == '(') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

}
