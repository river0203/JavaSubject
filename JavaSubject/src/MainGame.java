import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MainGame {
    public static void main(String[] args) {
       
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
        HowPanel howPanel = new HowPanel(mainPanel, cardLayout);
        
        mainPanel.add(homePanel, "Home");
        mainPanel.add(levelChoicePanel, "LevelChoice");
        
        mainPanel.add(easyPanel,"EasyLevel");
        mainPanel.add(regularPanel,"RegularLevel");
        mainPanel.add(hardPanel,"HardLevel");
        mainPanel.add(howPanel, "How");
        
        frame.add(mainPanel);
        frame.setVisible(true);
        
        cardLayout.show(mainPanel, "Home");
    }
}