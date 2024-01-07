
public class PatternSearchKMP {
	
	boolean KMP(String text, String pattern){
		int[] lps=computePatternArray(pattern);
		int i=0;
		int j=0;
		
		while (i<text.length() && j<pattern.length()) {
			
			if(text.charAt(i)==pattern.charAt(j)) {
				i++;
				j++;
			}else {
				if(j!=0) {
					j=lps[j-1];
				}else {
					i++;
				}
			}
			
		}
		if(j==pattern.length())
			return true;
		else
			return false;
	}
	
	
	public int[]computePatternArray(String pattern){
	  
	int size=pattern.length();
	int lps[]=new int[size];
		lps[0]=0;
	  int index=0;
	  for(int i=1;i<size;) {
		  if(pattern.charAt(i)==pattern.charAt(index)) {
			  lps[i]=index+1;
			  index++;
			  i++;
		  }else {
			  if (index!=0) {
				  index=lps[index-1];
			  }else {
				  lps[i]=0;
				  i++;
			  }
		  }
	  }
	  
	  
	  return lps;
	}
	
	
	public static void main(String args[]) {
		
		String pattern="";
		String text="";
		PatternSearchKMP kmp=new PatternSearchKMP();
		System.out.println(""+kmp.KMP(text, pattern));
		
		
		
	}

}
