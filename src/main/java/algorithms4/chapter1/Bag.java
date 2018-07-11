package algorithms4.chapter1;

import java.util.Iterator;

/**
 * 背包
 *
 * @param <Item>
 */
public class Bag<Item> {
	private Node first;
	private int N;


	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void add(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;//在头部加入元素  如果在尾部加入，则应该是：oldFirst.next = first;
		N++;
	}


	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class Node {
		Item item;
		Node next;
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {

		}
	}
}
