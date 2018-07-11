package algorithms4.chapter1;

import java.util.Iterator;

/**
 * 先进先出队列
 */
public class Queue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private Integer N;

	public boolean isEmpty() {
		return first == null;
	}

	public Integer size() {
		return N;
	}

	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else oldLast.next = last;
		N++;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (isEmpty()) last = first;  //或者 last = null;
		N--;
		return item;
	}

	public Iterator<Item> iterator() {
		return null;
	}

	private class Node {
		private Node next;
		private Item item;
	}

	private class LinkedIterator implements Iterator<Item> {
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
