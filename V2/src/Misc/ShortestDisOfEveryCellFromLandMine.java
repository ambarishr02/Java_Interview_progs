package Misc;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int x;
    int y;
    int distance;

    public Node(int x, int y, int distance){
        this.x=x;
        this.y=y;
        this.distance=distance;
    }
}

 class ShortestDisOfEveryCellFromLandMine{

    public static void main(String[] args) {
        char[][] mat =
        {
                {'O', 'M', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'O', 'M'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'X', 'X', 'O'},
                {'O', 'O', 'M', 'O', 'O'},
                {'O', 'X', 'X', 'M', 'O'}
        };

    int[][] result = updateShortestDistance(mat);
  for (int i = 0; i < result.length; i++) {
        for (int j = 0; j < result[0].length; j++) {
            System.out.print(result[i][j]+",");
            
        }
        System.out.println();
  }
      }

    private static int[][] updateShortestDistance(char[][] mat) {

        if(mat.length==0 || mat[0].length==0)
        return null;

       int m= mat.length;
       int n=mat[0].length;
       Queue<Node> q=new LinkedList<>();
       
       int[][] result =new int[m][n];
       for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {

            if(mat[i][j]=='M'){
                q.add(new Node(i, j,0));
                result[i][j]=0;
            }else{
                result[i][j]=-1;
            }
            
        }
       }

       int x_offset[]={0,-1,0,1};
       int y_offset[]={1,0,-1,0};

       while(!q.isEmpty()){
         int x=q.peek().x;
         int y=q.peek().y;
         int dis=q.peek().distance;
            q.poll();
        System.out.println("==========");
         for (int i = 0; i < y_offset.length; i++) {
            if(isValid(x+x_offset[i], y+y_offset[i], m, n) &&
                isSafe(x+x_offset[i], y+y_offset[i], mat, result)){
                    q.add(new Node(x+x_offset[i],y+y_offset[i], dis+1));
                    result[x+x_offset[i]][y+y_offset[i]]=dis+1;
            }     
         }
       }
        
        
        return result;
    }

    private static boolean isValid(int x, int y, int m, int n){
        if((x>=0 && x<m) && (y>=0 && y<n)) return true;

        return false;
    }

    private static boolean isSafe(int x, int y, char[][] mat, int [][] result){
        if(mat[x][y]=='O' && result[x][y]==-1) return true;
        return false;
    }



 }