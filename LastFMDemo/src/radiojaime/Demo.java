package radiojaime;

import java.text.DateFormat;
import java.util.Collection;

import de.umass.lastfm.Artist;
import de.umass.lastfm.Caller;
import de.umass.lastfm.Chart;
import de.umass.lastfm.User;

public class Demo 
{

	
	public static void main(String[] args) {
		String userAgent = "tst";
		Caller.getInstance().setUserAgent(userAgent);
		Caller.getInstance().setDebugMode(true);
		
		String key = "ab5252887303a2a26ed5ba0f310deb6f"; //this is the key used in the Last.fm API examples
		String user = "JRoar";
		Chart<Artist> chart = User.getWeeklyArtistChart(user, 10, key);
		DateFormat format = DateFormat.getDateInstance();
		String from = format.format(chart.getFrom());
		String to = format.format(chart.getTo());
		System.out.printf("Charts for %s for the week from %s to %s:%n", user, from, to);
		Collection<Artist> artists = chart.getEntries();
		for (Artist artist : artists) {
		    System.out.println(artist.getName());
		}
	}
}
