package algorithms4.chapter1;

import algorithms4.utils.StdOut;

/**
 * 定容栈
 */
public class FixedCapacityStackOfStrings {
	private String [] a;
	private Integer N = 0;//用于标识元素个数，以方便元素存取 初始值为0
	public FixedCapacityStackOfStrings(Integer cap){
		 a = new String [cap];
	}
	public boolean isEmpty(){return this.N == 0;}
	public Integer size(){return this.N;}
	public void push(String item){
		if(N == a.length){
			StdOut.println("the capacity of stack reached the upper limit!");
			return;
		}
		a[N++] = item;
	}
	public String pop(){
		if(N == 0){
			StdOut.println("the stack hans reached the lower limit!");
			return "";
		}
		return a[--N];
	}

	public static void main(String [] args){
		FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(5);
		StdOut.println(stack.pop());
		stack.push("1");
		StdOut.println(stack.pop());
		StdOut.println(stack.pop());
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
		stack.push("6");
		stack.push("7");
		StdOut.println(stack.pop());
		StdOut.println(stack.pop());
	}
}
