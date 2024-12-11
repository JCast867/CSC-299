package box;

/**
 * @author <Jaime>
 */
public class BoxDrawing 
{
	public static final String EXAMPLE_SOLID_BOX = "*****\n*****\n*****\n*****\n*****\n";
	public String drawFilledBox(int height, int width)
	{
	
		String out = "";
		for (int i = 0; i < height; i += 1) {
			for (int j = 0; j < width; j += 1) {
				out += "*";
			}
			out += "\n";
		}
		System.out.println(out);
		return out;
		
	}

	public static final String EXAMPLE_EMPTY_BOX = "*****\n*   *\n*   *\n*   *\n*****\n";
	public String drawEmptyBox(int height, int width)
	{
		String out = "";
		for (int i = 0; i < height; i += 1) {
			for (int j = 0; j < width; j += 1) {
				if (i == 0 || i == height-1 || j == 0 || j == width-1) {
					out += "*";
				} else { 
					out += " "; }	
			}
			out += "\n";
		}
		System.out.println(out);
		return out;
	}

	public static final String EXAMPLE_RIGHT_TRIANGLE = "*\n**\n***\n****\n*****\n";
	public String drawRightTriangle(int length)
	{
		String out = "";
		for (int i = 0; i < length; i += 1) {
			for (int j = 0; j < i+1; j+= 1) {
				out += "*";
			}
			out += "\n";
		}
		System.out.println(out);
		return out;
	}

	public static final String EXAMPLE_FLIPPED_RIGHT_TRIANGLE = "*****\n****\n***\n**\n*\n";
	public String drawFlippedRightTriangle(int length)
	{
		String out = "";
		for (int i = 0; i < length; i += 1) {
			for (int j = 0; j < length-i; j+= 1) {
				out += "*";
			}
			out += "\n";
		}
		System.out.println(out);
		return out;
	}

	public static final String EXAMPLE_MIRRORED_RIGHT_TRIANGLE = "    *\n   **\n  ***\n ****\n*****\n";
	public String drawMirroredRightTriangle(int length)
	{
		String out = "";
		for (int i = 0; i < length; i += 1) {
			for (int j = 0; j < length-i-1; j += 1) {
				out += " ";
			}
			for (int k = 0; k < i + 1; k += 1) {
				out += "*";
			}
			out += "\n";
		}
		return out;
	}

	public static final String EXAMPLE_ISOSOLESE_TRIANGLE = "    *\n   ***\n  *****\n *******\n*********\n";
	public String drawIsosoleseTriangle(int length)
	{
		String out = "";
		for (int i = 0; i < length; i += 1) {
			for (int j = 0; j < length-i-1; j+= 1) {
				out += " ";
			}
			for (int k = 0; k < 2*i+1; k += 1) {
				out += "*";
			}
			out += "\n";
		}
		return out;
	}
}