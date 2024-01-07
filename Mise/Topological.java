import java.util.ArrayList;
import java.util.Stack;

public class Topological {
	
	static class Graph{
		Integer v;
		ArrayList<ArrayList<Integer>> adj;
		
		public Graph(int v) {
			this.v=v;
			for( int i=0;i<v;i++) {
				adj=new ArrayList<ArrayList<Integer>>(v);
			}
		}
		
		void addEdge(int v, int w){
			adj.get(v).add(w);
		}
	}

	public void topologicalSort(int v){
		
	boolean visited[]=new boolean[v];
	Stack <Integer> stack=new Stack<Integer>();
		for(int i=0; i<v;i++) {
			visited[i]=false;
		}

		for(int i=0;i<v;v++) {
			if(visited[i]==false) {
				topologicalUtil(i,visited, stack);
			}
		}
	}
	
	public void topologicalUtil(int i,boolean[] visited, Stack<Integer> stack) {
		visited[i]=true;
		
		//Iterator<Integer> it = adj.get(v).iterator();
		
		
	}
	
}
