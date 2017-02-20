
public class CustomStack {
	int[] arr = new int[5];
	int top = -1;
	
	private void push(int value){
		if(top < arr.length){
			arr[++top] = value;
			
		} else {
			try {
				throw new StackLimitReached();
			} catch (StackLimitReached e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private int pop(){
		int poppedVal = 0;
		
		if(top == 0 || top > arr.length) {
			try {
				throw new StackLimitReached();
			} catch (StackLimitReached e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return arr[top--];
		}
		return poppedVal;
	}
	
	private int peek(){
		return arr[top];
	}
	public static void main(String args[]) {
		CustomStack stack = new CustomStack();
		stack.push(25);
		stack.push(4);
		stack.push(5);
		stack.push(65);
		stack.push(02);
		stack.pop();
		
		for (int i = 0; i <= stack.top; i++) {
			System.out.println(stack.arr[i]);
		}
		System.out.println("peek value "+stack.peek());
	}
}
