package Array.Streams;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicate {
    
    public static void main(String[] args) {
        Integer[] numArray = new Integer[]{1, 2, 3, 4, 5, 1, 3, 5};
      
     // Collectors.groupingBy(null, null, null)
      
        Map<Integer,Long> map= Arrays.stream(numArray).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


       map.forEach((k,v)->{
        System.out.println(k+"   "+v);
       });
    }
}   
