package ArrayList.AutoArray;

public class E_Test {
	private String name;
	private String age;

	public E_Test(String name, String age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("Student(name: %s, age: %s)", name, age);
	}

	public static void main(String[] args) {
		ArrayObject<E_Test> arrayObject = new ArrayObject<>();
		arrayObject.addLast(new E_Test("sangsan", "21"));
		arrayObject.addLast(new E_Test("lisi", "22"));
		arrayObject.addLast(new E_Test("wangwu", "23"));
		System.out.println(arrayObject);
	}
}
