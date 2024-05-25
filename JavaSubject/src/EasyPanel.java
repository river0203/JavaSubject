import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

class EasyPanel extends JPanel {
	static private String[] btnTxt = {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8","b9"};
	static private JButton[] cardBtn = new JButton[9];
	static private JPanel[] cardPanel = new JPanel[9];
	private Card gameCard = new Card();
	
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
       cardPanel[0].setBackground(new Color(170, 240, 180));
	   cardPanel[1].setBounds(140+100, 10, 60, 80);
	   cardPanel[1].setBackground(new Color(170, 240, 180));
	   cardPanel[2].setBounds(140+(100*2), 10, 60, 80);
	   cardPanel[2].setBackground(new Color(170, 240, 180));
	   cardPanel[3].setBounds(140, 10+180, 60, 80);
	   cardPanel[3].setBackground(new Color(170, 240, 180));
	   cardPanel[4].setBounds(140+100, 10+180, 60, 80);
	   cardPanel[4].setBackground(new Color(170, 240, 180));
	   cardPanel[5].setBounds(140+(100*2), 10+180, 60, 80);
	   cardPanel[5].setBackground(new Color(170, 240, 180));
	   cardPanel[6].setBounds(140, 10+(180*2), 60, 80);
	   cardPanel[6].setBackground(new Color(170, 240, 180));
	   cardPanel[7].setBounds(140+100, 10+(180*2), 60, 80);
	   cardPanel[7].setBackground(new Color(170, 240, 180));
	   cardPanel[8].setBounds(140+(100*2), 10+(180*2), 60, 80);
	   cardPanel[8].setBackground(new Color(170, 240, 180));
	      
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
	   
	   selectCard[0] = gameCard.getCardCode1(0, 0);
	   selectCard[1] = gameCard.getCardCode1(0, 1);
	   selectCard[2] = gameCard.getCardCode1(0, 2);
	   selectCard[3] = gameCard.getCardCode1(1, 0);
	   selectCard[4] = gameCard.getCardCode1(1, 1);
	   selectCard[5] = gameCard.getCardCode1(1, 2);
	   selectCard[6] = gameCard.getCardCode1(2, 0); 
	   selectCard[7] = gameCard.getCardCode1(2, 1);
	   selectCard[8] = gameCard.getCardCode1(2, 2);
	      
    }
    public void InputCard(int btnNum)
    {
    	if(isOpen[0] != (-1))
    	{
    		isOpen[1] = btnNum;
    		cardBtn[isOpen[1]].setEnabled(false);
    	}
    	else
    	{
    		isOpen[0] = btnNum;
    		cardBtn[isOpen[0]].setEnabled(false);
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
