package Maze;
/*
 * Given an N × N matrix of positive integers, find the shortest path from the first cell of the matrix to its last cell that satisfies given constraints.

We are allowed to move exactly k steps from any cell in the matrix where k is the cell’s value, i.e., 
from a cell (i, j) having value k in a matrix M, we can move to (i+k, j), (i-k, j), (i, j+k), or (i, j-k). 
The diagonal moves are not allowed.
    Input:
 
[ 7  1  3  5  3  6  1  1  7  5 ]
[ 2  3  6  1  1  6  6  6  1  2 ]
[ 6  1  7  2  1  4  7  6  6  2 ]
[ 6  6  7  1  3  3  5  1  3  4 ]
[ 5  5  6  1  5  4  6  1  7  4 ]
[ 3  5  5  2  7  5  3  4  3  6 ]
[ 4  1  4  3  6  4  5  3  2  6 ]
[ 4  4  1  7  4  3  3  1  4  2 ]
[ 4  4  5  1  5  2  3  5  3  5 ]
[ 3  6  3  5  2  2  6  4  2  1 ]
 
Output:
 
The shortest path length is 6
The shortest path is (0, 0) (0, 7) (0, 6) (1, 6) (7, 6) (7, 9) (9, 9)

 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestPath {
    
   static int row[]={-1,1,0,0};
   static int col[]={0,0,-1,1};

    static class Node{
        int x;
        int y;
       Node parent;

    public Node(int x, int y, Node node) {
     this.x=x;
     this.y=y;
     this.parent=node;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
        
    }
    static List<String> findPath(Node node,List<String> path){
        if(node!=null){
            findPath(node.parent, path);
            path.add(node.toString()); 
        }
        return path;
    }
    static boolean  isValid(int x, int y, int m ,int n){
       return((x>=0 && x<m) && (y>=0 && y<n));
    }

    static List<String> shortestPath(int[][] matrix, int i, int j){
        if(matrix.length==0 || matrix[0].length==0){
            return null;
        }
        List<String> path=new ArrayList<>();
        Queue<Node> que=new ArrayDeque<Node>();
        que.add(new Node(i, j,null));
        Set<String> visited=new HashSet<>();
        String key=i+","+j;
        int m=matrix.length;
        int n=matrix[0].length;
        visited.add(key);
        while(!que.isEmpty()){
         Node current=que.poll();
           int x=current.x;
           int y= current.y;
          int val=matrix[x][y];
        
          if(x==matrix.length-1 && y==matrix.length-1){
                findPath(current, path);
                return path;
            }

           for (int k = 0; k < row.length; k++) {
            int nextX=   x+row[k]*val;
            int nextY=   y+col[k]*val;
               if(isValid(nextX, nextY, m,n)){
                   Node next= new Node(nextX, nextY,current);
                   key=next.x+","+next.y;
                    if(!visited.contains(key)){
                        que.add(next);
                        visited.add(key);
                    }
               }
           }
        }
       System.out.println(path.toString());
        return path;
    }

    public static void main(String[] args) {
        int[][] matrix =
        {
            { 4, 4, 6, 5, 0, 1, 1, 1, 7, 4 },
            { 3, 6, 2, 4, 6, 5, 7, 2, 6, 6 },
            { 1, 3, 6, 1, 1, 1, 7, 1, 4, 5 },
            { 7, 5, 6, 3, 1, 3, 3, 1, 1, 7 },
            { 3, 4, 6, 4, 7, 2, 6, 5, 4, 4 },
            { 3, 2, 5, 1, 2, 5, 1, 2, 3, 4 },
            { 4, 2, 2, 2, 5, 2, 3, 7, 7, 3 },
            { 7, 2, 4, 3, 5, 2, 2, 3, 6, 3 },
            { 5, 1, 4, 2, 6, 4, 6, 7, 3, 7 },
            { 1, 4, 1, 7, 5, 3, 6, 5, 3, 4 }
        };
        List<String> path = shortestPath(matrix, 0, 0);
 
        if (path != null && path.size() > 0) {
            System.out.print("The shortest path is " + path);
        } else {
            System.out.println("Destination is not found");
        }

    }
}
