package Maze;

import java.util.LinkedList;
import java.util.Queue;
/**
 * https://www.techiedelight.com/find-shortest-distance-every-cell-landmine-maze/
 * Given a maze in the form of a rectangular matrix, filled with either O, X, or M, where O represents an open cell,
 *  X represents a blocked cell, and M represents landmines in the maze, 
 * find the shortest distance of every open cell in the maze from its nearest mine.
	We are only allowed to travel either of the four directions, and diagonal moves are not allowed. 
	We can assume cells with the mine have distance 0. Also, blocked and unreachable cells have distance -1.
	For example,

Input: 6 × 5 matrix filled with O (Open cell), X (Blocked Cell), and M (Landmine).
 
O   M   O   O   X
O   X   X   O   M
O   O   O   O   O
O   X   X   X   O
O   O   M   O   O
O   X   X   M   O
 
Output:
 
1   0   1   2  -1
2  -1  -1   1   0
3   4   3   2   1
3  -1  -1  -1   2
2   1   0   1   2
3  -1  -1   0   1
 */
class Node{
	int x;
	int y;
	int distance;
	Node parent;
	public Node(int x, int y, int distance) {
		super();
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public Node(int x, int y, int distance, Node parent) {
		super();
		this.x = x;
		this.y = y;
		this.distance = distance;
		this.parent=parent;
	}
	
	@Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}
public class Matrixmaze {
	static int row[]={-1,1,0,0};
	static int col[]={0,0,-1,1};

	static boolean isValid(int M, int N,int x , int y){
		return ((x>=0 && x<M) && (y>=0 && y<N));
	}

	// M- stands for  mine , O is open and X blocked 
	static int[][] updateShortestDistanceFromLandmine(char[][] matrix){
	
	int[][] result=new int[matrix.length][matrix[0].length];	
	
	Queue<Node> q=new LinkedList<Node>();
	for(int i=0; i<matrix.length;i++)
		for(int j=0;j<matrix[0].length;j++)
			if(matrix[i][j]=='M'){
				q.add(new Node(i,j, 0));
				result[i][j]=0;
			}else
				result[i][j]=-1;
	
	while(q.size()>0){
		int x=q.peek().x;
		int y= q.peek().y;
		int distance=q.peek().distance;
		q.poll();
		
		for(int i=0;i<row.length;i++){
			if(isValid(matrix.length, matrix[0].length, x+row[i], y+col[i]) && isSafe(x+row[i], y+col[i],matrix,result)){
				q.add(new Node(x+row[i], y+col[i], distance+1));
				result[x+row[i]][y+col[i]]=distance+1;
			}
		}
	}
	return result;	
	
}
	
	
	static boolean isSafe(int i, int j, char[][] matrix , int[][] result){
		return matrix[i][j]=='O' && result[i][j]==-1;
	}
	
	public static void main(String[] args) {
		char[][] matrix={
					{'O', 'M', 'O', 'O', 'X'},
			        {'O', 'X', 'X', 'O', 'M'},
			        {'O', 'O', 'O', 'O', 'O'},
			        {'O', 'X', 'X', 'X', 'O'},
			        {'O', 'O', 'M', 'O', 'O'},
			        {'O', 'X', 'X', 'M', 'O'}	
		};
		int result[][]=updateShortestDistanceFromLandmine(matrix);
		for(int arr[]:result){
			for(int x:arr){
				System.out.print(x+",");
			}
			System.out.println();
		}
		//Stream.of(result).flatMap(Stream::of).forEach(System.out::println);
	}
}
