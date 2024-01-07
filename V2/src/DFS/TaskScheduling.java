package DFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some
prerequisite tasks which need to be completed before it can be scheduled.
Given the number of tasks and a list of prerequisite pairs, find out if it is
possible to schedule all the tasks
 */
public class TaskScheduling {
    
    public static void main(String[] args) {
        Integer[][] Prerequisites={{2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2},{1, 3}};
       // buildGraph(Prerequisites,6);
        boolean result = TaskScheduling.isSchedulingPossible(6, Prerequisites);
    }

    private static boolean isSchedulingPossible(int n, Integer[][] prerequisites) {
        Stack<Integer> stk=new Stack<>();
        boolean visited[]=new boolean[n];

        ArrayList<ArrayList<Integer>> graph= buildGraph(prerequisites,6);
        
         Queue<Integer> q=new LinkedList<>();
        int inDegree[]=new int[n];
        for (int from = 0; from < inDegree.length; from++) {
          ArrayList<Integer> temp=  graph.get(from);
          for(Integer to: temp ){
            inDegree[to]++;
          }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i]==0)
                q.add(i);
        }
        ArrayList<Integer> result=new ArrayList<>();
        while(!q.isEmpty()){
            int u=q.poll();
            result.add(u);
            for(Integer child:graph.get(u)){
                if(--inDegree[child]==0)
                q.add(child);
            }
        }

        System.out.println(result.toString());
        // for (int i = 0; i < n; i++) {
        //     if(!visited[i])
        //     solution(i, stk, graph,visited); 
        // }
        // while (!stk.isEmpty()) System.out.print(stk.pop() + " ");

        return false;
    }

   
    private static void solution(int i, Stack<Integer> stk, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {

        visited[i]=true;

        Iterator<Integer> itr=graph.get(i).iterator();
        while(itr.hasNext()){
           Integer next= itr.next();
           if(!visited[next])
            solution(next, stk, graph,visited); 
        }
        stk.push(i);
    }

    private static  ArrayList<ArrayList<Integer>>  buildGraph(Integer[][] prerequisites, int n){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>(n);
        for (int i = 0; i <n; i++) {
               result.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
              result.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
       return result;
    }

}
