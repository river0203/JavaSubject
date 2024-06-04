import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

class HardPanel extends JPanel
{
   static private String[] btnTxt = {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10", "b11", "b12", "b13", "b14", "b15", "b16"};
   static private JButton[] cardBtn = new JButton[16];
   static private JPanel[] cardPanel = new JPanel[16];
   static private JPanel[] cardbackPanel = new JPanel[16];
   
    
   private Card gameCard = new Card();
   private Timer m_timer = new Timer();
   
   private int[] selectCard = new int[16];
   private int[] openIndex = {-1, -1};
   private boolean isMatch = false;
   private int[] aryOpenCardIndex = {0, 0}; 
   
   private ImagePanel imagePanel;
   private JPanel topPanel, bottomPanel;
   private JLabel lblTitle;
   private JButton btnHome, btnHint;
   private JPanel mainPanel;
   private CardLayout cardLayout;
   private ButtonListener btnL;
   private int presentLife = 5;  //gameCard.getGameLifer();
   
   ImagePanel back0 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back1 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back2 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back3 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back4 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back5 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back6 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back7 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back8 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back9 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back10 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back11 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back12 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back13 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back14 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());
   ImagePanel back15 = new ImagePanel(new ImageIcon("./src/image/hardPanel.jpg").getImage());

   

