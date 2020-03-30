package LinkedList.UnidirectionList;

public interface MyList<E> {
	// 添加一个元素
	public void add(E e);

	// 在index处添加一个元素
	public void add(int index, E e);

	// 清除一个list列表
	public void clear();

	// 删除一个元素
	public boolean remove(E e);

	// 删除并返回index处的元素
	public E remove(int index);

	// index处的元素设置为元素e
	public Object set(int index, E e);

	// 判断是否包含元素e
	public boolean contains(E e);

	// 返回index处的元素
	public E get(int index);

	// 返回列表中第一个与元素e匹配的下标index
	public int indexOf(E e);

	// 返回列表中最后一个与元素e匹配的元素下标index
	public int lastIndeOf(E e);

	// 判断列表是否为空
	public boolean isEmpty();

	// 返回列表的大小
	public int size();
}
