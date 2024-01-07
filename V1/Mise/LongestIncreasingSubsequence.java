


	public class LongestIncreasingSubsequence {
		
		public static void LIS(int X[])
		{
			int parent[]= new int[X.length]; //Tracking the predecessors/parents of elements of each subsequence.
			int increasingSub[]= new int[X.length ]; //Tracking ends of each increasing subsequence.
			int length = 0; //Length of longest subsequence.
			
			for(int i=0; i<X.length; i++)
			{
				//Binary search
				int low = 1;
				int high = length;
				while(low <= high)
					
				{	
					
					System.out.println("LOW="+low+",High="+high);
					int mid = (int) Math.ceil((low + high)/2);
					System.out.println("Mid="+mid);
					int ins=increasingSub[mid];
					System.out.println("Ins Mid="+ins);
					if(X[increasingSub[mid]] < X[i]) {
						System.out.println("X[increasingSub[mid]]="+X[increasingSub[mid]]+" < "+ "X[i]="+ X[i]);
					//	System.out.println("ins="+ins+",Value"+X[ins]);
						low = mid + 1;
						System.out.println("low incrementd="+low);
					}
					else {
						System.out.println("X[increasingSub[mid]]="+X[increasingSub[mid]]+" < "+ "X[i]="+ X[i]);
							//System.out.println("ins="+ins+",Value::"+X[ins]);
						high = mid - 1;
						System.out.println("High Decremented="+high);
					}
					System.out.println("LOW="+low+",High="+high);
					System.out.println("------------------");
					
				}
				
				int pos = low;
				
				//update parent/previous element for LIS
				parent[i] = increasingSub[pos-1];
				//Replace or append
				increasingSub[pos] =  i;
			
				
				
				
				System.out.println("Pos="+pos+",Iteration="+i);
				System.out.print("Parent=");
				for(int j=0;j<parent.length;j++) {
					System.out.print(parent[j]+",");
				}
				System.out.print("\n");
				
				System.out.print("Subsequence=");
				for(int j=0;j<increasingSub.length;j++) {
					System.out.print(increasingSub[j]+",");
				}
				System.out.print("\n");
				
				System.out.print("X=");
				
				
				
				for(int j=0;j<X.length;j++) {
					System.out.print(X[j]+",");
					}
					System.out.print("\n");
				System.out.println("======================================\n\n");
					
				//Update the length of the longest subsequence.
				if(pos > length)
					length=pos;
				
				
			}
			
			
			System.out.println("Length="+length);
			
			//Generate LIS by traversing parent array
			int LIS[] = new int[length];
			int k 	= increasingSub[length];
			for(int j=length-1; j>=0; j--)
			{
				LIS[j] =  X[k];
				k = parent[k];
			}
			
			
			for(int i=0; i<length; i++)
			{
				System.out.println(LIS[i]);
			}
		
			
		}
		
		public static void main(String args[])
		{
			int X[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6};
			LIS(X);
		}
	
}
