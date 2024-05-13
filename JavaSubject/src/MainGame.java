import java.util.*;

public class MainGame{
	public static void main(String args[])
	{
		boolean clearingGame;
		int presentPlayerLife;
		int presentLevel = 0;
		int randomCardCode;
		
		Random gen = new Random();
		gen.setSeed(System.currentTimeMillis());
		
		if(presentLevel == 1)
		{
			Card[] objCard = new Card[9];
			
			for(int i = 0; i < 9; i++)
			{
				randomCardCode = gen.nextInt(2);
				objCard[i] = new Card(randomCardCode);
			}
		}
		else if(presentLevel == 2)
		{
			Card[] objCard = new Card[16];
			
			for(int j = 0; j < 16; j++)
			{
				randomCardCode = gen.nextInt(3);
				objCard[j] = new Card(randomCardCode);
			}
		}
		else
		{
			Card[] objCard = new Card[25];
			
			for(int k = 0; k < 25; k++)
			{
				randomCardCode = gen.nextInt(3);
				objCard[k] = new Card(randomCardCode);
			}
		}
	}
}