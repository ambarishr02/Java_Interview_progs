package Maze;
/**
 * https://www.techiedelight.com/find-longest-possible-route-matrix/
 * Given a rectangular path in the form of a binary matrix, find the length of the longest possible route from source to destination
 *  by moving to only non-zero adjacent positions, i.e., We can form the route from positions having their value as 1. 
 * Note there should not be any cycles in the output path.
 * 
 */
public class LongestPath {



     static void  findPath(int arr[][]){
        //check arr for basic condition
        // visited array to avoid cycle
        //call a method with all values

        //arr, visited, start, end , maxdists, currendist

        // as we need to travel only through 1 if arr[start]==0 return
        //figure currentmax is greater than max if so assign
        //make current location visited
        //check the allowed four direction is safe or not
        //on safe of each call functio by incrementing currentdist assign result to maxdist
        //directions i+1, j   i-1 j  i,j+1, i j-1
        //remove visited

        //safe func 
        //should not visited, witin the boundary, and arr[i][j]==1

     }
    
    public static void main(String[] args) {
         // input matrix
       /*   int mat[][] =
         {
                 { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                 { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                 { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                 { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                 { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
                 { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                 { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                 { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                 { 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                 { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
         };*/
    }
}
