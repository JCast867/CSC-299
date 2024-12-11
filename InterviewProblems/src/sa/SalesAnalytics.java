package sa;

import java.util.ArrayList;
import java.util.List;

/** 
 *  A large retailer wants to better understand its customers through their data.  
 *  They believe that they can create categories of customers based on their common
 *  purchase patterns.  When customers by the same items with the same frequency, they 
 *  are similar to each other.  When their purchasing patterns are drastically different
 *  then they are not.
 *  
 *  This module compares customer purchasing pattern.  The caller provides purchases as an 
 *  encoded string were each letter of the alphabet represents a different product and the string
 *  list the purchases in order.  Two customers are similar if the difference in total purchases 
 *  for each product is no more than the similarity threshold.  For example, 
 *    Customer 1:  aaabbaa
 *    Customer 2:  ccaaa
 *    Customer 3:  bcbca
 *  
 *  Customers 1 and 2 are similar for a threshold of 3, because the difference for product a is 2, b is 2, and c is 2.
 *  Customers 2 and 3 are likewise similar for a threshold with a difference of 2, 2, 0.
 *  Customers 1 and 3 are not similar for a threshold of 3 because the difference in a is 4.  
 * 
 */
public class SalesAnalytics
{
	public boolean isSimilar(String first, String second, int similarityThreshold)
	{
		return false;
	}
	
	/**
	 * Determine if 
	 * @param first
	 * @param second
	 * @param similarityThreshold
	 * @return
	 */
	public List<Boolean> getSimilar(List<String> first, List<String> second, int similarityThreshold)
	{
		List<Boolean> results = new ArrayList<>();
		return results;
	}
}
