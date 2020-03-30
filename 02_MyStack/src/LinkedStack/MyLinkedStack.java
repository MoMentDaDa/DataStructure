package LinkedStack;

import java.util.LinkedList;

import javax.swing.text.TabStop;

/**
 * @ClassName: Stack
 * @Description: 通过实现接口编写基于单向链表的顺序栈
 * @author: MoMent
 * @date: 2020年3月3日 下午3:35:10
 * @param <E>
 */
@SuppressWarnings("all")
public class MyLinkedStack<E> implements StackInterface<E> {
	private static final int DEFAULT_CAPACITY = 1024;
	private int capacity;
	private LinkedList<E> data;

	public MyLinkedStack(int capacity) {
		this.capacity = capacity;
		this.data = new LinkedList<E>();
	}

	public MyLinkedStack() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * 将元素压入栈中。
	 * @param element
	 * @return void
	 * @throws StackOverflowException
	 */
	public void push(E e) {
		data.addLast(e);
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
		return data.removeLast();
	}

	/**
	 * 查看当前栈顶元素。
	 * @param void
	 * @return Element at the top.
	 * @throws StackEmptyException
	 */
	public E peek() {
		if (isEmpty()) {
			throw new RuntimeException("栈表为空");
		}
		return data.getLast();
	}

	/**
	 * 计算栈已存储的元素数量。
	 * @param void
	 * @return Size of the {@code Stack}.
	 */
	public int size() {
		return data.size();
	}

	/**
	 * 判断栈是否为空。
	 * @param void
	 * @return Boolean
	 */
	public boolean isEmpty() {
		return data.isEmpty();
	}

	/**
	 * 清空栈。
	 * @return void
	 * @param void
	 */
	public void clear() {
		data.clear();
	}

	@Override
	public String toString() {
		return data.toString();
	}

}
