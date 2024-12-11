package strings.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import gradescope.grader.GradedTest;
import ledger.LoggedTest;
import strings.StringUtils;

public class ConcatTest extends LoggedTest
{

	@Test
    @GradedTest(name="Test Basic Examples", max_score=10)
	public void testBasic()
	{
		StringUtils uut = new StringUtils();
		assertEquals("abc", uut.concat(new String[]{"a", "b", "c"}));
		assertEquals("testing 1 2 3", uut.concat(new String[]{"testing ", "1", " ", "2", " ", "3", ""}));
		assertEquals("foobar", uut.concat(new String[]{"f", "o", "o", "bar"}));
		assertEquals("", uut.concat(new String[]{}));
	}

	private static final String CODE_FILE= "src/strings/StringUtils";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}	
}
