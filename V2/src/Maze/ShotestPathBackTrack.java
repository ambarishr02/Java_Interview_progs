package Maze;
/**
 * Given a maze in the form of a binary rectangular matrix, 
 * find the shortest path’s length in the maze from a given source to a given destination. 
 * The path can only be constructed out of cells having value 1, and at any moment, 
 * we can only move one step in one of the four directions.
 */
public class ShotestPathBackTrack {
    static int row[]={1,-1,0,0};
    static int col[]={0,0,1,-1};

    static boolean isSafe(int arr[][], boolean visited[][],int i, int j){
       return(i>=0 && i<arr.length && j>=0 && j<arr[0].length && arr[i][j]==1 && !visited[i][j]);
    }

    static int findPath(int arr[][], boolean visited[][], int x, int y, int x1, int y1, int dis, int min){

        if(x==x1 && y==y1){
            return Math.min(dis, min);
        }
        visited[x][y]=true;
       if(isSafe(arr, visited, x+1, y))
        min=findPath(arr,visited,x+1, y, x1, y1,dis+1,min);
        if(isSafe(arr, visited, x-1, y))
        min=findPath(arr,visited,x-1, y, x1, y1,dis+1,min);
        if(isSafe(arr, visited, x, y-1))
        min=findPath(arr,visited,x, y-1, x1, y1,dis+1,min);
        if(isSafe(arr, visited, x, y+1))
        min=findPath(arr,visited,x, y+1, x1, y1,dis+1,min);
        visited[x][y]=false;
         return min;
    }
    static int shortestPath(int arr[][], int x, int y, int x1, int y1){
        if(arr.length==0|| arr[0].length==0 || arr[x][y]==0 || arr[x1][y1]==0){
            return 0;
        }
        int m=arr.length;
        int n=arr[0].length;
        boolean visited[][]=new boolean[m][n];
        int min=Integer.MAX_VALUE;
        int dist=0;
         return   findPath(arr, visited,x, y, x1,y1, dist,min);
    }
    public static void main(String[] args) {
        // int mat[][] =
        // {
        //     { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
        //     { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
        //     { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
        //     { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
        //     { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
        //     { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
        //     { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
        //     { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
        //     { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
        //     { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
        // };

        int mat[][]={{1,1,1},
                     {1,0,1},
                     {1,1,1}
        };
 
        int min_dist = shortestPath(mat, 0, 0, 2, 1);
        System.out.println(min_dist);
    }
}
