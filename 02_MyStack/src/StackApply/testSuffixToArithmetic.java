package StackApply;

public class testSuffixToArithmetic {

	public static void main(String[] args) {
		String str = "3+(2-5)*6/3"; // 其后缀表达式为325-6*3/+
		// 调用方法：中缀表达式转成后缀表达式
		System.out.println(SuffixToArithmetic.infixToSuffix(str));
		// 调用方法：给出一个算术表达式（中缀表达式），得到计算结果
		System.out.println(SuffixToArithmetic.stringToArithmetic(str));
	}

}
