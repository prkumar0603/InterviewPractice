/*Problem Statement: Perform sorting operation on a stack
Follow-up Question 1: You can only use 1 additional stack for solving the problem.
This problem is quite popular among stack problems asked by companies.
 */
import java.util.Stack;
public class Solution7 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(20);
        stack.push(12);
        stack.push(15);
        stack.push(25);
        stack.push(1);
        stack.push(7);
        stack.push(9);

        System.out.println("before : "+stack);

        // iterative aproach
//        Stack<Integer> tempstack = new Stack<>();
//        while(!stack.isEmpty()){
//            int temp = stack.pop();
//
//            while (!tempstack.isEmpty() && tempstack.peek() > temp){
//                stack.push(tempstack.pop());
//            }
//
//            tempstack.push(temp);
//        }
//        System.out.println("After = "+ tempstack);

        sortStack(stack);
        System.out.println("After = "+ stack);
    }

    private static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()){
            int temp = stack.pop();
            sortStack(stack);

            stackInsert(stack, temp);
        }
    }

    private static void stackInsert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty() || stack.peek() < temp){
            stack.push(temp);
            return;
        }

        //if top of stack > temp value, then pop element recursively until condition is true.
        int top = stack.pop();
        stackInsert(stack, temp);

        stack.push(top);
    }

}
/*Approach -
Iterative -   taking each element out of 1st stack into "temp" variable one by one and putting into 2nd stack
		            if temp value > 2nd stack top, then push into 2nd stack.
		            else pop elements from 2nd stack and store in 1st stack
		            until top of 2nd stack < temp value.

Recursive - pop all element from stack recursively and call stackInsert method with last element popped.
            in stackInsert method, insert into stack if top of stack < temp value.
            else pop until above condition is true.
*/
