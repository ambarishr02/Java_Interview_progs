package Strings;

public class AllPermutation {

	static void printPermutationOfString(String str) {

		for (int c = 0; c < str.length(); c++) {
			for (int i = 0; i <= str.length() - c; i++) {
				String sub = str.substring(c, c + i);
				System.out.println(sub);
			}
		}

	}

	public static void main(String args[]) {

		String str = "ABC";
		 printPermutationOfString(str);
	}

}
