import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	
	int v;
	LinkedList<Integer> adj[]; 
	
	public DFS(int v){
	  this.v=v;
	  adj=new LinkedList[v];
	  for(int i=0;i<v;i++) {
		  adj[i]=new LinkedList();
	  }
	 
	}
	
	void addEdge(int v,int w) {
		adj[v].add(w);
	}
	
	
	public void DFSUtil(int v,boolean visited[]) {
		visited[v]=true;
		System.out.println(""+v);
		Iterator<Integer> itr= adj[v].iterator();
		while(itr.hasNext()) {
			int n= itr.next();
			 if(!visited[n]) {
				 DFSUtil(n,visited);
			 }
		}
	}
	
    public void constructDFS(){
     boolean  visited[] =new boolean[v];
     for(int i=0;i<v;i++) {
    	 if(visited[i]==false) {
    		 DFSUtil(v,visited);
    	 }
       }
   	}
    
    public void BFS() {
    	
    }
	
	
   public void main(String args[]) {
		DFS g=new DFS(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);
	 }
}
