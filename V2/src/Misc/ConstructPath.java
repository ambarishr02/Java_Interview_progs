package Misc;

public class ConstructPath {

    public static void main(String[] args) {
        String path[][] ={ {"/abc","/ef"}, 
                           {"/mn","/pq"},
                           {"/xy","/st"}};
      
        pathConstruct(path,0, new String[path.length]);
    }

    private static void pathConstruct(String[][] path, int currentIndex, String[] currentPath) {

        if(currentIndex>=path.length){
            for(int j=0;j<currentPath.length;j++){
                System.out.print(currentPath[j]);
            }
            System.out.println();
            return;
        }

       for(String s:path[currentIndex]){
            currentPath[currentIndex]=s;
            pathConstruct(path,currentIndex+1,currentPath);
       }
    }


    
}
