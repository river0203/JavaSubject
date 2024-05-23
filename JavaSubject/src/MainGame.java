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
		int[] randomCardCode1 = new int[9];

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
		
		Card objCard = new Card();
		
		if(presentLevel == 1)
		{
			
		}
		else if(presentLevel == 2)
		{
			
		}
		else
		{
			
		}
	}
}
