package Maze;

public class UniqPathsBackTrack {
    
    int row[]={0, 0,1,-1};
    int col[]={1, -1, 0,0};

    static boolean isValid(int arr[][] , int x, int y){
        return(x>=0 && x<arr.length && y>=0 && y<arr[0].length && arr[x][y]==1);
    }

    static int countPaths(int arr[][], boolean visited[][], int x1,int y1, int x2, int y2){
        if(x1==x2 && y1==y2){
            return 1;
        }
        int count=0;
        visited[x1][y1]=true;
       
        if(isValid(arr, x1,y1)){
            if(isValid(arr,x1+1,y1) && !visited[x1+1][y1])
            count+=countPaths(arr, visited, x1+1, y1, x2, y2);
            if(isValid(arr,x1-1,y1) && ! visited[x1-1][y1])
            count+=countPaths(arr, visited,x1-1,y1,x2,y2);
            if(isValid(arr,x1,y1+1) && !visited[x1][y1+1])
            count+=countPaths(arr, visited,x1,y1+1,x2,y2);
            if(isValid(arr,x1,y1-1)&& !visited[x1][y1-1])
            count+=countPaths(arr, visited,x1,y1-1,x2,y2);
        }   
        visited[x1][y1]=false;
        return count;
    }

    static void findUniquePaths(int arr[][], int x1, int y1, int x2, int y2) {

        if(arr==null || arr.length==0 ||x1==x2|| y1==y2){
            return ;
        }
        int m=arr.length;
        int n=arr[0].length;
        boolean visited[][]=new boolean[m][n];
         System.out.println(countPaths(arr, visited, x1, y1, x2, y2));
       
    }

    public static void main(String[] args) {
        int[][] maze = {
                { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 1 },
                { 1, 1, 1, 1 }
        };

        findUniquePaths(maze,0,0,3,3);

    }
}
