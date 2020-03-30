package ArrayList.StaticArray;

public class test {
	public static void main(String[] args) {
		MyArray arr = new MyArray(20);
		for (int i = 0; i < 10; i++) {
			arr.addLast(i);
		}
		System.out.println(arr);
		System.out.println("------------");
		
		arr.add(1, 100);
		System.out.println(arr);
		System.out.println("------------");
		
		arr.addFirst(-1);
		// [-1,0,100,1,2,3,4,5,6,7,8,9]
		System.out.println(arr);
		System.out.println("------------");
		
		arr.remove(2);
		// [-1,0,1,2,3,4,5,6,7,8,9]
		System.out.println(arr);
		System.out.println("------------");
		
		arr.removeElement(4);
		// [-1,0,1,2,3,5,6,7,8,9]
		System.out.println(arr);
		System.out.println("------------");
		
		arr.removeFirst();
		// [0, 1, 2, 3, 5, 6, 7, 8, 9]
		System.out.println(arr);
	}
}
