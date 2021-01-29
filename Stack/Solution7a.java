/*Write a program to reverse a stack using recursion.You are not allowed to use loop constructs like while, for..etc, 
 and you can only use the following ADT functions on Stack S:
isEmpty(S)
push(S)
pop(S)
*/
import java.util.Stack;
public class Solution7a {

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
		
		reverse(stack);
		System.out.println("after : "+stack);
		
	}
	
	public static void reverse(Stack<Integer> s){
		if(!s.isEmpty()){
			int temp = s.pop();
			reverse(s);
			reversestack(s,temp);
		}
	}

	private static void reversestack(Stack<Integer> s, int temp) {
		// TODO Auto-generated method stub
		if(s.isEmpty()){
			s.push(temp);
			return;
		}
		
		int top = s.pop();
		reversestack(s, temp);
		s.push(top);
		
	}
}
