import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Card{
	// cardCode means cardImage select
	/// cardState 0 means back, 1 means front
	private int gameLife = 3;
	private Integer[] aryCardCoedEasy = {1, 2, 2, 0, 1, 0, 3, 4, 3};
	private Integer[] aryCardCoedRegular = {0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3};
	
	//Constructor
	public Card()
	{
		List<Integer> list =Arrays.asList(aryCardCoedEasy);
        System.out.println("랜덤 정렬 전 : " + Arrays.toString(aryCardCoedEasy));
        
        Collections.shuffle(list);
        list.toArray(aryCardCoedEasy);
        System.out.println("랜덤 정렬 후 : " + Arrays.toString(aryCardCoedEasy));
        
        List<Integer> listRegular = Arrays.asList(aryCardCoedRegular);
        System.out.println("랜덤 정렬 전 (Regular) : " + Arrays.toString(aryCardCoedRegular));

        Collections.shuffle(listRegular);
        listRegular.toArray(aryCardCoedRegular);
        System.out.println("랜덤 정렬 후 (Regular) : " + Arrays.toString(aryCardCoedRegular));
	}
	//getter&setter
	public int getCardCode1(int x, String difficulty) {
        if (difficulty.equals("easy")) 
        {
            return aryCardCoedEasy[x];
        } else if (difficulty.equals("regular")) 
        {
            return aryCardCoedRegular[x];
        } else 
        {
            throw new IllegalArgumentException("Invalid difficulty level");
        }
    }

	public int getGameLifer()
	{
		return gameLife;
	}
}