   ImagePanel front0 = new ImagePanel(new ImageIcon("./src/image/angry.jpg").getImage());
   ImagePanel front1 = new ImagePanel(new ImageIcon("./src/image/happy.jpg").getImage());
   ImagePanel front2 = new ImagePanel(new ImageIcon("./src/image/oh.jpg").getImage());
   ImagePanel front3 = new ImagePanel(new ImageIcon("./src/image/sorry.jpg").getImage());
   ImagePanel front4 = new ImagePanel(new ImageIcon("./src/image/haha.jpg").getImage());
   ImagePanel front5 = new ImagePanel(new ImageIcon("./src/image/ap.jpg").getImage());
   ImagePanel front6 = new ImagePanel(new ImageIcon("./src/image/um.jpg").getImage());
   ImagePanel front7 = new ImagePanel(new ImageIcon("./src/image/find.jpg").getImage());

   
   public HardPanel(JPanel mainPanel,CardLayout cardLayout) {
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
      
      lblTitle = new JLabel("HARD LEVEL");
      lblTitle.setBounds(200,10,200,50);
      lblTitle.setFont(new Font("Verdana",Font.BOLD,25));
      topPanel.add(lblTitle);
   
      btnHome = new JButton("HOME");
      btnHome.setBounds(40,60,100,50);
      btnHome.setFont(new Font("Verdana",Font.BOLD,19));
      btnHome.setBackground(new Color(176,224,230));
      btnHome.addActionListener(btnL);
      topPanel.add(btnHome);
      
      btnHint = new JButton("HINT");
      btnHint.setBounds(450,60,100,50);
      btnHint.setFont(new Font("Verdana",Font.BOLD,20));
      btnHint.setBackground(new Color(176,224,230));
      topPanel.add(btnHint);
      
   
      for(int i = 0; i < 16; i++)
      {
         cardPanel[i] =  new JPanel();
         cardPanel[i].setLayout(null);
         bottomPanel.add(cardPanel[i]);
      }
   
      cardPanel[0].setBounds(100, 10, 60, 80);
      cardPanel[0].add(back0);
      cardPanel[1].setBounds(200, 10, 60, 80);
      cardPanel[1].add(back1);
      cardPanel[2].setBounds(300, 10, 60, 80);
      cardPanel[2].add(back2);
      cardPanel[3].setBounds(400, 10, 60, 80);
      cardPanel[3].add(back3);
      cardPanel[4].setBounds(100, 130, 60, 80);
      cardPanel[4].add(back4);
      cardPanel[5].setBounds(200, 130, 60, 80);
      cardPanel[5].add(back5);
      cardPanel[6].setBounds(300, 130, 60, 80);
      cardPanel[6].add(back6);
      cardPanel[7].setBounds(400, 130, 60, 80);
      cardPanel[7].add(back7);
      cardPanel[8].setBounds(100, 250, 60, 80);
      cardPanel[8].add(back8);
      cardPanel[9].setBounds(200, 250, 60, 80);
      cardPanel[9].add(back9);
      cardPanel[10].setBounds(300, 250, 60, 80);
      cardPanel[10].add(back10);
      cardPanel[11].setBounds(400, 250, 60, 80);
      cardPanel[11].add(back11);
      cardPanel[12].setBounds(100, 370, 60, 80);
      cardPanel[12].add(back12);
      cardPanel[13].setBounds(200, 370, 60, 80);
      cardPanel[13].add(back13);
      cardPanel[14].setBounds(300, 370, 60, 80);
      cardPanel[14].add(back14);
      cardPanel[15].setBounds(400, 370, 60, 80);
      cardPanel[15].add(back15);


   
      for(int i = 0; i < 16; i++)
      {
         cardBtn[i] = new JButton(btnTxt[i]);
         cardBtn[i].setVisible(true);
         cardBtn[i].addActionListener(btnL);
         bottomPanel.add(cardBtn[i]);
      }
      
      cardBtn[0].setBounds(100, 90, 50, 30);
      cardBtn[1].setBounds(200, 90, 50, 30);
      cardBtn[2].setBounds(300, 90, 50, 30);  
      cardBtn[3].setBounds(400, 90, 50, 30);
      
      cardBtn[4].setBounds(100, 210, 50, 30);
      cardBtn[5].setBounds(200, 210, 50, 30);
      cardBtn[6].setBounds(300, 210, 50, 30);
      cardBtn[7].setBounds(400, 210, 50, 30);
      
      cardBtn[8].setBounds(100, 330, 60, 30);
      cardBtn[9].setBounds(200, 330, 60, 30);
      cardBtn[10].setBounds(300, 330, 60, 30);
      cardBtn[11].setBounds(400, 330, 60, 30);
      
      cardBtn[12].setBounds(100, 450, 60, 30);
      cardBtn[13].setBounds(200, 450, 60, 30);
      cardBtn[14].setBounds(300, 450, 60, 30);
      cardBtn[15].setBounds(400, 450, 60, 30);
   
       for (int i = 0; i < 12; i++) {
           selectCard[i] = gameCard.getCardCode1(i, "hard");
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
             else if(selectCard[openIndex[1]] == 4)
             {
                cardPanel[btnNum].add(front4);
                     front4.repaint();
             }
             else if(selectCard[openIndex[1]] == 5)
             {
                cardPanel[btnNum].add(front5);
                     front5.repaint();
             }
             else if(selectCard[openIndex[1]] == 6)
             {
                cardPanel[btnNum].add(front6);
                     front6.repaint();
             }
             else if(selectCard[openIndex[1]] == 7)
             {
                cardPanel[btnNum].add(front7);
                     front7.repaint();
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
             else if(selectCard[openIndex[0]] == 4)
             {
                cardPanel[btnNum].add(front4);
                     front4.repaint();
             }
             else if(selectCard[openIndex[0]] == 5)
             {
                cardPanel[btnNum].add(front5);
                     front5.repaint();
             }
             else if(selectCard[openIndex[0]] == 6)
             {
                cardPanel[btnNum].add(front6);
                     front6.repaint();
             }
             else if(selectCard[openIndex[0]] == 7)
             {
                cardPanel[btnNum].add(front7);
                     front7.repaint();
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
                  cardPanel[12].add(back12);
                  cardPanel[13].add(back13);
                  cardPanel[14].add(back14);
                  cardPanel[15].add(back15);
                  
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
                  back12.repaint();
                  back13.repaint();
                  back14.repaint();
                  back15.repaint();
                  
               }
            };
            m_timer.schedule(m_task, 2000);
         }
         openIndex[0] = openIndex[1] = -1;
      }
    }


   public void ResetCardBtn()
   {
     
      for(int i = 0; i < 16; i++)
      {
         cardBtn[i].setEnabled(true);
      }
      openIndex[0] = openIndex[1] = -1;
      
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
            if(obj1 == cardBtn[9])
            {
               InputCard(9);
                MatchCard();
            }
            if(obj1 == cardBtn[10])
            {
               InputCard(10);
                MatchCard();
            }
            if(obj1 == cardBtn[11])
            {
               InputCard(11);
                MatchCard();
            }
            if(obj1 == cardBtn[12])
            {
               InputCard(12);
                MatchCard();
            }
            if(obj1 == cardBtn[13])
            {
               InputCard(13);
                MatchCard();
            }
            if(obj1 == cardBtn[14])
            {
               InputCard(14);
                MatchCard();
            }
            if(obj1 == cardBtn[15])
            {
               InputCard(15);
                MatchCard();
            }
      }
   }      
}