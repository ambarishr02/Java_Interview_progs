package DFS;

import java.util.ArrayList;
import java.util.List;

public class FindCycle {

    int v;
    List<Integer> adj[];

    @SuppressWarnings("unchecked")
    FindCycle(int v) {
        this.v = v;
        this.adj = new  ArrayList[4];
        for (Integer i = 0; i < v; i++) {
            this.adj[i] = new ArrayList<Integer>();
        }
    }

    void addEdge(int v, int w) {
        this. adj[v].add(w);
    }

    boolean isCyclic() {
        boolean[] visited = new boolean[v];
        boolean[] recStck = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (isCyclicUtil(i, visited, recStck)) {
                return true;
            }
        }
        return false;
    }

    boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStck) {

        if (recStck[i])
            return false;

         if(visited[i])
            return true;   

          visited[i]=true;
          recStck[i]=true;
          
          List<Integer> children=adj[i];
          for(Integer c:children)   
            if(isCyclicUtil(c, visited, recStck))
                return true;

         recStck[i]=false;    

        return false;
    }

    public static void main(String[] args) {
        FindCycle graph = new FindCycle(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
       System.out.println(graph.isCyclic());
    }

}
