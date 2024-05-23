import java.awt.event.*;

public class Card{
	// cardCode means cardImage select
	/// cardState 0 means back, 1 means front
	private int cardState = 0;
	private int[][] aryCardCoedEasy = {{1, 2, 1},{2, 0, 0},{0, 1, 2}};
	
	//Constructor
	public Card()
	{
		
	}
	//getter&setter
	public int getCardCode1(int x, int y)
	{
		return aryCardCoedEasy[x][y];
	}

	//method
	public void changeImage()
	{
		
	}
	
}