package ArrayList.CompareCopy;

/**
 * @ClassName: shallowCopy
 * @Description: 演示浅拷贝
 * @author: MoMent
 * @date: 2020年2月25日 上午11:08:18
 */
public class shallowCopy {
	static class Person implements Cloneable {
		public String name;
		public int age;
		public Man man = new Man();

		public Object clone() {
			try {
				return super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return null;
		}

		class Man implements Cloneable {
			public String name;
			public int age;

			public Object clone() {
				try {
					return super.clone();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
				return null;
			}
		}

		public static void main(String[] args) {
			Person person = new Person();
			person.name = "法法";
			person.age = 24;
			Person cloneperson = (Person) person.clone();
			System.out.println("person==cloneperson  :" + (person == cloneperson));
			System.out.println("person hash  :" + person.hashCode());
			System.out.println("person hash  :" + cloneperson.hashCode());
			System.out.println("person.man==cloneperson.man  :" + (person.man == cloneperson.man));
			System.out.println("person.man hash  :" + (person.man.hashCode()));
			System.out.println("cloneperson.man hash  :" + (cloneperson.man.hashCode()));
		}
	}
}
