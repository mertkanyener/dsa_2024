package queue;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //By making dequeue costly is the best option average time complexity will be O(1)
    public void enqueue(int value) {
        stack1.push(value);
    }

    public Integer dequeue() {
        if(!stack2.isEmpty()) {
            return stack2.pop();
        }
        if (stack1.isEmpty()) {
            return -1;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
