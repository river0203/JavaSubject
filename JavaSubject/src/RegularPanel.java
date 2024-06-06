import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

class RegularPanel extends JPanel
{
   static private String[] btnTxt = {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8","b9","b10", "b11","b12"};
   static private JButton[] cardBtn = new JButton[12];
   static private JPanel[] cardPanel = new JPanel[12];
   static private JPanel[] cardbackPanel = new JPanel[12];
   private Card gameCard = new Card();
   private Timer m_timer = new Timer();
   
   //move to Class Card
   private int[] selectCard = new int[12];
   private int[] openIndex = {-1, -1};
   private boolean isMatch = false;
   private int[] aryOpenCardIndex = {0, 0}; 
      
   private ImagePanel imagePanel;
   private JPanel topPanel, bottomPanel;
   private JLabel lblTitle,lblLife, lblLife2;
   private JButton btnHome, btnHint;
   private JPanel mainPanel;
   private CardLayout cardLayout;
    private ButtonListener btnL;
    private int presentLife = 4;
    
    ImagePanel back0 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_back.jpg").getImage());
   ImagePanel back1 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_back.jpg").getImage());
   ImagePanel back2 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_back.jpg").getImage());
   ImagePanel back3 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_back.jpg").getImage());
   ImagePanel back4 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_back.jpg").getImage());
   ImagePanel back5 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_back.jpg").getImage());
   ImagePanel back6 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_back.jpg").getImage());
   ImagePanel back7 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_back.jpg").getImage());
   ImagePanel back8 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_back.jpg").getImage());
   ImagePanel back9 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_back.jpg").getImage());
   ImagePanel back10 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_back.jpg").getImage());
   ImagePanel back11 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_back.jpg").getImage());
   ImagePanel back12 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_back.jpg").getImage());
       
   ImagePanel front0 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Leve2_0.jpg").getImage());
   ImagePanel front1 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_1.jpg").getImage());
   ImagePanel front2 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_2.jpg").getImage());
   ImagePanel front3 = new ImagePanel(new ImageIcon("/C:/Users/aspp3/OneDrive/문서/GitHub/JavaSubject/JavaSubject/src/Image/Level2_3.jpg").getImage());
      
   
    public RegularPanel(JPanel mainPanel,CardLayout cardLayout ) 
    {
       this.mainPanel = mainPanel;
       this.cardLayout = cardLayout;
       
       btnL = new ButtonListener();
       
       setPreferredSize(new Dimension(600, 700));
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

       lblLife = new JLabel();
       lblLife.setText(Integer.toString(presentLife));
       lblLife.setBounds(510,100,100,50);
       lblLife.setFont(new Font("Verdana", Font.BOLD, 19));
       lblLife.setBackground(new Color(255,199,199));
       topPanel.add(lblLife);
       
       lblLife2 = new JLabel("Life : ");
       lblLife2.setBounds(450,100,100,50);
       lblLife2.setFont(new Font("Verdana", Font.BOLD, 19));
       topPanel.add(lblLife2);
       
       lblTitle = new JLabel("REGULAR LEVEL");
       lblTitle.setBounds(200, 10, 200, 50);
       lblTitle.setFont(new Font("Verdana", Font.BOLD, 24));
       lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
       lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
       topPanel.add(lblTitle);
      
       btnHome = new JButton ("HOME");
       btnHome.setBounds(30, 60, 100, 50);
       btnHome.setFont(new Font("Verana", Font.BOLD, 20));
       btnHome.setBackground(new Color(250, 239, 110));
       btnHome.addActionListener(btnL);
       topPanel.add(btnHome);
       
       btnHint = new JButton ("HINT");
       btnHint.setBounds(450, 60, 100, 50);
       btnHint.setFont(new Font("Verana", Font.BOLD, 20));
       btnHint.setBackground(new Color(250, 239, 110));
       btnHint.addActionListener(btnL);
       topPanel.add(btnHint);
       
       for(int i = 0; i < 12; i++)
         {
            cardPanel[i] =  new JPanel();
             cardPanel[i].setLayout(null);
             bottomPanel.add(cardPanel[i]);
         }
         cardPanel[0].setBounds(110, 40, 60, 80);
         cardPanel[0].add(back0);
         cardPanel[1].setBounds(200, 40, 60, 80);
         cardPanel[1].add(back1);
         cardPanel[2].setBounds(290, 40, 60, 80);
         cardPanel[2].add(back2);
         cardPanel[3].setBounds(380, 40, 60, 80);
         cardPanel[3].add(back3);
         
         cardPanel[4].setBounds(110, 200, 60, 80);
         cardPanel[4].add(back4);
         cardPanel[5].setBounds(200, 200, 60, 80);
         cardPanel[5].add(back5);
         cardPanel[6].setBounds(290, 200, 60, 80);
         cardPanel[6].add(back6);
         cardPanel[7].setBounds(380, 200, 60, 80);
         cardPanel[7].add(back7);
         
         cardPanel[8].setBounds(110, 360, 60, 80);
         cardPanel[8].add(back8);
         cardPanel[9].setBounds(200, 360, 60, 80);
         cardPanel[9].add(back9);
         cardPanel[10].setBounds(290, 360, 60, 80);
         cardPanel[10].add(back10);
         cardPanel[11].setBounds(380, 360, 60, 80);
         cardPanel[11].add(back11);
         
         for(int i = 0; i < 12; i++)
         {
            cardBtn[i] = new JButton(btnTxt[i]);
            cardBtn[i].setVisible(true);
            cardBtn[i].addActionListener(btnL);
            bottomPanel.add(cardBtn[i]);
         }
            
         cardBtn[0].setBounds(118, 130, 50, 30);
         cardBtn[1].setBounds(208, 130, 50, 30);
         cardBtn[2].setBounds(298, 130, 50, 30);  
         cardBtn[3].setBounds(388, 130, 50, 30);
         
         cardBtn[4].setBounds(118, 290, 50, 30);
         cardBtn[5].setBounds(208, 290, 50, 30);
         cardBtn[6].setBounds(298, 290, 50, 30);
         cardBtn[7].setBounds(388, 290, 50, 30);
         
         cardBtn[8].setBounds(118, 450, 50, 30);
         cardBtn[9].setBounds(208, 450, 50, 30);
         cardBtn[10].setBounds(298, 450, 50, 30);
         cardBtn[11].setBounds(388, 450, 50, 30);  
         
         for (int i = 0; i < 12; i++) 
         {
               selectCard[i] = gameCard.getCardCode1(i, "regular");
         }
         
   }
    
    
   
    public void InputCard(int btnNum) {
         if(openIndex[0] != (-1))
          {
        	 openIndex[1] = btnNum;
             cardBtn[openIndex[1]].setEnabled(false);
             if(selectCard[openIndex[1]] == 0)
             {
                cardPanel[btnNum].add(front0);
                     front0.repaint();
             }
             else if(selectCard[openIndex[1]] == 1)
             {
                cardPanel[btnNum].add(front1);
                     front1.repaint();
             }
             else if(selectCard[openIndex[1]] == 2)
             {
                cardPanel[btnNum].add(front2);
                     front2.repaint();
             }
             else if(selectCard[openIndex[1]] == 3)
             {
                cardPanel[btnNum].add(front3);
                     front3.repaint();
             }
          }
          else
          {
        	  openIndex[0] = btnNum;
             cardBtn[openIndex[0]].setEnabled(false);
             if(selectCard[openIndex[0]] == 0)
             {
                cardPanel[btnNum].add(front0);
                     front0.repaint();
             }
             else if(selectCard[openIndex[0]] == 1)
             {
                cardPanel[btnNum].add(front1);
                     front1.repaint();
             }
             else if(selectCard[openIndex[0]] == 2)
             {
                cardPanel[btnNum].add(front2);
                     front2.repaint();
             }
             else if(selectCard[openIndex[0]] == 3)
             {
                cardPanel[btnNum].add(front3);
                     front3.repaint();
             }
          }
       }
    public void MatchCard()
      {
         if(openIndex[0] != (-1) && openIndex[1] != (-1))
            {
               if(selectCard[openIndex[0]] == selectCard[openIndex[1]])
               {
                  System.out.print("Match ");
                  cardBtn[openIndex[0]].setEnabled(false);
                  cardBtn[openIndex[1]].setEnabled(false);
               }
               else
               {
                  presentLife -=1;
                  if(presentLife == 0)
                  {
                  cardLayout.show(mainPanel,"Home");
                  }
                  cardBtn[openIndex[0]].setEnabled(true);
                  cardBtn[openIndex[1]].setEnabled(true);
                  
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
                         cardPanel[9].add(back9);
                         cardPanel[10].add(back10);
                         cardPanel[11].add(back11);
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
                         back9.repaint();
                         back10.repaint();
                         back11.repaint();
                      }
                   };
                   m_timer.schedule(m_task, 2000);
                }
               openIndex[0] = openIndex[1] = -1;
             }
           }
    
    public void end()
	{
		if(cardBtn[0].isEnabled() == false  && cardBtn[1].isEnabled() == false && cardBtn[2].isEnabled() == false && cardBtn[3].isEnabled() == false && cardBtn[4].isEnabled() == false && cardBtn[5].isEnabled() == false && cardBtn[6].isEnabled() == false && cardBtn[7].isEnabled() == false ) {
			presentLife= 3;
			cardPanel[0].setVisible(false);
      	    cardPanel[1].setVisible(false);
			cardPanel[2].setVisible(false);
			cardPanel[3].setVisible(false);
			cardPanel[4].setVisible(false);
			cardPanel[5].setVisible(false);
			cardPanel[6].setVisible(false);
			cardPanel[7].setVisible(false);
			  
			cardbackPanel[0].setVisible(true);
			cardbackPanel[1].setVisible(true);
			cardbackPanel[2].setVisible(true);
			cardbackPanel[3].setVisible(true);
			cardbackPanel[4].setVisible(true);
			cardbackPanel[5].setVisible(true);
			cardbackPanel[6].setVisible(true);
			cardbackPanel[7].setVisible(true);
			ResetCardBtn();
      	    lblLife.setText(Integer.toString(presentLife));

			cardLayout.show(mainPanel,"Home");
		}
	}
    
          public void ResetCardBtn()
          {
             for(int i = 0; i < 12; i++)
             {
                cardBtn[i].setEnabled(true);
             }
             openIndex[0] = openIndex[1] = -1;
          }
          
       
          private class ButtonListener implements ActionListener
          {
              public void actionPerformed(ActionEvent e) {
                  Object obj1 = e.getSource();
                  if (obj1 == btnHome) {
                      ResetCardBtn();
                      cardLayout.show(mainPanel, "Home");
                  } 
                  if(obj1 ==  btnHint)
                  {
                	  
                  }
                  for (int i = 0; i < cardBtn.length; i++) 
                  {
                      if (obj1 == cardBtn[i]) {
                          InputCard(i);
                          MatchCard();
                          end();
                      }
                  }
              }
         }
}