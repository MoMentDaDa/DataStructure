package LinkedQueue;

public class test {

	public static void main(String[] args) {
		MyLinkedQueue<Integer> LinkeQueue = new MyLinkedQueue<Integer>();
		for (int i = 0; i <= 10; i++) {
			LinkeQueue.add(i);
		}
		System.out.println(" MyLinkedQueue [队头{" + LinkeQueue.toString() + "}队尾] head=" + LinkeQueue.peek() + ", size=" + LinkeQueue.size());
		// 初始化队列数据
		System.out.println("原始队列: " + LinkeQueue.toString());
		// 元素0出队
		LinkeQueue.poll();
		System.out.println("元素0出队: " + LinkeQueue.toString());
		LinkeQueue.poll();
		System.out.println("元素1出队: " + LinkeQueue.toString());
		LinkeQueue.poll();
		System.out.println("元素2出队: " + LinkeQueue.toString());
		LinkeQueue.poll();
		System.out.println("元素3出队: " + LinkeQueue.toString());
		LinkeQueue.poll();
		System.out.println("元素4出队: " + LinkeQueue.toString());
		// 队首元素
		System.out.println("队首元素：" + LinkeQueue.peek());
		System.out.println(" MyLinkedQueue [队头{" + LinkeQueue.toString() + "}队尾] head=" + LinkeQueue.peek() + ", size=" + LinkeQueue.size());
		System.out.println(LinkeQueue.isEmpty());
		LinkeQueue.clearQueue();
		System.out.println(LinkeQueue.isEmpty());
		System.out.println(" MyLinkedQueue [队头{" + LinkeQueue.toString() + "}队尾] head=" + LinkeQueue.peek() + ", size=" + LinkeQueue.size());
	}

}
