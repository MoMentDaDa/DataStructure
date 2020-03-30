package ArrayList.CompareCopy;

import java.util.Arrays;

/**
 * @ClassName: testArrayCopy
 * @Description: 测试四种拷贝方式的效率
 * @author: MoMent
 * @date: 2020年2月25日 上午9:47:37
 */
public class testArrayCopy {
	public static void main(String args[]) {
		// 需要改变原始数组的大小
		String[] original = new String[1000];
		for (int i = 0; i < original.length; i++) {
			original[i] = "abcd";
		}
		System.out.println("原始数组的大小:" + original.length);
		//System.out.println("原始数组哈希值："+original.hashCode());
		testSystemArrayCopy(original);
		testArraysCopyOf(original);
		testClone(original);
		testFor(original);
	}

	public static void testSystemArrayCopy(String[] orginal) {
		long start_time = System.nanoTime();
		String[] target = new String[orginal.length];
		System.arraycopy(orginal, 0, target, 0, target.length);
		long end_time = System.nanoTime();
		System.out.println("使用System.arraycopy方法耗时:" + (end_time - start_time));
		//System.out.println("和原始对象是否一样："+(orginal==target));

	}

	public static void testArraysCopyOf(String[] orginal) {
		long start_time = System.nanoTime();
		String[] target = new String[orginal.length];
		target = Arrays.copyOf(orginal, orginal.length);
		long end_time = System.nanoTime();
		System.out.println("使用Arrays.copyOf方法耗时:" + (end_time - start_time));
	}

	public static void testClone(String[] orginal) {
		long start_time = System.nanoTime();
		String[] target = new String[orginal.length];
		target = orginal.clone();
		long end_time = System.nanoTime();
		System.out.println("使用clone方法耗时:" + (end_time - start_time));
	}

	public static void testFor(String[] orginal) {
		long start_time = System.nanoTime();
		String[] target = new String[orginal.length];
		for (int i = 0; i < orginal.length; i++) {
			target[i] = orginal[i];
		}
		long end_time = System.nanoTime();
		System.out.println("使用for循环耗时:" + (end_time - start_time));
	}

}
