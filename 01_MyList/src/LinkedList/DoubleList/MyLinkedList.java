package LinkedList.DoubleList;

public class MyLinkedList<T> {
	protected MyNode<T> head; // 不带数据的头结点
	protected MyNode<T> tail; // 指向尾部的指针

	public MyLinkedList() {
		this.head = this.tail = new MyNode<>(); // 初始化头结点
	}

	/**
	  * 传入一个数组,转换成链表
	  * @param array
	  */
	public MyLinkedList(T[] array) {
		this();
		if (array != null && array.length > 0) {
			this.head.next = new MyNode<T>(array[0]);
			tail = this.head.next;
			tail.prev = this.head;
			int i = 1;
			while (i < array.length) {
				tail.next = new MyNode<T>(array[i++]);
				tail.next.prev = tail;
				tail = tail.next;
			}
		}
	}

	public boolean isEmpty() {
		return head.next == null;
	}

	public int length() {
		int length = 0;
		MyNode<T> pre = head.next;
		while (pre != null) {
			length++;
			pre = pre.next;
		}
		return length;
	}

	public T get(int index) {
		if (index >= 0) {
			int j = 0;
			MyNode<T> pre = this.head.next;
			while (pre != null && j < index) {
				j++;
				pre = pre.next;
			}
			if (pre != null)
				return pre.data;
		}
		return null;
	}

	public T set(int index, T data) {
		T old = null;
		if (index > 0 && data != null) {
			int j = 0;
			MyNode<T> pre = this.head.next;
			// 查找需要替换的位置
			while (pre != null && j < index) {
				j++;
				pre = pre.next;
			}
			if (pre != null) {
				old = pre.data;
				// 替换数据
				pre.data = data;
			}
		}
		return old;
	}

	/**
	 * 插入结点
	 * @param index
	 * @param data
	 * @return
	 */
	public boolean add(int index, T data) {
		if (index < 0 || data == null)
			throw new NullPointerException("index < 0 || data == null");

		int j = 0;
		MyNode<T> front = this.head;
		// 查找要插入结点位置的前一个结点
		while (front.next != null && j < index) {
			j++;
			front = front.next;
		}

		// 创建需要插入的结点,并让其前继指针指向front,后继指针指向front.next
		MyNode<T> q = new MyNode<T>(data, front, front.next);

		// 空双链表插入,需要确保front.next不为空
		if (front.next != null) {
			// 更改front.next的前继指针
			front.next.prev = q;
		}
		// 更改front的后继指针
		front.next = q;

		// 在尾部插入时需要注意更新tail指向
		if (front == this.tail) {
			this.tail = q;
		}

		return true;
	}

	/**
	 * 尾部添加
	 * @param data
	 * @return
	 */
	public boolean add(T data) {
		if (data == null)
			return false;
		// 创建新结点,并把其前继指针指向tail
		MyNode<T> q = new MyNode<T>(data, tail, null);
		tail.next = q;
		// 更新尾部结点
		this.tail = q;
		return true;
	}

	/**
	 * 根据下标删除结点
	 * 1.头删除
	 * 2.中间删除
	 * 3.尾部删除,更新tail指向
	 * @param index 下标起始值为0
	 * @return
	 */
	public T remove(int index) {

		int size = length();
		T temp = null;

		if (index < 0 || index >= size || isEmpty()) {
			return temp;
		}

		MyNode<T> p = this.head;
		int j = 0;
		// 头删除/尾删除/中间删除,查找需要删除的结点(要删除的当前结点因此i<=index)
		while (p != null && j <= index) {
			p = p.next;
			j++;
		}
		// 当链表只要一个结点时,无需此步
		if (p.next != null) {
			p.next.prev = p.prev;
		}
		p.prev.next = p.next;
		// 如果是尾结点
		if (p == this.tail) {
			this.tail = p.prev;// 更新未结点的指向
		}
		temp = p.data;

		return temp;
	}

	/**
	 * 根据data删除结点,无需像单向链表那样去存储要删除结点的前一个结点
	 * 1.头删除
	 * 2.中间删除
	 * 3.尾部删除,更新tail指向
	 * @param data
	 * @return
	 */
	public boolean removeAll(T data) {

		boolean isRemove = false;

		if (data == null || isEmpty())
			return isRemove;

		// 注意这里的起点,如果起点为this.head,那么情况区别如同前面的根据index的删除实现
		MyNode<T> p = this.head.next;

		// 头删除/尾删除/中间删除(size>1),查找所有需要删除的结点
		while (p != null) {

			if (data.equals(p.data)) {
				if (p == this.tail) {
					// 如果是尾结点
					this.tail = p.prev;// 更新未结点的指向
					p.prev = null;
					this.tail.next = null;
				} else {
					// 如果是在中间删除,更新前继和后继指针指向
					p.prev.next = p.next;
					p.next.prev = p.prev;
				}
				isRemove = true;
				p = p.next;// 继续查找
			} else {
				p = p.next;
			}

		}
		return isRemove;
	}

	/**
	 * 清空链表
	 */
	public void clear() {
		this.head.next = null;
		this.tail = this.head;
	}

	public boolean contains(T data) {

		if (data == null) {
			return false;
		}

		MyNode<T> p = this.head.next;
		while (p != null) {
			if (data.equals(p.data)) {
				return true;
			} else {
				p = p.next;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		String str = "(";
		MyNode<T> pre = this.head.next;
		while (pre != null) {
			str += pre.data;
			pre = pre.next;
			if (pre != null)
				str += ", ";
		}
		return str + ")";
	}
}
