public class Card{
	// cardCode means cardImage select
	/// cardState 0 means back, 1 means front
	private int cardCode;
	private int cardState = 0;
	
	public Card(int cardValue)
	{
		cardCode = cardValue;
	}
	
	public int getCardCode() {return cardCode;}
	
	//Image output according to card code
}