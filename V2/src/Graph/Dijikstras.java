package Graph;

/**
 * Dijikstras
 *  Shortest Path Tree
 */
public class Dijikstras {

    static int min(int dist[],boolean shortPathset[],int n){
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        for(int v=0; v<n;v++){
            if(!shortPathset[v]&& dist[v]<min){
                min=dist[v];
                min_index=v;
            }
        }
        return min_index;
    }
    
    
    static void printpath(int currentVertex, int parent[]){
        if(parent[currentVertex]==-1){
            return;
        }
        printpath(parent[currentVertex], parent);
        System.out.print(currentVertex+" ");
    }
    
    static void findShortPath(int graph[][], int source, int n){
       boolean shortetsPathSet[]= new boolean[n];
       int dist[]=new int[n];
       for (int i = 0; i < dist.length; i++) {
            dist[i]=Integer.MAX_VALUE;
       }
       dist[source]=0;
       int parent[]=new int[n];
       parent[source]=-1;
       //List<Integer> path=new ArrayList();
       for (int i = 0; i < dist.length-1; i++) {
        
        int u = min(dist, shortetsPathSet,n);
         shortetsPathSet[u]=true;
         //   path.add(u);

         for(int v=0;v<n;v++){
            if(!shortetsPathSet[v] && graph[u][v]!=0 && dist[u]!= Integer.MAX_VALUE
                && (dist[u]+graph[u][v])<dist[v]){
                dist[v]=dist[u]+graph[u][v];
                parent[v]=u;
            }
         }
       }
       
       for (int i = 0; i < dist.length; i++) {
      //  if(i!=source){
        System.out.println(i+"\t\t\t"+dist[i]);
        printpath(i, parent);
       // }
       }
     //  path.forEach(e->System.out.print(e+"\t"));
    }

    public static void main(String[] args) {
        int graph[][]=new  int[][] { 
        { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } 
    };
    findShortPath(graph,0, 9);
   
    }


}