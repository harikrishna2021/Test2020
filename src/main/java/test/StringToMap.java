package test;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringToMap {
	// consider the input with , delimited KeyValuePairs
	//http://clearurdoubt.com/how-to-convert-a-string-into-a-map-in-java/
	public static void main(String[] args) 
	{		
		String input = "1=ONE,2=TWO,3=THREE,4=FOUR"; // consider the input with , delimited KeyValuePairs
	
	//	String input1="\"1\":\"one\",\"2\":\"two\",\"3\":\"three\"";
		String input1="\"1\":\"one\",\"2\":\"two\",\"3\":\"three\"";
		String replaceString=(input1.replaceAll("\\s",""));  
		String replaceString1=(input1.replaceAll(":","=")); 
		System.out.println(replaceString1);  
		
		List<String> pairs = Arrays.asList(input.split(",")); // Split the String into list of Pairs
		
		Map<Integer,String> mappers = new TreeMap<>();  // Create a TreeMap as we want to store the keys in sorted order
		
		for(String entry : pairs) // loop through the pairs
		{
			String[] pair = entry.split("="); // Split the entry into Key and Value
			
			mappers.put(Integer.parseInt(pair[0]), pair[1]); // Add the key & value to TreeMap.
		}
		
		// Display the TreeMap elements
		System.out.println("TreeMap Elements:\n");
		for(Integer key : mappers.keySet())
		{
			System.out.println(key + "=" + mappers.get(key));
		}	
	}
 
}
	

