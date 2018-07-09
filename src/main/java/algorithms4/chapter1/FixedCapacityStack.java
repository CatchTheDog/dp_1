package algorithms4.chapter1;

/**
 *采用泛型实现定容栈
 */
public class FixedCapacityStack<Item> {
	private Item[] a;
	private Integer N = 0;

	public FixedCapacityStack(Integer cap) {
		a = (Item[]) new Object[cap]; //java 不允许使用泛型数组，所以采用此种方式处理泛型数组
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public Integer size() {
		return N;
	}

	public void push(Item item) {
		a[N++] = item;
	}

	public Item pop() {
		return a[--N];
	}
}
