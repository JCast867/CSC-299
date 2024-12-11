package strings;

/**
 * @author <Jaime Castaneda>
 */
public class BasicTextManipulations
{
	/**
	 * Convert the input string to a new string in the opposite order
	 * @param in - a string to manipulate
	 * @return the reversed string
	 */
    public String reverse(String in)
    {
    	char[] charArray = in.toCharArray();
    	int i = 0;
    	int j = charArray.length-1;
    	while (j > i) {
    		char curr = charArray[j];
    		charArray[j] = charArray[i];
    		charArray[i] = curr;
    		j--;
    		i++;
    	}
        return new String(charArray);
    }
    
	/**
	 * Count how many times the chosen character appears in a string
	 * @param within - the string to search
	 * @param find - the character to find
	 * @return the count
	 */
    public int count(String within, char find)
    {
    	int count = 0;
    	for (int i = 0; i < within.length(); i++) {
    		if (within.charAt(i) == find) {
    			count++;
    		}
    	}
        return count;
    }
    
	/**
	 * Remove any non alphabetic characters from a string 
	 * @param within - the string to 'clean'
	 * @return a string with only A-Z and a-z
	 */
    public String onlyAlpha(String within)
    {
    	
        return within.replaceAll("[^A-Za-z]", "");
    }
    
	/**
	 * Count the number of times a substring appears within a string
	 * @param within - the string to search
	 * @param find - the substring to find
	 * @return the count
	 */
    public int count(String within, String find)
    {
    	int sum = 0;
    	int index = within.indexOf(find);
    	
    	while (index != -1) {
    		sum += 1;
    		index = within.indexOf(find, index + find.length());
    	}
    	
        return sum;
    }

	/**
	 * Modify a string such that a 2 appears between any double characters in the string
	 * @param within - the string to search
	 * @return the same string marked with doubles
	 */
    public String markDoubles(String within)
    {
    	
    	String result = "";
    	
    	for (int i = 0; i < within.length(); i++) {
    		char current = within.charAt(i);
    		result += current;
    		
    		if (i < within.length() - 1 && current == within.charAt(i+1)) {
    			result += "2";
    		}
    	}
    	
        return result;
    }
    
	/**
	 * Check to see if a string is a palindrome
	 * @param within - the string to search
	 * @return true if the string is the same forward and back
	 */
    public boolean isPalindrome(String within)
    {
    	int left = 0;
    	int right = within.length() - 1;
    	
    	while (left < right) {
    		if (within.charAt(left) != within.charAt(right)) {
    			return false;
    		}
    		left++;
    		right--;
    	}
    	return true;
    }

	/**
	 * Modifies the case of any alphabetic characters
	 * @param within - the string to modify
	 * @return a new string where A-Z is a-z or vice versa
	 */
    public String swapCase(String within)
    {
    	char[] characters = within.toCharArray();
    	
    	for (int i = 0; i < characters.length; i++) {
    		char c = characters[i];
    		
    		if (Character.isLetter(c)) {
    		
    			if (Character.isUpperCase(c)) {
    				characters[i] = Character.toLowerCase(c);
    			} else if (Character.isLowerCase(c)) {
    				characters[i] = Character.toUpperCase(c);
    		}
    	}
    	
    	}
    	return new String(characters);
    }
	/**
	 * Count the number of times the character 'n' appears in the string, 
	 * but ignoring new line characters (\n) 
	 * @param within - the string to search
	 * @return
	 */
    public int countNs(String within)
    {
    	int count = 0;
    	
    	char N = 'n';
    	
    	for (int i = 0; i < within.length(); i++) {
    		if (within.charAt(i) == N) {
    			count += 1;
    		}
    	}
    	
        return count;
    }
}