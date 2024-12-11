package ni;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * This utility extracts valid and relevant integers.
 * 
 * Integers are valid when there is only one number on a line, that number does not start 
 * with leading zeros, and does not contain a decimal component.  An number is relevant 
 * when it is greater than or equal to negative one billion and less than or equal to one 
 * billion.  The reader should ignore invalid or irrelevant lines.   
 */
public class NumberInput
{
	/**
	 * Converts a single string to a integer 
	 * @param input a string that may or may not be a valid and relevant integer
	 * @return the integer value
	 * @throws NumberFormatException thrown if the number is invalid or irrelevant
	 */
	public int readInteger(String input) throws NumberFormatException
	{
		
		input = input.replaceAll(" ", "");
		char result = input.charAt(0);
	
		System.out.println(result);

		
		int in = Integer.parseInt(input);
		


		
		
	//	System.out.println(in);
		
		return in;
	}
	
	/**
	 * Read a series of numbers from an input channel and return all valid and relevant numbers.
	 * @param input a Java reader with a series of inputs (until a null is received)
	 * @return a list of integers that were valid and relevant
	 */
    public List<Integer> readIntegers(Reader input)
    {
    	List<Integer> values = new ArrayList<>();
    	
    	
    	
    	
    	return values;
    }
}