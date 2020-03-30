package LinkedList.UnidirectionList;

public class testMyList {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.toString());
		list.add(2, 4);
		System.out.println(list.toString());
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.get(2));//从0开始算起
		System.out.println(list.contains(3));
		System.out.println(list.indexOf(9));
		list.removeFirst();
		System.out.println(list.toString());
		list.removeLast();
		System.out.println(list.toString());
		list.remove(1);
		System.out.println(list.toString());
		list.clear();
		System.out.println(list.size());
		System.err.println(list.isEmpty());

	}

}
