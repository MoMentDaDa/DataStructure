package LinkedList.UnidirectionList;

/**
 * @ClassName: MyAbstractList
 * @Description: 实现接口的抽象类，定义了公共的方法
 * @author: MoMent
 * @date: 2020年2月28日 下午7:19:05
 * @param <E>
 */
public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0;

	protected MyAbstractList() {

	}

	protected MyAbstractList(E[] objects) {
		for (int i = 1; i < objects.length; i++)
			add(objects[i]);
	}

	@Override
	public void add(E e) {
		add(size, e);
	}

	@Override
	public void add(int index, E e) {

	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		} else
			return false;
	}

	@Override
	public E remove(int index) {
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object set(int index, E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndeOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}
}
