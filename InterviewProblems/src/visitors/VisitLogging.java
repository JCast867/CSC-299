package visitors;

import java.util.ArrayList;
import java.util.List;

/**
 *  A secure office place has a system that records when users enter and leave
 *  the facility.  The log show the user's id, the time they enter/leave and the
 *  action they take at that time (signing in or out) such as the following  
 *     20 44 sign-in
 *     50 55 sign-in
 *     20 59 sign-out
 *  In the example, user 20 signs in 44 minutes after the start of the work day, followed
 *  by user 50 who signs at 55 minutes.  User 20 then signs out of the building at 59 minutes
 *  into the work day.  The log would continue as above.  The time available for a work day 
 *  is 12 hours so the log goes from 0 to 720 for possible time entries (security ensures
 *  the building is emptied each night).   
 *    
 *  The security team has been warned of a threat where some insider is coming in for short visits.
 *  The suspect is grabbing information, and quickly leaving to deliver to their contact.  
 *  Security needs to determine a pool of candidates that match the suspected activity from the 
 *  log data.  They want a tool that will query the log and report any user IDs that show
 *  short visits to the office less than a requested threshold.     
 *   
 */
public class VisitLogging
{

	/**
	 * Scan the log for all users who have a visit to the office less than the
	 * provided threshold
	 * @param log - a list of log entries as described above
	 * @param visitThreshold - the number of minutes to report as a short visit 
	 * @return a list of user ids who visited less than the given threshold
	 */
	public List<String> getShortVisits(List<String> log, int visitThreshold)
	{
		List<String> results = new ArrayList<>();
		return results;
	}
}
