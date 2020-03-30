package LinkedList.DoubleList;

public class test {

	public static void main(String[] args) {
		String[] letters = { "A", "B", "C", "D", "Z", "E", "F" };
//      String[] letters={"A"};
		MyLinkedList<String> list = new MyLinkedList<>(letters);

		System.out.println("list.get(3)->" + list.get(3));
		System.out.println("list:" + list.toString());

		System.out.println("list.add(4,Y)—>" + list.add(0, "Y"));
		System.out.println("list:" + list.toString());
		System.out.println("list.add(Z)—>" + list.add("Z"));
		System.out.println("list:" + list.toString());

		System.out.println("list.contains(Z)->" + list.contains("Z"));
		System.out.println("list.set(4,P)-->" + list.set(4, "P"));
		System.out.println("list:" + list.toString());

		System.out.println("list.remove(6)-->" + list.remove(6));
//      System.out.println("list.remove(Z)->"+list.removeAll("Z"));
		System.out.println("list:" + list.toString());

	}

}
