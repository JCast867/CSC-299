package arrays;

import java.util.Arrays;

/**
 * @author <Your Name Here>
 */
public class BasicArrayManipulations
{
	/**
	 * Compute the total value of an array of integers
	 * @param values - an array of integers
	 * @return the total
	 */
    public int total(int[] values)
    {
    	int sum = 0;
    	for (int i = 0; i < values.length; i++) {
    		sum += values[i];
    	}
        return sum;
    }
    
    /**
     * Compute the mean/average of an array of integers
	 * @param values - an array of integers
     * @return the mean
     */
    public double mean(int[] values)
    {
    	if (values.length == 0) { return 0; }
    	int sum = 0;
    	for (int i = 0; i < values.length; i++) {
    		sum += values[i];
    	}
        return sum/values.length;
    }

    /**
     * See how often the target value appears in an array of integers
	 * @param values - an array of integers
     * @param find - the value to find/count 
     * @return the number of times the find value appears in the array
     */
    public int count(int[] values, int find)
    {
    	int count = 0;
    	for (int i = 0; i < values.length; i++) {
    		if (values[i] == find) {
    			count += 1;
    		}
    	}
        return count;
    }

    /**
     * Compute the median (middle value) of an array of integers.  
     *  For even sized arrays, the value is the average of the two middle values.
	 * @param values - an array of integers
     * @return
     */
    public double median(int[] values)
    {
    	Arrays.sort(values);
 
    	double val = 0;
    	for (int i = 0; i < values.length; i++) {
    		int len = values.length;
    		if (len % 2 == 0) { 
    			val = (double) (values[(len/2)-1] + values[len/2]) / 2;
    		} else {
    			val = (double) values[len/2];
    		}
    			
    	}
    	
        return val;
    }

    /**
     * Find the largest value in an array of integers
	 * @param values - an array of integers
     * @return the largest value within the values
     */
    public int largest(int[] values)
    {
    	if (values.length == 0) { return 0; }
    	int max = values[0];
    	for (int i = 1; i < values.length; i++) {
    		if (values[i] > max) {
    			max = values[i];
    		}
    	}
        return max;
    }

    /**
     * Find the smallest value in an array of integers
	 * @param values - an array of integers
     * @return the smallest value within the values
     */
    public int smallest(int[] values)
    {
    	if (values.length == 0) { return 0; }
    	int min = values[0];
    	for (int i = 1; i < values.length; i++) {
    		if (values[i] < min) {
    			min = values[i];
    		}
    	}
        return min;
    }
    
    /**
     * Looks through an array of integers to see if any one value is equal
     * to ten times any other value on the list (excluding zero).  
	 * @param values - an array of integers
     * @return true, if a value is 10 times another value
     */
    public boolean tenTimes(int[] values)
    {
    	for (int i = 0; i < values.length; i++) {
    		for (int j = 0; j < values.length; j++) {
    			if (i != j && values[j] != 0 && values[i] == 10 * values[j]) {
    				return true;
    			}
    		}
    	}
    	
        return false;
    }    
}