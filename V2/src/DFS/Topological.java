package DFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Util.GraphUtil.Graph;

public class Topological {

  static void TopologicalSort(Graph g, int v) {
    Stack<Integer> stk = new Stack<>();
    boolean[] visited = new boolean[v];

    for (int i = 0; i < visited.length; i++) {
      if (!visited[i]) 
      sort(g, i, visited, stk);
    }
    while (!stk.isEmpty()) System.out.print(stk.pop() + " ");
  }

  private static void sort(Graph g,int v,boolean[] visited,Stack<Integer> stk) {
    
    visited[v] = true;
    Iterator<Integer> itr = g.getAdj().get(v).iterator();
    while (itr.hasNext()) {
      Integer nextPossibleNode = itr.next();
      if (!visited[nextPossibleNode]) sort(g, nextPossibleNode, visited, stk);
    }
    stk.size();
    stk.push(v);
  
  }



  private static void topologicalUsingBFS(Graph g, int v){

    int inDegree[]=new int[v];
    
    for (int from = 0; from < v; from++) {
        ArrayList<Integer> toList= g.getAdj().get(from);
        for (int to : toList) {
            inDegree[to]++;
        }
    }

    Queue<Integer> q=new LinkedList<>();
    for (int i = 0; i < inDegree.length; i++) {
        if(inDegree[i]==0){
            q.add(i);
        }
    }
    ArrayList<Integer> result=new ArrayList<>();
    while(!q.isEmpty()){
        Integer u =q.poll();
        result.add(u);
        
       for(Integer node: g.getAdj().get(u)){
           if(--inDegree[node]==0)
           q.add(node);
       }

    }
    System.out.println("=======================");
    System.out.println(result.toString());

  }


  public static void main(String[] args) {
    Graph g = new Graph(6);// {{2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2},{1, 3}};
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);

    //  g.addEdge(2, 5);
    // g.addEdge(0, 5);
    // g.addEdge(0, 4);
    // g.addEdge(1, 4);
    // g.addEdge(3, 2);
    // g.addEdge(1, 3);

    TopologicalSort(g, 6);
   //topologicalUsingBFS(g,6);
  }
} 
