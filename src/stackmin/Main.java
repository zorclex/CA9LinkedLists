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
		stack.push(4);
		stack.push(1);
		stack.push(5);
		stack.push(10);
		stack.pop();
		stack.pop();
		stack.pop();
		
		stack.stack.traverse();
		stack.stackMin.traverse();

		//cabbage
	}

}
