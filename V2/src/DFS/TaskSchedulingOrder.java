package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some
prerequisite tasks which need to be completed before it can be scheduled.
Given the number of tasks and a list of prerequisite pairs, write a method
to find the ordering of tasks we should pick to finish all tasks.
Input: Tasks=6, Prerequisites={2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2},
{1, 3}
Output: {0 1 4 3 2 5}
 */
public class TaskSchedulingOrder {
    



    public static void main(String[] args) {
        
        int [][] graph={{2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2},{1, 3}};
        int tasks=6;

        scheduleTask(tasks, graph);

    }

    private static void scheduleTask(int tasks, int[][] g) {
        Map<Integer ,ArrayList<Integer>> graph =new HashMap<>(); 
        Map<Integer, Integer> inDegree=new HashMap<>();

        for (Integer i = 0; i <tasks; i++) {
            inDegree.put(i,0);
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < g.length; i++) {
            int parent=g[i][0];
            int child=g[i][1];
            graph.get(parent).add(child);
            inDegree.put(child,inDegree.get(child)+1);
        }


        Queue<Integer> src=new LinkedList<>();
        for(Map.Entry<Integer ,Integer> entry:inDegree.entrySet()){
            if(entry.getValue()==0)
                src.add(entry.getKey());
        }
          List<Integer> result=new ArrayList<>();
          PrintAllTopologicalSort(inDegree, src, graph,result);
       
        // while(!src.isEmpty()){
        //     int v=src.poll();
        //     result.add(v);
        //    List<Integer> child= graph.get(v);
        //    for(Integer c:child){
        //     inDegree.put(c, inDegree.get(c)-1);
        //     if(inDegree.get(c)==0){
        //         src.add(c);
        //     }
        //    }
        // }

        // System.out.println(result.toString());


    }



static void PrintAllTopologicalSort(Map<Integer, Integer> inDegree, Queue<Integer> src,Map<Integer ,ArrayList<Integer>> graph,List<Integer> result){
    if(!src.isEmpty()){
        for(Integer v: src){
            result.add(v);
            Queue<Integer> clonedSrc=cloneQueue(src);
            clonedSrc.remove(v);
            List<Integer> children=graph.get(v);
            for(int child :children){
                inDegree.put(child, inDegree.get(child)-1);
              if(inDegree.get(child)==0)
                clonedSrc.add(child);
               
            }
            PrintAllTopologicalSort(inDegree, clonedSrc, graph,result);
            result.remove(v);
            for(int child :children){
               inDegree.put(child, inDegree.get(child)+1);
            }
        }
        }
          if(result.size()== inDegree.size()){
            System.out.println(result);
            }

    }


    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
        clone.add(num);
        return clone;
        }

}