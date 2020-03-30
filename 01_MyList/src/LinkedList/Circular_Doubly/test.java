package LinkedList.Circular_Doubly;

public class test {
	public static void main(String[] args) {
		String[] letters = { "A", "B", "C", "D", "Z", "E", "F" };
		LinkedList<String> list = new LinkedList<>(letters);
		System.out.println("init list-->" + list.toString() + list.length());
		System.out.println(list.isEmpty());
		System.out.println(list.get(6).data);
		System.out.println(list.contains("B"));
		System.out.println(list.set(0, "F"));
		System.out.println("init list-->" + list.toString() + list.length());
		System.out.println(list.addNext(0, "R"));
		System.out.println("init list-->" + list.toString() + list.length());
		System.out.println(list.addPre(4, "B"));
		System.out.println("init list-->" + list.toString() + list.length());
		System.out.println(list.addHead("O"));
		System.out.println("init list-->" + list.toString() + list.length());
		System.out.println(list.addTail("G"));
		System.out.println("init list-->" + list.toString() + list.length());
		System.out.println(list.remove(1));
		System.out.println("init list-->" + list.toString() + list.length());
		System.out.println(list.removeFirst());
		System.out.println("init list-->" + list.toString() + list.length());
		System.out.println(list.removeLast());
		System.out.println("init list-->" + list.toString() + list.length());
		System.out.println(list.indexOf("B"));
		System.out.println(list.lastIndexOf("B"));
		// 使用迭代器，不可并发操作
		for (String i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
		// 测试subList
		System.out.println(list.subList(2, 4));
		list.remoAll();
		System.out.println("init list-->" + list.length());
	}

}
