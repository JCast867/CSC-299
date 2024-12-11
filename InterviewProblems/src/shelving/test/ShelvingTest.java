package shelving.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import gradescope.grader.GradedTest;
import ledger.LoggedTest;
import shelving.Shelving;

public class ShelvingTest extends LoggedTest
{
	private static final int MAX_SHELF_COUNT = 20;
	private static final int SHELF_JUMP = 7;
	private static final int REPEAT_COUNT = 10;
	@Test
    @GradedTest(name="Test Basic Examples", max_score=15)
	public void testBasic()
	{
		Shelving uut = new Shelving();
		List<Integer> actual;
		
		actual = uut.renumber(Arrays.asList(1, 2, 3, 4, 5));
		assertEquals(Arrays.asList(1, 2, 3, 4, 5), actual);
		actual = uut.renumber(Arrays.asList(2, 3, 4, 5, 6));
		assertEquals(Arrays.asList(1, 2, 3, 4, 5), actual);
		actual = uut.renumber(Arrays.asList(6, 5, 4));
		assertEquals(Arrays.asList(3, 2, 1), actual);

		actual = uut.renumber(Arrays.asList(3, 7, 5, 3, 7));
		assertEquals(Arrays.asList(1, 3, 2, 1, 3), actual);
	}

	@Test
    @GradedTest(name="Test Randomized", max_score=10)
	public void testRandomized()
	{
		Shelving uut = new Shelving();
		Random random = new Random();
		
		for (int repeat = 0; repeat < REPEAT_COUNT; repeat++)
		{
			List<Integer> ogShelves = new ArrayList<>();
			int nextShelf = 1 + random.nextInt(SHELF_JUMP); 
			for (int i = 0; i < MAX_SHELF_COUNT; i++)
			{
				ogShelves.add(nextShelf);
				nextShelf += 1 + random.nextInt(SHELF_JUMP);
			}
			
			List<Integer> input = new ArrayList<>();
			List<Integer> expected = new ArrayList<>();
			int itemCount = MAX_SHELF_COUNT + 2 * random.nextInt(MAX_SHELF_COUNT);
			Set<Integer> leftOver = new HashSet<>(ogShelves);
			for (int i = 0; i < itemCount; i++)
			{
				int nextIndex = random.nextInt(ogShelves.size());
				input.add(ogShelves.get(nextIndex));
				expected.add(nextIndex + 1);
				leftOver.remove(ogShelves.get(nextIndex));
			}
			
			for (int leftover : leftOver)
			{
				input.add(leftover);
				expected.add(ogShelves.indexOf(leftover) + 1);
			}
			
			List<Integer> actual = uut.renumber(input);
			assertEquals(expected, actual);
		}
	}

	private static final String CODE_FILE= "src/shelving/Shelving";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}