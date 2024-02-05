package Lamda;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicates {
    public static void main(String[] args) {
         List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape", "orange");

        Set<Entry<String, List<String>>> temp = strings.stream()
                .collect(Collectors.groupingBy(s -> s))
                .entrySet();
        for(Entry<String, List<String>>  entry:temp){
            System.out.println(""+entry.getKey()+","+entry.getValue());
        }       
         List<String>  duplicates= temp.stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("Duplicates: " + duplicates);
    }
   
}
