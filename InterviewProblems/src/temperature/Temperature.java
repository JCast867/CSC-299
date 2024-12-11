package temperature;

import java.util.Arrays;

/**
 * See the image temperature.png for the problem description
 */
public class Temperature
{
	/**
	 * Find the temperature closest to zero
	 * @param temperatures an array of values
	 * @return the value closest to zero, positive if there is an equal negative value
	 */
	public int computeClosestToZero(int[] ts) 
	{
		if (ts == null) return 0;
		
		
		int closeTemp = ts[0];
		
		for (int i = 1; i < ts.length; i++) {
			int currTemp = ts[i];
			
			if (Math.abs(currTemp) < Math.abs(closeTemp)) {
				closeTemp = currTemp;
			} else if (Math.abs(currTemp) == Math.abs(closeTemp)) {
				closeTemp = currTemp;
			}
		}
		
		
		
		return closeTemp;
	}
}