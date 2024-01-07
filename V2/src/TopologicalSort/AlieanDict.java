package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * There is a dictionary containing words from an alien language for which
we don’t know the ordering of the alphabets. Write a method to find the
correct order of the alphabets in the alien language. It is given that the
input is a valid dictionary and there exists an ordering among its
alphabets.

Input: Words: ["ba", "bc", "ac", "cab"]
Output: bac
Explanation: Given that the words are sorted lexicographically by th
e rules of the alien language, so
from the given words we can conclude the following ordering among it
s characters:
1. From "ba" and "bc", we can conclude that 'a' comes before 'c'.
2. From "bc" and "ac", we can conclude that 'b' comes before 'a'
 */
public class AlieanDict {

    public static void main(String[] args) {
        String words []={"ba", "bc", "ac", "cab"};

        Map<Character, Integer> inDegree=new  HashMap<>();
        Map<Character, List<Character>> graph=new HashMap<>();

        for(String word: words){
            for(Character c:word.toCharArray()){
                inDegree.put(c,0);
                graph.put(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length-1; i++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i+1].length()); j++) {
                Character parent =words[i].charAt(j);
                Character child=words[i+1].charAt(j);
                if(!parent.equals(child)){
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child)+1);
                    break;
                }
            }
        }

        Queue<Character> q=new LinkedList<>();
        for(Map.Entry<Character, Integer> entry:inDegree.entrySet()){
            if(entry.getValue()==0){
                q.add(entry.getKey());
            }
        }
        StringBuilder resultString=new StringBuilder();
        while(!q.isEmpty()){
           Character vertex= q.poll();
           resultString.append(vertex);
          for(Character child:graph.get(vertex)){
            inDegree.put(child, inDegree.get(child)-1);
               if(inDegree.get(child)==0)
                q.add(child);    
            } 
          }
       
          if(resultString.length()!=inDegree.size()){
            //if sortedOrder doesn't contain all characters, there is a cyclic dependency betwe
            // will not be able to find the correct ordering of the characters
            System.out.println("None");
          }else
            System.out.println(resultString.toString());


    }
    
}
