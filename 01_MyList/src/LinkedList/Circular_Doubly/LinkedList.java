package LinkedList.Circular_Doubly;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
	MyNode<T> head;
	int size;
	private int modCount = 0; // 记录list修改次数

	public LinkedList() {
		this.head = new MyNode<>();
		this.head.next = head;
		this.head.prev = head;
		size = 0;
	}

	// 传入一个数组,构造成双向循环链表
	public LinkedList(T[] array) {
		this();
		if (array != null && array.length > 0) {
			MyNode<T> temp = new MyNode<>(array[0], head, head);
			head.next = temp;
			head.prev = temp;
			size++;
			int i = 1;
			while (i < array.length) {
				temp.next = new MyNode<>(array[i++], temp, head);
				head.prev = temp.next;
				temp = temp.next;
				size++;
				// System.out.println(size);
			}
		}
	}

	// 判断是否为空
	public boolean isEmpty() {
		return size == 0;// 循环双链表的后继指针指向自己说明是空链表
	}

	// 返回链表长度
	public int length() {
		return size;
	}

	// 返回索引为index处的节点
	public MyNode<T> get(int index) {
		if (index <= size - 1) {
			MyNode<T> temp = this.head.next;
			int j = 0;
			while (j != index) {
				temp = temp.next;
				j++;
			}
			return temp;
		}
		return null;
	}
	// 根据索引修改指定值,并返回原值
	public T set(int index, T data) {
		MyNode<T> temp = this.get(index);
		T oldData = temp.data;
		temp.setData(data);
		return oldData;
	}

	// 根据index后面添加
	public boolean addNext(int index, T data) {
		MyNode<T> temp = this.get(index);
		if (temp != null) {
			MyNode<T> newNode = new MyNode<>(data, temp, temp.next);
			temp.next = newNode;
			newNode.next.prev = newNode;
			size++;
			return true;
		}
		return false;
	}

	// 根据index前面添加
	public boolean addPre(int index, T data) {
		MyNode<T> temp = this.get(index - 1);
		if (temp != null) {
			// 创建新结点,如果index=3,那么插入的位置就是第4个位置
			MyNode<T> newNode = new MyNode<>(data, temp, temp.next);
			temp.next = newNode;
			temp.next.prev = newNode;
			size++;
			return true;
		}
		return false;
	}

	// 头插入,即头结点之后，第一个节点之前
	public boolean addHead(T data) {
		if (data != null) {
			MyNode<T> newNode = new MyNode<>(data, head, head.next);
			// 更新tail后继指针的指向
			head.next = newNode;
			newNode.next.prev = newNode;
			size++;
			return true;
		}
		return false;
	}

	// 尾插入，即头结点之前，最后一个节点之后
	public boolean addTail(T data) {
		if (data != null) {
			MyNode<T> newNode = new MyNode<>(data, head.prev, head);
			// 更新tail后继指针的指向
			newNode.prev.next = newNode;
			head.prev = newNode;
			size++;
			return true;
		}
		return false;
	}

	// 删除指定索引的节点
	public T remove(int index) {
		MyNode<T> temp = this.get(index);
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		size--;
		return temp.data;
	}

	// 删除并返回首元素
	public T removeFirst() {
		T oldData = head.next.data;
		head.next.next.prev = head;
		head.next = head.next.next;
		size--;
		return oldData;
	}

	// 删除并返回尾元素
	public T removeLast() {
		T oldData = head.prev.data;
		head.prev.prev.next = head;
		head.prev = head.prev.prev;
		size--;
		return oldData;
	}

	// 判断是否包含指定值
	public int contains(T data) {
		if (data != null) {
			MyNode<T> temp = this.head.next;
			int j = 0;
			while (temp != head) {
				if (data.equals(temp.data)) {
					return j;
				}
				j++;
				temp = temp.next;
			}
		}

		return -1;
	}

	// 清空表中对象,只保留头结点
	public void remoAll() {
		if (size > 0) {
			// 清空对象
			for (MyNode<T> node = head.next; node != head;) {
				MyNode<T> delete = node;
				node = node.next;
				delete.data = null;
				delete.next = null;
				delete.prev = null;
			}
			head.next = head;
			head.prev = head;
			size = 0;
			modCount++;
		}
	}

	// 返回第一个值等于obj的index，如果表中不包含值obj，返回-1
	public int indexOf(T obj) {
		MyNode<T> node = head.next;
		int index = 0;
		while (node != head && !node.data.equals(obj)) {
			node = node.next;
			index++;
		}
		if (node != head)
			return index;
		return -1;
	}

	// 返回最后一个值等于obj的index，如果表中不包含值obj，返回-1
	public int lastIndexOf(T obj) {
		MyNode<T> node = head.prev;
		int index = size - 1;
		while (node != head && !node.data.equals(obj)) {
			node = node.prev;
			index--;
		}
		return index;
	}

	// 返回迭代器
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int index = 0;
			private int expectModCount = modCount;

			@Override
			public boolean hasNext() {
				return index < size;
			}

			@Override
			public T next() {
				checkForModification();
				if (!hasNext())
					throw new NoSuchElementException();
				MyNode<T> result = get(index);
				index++;
				return result.data;
			}

			private void checkForModification() {
				if (expectModCount != modCount)
					throw new ConcurrentModificationException();
			}
		};
	}

	/// 返回子list
	public LinkedList<T> subList(int fromIndex, int lastIndex) {
		if (fromIndex < 0 || fromIndex > lastIndex || lastIndex > size)
			throw new IndexOutOfBoundsException("索引越界");
		MyNode<T> from = get(fromIndex);
		LinkedList<T> result = new LinkedList<>();
		while (fromIndex < lastIndex) {
			result.addTail(from.data);
			from = from.next;
			fromIndex++;
		}
		return result;
	}

	public String toString() {
		String str = "(";
		MyNode<T> p = this.head.next;
		while (p != head) {
			str += p.data.toString();
			p = p.next;
			if (p != head)
				str += ", ";
		}
		return str + ")";
	}

}
