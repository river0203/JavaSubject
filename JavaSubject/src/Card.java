import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Card{
	// cardCode means cardImage select
	/// cardState 0 means back, 1 means front
	private boolean isOpen = false;
	private boolean isMatch = false;
	private Integer[] aryCardCoedEasy = {1, 2, 2, 0, 1, 0, 3, 4, 3};
	
	//Constructor
	public Card()
	{
		List<Integer> list =Arrays.asList(aryCardCoedEasy);
        System.out.println("랜덤 정렬 전 : " + Arrays.toString(aryCardCoedEasy));
        
        Collections.shuffle(list);
        list.toArray(aryCardCoedEasy);
        System.out.println("랜덤 정렬 후 : " + Arrays.toString(aryCardCoedEasy));
	}
	//getter&setter
	public int getCardCode1(int x)
	{
		return aryCardCoedEasy[x];
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