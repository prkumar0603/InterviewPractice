package recursion;

import java.util.Stack;

public class reverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

    private static void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()){
            int value = stack.pop();
            reverse(stack);

            fillStack(stack, value);
        }

    }

    private static void fillStack(Stack<Integer> stack, int value) {
        if (stack.isEmpty()){
            stack.push(value);
            return;
        }

        int temp = stack.pop();
        fillStack(stack,temp);
        stack.push(temp);

    }
}
