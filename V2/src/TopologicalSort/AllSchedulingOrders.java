package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AllSchedulingOrders {
    
    public static void main(String[] args) {
        int[][] Prerequisites={{3, 2}, {3, 0}, {2, 0}, {2, 1}};
        int Tasks=4;
        taskScheduling(Prerequisites,Tasks);
    }

    private static void taskScheduling(int [][] prerequisites, int tasks){
         List<Integer> tempResult=new ArrayList<>();    
        Map<Integer,List<Integer>> graph=new HashMap<>();
        Map<Integer, Integer>inDegree=new HashMap<>();
        
        for (int i = 0; i < tasks; i++) {
            graph.put(i, new ArrayList<Integer>()); 
            inDegree.put(i, 0);     
        }

        //build graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent=prerequisites[i][0], child=prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child)+1);
        }

        Queue<Integer> q=new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry:inDegree.entrySet())
         if(entry.getValue()==0)
            q.add(entry.getKey());

        printAllTopologicalSort(graph, inDegree, q,tempResult);
        
    }


    private static void  printAllTopologicalSort(Map<Integer,List<Integer>> graph, Map<Integer, Integer>inDegree,Queue<Integer> q, List<Integer> tempResult){
        if(!q.isEmpty()){
          for(Integer v:q){
           tempResult.add(v);
            Queue<Integer> next=cloneQueue(q);
            next.remove(v);
          
           List<Integer> children=graph.get(v);
            for (Integer child:children) {
                inDegree.put(child, inDegree.get(child)-1);
                if(inDegree.get(child)==0)
                next.add(child);
            }
            printAllTopologicalSort(graph, inDegree, next,tempResult);

            tempResult.remove(v);
              for (Integer child:children) 
             inDegree.put(child, inDegree.get(child)+1);
          }
        }

        if (tempResult.size() == inDegree.size())
            System.out.println(tempResult);
    }


    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
        clone.add(num);
        return clone;
        }
    
}
