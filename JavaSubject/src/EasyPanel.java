import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

class EasyPanel extends JPanel {
	static private String[] btnTxt = {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8","b9"};
	static private JButton[] cardBtn = new JButton[9];
	static private JPanel[] cardPanel = new JPanel[9];
	static private JPanel[] cardbackPanel = new JPanel[9];
	private Card gameCard = new Card();
	private Timer m_timer = new Timer();
	
	//move to Class Card
    private int[] selectCard = new int[9];
    private int[] isOpen = {-1, -1};
    private boolean isMatch = false;
    private int[] aryOpenCardIndex = {0, 0}; 
	
    private ImagePanel imagePanel;
    private JPanel topPanel, bottomPanel;
    private JLabel lblTitle;
    private JButton btnHome, btnHint;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private ButtonListener btnL;
    
    ImagePanel back0 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level1Back.jpg").getImage());
    ImagePanel back1 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level1Back.jpg").getImage());
    ImagePanel back2 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level1Back.jpg").getImage());
    ImagePanel back3 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level1Back.jpg").getImage());
    ImagePanel back4 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level1Back.jpg").getImage());
    ImagePanel back5 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level1Back.jpg").getImage());
    ImagePanel back6 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level1Back.jpg").getImage());
    ImagePanel back7 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level1Back.jpg").getImage());
    ImagePanel back8 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level1Back.jpg").getImage());

    ImagePanel front0 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level1_0.jpg").getImage());
    ImagePanel front1 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level1_1.jpg").getImage());
    ImagePanel front2 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level1_2.jpg").getImage());
    ImagePanel front3 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level1_4.jpg").getImage());
    ImagePanel frontJoker = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Joker_4.jpg").getImage());

    public EasyPanel(JPanel mainPanel, CardLayout cardLayout){
       this.mainPanel = mainPanel;
       this.cardLayout = cardLayout;
       
       btnL = new ButtonListener();
       
       setPreferredSize(new Dimension(600,700));
       setBackground(Color.white);
       setLayout(null);

       
       topPanel = new JPanel();
       topPanel.setBounds(0, 10, 600, 150);
       topPanel.setBackground(Color.white);
       topPanel.setLayout(null);
       add(topPanel);
       
       bottomPanel = new JPanel();
       bottomPanel.setBounds(0, 160, 600, 498);
       bottomPanel.setBackground(Color.white);
       bottomPanel.setLayout(null);
       add(bottomPanel);

       lblTitle = new JLabel("EASY LEVEL");
       lblTitle.setBounds(200, 10, 200, 50);
       lblTitle.setFont(new Font("Verdana", Font.BOLD, 30));
       lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
       lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
       topPanel.add(lblTitle);
       
       btnHome = new JButton("HOME");
       btnHome.setBounds(40, 60, 100, 50);
       btnHome.setFont(new Font("Verdana", Font.BOLD, 19));
       btnHome.setBackground(new Color(255,199,199));
       btnHome.addActionListener(btnL);
       topPanel.add(btnHome);
       
       btnHint = new JButton("HINT");
       btnHint.setBounds(450, 60, 100, 50);
       btnHint.setFont(new Font("Verdana", Font.BOLD, 19));
       btnHint.setBackground(new Color(255,199,199));
       topPanel.add(btnHint);
       
       //카드 부분 코드를 bottomPanel여기에 넣어야 함.
       //패널안에 들어가는 지 위치 확인하려면 바탕 색을 화이트에서 다른 색 넣어서 확인해보기.
       
       for(int i = 0; i < 9; i++)
       {
    	   cardPanel[i] =  new JPanel();
    	   cardPanel[i].setLayout(null);
    	   bottomPanel.add(cardPanel[i]);
       }
       
       cardPanel[0].setBounds(140, 10, 60, 80);
       cardPanel[0].add(back0);
	   cardPanel[1].setBounds(140+100, 10, 60, 80);
	   cardPanel[1].add(back1);
	   cardPanel[2].setBounds(140+(100*2), 10, 60, 80);
	   cardPanel[2].add(back2);
	   cardPanel[3].setBounds(140, 10+180, 60, 80);
	   cardPanel[3].add(back3);
	   cardPanel[4].setBounds(140+100, 10+180, 60, 80);
	   cardPanel[4].add(back4);
	   cardPanel[5].setBounds(140+(100*2), 10+180, 60, 80);
	   cardPanel[5].add(back5);
	   cardPanel[6].setBounds(140, 10+(180*2), 60, 80);
	   cardPanel[6].add(back6);
	   cardPanel[7].setBounds(140+100, 10+(180*2), 60, 80);
	   cardPanel[7].add(back7);
	   cardPanel[8].setBounds(140+(100*2), 10+(180*2), 60, 80);
	   cardPanel[8].add(back8);
	      
	   for(int i = 0; i < 9; i++)
	   {
		   cardBtn[i] = new JButton(btnTxt[i]);
		   cardBtn[i].setVisible(true);
		   cardBtn[i].addActionListener(btnL);
		   bottomPanel.add(cardBtn[i]);
	   }	
	      
	   cardBtn[0].setBounds(145, 90, 50, 30);
	   cardBtn[1].setBounds(145+100, 90, 50, 30);
	   cardBtn[2].setBounds(145+200, 90, 50, 30);
	   cardBtn[3].setBounds(145, 90+180, 50, 30);
	   cardBtn[4].setBounds(145+100, 90+180, 50, 30);
	   cardBtn[5].setBounds(145+200, 90+180, 50, 30);
	   cardBtn[6].setBounds(145, 90+(180*2), 50, 30);
	   cardBtn[7].setBounds(145+100, 90+(180*2), 50, 30);
	   cardBtn[8].setBounds(145+200, 90+(180*2), 50, 30);
	   
	   selectCard[0] = gameCard.getCardCode1(0);
	   selectCard[1] = gameCard.getCardCode1(1);
	   selectCard[2] = gameCard.getCardCode1(2);
	   selectCard[3] = gameCard.getCardCode1(3);
	   selectCard[4] = gameCard.getCardCode1(4);
	   selectCard[5] = gameCard.getCardCode1(5);
	   selectCard[6] = gameCard.getCardCode1(6); 
	   selectCard[7] = gameCard.getCardCode1(7);
	   selectCard[8] = gameCard.getCardCode1(8);
	      
    }
    public void InputCard(int btnNum)
    {
    	if(isOpen[0] != (-1))
    	{
    		isOpen[1] = btnNum;
    		cardBtn[isOpen[1]].setEnabled(false);
    		if(selectCard[isOpen[1]] == 0)
    		{
    			cardPanel[btnNum].add(front0);
          	  	front0.repaint();
    		}
    		else if(selectCard[isOpen[1]] == 1)
    		{
    			cardPanel[btnNum].add(front1);
          	  	front1.repaint();
    		}
    		else if(selectCard[isOpen[1]] == 2)
    		{
    			cardPanel[btnNum].add(front2);
          	  	front2.repaint();
    		}
    		else if(selectCard[isOpen[1]] == 3)
    		{
    			cardPanel[btnNum].add(front3);
          	  	front3.repaint();
    		}
    		else if(selectCard[isOpen[1]] == 3)
    		{
    			cardPanel[btnNum].add(frontJoker);
    			frontJoker.repaint();
    		}
    	}
    	else
    	{
    		isOpen[0] = btnNum;
    		cardBtn[isOpen[0]].setEnabled(false);
    		if(selectCard[isOpen[0]] == 0)
    		{
    			cardPanel[btnNum].add(front0);
          	  	front0.repaint();
    		}
    		else if(selectCard[isOpen[0]] == 1)
    		{
    			cardPanel[btnNum].add(front1);
          	  	front1.repaint();
    		}
    		else if(selectCard[isOpen[0]] == 2)
    		{
    			cardPanel[btnNum].add(front2);
          	  	front2.repaint();
    		}
    		else if(selectCard[isOpen[0]] == 3)
    		{
    			cardPanel[btnNum].add(front3);
          	  	front3.repaint();
    		}
    		else if(selectCard[isOpen[0]] == 4)
    		{
    			cardPanel[btnNum].add(frontJoker);
    			frontJoker.repaint();
    		}
    	}
    	
    }
	public void MatchCard()
	{
		if(isOpen[0] != (-1) && isOpen[1] != (-1))
		{
			if(selectCard[isOpen[0]] == selectCard[isOpen[1]])
			{
				System.out.print("Match ");
				cardBtn[isOpen[0]].setEnabled(false);
				cardBtn[isOpen[1]].setEnabled(false);
			}
			else
			{
				cardBtn[isOpen[0]].setEnabled(true);
				cardBtn[isOpen[1]].setEnabled(true);
				
				TimerTask m_task = new TimerTask() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						cardPanel[0].add(back0);
						cardPanel[1].add(back1);
						cardPanel[2].add(back2);
						cardPanel[3].add(back3);
						cardPanel[4].add(back4);
						cardPanel[5].add(back5);
						cardPanel[6].add(back6);
						cardPanel[7].add(back7);
						cardPanel[8].add(back8);
						System.out.print("timer");
						back0.repaint();
						back1.repaint();
						back2.repaint();
						back3.repaint();
						back4.repaint();
						back5.repaint();
						back6.repaint();
						back7.repaint();
						back8.repaint();
					}
				};
				m_timer.schedule(m_task, 2000);
			}
			isOpen[0] = isOpen[1] = -1;
		}
    }
	
	public void ResetCardBtn()
	{
		for(int i = 0; i < 9; i++)
		{
			cardBtn[i].setEnabled(true);
		}
		isOpen[0] = isOpen[1] = -1;
	}
	
	public void ResetCardImg()
	{
		
	}
    private class ButtonListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e) {
          Object obj1 = e.getSource();
          if(obj1 == btnHome) {
        	  ResetCardBtn();
             cardLayout.show(mainPanel,"Home");
          }
          
          if(obj1 == cardBtn[0])
		   {
        	  //cardPanel[0].add(front0);
        	  //front0.repaint();
        	  InputCard(0);
        	  MatchCard();
		   }
		   if(obj1 == cardBtn[1])
		   {
			   InputCard(1);
			   MatchCard();
		   }
		   if(obj1 == cardBtn[2])
		   {
			   InputCard(2);
			   MatchCard();
		   }
		   
		   if(obj1 == cardBtn[3])
		   {
			   InputCard(3);
			   MatchCard();
		   }
		   if(obj1 == cardBtn[4])
		   {
			   InputCard(4);
			   MatchCard();
		   }
		   if(obj1 == cardBtn[5])
		   {
			   InputCard(5);
			   MatchCard();
		   }
		   
		   if(obj1 == cardBtn[6])
		   {
			   InputCard(6);
			   MatchCard();
		   }
		   if(obj1 == cardBtn[7])
		   {
			   InputCard(7);
			   MatchCard();
		   }
		   if(obj1 == cardBtn[8])
		   {
			   InputCard(8);
			   MatchCard();
		   }

       }
    }      
}
