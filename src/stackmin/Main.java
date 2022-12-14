package stackmin;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("====WElcome to StackMania! we fulfill all of your stakc-y needs! ====="); //I have no idea I've lost my mind at this point finals are fun I need more tea
		
		StackMin stack = new StackMin();
		
		
		stack.push(3);
		stack.push(7);
		stack.push(8);
		stack.push(2);
		stack.push(9);
		stack.push(10);
		stack.push(1);
		stack.push(5);
		stack.push(4);
		System.out.println("the minimum in this stack is " + stack.getMin());
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println("the minimum in this stack is " + stack.getMin());
		System.out.println("the top of this stack is " + stack.peek());


		
		stack.stack.traverse();
		stack.stackMin.traverse();
		
		//cabbage
	}

}
