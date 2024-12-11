package aa.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import aa.ArchitectureAnalytics;
import aa.UserStats;
import gradescope.grader.GradedTest;
import ledger.LoggedTest;

public class AATest extends LoggedTest
{
	@SuppressWarnings("unchecked")
	@Test
    @GradedTest(name="Test Basic Examples", max_score=8)
	public void testBasic()
	{
		ArchitectureAnalytics uut = new ArchitectureAnalytics();
		Map<String, UserStats> input = new HashMap<>();
		Map<Long, Long> expected = new HashMap<>();
		input.put("123", new UserStats(5));
		expected.put(123l, 5l);
		assertEquals(expected, uut.count(input));
		
		input.put("456", new UserStats(1));
		expected.put(456l, 1l);
		assertEquals(expected, uut.count(input));
	}

	@SuppressWarnings("unchecked")
	@Test
    @GradedTest(name="Test Multiple Inputs", max_score=7)
	public void testMultiples()
	{
		ArchitectureAnalytics uut = new ArchitectureAnalytics();
		Map<String, UserStats> input = new HashMap<>();
		Map<String, UserStats> input2 = new HashMap<>();
		Map<Long, Long> expected = new HashMap<>();
		input.put("123", new UserStats(5));
		expected.put(123l, 5l);
		assertEquals(expected, uut.count(input, input2));
		
		input.put("456", new UserStats(1));
		expected.put(456l, 1l);
		assertEquals(expected, uut.count(input, input2));

		input.put("789", new UserStats(55));
		expected.put(789l, 55l);
		assertEquals(expected, uut.count(input, input2));
		
		input2.put("456", new UserStats(9));
		expected.put(456l, 10l);
		assertEquals(expected, uut.count(input, input2));
	}

	@SuppressWarnings("unchecked")
	@Test
    @GradedTest(name="Test Error Flows", max_score=10)
	public void testErrors()
	{
		ArchitectureAnalytics uut = new ArchitectureAnalytics();
		Map<String, UserStats> input = null;
		Map<Long, Long> expected = new HashMap<>();
		assertEquals(expected, uut.count(input));
		
		input = new HashMap<>();
		Map<String, UserStats> input2 = new HashMap<>();
		input.put("123", new UserStats(5));
		expected.put(123l, 5l);
		assertEquals(expected, uut.count(input, input2));

		input.put("abc", new UserStats(5));
		assertEquals(expected, uut.count(input, input2));
		
		input.put("222", null);
		assertEquals(expected, uut.count(input, input2));

		input.put("333", new UserStats());
		assertEquals(expected, uut.count(input, input2));
		
		assertEquals(expected, uut.count(input, null, input2));
	}	
	
	
	private static final String CODE_FILE= "src/aa/ArchitectureAnalytics";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}
