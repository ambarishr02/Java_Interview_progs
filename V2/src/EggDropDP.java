
public class EggDropDP {
	
	//n= Number of Eggs 
	//k =number of floors
	static int eggDrop(int n, int k) {
		
		int[][] eggDP=new int[n+1][k+1];
		int  i, j, x;
		
		for(i=1;i<=n;i++) {
			eggDP[i][1]=1;
			eggDP[i][0]=0;		
		}
		
		for(j=1;j<=k;j++) {
			eggDP[1][j]=j;
		}
		int res;
		for(i=2;i<=n;i++) {
			
			for(j=2;j<=k;j++) {
				eggDP[i][j]=Integer.MAX_VALUE;
				for(x=1;x<=j;x++) {
					res= 1+Math.max(eggDP[i-1][x-1],eggDP[i][j-x]);
					
					if(res<eggDP[i][j]) {
						eggDP[i][j]=res;
					}
				}
				
			}
		}
		return eggDP[n][k]; 
	}
	
	public static void main(String args[]) {
		int n=2 , k=10;
		
		System.out.println(""+eggDrop(2,36));
	}

}
