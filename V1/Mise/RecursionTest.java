package Mise;

import java.math.BigInteger;
import java.util.Arrays;

public class RecursionTest {
	
	
	
	
	public static void printCombinationsRecursively(String[][] table) {
         printCombinationsRecursively(table, new String[table.length], 0);
    }

    public static void printCombinationsRecursively(String[][] table, String[] selection, int currentRow) {
        if(currentRow >= table.length) {
            System.out.println(Arrays.toString(selection));
            return ;
        }
      //  BigInteger count = BigInteger.ZERO;
        for (String c : table[currentRow]) {
            selection[currentRow] = c;
         printCombinationsRecursively(table, selection, currentRow + 1);
        }
        return ;
    }

    public static void main(String[] args) {

    	String[][] input = new String[][] { 
    		{ "src/main/resources", "src/main/app/config" },
			{ "/server", "/client", "/apm", "/feign", "/hystrix" }, { "/api" },
			{ "/application.properties", "/application.yml" } };
         printCombinationsRecursively(input);
      //  System.out.println(combinations + " combinations");
    }

}
