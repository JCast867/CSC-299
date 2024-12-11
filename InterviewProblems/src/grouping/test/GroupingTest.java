package grouping.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import gradescope.grader.GradedTest;
import grouping.GroupingValidator;
import ledger.LoggedTest;

public class GroupingTest extends LoggedTest
{
	private static final Map<String, Boolean> BASIC_PASS = Map.of( 
			"()", true,
			"[]", true,
			"{}", true,
			"([])", true,
			"([{}])", true,
			"(testing)", true,
			"(a[b]c)", true);
	private static final Map<String, Boolean> BASIC_FAIL = Map.of( 
			"<>", true, // That way all of these are not false, and this is not included grouping anyway
			")", false,
			"{)", false,
			"(()", false,
			"(])", false,
			"([[)", false);
	private static final Map<String, Boolean> TOUGHER_TESTS = Map.of( 
			"}][}}(}][))]", false,
			"[](){()}", true,
			"({}([][]))[]()", true,
			"{)[](}]}]}))}(())(", false,
			"({[}])", false);

	@Test
    @GradedTest(name="Test Basic Passing Cases", max_score=10)
	public void testPass()
	{
		test(BASIC_PASS);
	}

	@Test
    @GradedTest(name="Test Fail Cases", max_score=10)
	public void testFail()
	{
		test(BASIC_FAIL);
	}

	@Test
    @GradedTest(name="Test Fail Cases", max_score=10)
	public void testTougher()
	{
		test(TOUGHER_TESTS);
	}
	
	protected void test(Map<String, Boolean> tests)
	{
		GroupingValidator uut = new GroupingValidator();
		for (Map.Entry<String, Boolean> test : tests.entrySet())
		{
			if (test.getValue())
			{
				assertTrue(uut.isValid(test.getKey()));
			} else
			{
				assertFalse(uut.isValid(test.getKey()));
			}
		}
	}
	
	private static final String CODE_FILE= "src/grouping/GroupingValidator";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}	
}