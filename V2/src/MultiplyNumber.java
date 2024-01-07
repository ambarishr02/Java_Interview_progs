
public class MultiplyNumber {
	
	

	    // Function to multiply two  
	    // numbers using Russian Peasant method 
	    static int russianPeasant(int a, int b) 
	    { 
	        // initialize result 
	        int res = 0;   
	        String ex="";
	        int v=ex.length();
	        
	   
	        // While second number doesn't become 1 
	        while (b > 0) 
	        { 
	             // If second number becomes odd,  
	             // add the first number to result 
	             if ((b & 1) != 0) 
	                 res = res + a; 
	   
	            // Double the first number  
	            // and halve the second number 
	            a = a << 1; 
	            b = b >> 1; 
	        } 
	        return res; 
	    } 
	      
	    // driver program 
	    public static void main (String[] args)  
	    { 
	        System.out.println(russianPeasant(6, 3)); 
	        System.out.println(russianPeasant(20, 12)); 
	    } 

	
	    
	    int Add(int x, int y)  
	    {  
	        // Iterate till there is no carry  
	        while (y != 0)  
	        {  
	            // carry now contains common  
	            //set bits of x and y  
	            int carry = x & y;  
	      
	            // Sum of bits of x and y where at  
	            //least one of the bits is not set  
	            x = x ^ y;  
	      
	            // Carry is shifted by one so that adding  
	            // it to x gives the required sum  
	            y = carry << 1;  
	        }  
	        return x;  
	    }  
	      
	  
	
}
