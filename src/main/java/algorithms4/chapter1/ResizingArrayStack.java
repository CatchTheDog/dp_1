package algorithms4.chapter1;

import java.util.Iterator;

/**
 * 考虑定容栈的空间是有限的，需要动态扩展其空间；为了避免频繁进行空间扩展或者收缩操作：
 * 在定容栈内元素个数达到其容量上限时，将其空间扩展为原来的2倍；
 * 在定容栈内元素个数达到其容量上限的1/4时，将其空间收缩为原来的1/2；为什么是1/4,因为这样就可以保持空间利用率在50%
 * 考虑 集合遍历——迭代
 * 实现Iterator<?> 接口
 * 考虑 集合内元素的游离——保存一个不需要的对象引用
 * 比如定容栈的实现中，元素被pop后，就再无法访问到该元素，但是该元素的引用仍然保存在集合中，致使虚拟机无法回收此对象；造成对象游离
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

	private Item[] a = (Item[]) new Object[1];
	private Integer N = 0;

	public boolean isEmpty() {
		return N == 0;
	}

	public Integer size() {
		return N;
	}

	/**
	 * 空间调整
	 *
	 * @param max
	 */
	public void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void push(Item item) {
		if (N == a.length) resize(a.length * 2);
		a[N++] = item;
	}

	public Item pop() {
		Item item = a[--N];
		a[N] = null; //避免对象游离
		if (N > 0 && N == a.length / 4) resize(a.length / 2);
		return item;
	}

	/**
	 * 提供接口，供外部使用
	 *
	 * @return
	 */
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	/**
	 * 使用内部类实现，因为内部类可以访问到外部类的所有属性
	 */
	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = N;

		public boolean hasNext() {
			return i > 0;
		}

		public Item next() {
			//如果i=0 ,则抛出NoSuchElementException
			return a[--i];
		}

		/**
		 * 不提供删除接口
		 */
		public void remove() {
			//在调用时抛出UnsupportedOperationException
		}
	}
	//此实现优点：没项操作的用时均与集合大小无关
	//           空间需求总是不超过集合大小乘以一个常数
	// 缺点在于pop,push操作有可能导致resize，此操作耗时与集合大小成正比
}
