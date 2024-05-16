import java.awt.event.*;

public class Card{
	// cardCode means cardImage select
	/// cardState 0 means back, 1 means front
	private int cardCode;
	private int cardState = 0;
	
	Map gameMap = new Map();
	
	//Constructor
	public Card(int cardCodeValue)
	{
		cardCode = cardCodeValue;
	}
	
	//getter&setter
	public int getCardCode() {return cardCode;}
	public void setCardCode(int codeValue)
	{
		cardCode = codeValue;
	}
	//Image output according to card codes
	
	public void checkCardCode()
	{
		System.out.println(cardCode);
	}
	
	public void changeState()
	{
		//event checking
		if(cardState == 0)
		{
			cardState = 1;
			//front Image
		}
		else
		{
			cardState = 0;
			//back Image
		}
	}
	
	// cardDelete method
	/// all cardDelete -> game clear True
	
	private class CardListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}