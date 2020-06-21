package test;

public class test {
	public static void main(String args[]){ 
	String input1="\"1\":\"one\",\"2\":\"two\",\"3\":\"three\"";
	String replaceString=(input1.replaceAll("\\s",""));  
	String replaceString1=(input1.replaceAll(":","=")); 
	System.out.println(replaceString1);  
}
}