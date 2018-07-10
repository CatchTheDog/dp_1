package algorithms4.chapter1;

import algorithms4.utils.StdIn;
import algorithms4.utils.StdOut;

import java.util.Iterator;

/**
 * 堆栈（链表实现）
 *
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item> {
	private Node first;
	private int N;

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
			} else if (!s.isEmpty()) StdOut.println(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + "left on stack )");
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;//在头部加入元素  如果在尾部加入，则应该是：oldFirst.next = first;
		N++;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
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
