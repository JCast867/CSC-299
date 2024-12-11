package visitors.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import gradescope.grader.GradedTest;
import ledger.LoggedTest;
import visitors.VisitLogging;

public class VisitTest extends LoggedTest
{
	@Test
    @GradedTest(name="Test Basic Examples", max_score=20)
	public void testBasic()
	{
		VisitLogging uut = new VisitLogging();
		assertEquals(Arrays.asList("20"), uut.getShortVisits(Arrays.asList("20 44 sign-in", "50 55 sign-in", "20 59 sign-out"), 50));
		assertEquals(new ArrayList<String>(), uut.getShortVisits(Arrays.asList("20 44 sign-in", "50 55 sign-in", "20 59 sign-out"), 14));
		assertEquals(Arrays.asList("20", "50"), uut.getShortVisits(Arrays.asList("20 44 sign-in", "50 55 sign-in", "20 59 sign-out", "50 100 sign-out"), 50));
	}

	private static final String CODE_FILE= "src/visitors/VisitLogging";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}
