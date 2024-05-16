// function : only show image resource
import java.awt.event.*;

public class Map{
	private int mapLevel = 0;
	private boolean gameClear;
	private int playerLife;
	
	public Map()
	{
		
	}
	public Map(int level)
	{
		// print Map UI
	}
	public Map(int level, int playerLife)
	{
		// print Map UI & player life
	}
	
	public boolean getGameClear() {return gameClear;}
	public void setGameClear(boolean value)
	{
		gameClear = value;
	}
	public int getMapLeve() {return mapLevel;}
	public int getPlayerLife() {return playerLife;}
	public void setPlayerLife(int value)
	{
		playerLife = value;
	}
	
	
	private class MapListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}