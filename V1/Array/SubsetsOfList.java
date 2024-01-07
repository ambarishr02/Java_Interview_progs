package Array;
import java.util.*;

public class SubsetsOfList {

	


	  public static List<List<Integer>> findSubsets(int[] nums) {
	    List<List<Integer>> subsets = new ArrayList<>();
	    // start by adding the empty subset
	    subsets.add(new ArrayList<>());
	    for (int currentNumber : nums) {
	      // we will take all existing subsets and insert the current number in them to create new subsets
	      int n = subsets.size();
	      System.out.println(n);
	      for (int i = 0; i < n; i++) {
	        // create a new subset from the existing subset and insert the current element to it
	        List<Integer> set = new ArrayList<>(subsets.get(i));
	         System.out.println("="+currentNumber);
	        set.add(currentNumber);
	        subsets.add(set);
	      }
	    }
	    return subsets;
	  }

	  public static void main(String[] args) {
	    List<List<Integer>> result =SubsetsOfList.findSubsets(new int[] { 8, 4 });
	    System.out.println("Here is the list of subsets: " + result);

	  //  result = SubsetsOfList.findSubsets(new int[] { 1, 5, 3 });
	    System.out.println("Here is the list of subsets: " + result);
	  }
	}
	
	

