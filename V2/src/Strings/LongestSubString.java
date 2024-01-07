package Strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    static Set<String> substring=new HashSet<>();
    static int finalSubStr=0;
    public static void main(String[] args) {
        String str="abcfbbac";
        extractMaxLenSubString(str);

    }

    private static void extractMaxLenSubString(String str) {
      char input[]= str.toCharArray();
      boolean flag[]=new boolean[256];
      int j=0;
      for (int i = 0; i < input.length; i++) {
        char c=input[i];
        if(flag[c]){
          extractSubstring(input,j,i);
          for (int k = j; k < i; k++) {
            if(input[k]==c){
              j=k+1;
              break;
            }
            flag[input[k]]=false;
          }
        }else{
         flag[c]=true;
        }
      }
      extractSubstring(input,j,input.length);
      System.out.println(substring.toString());
    }

    private static void extractSubstring(char[] input, int i, int j) {
      StringBuilder sb=new StringBuilder();
      
      for (int j2 = i; j2 < j; j2++) {
        sb.append(input[j2]);  
      }
      String str=sb.toString();
      if(str.length()>finalSubStr){
        finalSubStr=str.length();
        substring.clear();
        substring.add(str);
      }else if(str.length()==finalSubStr){
         substring.add(str);
      }
    }

    

}
