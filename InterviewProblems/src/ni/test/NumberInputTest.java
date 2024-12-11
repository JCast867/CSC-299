package ni.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import gradescope.grader.GradedTest;
import ledger.LoggedTest;
import ni.NumberInput;

public class NumberInputTest extends LoggedTest
{
	@Test
    @GradedTest(name="Test Basics", max_score=5)
	public void testBasic()
	{
		NumberInput uut = new NumberInput();
		assertEquals(0, uut.readInteger("0"));
		assertEquals(1, uut.readInteger("1"));
		assertEquals(1, uut.readInteger("+1"));
		assertEquals(-1, uut.readInteger("-1"));
		assertEquals(4, uut.readInteger("     4"));
	}
	
	@Test
    @GradedTest(name="Test Fail Cases", max_score=10)
	public void testFails()
	{
		NumberInput uut = new NumberInput();
		try
		{
			assertEquals(0, uut.readInteger("01"));
			fail("Should not have allowed a number with a preceeding zero");
		} catch(NumberFormatException e) {}

		try
		{
			assertEquals(0, uut.readInteger("1 2"));
			fail("Should not have allowed multiple numbers on the line");
		} catch(NumberFormatException e) {}

		try
		{
			assertEquals(0, uut.readInteger("1.2"));
			fail("Should not have allowed decimal parts");
		} catch(NumberFormatException e) {}
		
		try
		{
			assertEquals(0, uut.readInteger("1000000001"));
			fail("Should not have allowed a number with a preceeding zero");
		} catch(NumberFormatException e) {}
	}
	
	@Test
    @GradedTest(name="Test Full File", max_score=10)
	public void testFile()
	{
		try
		{
			NumberInput uut = new NumberInput();
	    	Reader reader = new FileReader("input.txt");
	    	List<Integer> actual = uut.readIntegers(reader);
	    	assertEquals(Arrays.asList(137, -104, 0, 1, 0, -1), actual);
		} catch(Exception e)
		{
			fail("Something went wrong " + e);
		}
		
	}
	
	private static final String CODE_FILE= "src/ni/NumberInput";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}