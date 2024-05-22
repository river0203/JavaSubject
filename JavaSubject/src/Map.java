// function : only show image resource
import javax.swing.*;
import java.awt.event.*;

public class Map extends JPanel{
	private int mapLevel = 0;
	private boolean gameClear;
	private int playerLife;
	
	private JPanel mainPanel;
	private JLabel lblTitel, lblHint;
	
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
}