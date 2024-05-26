import java.awt.event.*;

public class Card{
	// cardCode means cardImage select
	/// cardState 0 means back, 1 means front
	private boolean isOpen = false;
	private boolean isMatch = false;
	private int[][] aryCardCoedEasy = {{1, 2, 2},{0, 1, 0},{3, 4, 3}};
	
	//Constructor
	public Card()
	{
		
	}
	//getter&setter
	public int getCardCode1(int x, int y)
	{
		return aryCardCoedEasy[x][y];
	}
	
	public boolean getIsOpen()
	{
		return isOpen;
	}
	public void setIsOpent(boolean value)
	{
		isOpen = value;
	}
	public boolean getIsMatch()
	{
		return isMatch;
	}
	public void setIsMatch(boolean value)
	{
		isMatch = value;
	}

	//method
	public void changeImage()
	{
		
	}
	
}