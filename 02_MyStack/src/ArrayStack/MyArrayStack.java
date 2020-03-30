package ArrayStack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: Stack
 * @Description: 通过实现接口编写基于数组的顺序栈
 * @author: MoMent
 * @date: 2020年3月3日 下午3:35:10
 * @param <E>
 */
@SuppressWarnings("all")
public class MyArrayStack<E> implements MyStackInterface<E> {
	private static final int DEFAULT_CAPACITY = 10;// 默认栈容量
	private int capacity;// 用户自定义栈大小
	private E[] data;// 数据
	private int top;// 当前栈顶索引

	public MyArrayStack(int capacity) {
		this.capacity = capacity;
		this.data = (E[]) new Object[capacity];
		this.top = -1;// 因为数组索引是0开始，所以空栈应该为-1
	}

	public MyArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	/**
	* 将元素压入栈中。
	* @param element
	* @return void
	* @throws StackOverflowException
	*/
	public void push(E e) {
		if (size() >= data.length) {
			resizeCapacity();
		}
		++top;
		data[top] = e;
		// System.out.println(data[2]);
	}

	/**
	* 将栈顶元素出栈。
	* @param void
	* @return Element at the top.
	* @throws StackEmptyException
	*/
	public E pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈表为空");
		}
		--top;
		return data[top + 1];
	}

	/**
	  *查看当前栈顶元素。
	 * @param void
	 * @return Element at the top.
	 * @throws StackEmptyException
	 */
	public E peek() {
		if (isEmpty()) {
			throw new RuntimeException("栈表为空");
		}
		return data[top];
	}

	/**
	* 清空栈。
	* @return void
	* @param void
	*/
	@SuppressWarnings("unchecked")
	public void clear() {
		for (int i = 0; i <= top; ++i) {
			data[i] = null;
		}
		this.data = (E[]) new Object[capacity];
		this.top = -1;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i <= top; ++i) {
			sb.append(data[i].toString());
			sb.append(", ");
		}
		sb.append(']');
		return sb.toString();
	}

	/**
	 * 计算栈已存储的元素数量。
	 * @param void
	 * @return Size of the stack.
	 */
	public int size() {
		return top + 1;
	}

	/**
	 * 判断栈是否为空。
	 * @param void
	 * @return Boolean
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	// 扩容
	private void resizeCapacity() {
		E[] newStack = (E[]) new Object[size() << 1];// 扩容一倍
		// System.out.println(Arrays.toString(data));
		System.arraycopy(data, 0, newStack, 0, data.length);
		data = newStack;
		// System.out.println(Arrays.toString(data));
	}

}
