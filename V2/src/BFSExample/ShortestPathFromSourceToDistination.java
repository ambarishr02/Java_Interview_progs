package BFSExample;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Go Top: (x, y) ��> (x � 1, y) Go Left: (x, y) ��> (x, y � 1) Go Down: (x, y)
 * ��> (x + 1, y) Go Right: (x, y) ��> (x, y + 1)
 * 
 * @author ambar
 *         https://www.techiedelight.com/lee-algorithm-shortest-path-in-a-maze/
 */

public class ShortestPathFromSourceToDistination {

	private static final int[] row = { -1, 0, 0, 1 };
	private static final int[] col = { 0, -1, 1, 0 };

	public static void main(String[] args) {
		int[][] mat = { 
			
		{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 }, 
		{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
		{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 }, 
		{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 }, 
		{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 }, { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 }, };

		int min_dist = findShortestPathLength(mat, 0, 0, 7, 5);
		System.out.println(min_dist);
	}

	private static int findShortestPathLength(int[][] mat, int srcX, int srcY, int dstX, int dstY) {

		if (mat == null || mat.length == 0 || mat[srcX][srcY] == 0 || mat[dstX][dstY] == 0) {
			return -1;
		}

		int M = mat.length;
		int N = mat[0].length;
		boolean[][] visited = new boolean[M][N];

		Queue<MazeNode> que = new ArrayDeque<>();
		visited[srcX][srcY] = true;
		que.add(new MazeNode(srcX, srcY, 0));

		int min_dist = Integer.MAX_VALUE;
		while (!que.isEmpty()) {
			MazeNode node = que.poll();
			srcX=node.x;
			srcY=node.y;
			int dist=node.distance;
			
			if(srcX==dstX && srcY== dstY) {
				min_dist=dist;
				break;
			}
			
			for(int k=0;k<4;k++) {
				if(isValid(mat, visited, srcX+row[k],srcY+col[k])) {
					visited[srcX+row[k]][srcY+col[k]]=true;
					que.add(new MazeNode(srcX+row[k],srcY+col[k],dist+1));
				}
			}
			
		}
		if(min_dist!=Integer.MAX_VALUE)
			return min_dist;
		return -1;
	}

	private static boolean isValid(int[][] mat, boolean[][] visited, int i, int j) {
		return (i<mat.length) && (j<mat[0].length)&& (i>=0) && (j>=0) && visited[i][j]==false && mat[i][j]==1;
	}

	
}
