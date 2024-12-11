package temperature.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import gradescope.grader.GradedTest;
import ledger.LoggedTest;
import temperature.Temperature;

public class TempTest extends LoggedTest
{
	@Test
    @GradedTest(name="Test Basic Examples", max_score=10)
	public void testBasics()
	{
		Temperature uut = new Temperature();
        assertEquals(1, uut.computeClosestToZero(new int[]{1, 2, 3, 4, 1000}));
        assertEquals(1, uut.computeClosestToZero(new int[]{1000, 999, 55, 1}));
        assertEquals(1, uut.computeClosestToZero(new int[]{1, -2, -8, 4, 5}));
        assertEquals(-1, uut.computeClosestToZero(new int[]{10, 2, -1, -6}));
        assertEquals(0, uut.computeClosestToZero(new int[]{0, 1, 2, 3, 4}));
	}
	
	@Test
    @GradedTest(name="Test Basic Examples", max_score=5)
	public void testTied()
	{
		Temperature uut = new Temperature();
	    assertEquals(1, uut.computeClosestToZero(new int[]{-2, -1, 1, 2}));
	    assertEquals(2, uut.computeClosestToZero(new int[]{-5, -4, -2, 12, -40, 4, 2, 18, 11, 5}));
	}
	
	private static final String CODE_FILE= "src/temperature/Temperature";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}