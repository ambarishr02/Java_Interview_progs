package DFS;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSTranversal {

	int v;
	LinkedList<Integer> adj[];

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DFSTranversal(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}
	}

	public void DFS1(int v) {
		boolean visited[] = new boolean[v];
		DFSUtil(v, visited);
	}

	void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;

		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int j = i.next();
			if (!visited[j]) {
				DFSUtil(j, visited);
			}
		}
	}

	public static void DFS(int arr[][], boolean visited[][], int x, int y) {
		visited[x][y] = true;
		int m = arr.length;
		int n = arr[0].length;
		System.out.println("x="+(x)+" ,y="+(y));
		int max=999;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(i==j) continue;
				if (arr[i][j]==1&&visited[i][j] != true ) {
					
					DFS(arr, visited, i, j);
				}
			}
		}
	}

	public static void main(String[] args) {

		/*
		 * char arr[][] = { { 'O', 'M', 'O', 'O', 'X' }, { 'O', 'X', 'X', 'O', 'M' }, {
		 * 'O', 'O', 'O', 'O', 'O' }, { 'O', 'X', 'X', 'X', 'O' }, { 'O', 'O', 'M', 'O',
		 * 'O' }, { 'O', 'X', 'X', 'M', 'O' } };
		 */
		int grid[][] = { 
				{ 0, 1,0, 0}, 
				{ 0,0, 1,1 }, 
				{  0,0, 0, 1 },
				{0, 0, 0, 0}};
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		DFS(grid, visited, 0, 0);

	}

}
