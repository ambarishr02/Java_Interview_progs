package Array;

import java.util.ArrayList;
import java.util.Random;
public class Test12 {
	
//
//
//
//
//Random rand = new Random();
//int n = rand.nextInt(26);

public static void main(String[] args) {
	
	char[] chars= {'A','B','C','D','E','F'};
	
	ArrayList<Character> string = new ArrayList<Character>();   
	Random randomGenerator = new Random(26);
	while (string.size() < 4) {

	    int random = randomGenerator .nextInt(4);
	    if (!string.contains(chars[random])) {
	        string.add(chars[random]);
	    }
	}
	
	System.out.println(string.toString());
//    ArrayList<Integer> list = new ArrayList<Integer>(chars.length);
//    for(int i = 1; i <= size; i++) {
//        list.add(i);
//    }
//
//    Random rand = new Random();
//    while(list.size() > 0) {
//        int index = rand.nextInt(list.size());
//        System.out.println("Selected: "+list);
//    }
}


}