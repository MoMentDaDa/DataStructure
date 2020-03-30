package ArrayQueue;

import java.util.Arrays;

@SuppressWarnings("all")
public class MyArrayQueue<E> {
	private E[] data; // 声明一个数组
	private int head;// 队首位置。从0开始算起
	private int tail;// 队尾位置
	private int size;// 队列中元素的个数
	// 初始化队列,capacity为实际可以存储的大小
	//所以默认为10，+1是用于存放头尾指针，但是数组长度为11
	public MyArrayQueue(int capacity) {
		data = (E[]) new Object[capacity + 1];
	}
	// 默认最大容量为10
	public MyArrayQueue() {
		this(10);
	}
	// 入队
	public boolean enqueue(E e) {
		// 检查队列为满
		if ((tail + 1) % data.length == head) {
			// 队列扩容
			resize(getCapacity() * 2);
		}
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size++;
		return true;
	}

	// 队列快满时，队列扩容；元素出队操作，指定条件可以进行缩容
	private void resize(int newCapacity) {
		// 这里的加1还是因为循环队列我们在实际使用的过程中要浪费一个空间,用于存放头尾指针
		E[] newData = (E[]) new Object[newCapacity + 1];
		// System.out.println("发生缩容" + data[head]);
		System.arraycopy(data, head, newData, 0, size);
		// 将新的数组引用赋予原数组的指向
		data = newData;
		// 充值head的位置（head总是指向队列中第一个元素）
		head = 0;
		// size 的大小不变，因为在这过程中，没有元素入队和出队
		tail = size;
	}

	// 元素出队
	public E dequeue() {
		if (isEmpty()) {
			throw new IllegalArgumentException("队列为空");
		}
		// 出队元素
		E element = data[head];
		// 元素出队后，将空间置为null
		data[head] = null;
		// 维护head的索引位置(循环队列)
		head = (head + 1) % data.length;
		// 维护size大小
		size--;
		// 元素出队后，判断容量的一半是否可以容纳队列中所有剩下的元素，可以进行进行缩容
		if (size == getCapacity() / 2 && getCapacity() / 2 != 0) {
			resize(getCapacity() / 2);
		}
		return element;
	}

	public E gethead() {
		if (isEmpty()) {
			throw new IllegalArgumentException("队列为空");
		}
		return data[head];
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return head == tail;
	}

	// 返回实际容量
	private int getCapacity() {
		// 注意：在初始化队列的时候，我们有意识的为队列加了一个空间，那么它的实际容量自然要减1
		return data.length - 1;
	}

	public String toString() {
		return "ArrayQueue{" + "【队首data=" + Arrays.toString(data) + "【队尾】" + ", head=" + head + ", tail=" + tail + ", size=" + size + ", capacity="
				+ getCapacity() + '}' +"数组长度"+data.length;

	}
}
