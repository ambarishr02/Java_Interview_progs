
public class WildCardMatching {
	
	
	public static boolean wildcardMatch(String s, String p){
		
		char[] pattern= p.toCharArray();
	    boolean isFirst=true;
	    int writeIndex=0;
	    
	    for(int i=0;i<pattern.length;i++) {
	    	if(pattern[i]=='*') {
	    		if(isFirst) {
	    			pattern[writeIndex++]=pattern[i];
	    			isFirst=false;
	    		}
	    	}else {
	    		pattern[writeIndex++]=pattern[i];
	    		isFirst=true;
	    	}
	    }
	    
	    boolean [][] T=new boolean[s.length()+1][writeIndex+1];
	    
	    T[0][0]=true;
	    
	    for(int i=1;i<T.length;i++) {
	    	for(int j=1;j<T[0].length;j++) {
	    		if(pattern[j-1]=='?' || pattern[j-1]==s.charAt(i-1))
	    			T[i][j]=T[i-1][j-1];
	    		else
	    			if(pattern[j-1]=='*') {
	    				T[i][j]=T[i-1][j]||T[i][j-1];
	    			}
	    			
	    	}
	    }
		
	    return T[s.length()][writeIndex];
	}
	
	
	public static void main(String args[]) {
		 System.out.println(wildcardMatch("xbylmz", "x?y*z"));
	}

}
