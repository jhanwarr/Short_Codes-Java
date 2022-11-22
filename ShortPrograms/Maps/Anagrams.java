import java.util.Arrays;
public class Anagrams 
{
	/**
	 * Build a signature for a string
	 * @param str string to build signature for
	 * @return signature of string
	 */
	public static String build(String str) 
	{
		str = str.toLowerCase();
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	
	/**
	 * Compare the signatures of two strings
	 * @param str1 first string
	 * @param str2 second string
	 * @return boolean indicating if two strings have equivalent signatures
	 */
	public static boolean compare(String str1, String str2) 
	{
		return build(str1).equals(build(str2));
	}
}
