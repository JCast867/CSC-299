package shelving;

import java.util.List;

/**
 * (Roughly remembered) 
 * A company is expanding and just built a second warehouse to hold their products.  Their new warehouse was specifically designed to hold 
 * advanced technology products giving more space for all types of products and a special controlled environment for the electronics.
 * The factory's robotic assistances require an exact ordering of the products in each warehouse to accommodate their retrieval systems, so 
 * all products must remain in the same shelving order even after moving.  Since the new warehouse has significantly fewer shelves, 
 * the product shelving must be renumbered to keep the current order, but to use the smallest possible shelf number.  For example, in the
 * old warehouse a product may have been on shelf 3 and being the first tech product in the new warehouse it will go on shelf 1, since the 
 * items on shelves 1 and 2 will stay in the old warehouse.  If the next product moved over was on shelf 7 (with the contents of shelves 4-6 
 * staying), that product will go on shelf 2 in the new warehouse.
 * 
 * While this problem would have been pretty simple to solve at first, nobody thought to renumber the products before they were packed.  The
 * packers instead wrote the existing shelf number on the product before packing them into boxes that made sense to fit in the moving trucks,
 * not for easily knowing where they go when they arrive.  Fortunately, they did create a list of every product and their original shelf.
 * 
 * This module takes a list of old shelf numbers for each product in the order they were packed from the old warehouse.  It needs to return a 
 * list of shelf numbers for where each item will be placed in the new warehouse.  So if the code received the list:
 *  (3, 7, 5, 3, 7) 
 * it would return the list
 *  (1, 3, 2, 1, 3)
 * since the 5 products were placed on 3 shelves.  Remember, the incoming list includes each item, and a shelf may hold many of those items.  
 * In our example above, the two items on shelf 3 get moved to shelf 1 in the new warehouse and the 2 items on shelf 7 get moved to shelf 3, 
 * with the lone item on shelf 5 moving to shelf 2.    
 * 
 * @author Tony
 */
public class Shelving
{
	/**
	 * Renumbers the list of shelf numbers from the old warehouse to the new warehouse (see description above)
	 * @param itemSelfNumber the old warehouse shelf number of each item
	 * @return a list of shelf numbers in the new warehouse for each item.
	 */
	public List<Integer> renumber(List<Integer> itemSelfNumber)
	{
		return itemSelfNumber;
	}
}