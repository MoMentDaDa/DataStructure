package PriorityQueue;

public class test {

	public static void main(String[] args) {
		MyPriorityQueue list=new MyPriorityQueue(10);
		for (int i = 0; i <10; i++) {
			list.insert(i);
		}
		System.out.println(list.toString());
		System.out.println(list.peekMin());
		System.out.println(list.isFull());
		System.out.println(list.remove());
		System.out.println(list.isEmpty());
		System.out.println(list.isFull());
		System.out.println(list.peekMin());
	}

}
