public class Card{
	
	// cardCode means cardImage select
	/// cardState 0 means back, 1 means front
	private int cardCode;
	private int cardState = 0;
	
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
}