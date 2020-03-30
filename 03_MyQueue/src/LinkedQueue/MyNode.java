package LinkedQueue;

public class MyNode<E> {
	E element;// 元素
	MyNode<E> next; // 指针

	public MyNode() {
	}

	public MyNode(E e) {
		element = e;
	}

	public MyNode(E element, MyNode<E> next) {
		this.element = element;
		this.next = next;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public MyNode<E> getNext() {
		return next;
	}

	public void setNext(MyNode<E> next) {
		this.next = next;
	}
}
