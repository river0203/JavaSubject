import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Card{
	private int gameLife = 3;
	private Integer[] aryCardCoedEasy = {1, 2, 2, 0, 1, 0, 3, 4, 3};
	private Integer[] aryCardCoedRegular = {0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3};
	private Integer[] aryCardCodeHard = {0, 1, 2, 3, 0, 1, 2, 3, 4, 4, 5, 5, 6, 6, 7, 7};
	
	//Constructor
	public Card()
	{
		List<Integer> list =Arrays.asList(aryCardCoedEasy);              
        Collections.shuffle(list);
        list.toArray(aryCardCoedEasy);               
        List<Integer> listRegular = Arrays.asList(aryCardCoedRegular);        
        Collections.shuffle(listRegular);
        listRegular.toArray(aryCardCoedRegular);                
        List<Integer> listHard = Arrays.asList(aryCardCodeHard);    
        Collections.shuffle(listHard);
        listHard.toArray(aryCardCodeHard);
	}
	//getter&setter
	public int getCardCode1(int x, String difficulty) {
        if (difficulty.equals("easy")) 
        {
            return aryCardCoedEasy[x];
        } 
        else if (difficulty.equals("regular")) 
        {
            return aryCardCoedRegular[x];
        } 
        else if (difficulty.equals("Hard")) 
        {
            return aryCardCodeHard[x];
        } 
        else 
        {
            throw new IllegalArgumentException("Invalid difficulty level");
        }
    }

	public int getGameLifer()
	{
		return gameLife;
	}
	public void setLife(int life) 
	{
        this.gameLife = life;
     }
}