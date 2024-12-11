package validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class ValidationHelper
{
	private PrintStream out;
	private BufferedReader in;

	/**
	 * Prompt the user until they provide a non-empty that is also not whitespace
	 * @param prompt - the message to show the user prompting for input
	 * @param error - the error message to show the user when incorrect
	 * @return the user's non-blank String
	 * @throws IOException
	 */
	public String getRequiredString(String prompt, String error) throws IOException
	{
		String input = "";
		while (true) {
			out.print(prompt);
			input = in.readLine();
			if (input.length() < 0) {
				out.print(error);
			} else {
				break;
			}
		}
		return input;
	}

	/**
	 * Prompt the user until they provide valid integer value 
	 * @param prompt - the message to show the user prompting for input
	 * @param error - the error message to show the user when incorrect
	 * @return the user's integer value
	 * @throws IOException
	 */
	public int getIntegerInput(String prompt, String error) throws IOException
	{
		
		
		String input = "";
		
		//String input = "";
		while (true) {
			out.print(prompt);
			input = in.readLine();			
			if(input == null || input.isEmpty()) {
				out.print(error);;
			} else {
				break;
			}
		}
		return Integer.parseInt(input);
	}

	/**
	 * Prompt the user until they provide valid positive value
	 * @param prompt - the message to show the user prompting for input
	 * @param error - the error message to show the user when incorrect
	 * @return
	 * @throws IOException
	 */
	public double getDoubleInput(String prompt, String error) throws IOException
	{
		
		
		String input = "";
		while (true) {
			out.print(prompt);
			input = in.readLine();
			if(input.length() < 0 ) {
				out.print(error);
			} else {
				break;
			}
		} return Double.parseDouble(input);
	}

	/**
	 * Prompt the user until they provide valid floating point number
	 * @param prompt - the message to show the user prompting for input
	 * @param error - the error message to show the user when incorrect
	 * @return the user's positive integer
	 * @throws IOException
	 */
	public int getPositiveInteger(String prompt, String error) throws IOException
	{
		out.print(prompt);
		String input = in.readLine();
		return Integer.parseInt(input);
	}
	
	/**
	 * Prompt the user until they provide an integer greater than or equal to the minimum
	 * @param prompt - the message to show the user prompting for input
	 * @param error - the error message to show the user when incorrect
	 * @param min - the minimum value acceptable
	 * @return the user's selected integer at or above the minimum
	 * @throws IOException
	 */
	public int getMinimumIntegerInput(String prompt, String error, int min) throws IOException
	{
		out.print(prompt);
		String input = in.readLine();
		return Integer.parseInt(input);
	}
	
	/**
	 * Prompt the user until they provide a predetermined number of integer values
     *  e.g.,  if you passed in "Test Score " this function would prompt
     *      Test Score 1:
     *      Test Score 2:
     *      Test Score ....(up to the count)
	 * @param prompt - the message to show the user prompting for input
	 * @param error - the error message to show the user when incorrect
	 * @param count - the number of required integers from the user
	 * @return an array equal to the size of count filled with the user's integers 
	 * @throws IOException
	 */
	public int[] getSeveralIntegers(String prompt, String error, int count) throws IOException
	{
		int [] values = new int[count];
		out.print(prompt);
		String input = in.readLine(); 
		System.out.println(input); // An example of how to get input using the dynamic input source and see what is there... you can delete this! 
		
		return values;
	}

	public ValidationHelper(PrintStream out, BufferedReader in)
	{
		this.out = out;
		this.in = in;
	}
}