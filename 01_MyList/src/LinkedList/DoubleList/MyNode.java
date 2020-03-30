package LinkedList.DoubleList;

public class MyNode<T> {
	T data;// 数据元素
	MyNode<T> prev, next;// 前继指针和后继指针

	public MyNode(T data, MyNode<T> prev, MyNode<T> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public MyNode(T data) {
		this(data, null, null);
	}

	public MyNode() {
		this(null, null, null);
	}

	public String toString() {
		return this.data.toString();
	}

}
