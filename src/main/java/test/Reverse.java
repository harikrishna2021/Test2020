package test;

public class Reverse
{


public static void main (String args[])
{
	 String input = "Geeks For Geeks"; 
	  
     // convert String to character array 
     // by using toCharArray 
     char[] try1 = input.toCharArray(); 

     for (int i = try1.length-1; i>=0; i--) 
         System.out.print(try1[i]); 
}
}