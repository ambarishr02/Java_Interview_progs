package Mise;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CountParenthesis {

	static Map<Integer, Integer> map;

	/**
	 * () =1 AB = A+B (A) = 2 *A EX : (()(()))=6 2*(1+(2*1))=6
	 */

	static int findBalancedParenthesisCount(int lo, int hi) {

		if (lo + 1 == hi)
			return 1;
		int mid = map.get(lo);
		if (mid == hi)
			return 2 * findBalancedParenthesisCount(lo + 1, hi - 1);
		return findBalancedParenthesisCount(lo, mid) + findBalancedParenthesisCount(mid + 1, hi);

	}

	public static void main(String[] args) {

		String str = "(()(()))";

		Stack<Integer> stack = new Stack<>();
		map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ')') {
				int top = stack.peek();
				map.put(top, i);
				stack.pop();
			} else {
				stack.push(i);
			}

		}
		System.out.println(findBalancedParenthesisCount(0, str.length() - 1));

	}
}
