package LinkedQueue;

import java.util.Arrays;
import java.util.NoSuchElementException;

@SuppressWarnings("all")
public class MyLinkedQueue<E> {
	private MyNode<E> head; // 队头
	private MyNode tail; // 队尾
	private int size; // 计数器
	private int maxSize = 128;// 用于控制最大容量,默认128,

	public MyLinkedQueue() {
		head = tail = null;
	}

	// data 入队,添加成功返回true,否则返回false,可扩容
	public Boolean add(E e) {
		if (e == null)
			throw new NullPointerException("The data can\'t be null");
		if (size >= maxSize)
			throw new IllegalArgumentException("The capacity of LinkedQueue has reached its maxSize:128");
		MyNode newNode = new MyNode(e);
		if (head == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;
		return true;
	}

	// 返回队头元素,不执行删除操作,若队列为空,返回null
	public E peek() {
		return this.isEmpty() ? null : this.head.element;
	}

	// 出队,执行删除操作,返回队头元素,若队列为空,返回null
	public E poll() {
		if (this.isEmpty())
			return null;
		E e = head.element;
		head = head.next;
		if (head == null)
			tail = null;
		size--;
		return e;
	}

	// 清空队列
	public void clearQueue() {
		head = tail = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return head == null && tail == null;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		MyNode<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(",");
			}
		}
		return result.toString();
	}
}
