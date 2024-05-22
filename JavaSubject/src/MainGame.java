import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MainGame{
	
	
	public static void main(String args[])
	{
		boolean clearingGame;
		int presentPlayerLife;
		int presentLevel = 1;
		int randomCardCode;

		JFrame frame = new JFrame("FIND THE SAME CARD");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(600, 700);

	    CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);
        
        HomePanel homePanel = new HomePanel(mainPanel, cardLayout);
        LevelChoicePanel levelChoicePanel = new LevelChoicePanel(mainPanel, cardLayout);
        
        EasyPanel easyPanel = new EasyPanel(mainPanel,cardLayout);
        RegularPanel regularPanel = new RegularPanel(mainPanel, cardLayout);
        HardPanel hardPanel = new HardPanel(mainPanel,cardLayout);
        
        mainPanel.add(homePanel, "Home");
        mainPanel.add(levelChoicePanel, "LevelChoice");
        
        mainPanel.add(easyPanel,"EasyLevel");
        mainPanel.add(regularPanel,"RegularLevel");
        mainPanel.add(hardPanel,"HardLevel");
        
        frame.add(mainPanel);
        frame.setVisible(true);
        
        cardLayout.show(mainPanel, "Home");

        
		Random gen = new Random();
		gen.setSeed(System.currentTimeMillis());
		
		if(presentLevel == 1)
		{
			Card[] objCard = new Card[9];
			
			for(int i = 0; i < 9; i++)
			{
				randomCardCode = (gen.nextInt(3));
				objCard[i] = new Card(randomCardCode);
				//objCard[i].checkCardCode();
			}
		}
		else if(presentLevel == 2)
		{
			Card[] objCard = new Card[16];
			
			for(int j = 0; j < 16; j++)
			{
				randomCardCode = gen.nextInt(4);
				objCard[j] = new Card(randomCardCode);
				//objCard[j].checkCardCode();
			}
		}
		else
		{
			Card[] objCard = new Card[25];
			
			for(int k = 0; k < 25; k++)
			{
				randomCardCode = gen.nextInt(5);
				objCard[k] = new Card(randomCardCode);
				//objCard[k].checkCardCode();
			}
		}
	}
}
