package DFS;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * DFSTraversal
 */
public class DFSTraversal {

    int v;
    LinkedList<Integer> adj[];

    @SuppressWarnings({"unchecked"})
    DFSTraversal(int v){
        this.v=v;
        adj=new LinkedList[4];
        for (int i = 0; i < adj.length; i++) {
           adj[i]=new LinkedList<>(); 
        }
    }

    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }

    public void traversal(int source){ // if no source is given check visited for each node otherwise comment line 31 , pass source instead of i.
        boolean[] visited=new boolean [4];
      for (int i = 0; i <this.v; i++) {
          if(!visited[i])
        this.DFSUtil(visited,i);
      }
      

    }

     void DFSUtil(boolean [] visited, int source){

        visited[source]=true;
        System.out.println(source+"");
         Iterator<Integer> itr=adj[source].listIterator();
         while(itr.hasNext()){
            int next= itr.next();
            if(!visited[next]){
                DFSUtil(visited, next);
            }
         }
     }
    public static void main(String[] args) {
        DFSTraversal dfs=new DFSTraversal(4);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);
        dfs.traversal(2);
    }
}