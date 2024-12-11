package checkers;

import java.util.Stack;

/**
 * @author <Jaime Castaneda>
 */
public class GameBoard implements Checkers 
{
	private static final int SIZE  = 8;

	/**
	 * A move a player can make on this board 
	 */
	public class Move
	{
		char player;
		int fromRow;
		int fromColumn;
		int toRow;
		int toColumn;

		public Move(char p, int fc, int fr, int tc, int tr)
		{
			player = p;
			fromRow = fr;
			fromColumn = fc;
			toRow = tr;
			toColumn = tc;
		}

		@Override
		public String toString()
		{
			return "Move [player=" + player + ", fromRow=" + fromRow + ", fromColumn=" + fromColumn + ", toRow=" + toRow
					+ ", toColumn=" + toColumn + "]";
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + fromColumn;
			result = prime * result + fromRow;
			result = prime * result + toColumn;
			result = prime * result + toRow;
			return result;
		}
	}
	
	private char[][] board;
	private Stack<Move> moves = new Stack<Move>();
	/**
	 * Start a new game by reseting the pieces to their starting place on the board
	 */
	public void startGame()
	{
		board = new char[0][0];
		moves.clear(); // Not required, but maybe helpful as a reminder?
	}
	
	/**
	 * Update the board with the provided move
	 * @param m the move to make
	 * Note: This does not need to determine if the move is valid, save that for the validateMove method
	 */
	public void makeMove(Move m)
	{
		char player;
		

	}

	/**
	 * Validate the proposed move on the current game board 
	 * @param m - the proposed move
	 * @return one of the constants from the Checkers interface, OK_MOVE if valid
	 */
	public String validateMove(Move m)
	{
	    return UNKNOWN_INVALID;
	}
	
	
	/* The following are here to help you visualize your code and the game... no need to edit!  */
	private void printBorder(int width)
	{
		for (int c = 0; c < width; c++)
		{
			System.out.print("+---");
		}
		System.out.println("+ ");
	}
	
	private void printSquares(char[] r, int rowNumber)
	{
		for (char piece : r)
		{
			System.out.print("| " + piece + " ");
		}
		System.out.println("| " + rowNumber);
	}
	
	public void drawBoard()
	{
		int rowNumber = 0;
		for (char[] r : board)
		{
			printBorder(r.length);
			printSquares(r, rowNumber++);
		}
		printBorder(board[0].length);
		for (int i = 0; i < SIZE; i++)
		{
			System.out.print("  " + i + " ");
		}
		System.out.println();
	}

	public char[][] getBoard()
	{
		return board;
	}
}