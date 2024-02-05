package BFSExample;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSTraversal {

    int v;
    LinkedList<Integer> adj[];

    @SuppressWarnings({"unchecked"})
    BFSTraversal(int n){
        this.v=n;
      adj=new LinkedList[4];
      for(int i=0; i<n;i++){
          adj[i]=new LinkedList<>();
      }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void Traverse(int source){
        boolean visited[]=new  boolean[4];
        LinkedList<Integer> que=new LinkedList<>();
        visited[source]=true;
        que.add(source);
        while(que.size()>0){
            int s=que.poll();
            System.out.println(s);
            Iterator<Integer> i=adj[s].listIterator();
            while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    visited[n]=true;
                    que.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSTraversal bfs=new BFSTraversal(4);

        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);
        bfs.Traverse(2);

        
    }
}
