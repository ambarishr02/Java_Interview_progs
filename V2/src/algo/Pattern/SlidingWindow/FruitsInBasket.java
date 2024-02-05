package algo.Pattern.SlidingWindow;

import java.util.HashMap;
/**
 * Maximum no of Fruits in each basket 
 * Each Backet can have only one type of fruit.
 */
public class FruitsInBasket {

    static void findMaxLength(char[] fruits, int k) {
        HashMap<Character, Integer> fruitsMap = new HashMap<>();
        int windowStart=0;
        int maxLength=0;
        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            Character ch = fruits[windowEnd];
            fruitsMap.put(ch, fruitsMap.getOrDefault(ch, 0) + 1);
            while(fruitsMap.size() > k) {
                fruitsMap.put(fruits[windowStart], fruitsMap.get(fruits[windowStart])-1);
                if(fruitsMap.get(fruits[windowStart])==0){
                    fruitsMap.remove(fruits[windowStart]);
                }
                windowStart++;
            }
            maxLength=Math.max(maxLength, windowEnd-windowStart+1);

        }
        System.out.println(maxLength);
    }

    public static void main(String[] args) {
        char[] fruits = { 'A', 'B', 'C', 'B', 'B', 'C'};
        findMaxLength(fruits, 2);
    }
}
