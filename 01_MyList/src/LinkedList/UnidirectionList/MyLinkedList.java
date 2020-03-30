package LinkedList.UnidirectionList;

public class MyLinkedList<E> extends MyAbstractList<E> {
	private MyNode<E> head, tail;

	public MyLinkedList() {
	}

	public MyLinkedList(E[] objects) {
		super(objects);
	}

	// 返回头元素
	public E getFirst() {
		if (size == 0) {
			return null;
		} else {
			return head.element;
		}
	}

	// 返回尾元素
	public E getLast() {
		if (size == 0) {
			return null;
		} else {
			return tail.element;
		}
	}

	// 添加首元素
	public void addFirst(E e) {
		MyNode<E> newMyNode = new MyNode<E>(e);
		newMyNode.next = head;
		head = newMyNode;
		size++;
		if (tail == null)
			tail = head;
	}

	// 添加尾元素
	public void addLast(E e) {
		MyNode<E> newMyNode = new MyNode<E>(e);
		if (tail == null) {
			head = tail = newMyNode;
		} else {
			tail.next = newMyNode;
			tail = tail.next;
		}
		size++;
	}

	// 在index处添加元素
	public void add(int index, E e) {
		if (index == 0)
			addFirst(e);
		else if (index >= size)
			addLast(e);
		else {
			MyNode<E> current = head;
			for (int i = 1; i < index; i++)
				current = current.next;
			MyNode<E> temp = current.next;
			current.next = new MyNode<E>(e);
			(current.next).next = temp;
			size++;
		}
	}

	// 删除并返回首元素
	public E removeFirst() {
		if (size == 0)
			return null;
		else if (size == 1) {
			MyNode<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			MyNode<E> temp = head;
			head = head.next;
			size--;
			return temp.element;
		}
	}

	// 删除并返回尾元素
	public E removeLast() {
		if (size == 0)
			return null;
		else if (size == 1) {
			MyNode<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			MyNode<E> current = head;
			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}
			MyNode<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	// 删除并返回index处的元素
	public E remove(int index) {
		if (index < 0 || index >= size)
			return null;
		else if (index == 0)
			return removeFirst();
		else if (index == size - 1)
			return removeLast();
		else {
			MyNode<E> previous = head;
			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}
			MyNode<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder("[");
		MyNode<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(",");
			} else {
				result.append("]");
			}
		}
		return result.toString();
	}

	public void clear() {
		head = tail = null;
	}

	// 是否包含元素e
	public boolean contains(E e) {
		MyNode<E> current = head;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e)) {
				return true;
			} else {
				current = current.next;
			}
		}
		return false;
	}

	// 返回index处的元素
	public E get(int index) {// index都是从0 算起的，size是从1算起的
		if (index < 0 || index >= size)
			return null;
		else if (index == 0)
			return head.element;
		else if (index == size - 1)
			return tail.element;
		else {
			MyNode<E> current = head;
			for (int i = 1; i < index; i++)
				current = current.next;
			MyNode<E> temp = current.next;
			return temp.element;
		}
	}

	// 返回列表中第一个与元素e匹配的下标index
	public int indexOf(E e) {
		if (size == 0)
			return -1;
		else {
			MyNode<E> current = head;
			for (int i = 0; i < size; i++) {
				if (current.element.equals(e))
					return i;
				else
					current = current.next;
			}
		}
		return -1;
	}

	public int lastIndexOf(E e) {
		if (size == 0)
			return -1;
		else {
			MyNode<E> current = tail;
			for (int i = size - 1; i >= 0; i--) {
				if (current.element.equals(e))
					return i;
				else
					current = current.next;
			}
		}
		return -1;
	}

	// 在index处的元素设置为e
	public E set(int index, E e) {
		if (index < 0 || index >= size)
			return null;
		else {
			MyNode<E> current = head;
			for (int i = 1; i < index; i++)
				current = current.next;
			MyNode<E> old = current.next;
			E oldE = old.element;
			old.element = e;
			return oldE;
		}
	}

	/************************************************************
	 ***下面是有序链表的插入***
	 ***这样简单排序就可以用链表来实现，复杂度为O(N)
	 ***定义一个方法，传入一个数组，
	 ***在方法内，遍历数组并调用insert方法就可以将数组中的数据排好序
	 **********************************************************
	public void addBySeq(E e) {
		MyNode<E> newLink = new MyNode(e);// 要插入的Link节点
		MyNode previous = null;// 前一个link节点
		MyNode current = head;// 因为是有序链表，从第一个开始
		while (current != null && e > current.element) {// 当前link不是空，插入的数据大于当前link值
			previous = current;// 记录当前为前一个link节点
			current = current.next;// 当前link向下找
		}
		if (previous == null) {// 前一个为null证明只有没有插入link节点，直接插入就行
			first = newLink;
		} else {
			previous.next = newLink;// 插入这个link在小于value的link下，后边link为当前节点
		}
		newLink.next = current;// 当前节点
		nElem++;// 有序链表长度+1
	}*/
}
