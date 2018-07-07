package algorithms4.chapter1;

import algorithms4.utils.StdIn;
import algorithms4.utils.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 使用双栈实现表达式解析
 */
public class Evaluate {
	/**
	 * 右括号 )
	 */
	public final static String RIGHT_PARENTHESIS = ")";

	public final static String LEFT_PARENTHESIS = "(";

	public final static String ADD = "+";

	public final static String MINUS = "-";

	public final static String MUTIPLY = "*";

	public final static String DEVISOR = "/";

	private static List<String> operatorList = new ArrayList<String>();
	/**
	 * 表达式元素
	 */
	static
	{
		operatorList.add(ADD);
		operatorList.add(MINUS);
		operatorList.add(MUTIPLY);
		operatorList.add(DEVISOR);
	}

	/**
	 * Std.isEmpty() 方法在运行之后，并不会返回，因为cmd一直在等待命令输入，使用CTRL+D 可以处理
	 * @param args
	 */
	public static void main(String [] args){
		Stack<String> operators = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(s.equals(LEFT_PARENTHESIS));
			else if(operatorList.contains(s)) operators.push(s);
			else if(s.equals(RIGHT_PARENTHESIS)){
				Double val_1 = vals.pop();
				Double val_2 = vals.pop();
				String operator = operators.pop();
				if(operator.equals(ADD)){
					vals.push(val_2 + val_1);
				}
				else if(operator.equals(MINUS)){
					vals.push(val_2 - val_1);
				}
				else if(operator.equals(MUTIPLY)){
					vals.push(val_2 * val_1);
				}
				else if(operator.equals(DEVISOR)){
					vals.push(val_2 / val_1);
				}
			}
			else vals.push(Double.parseDouble(s));
		}
		StdOut.println(vals.pop());
	}
}
