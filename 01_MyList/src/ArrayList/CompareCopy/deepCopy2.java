package ArrayList.CompareCopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;

/**
 * @ClassName: deepCopy2
 * @Description: 通过序列化实现深拷贝
 * @author: MoMent
 * @date: 2020年2月25日 上午11:11:48
 */
public class deepCopy2 {
	public static void main(String args[]) throws Exception {
		A a = new A();
		A aCloneA = MyUtil.clone(a);
		System.out.println("原始a里面b的值:" + a.b.j); // 测试类
		System.out.println("拷贝b里面b的值:" + aCloneA.b.j);
		System.out.println("对比两个父类引用地址：" + (a.b.hashCode() == aCloneA.b.hashCode()));
		System.out.println("对比两个父类中子类的引用地址：" + (a.hashCode() == aCloneA.hashCode()));

	}
}

class A implements Serializable {
	int i = 1;
	int a[][] = new int[2][2];
	B b = new B();
	Hashtable<Integer, B> ht = new Hashtable<>();
}

class B implements Serializable {
	int j = 2;
}

class MyUtil {
	private MyUtil() {
		throw new AssertionError();
	}

	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) throws Exception {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bout);
		oos.writeObject(obj);
		ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bin);
		return (T) ois.readObject();
	}
}
