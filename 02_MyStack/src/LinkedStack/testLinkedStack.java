package LinkedStack;

public class testLinkedStack {
	public static void main(String[] args) throws Exception {
		MyLinkedStack<String> aStack = new MyLinkedStack<String>();
		System.out.println("[INFO]: Testing push()...");
		System.out.println(aStack.isEmpty());
		for (int i = 0; i < 10; ++i) {
			try {
				aStack.push(String.valueOf(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(aStack);
		}
		aStack.push(String.valueOf(11));
		System.out.println(aStack);
		System.out.println(aStack.peek());
		System.out.println("[INFO]: Testing pop()...");
		int length=aStack.size();
		for (int i = 0; i<length; ++i) {
			try {
				System.out.println("出栈元素"+aStack.pop());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(aStack);
		}
		System.out.println(aStack.isEmpty());
		aStack.pop();
	}

}
