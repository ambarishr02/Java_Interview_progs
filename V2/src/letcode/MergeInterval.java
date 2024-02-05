package letcode;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeInterval {


    public static int[][] merge(int[][] intervals) {
      LinkedList<int[]> mergedIntervals=new LinkedList<>();
      Arrays.sort(intervals, (x,y)->x[0]-y[0]);
      for(int[] interval: intervals){
        if(mergedIntervals.isEmpty() || mergedIntervals.getLast()[1]<interval[0]){
            mergedIntervals.add(interval);
        }
        mergedIntervals.getLast()[1]=  Math.max(mergedIntervals.getLast()[1], interval[1]);
      }
      return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
    public static void main(String[] args) {
        int intervals[][]={{1,3},{2,4}};
    //Arrays.stream(merge(intervals)).flatMapToInt(Arrays::String);
    for (int[] row : merge(intervals))
    System.out.println(Arrays.toString(row));
    }
    
}
