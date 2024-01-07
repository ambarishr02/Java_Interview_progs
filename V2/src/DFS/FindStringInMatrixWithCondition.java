package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an M × N matrix of characters, find all occurrences of a given string in the matrix. 
 * We are allowed to search the string in all eight possible directions, i.e., North, West, South, East, North-East, North-West, South-East, South-West. 
 * Note that there should not be any cycles in the output path.
 * EX: [ D  E  M  X  B ]
 [ A  O  E  P  E ]
 [ D  D  C  O  D ]
 [ E  B  E  D  S ]
 [ C  P  Y  E  N ]

 If the given string is CODE, following are all its occurrences in the matrix:

C(2, 2)   O(1, 1)   D(0, 0)   E(0, 1)
C(2, 2)   O(1, 1)   D(2, 0)   E(3, 0)
C(2, 2)   O(1, 1)   D(2, 1)   E(1, 2)
C(2, 2)   O(1, 1)   D(2, 1)   E(3, 0)
C(2, 2)   O(1, 1)   D(2, 1)   E(3, 2)
C(2, 2)   O(2, 3)   D(2, 4)   E(1, 4)
C(2, 2)   O(2, 3)   D(3, 3)   E(3, 2)
C(2, 2)   O(2, 3)   D(3, 3)   E(4, 3)
 */
public class FindStringInMatrixWithCondition {
      //upperdiagonal, above,aboveright, left,right,bottomleft,bottom,lowerdiagonal
    static int row[]={-1, -1, -1,  0, 0,  1, 1, 1};
    static int col[]={-1,  0,  1, -1, 1, -1, 0, 1};
  static  class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }


    @Override
    public String toString() {
        return "{" +x+", "+y+
            "}";
    }

    }

    static boolean isValid(Node node, int row_size,int col_size, List<Node> path){
        return ((node.x>=0 && node.x<row_size) && (node.y>=0 && node.y<col_size) && !path.contains(node));
    }

    static void  dfs(Character[][] arr, Node node, String word, int index, List<Node> path){
        int x=node.x;
        int y=node.y;

        if(arr[x][y]!=word.charAt(index)){
            return;
        }
        path.add(node);

        if(index==word.length()-1){
            System.out.println(path.toString());
        }else{
                for (int k = 0; k < row.length; k++) {
                  Node newNode= new Node(x+row[k],y+col[k]);
                  if(isValid(newNode, arr.length, arr[0].length, path)){
                        dfs(arr, newNode, word, index+1, path);
                  }
                }
        }
        path.remove(path.size()-1);

    }
    

    static void findAllOccurances(Character[][] arr,String word){
        if(arr.length==0|| arr[0].length==0|| word==null){
            return;
        }
        List<Node> path=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
               Node node= new Node(i,j);
               dfs(arr, node, word, 0,path);
            }
        }

    }
    public static void main(String[] args) {
        Character arr[][]=  {{ 'D','E' ,'M' ,'X' ,'B' },
                             { 'A' ,'O' ,'E' ,'P' ,'E'},
                             { 'D' ,'D' ,'C' ,'O' ,'D' },
                             { 'E' ,'B' ,'E' ,'D' ,'S' },
                             { 'C' ,'P' ,'Y' ,'E' ,'N' }};

        String word="CODE";
        findAllOccurances(arr, word);
    }
}
