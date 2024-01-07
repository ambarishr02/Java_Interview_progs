package Mise;

public class PartitionSumSet {


		public int canPartition(int[] num) {
			return this.canPartitionRecursive(num, 0, 0, 0,"");
		}

		private int canPartitionRecursive(int[] num, int currentIndex, int sum1, int sum2,String x) {
			// base check
			System.out.println("currentIndex="+currentIndex+",sum1="+sum1+",sum2="+sum2+",X="+x);
			if (currentIndex == num.length)
				return Math.abs(sum1 - sum2);

			// recursive call after including the number at the currentIndex in the first set
			int diff1 = canPartitionRecursive(num, currentIndex+1, sum1+num[currentIndex], sum2,"diff1");
			System.out.println("currentIndex="+currentIndex+",sum1="+sum1+",sum2="+sum2+",diff1="+diff1);
			// recursive call after including the number at the currentIndex in the second set
			int diff2 = canPartitionRecursive(num, currentIndex+1, sum1, sum2+num[currentIndex],"diff2");
			System.out.println("currentIndex="+currentIndex+",sum1="+sum1+",sum2="+sum2+",diff2="+diff2);
			return Math.min(diff1, diff2);
		}

		public static void main(String[] args) {
			PartitionSumSet ps = new PartitionSumSet();
			int[] num = {1, 2, 3, 9};
			System.out.println(ps.canPartition(num));
//			num = new int[]{1, 2, 7, 1, 5};
//			System.out.println(ps.canPartition(num));
//			num = new int[]{1, 3, 100, 4};
//			System.out.println(ps.canPartition(num));
		}
	}
//
//		  public boolean canPartition(int[] num) {
//		    int sum = 0;
//		    for (int i = 0; i < num.length; i++)
//		      sum += num[i];
//
//		    // if 'sum' is a an odd number, we can't have two subsets with equal sum
//		    if(sum % 2 != 0)
//		      return false;
//
//		    return this.canPartitionRecursive(num, sum/2, 0);
//		  }
//
//		  private boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
//		    // base check
//			  System.out.println("sum="+sum+",Index="+currentIndex);
//		    if (sum == 0)
//		      return true;
//
//		    if(num.length == 0 || currentIndex >= num.length)
//		      return false;
//
//		    // recursive call after choosing the number at the currentIndex
//		    // if the number at currentIndex exceeds the sum, we shouldn't process this
//		    if( num[currentIndex] <= sum ) {
//		      if(canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1))
//		        return true;
//		    }
//
//		    // recursive call after excluding the number at the currentIndex
//		    return canPartitionRecursive(num, sum, currentIndex + 1);
//		  }

//		  public static void main(String[] args) {
//			 PartitionSumSet ps = new PartitionSumSet();
//		    int[] num = {1, 2, 3, 4};
//		    System.out.println(ps.canPartition(num));
////		    num = new int[]{1, 1, 3, 4, 7};
////		    System.out.println(ps.canPartition(num));
////		    num = new int[]{2, 3, 4, 6};
////		    System.out.println(ps.canPartition(num));
//		  }
//		}

