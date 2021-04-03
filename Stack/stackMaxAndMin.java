import java.util.Collections;
import java.util.Stack;

public class stackMaxAndMin {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack();
		stack.push(5);
		stack.push(3);
		stack.push(2);
		stack.push(8);
		stack.push(10);
		
		System.out.println(Collections.max(stack));
		System.out.println(Collections.min(stack));
    
	}

}
