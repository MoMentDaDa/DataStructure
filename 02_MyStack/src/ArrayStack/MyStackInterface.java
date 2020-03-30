package ArrayStack;

/**
 * @ClassName: StackInterface
 * @Description: 定义基于数组结构的顺序栈的接口
 * @author: MoMent
 * @date: 2020年3月3日 下午3:32:46
 * @param <E>
 */
public interface MyStackInterface<E> {
	public abstract void push(E e);

	public abstract E pop();

	public abstract E peek();

	public abstract int size();

	public abstract boolean isEmpty();

	public abstract void clear();

}
