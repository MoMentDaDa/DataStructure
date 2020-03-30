package StackApply;

import ArrayStack.MyArrayStack;

// 实现字符串反转
@SuppressWarnings("all")
public class StringReversal {
	public static void main(String[] args) {
		MyArrayStack stack = new MyArrayStack();
		String str = "how are you";
		char[] cha = str.toCharArray();
		for (char c : cha) {
			stack.push(c);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

}
