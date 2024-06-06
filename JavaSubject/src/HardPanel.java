import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;


class HardPanel extends JPanel
{
   static private String[] btnTxt = {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10", "b11", "b12", "b13", "b14", "b15", "b16"};
   static private JButton[] cardBtn = new JButton[16];
   static private JPanel[] cardPanel = new JPanel[16];
   static private JPanel[] cardbackPanel = new JPanel[16];
   
    
   private Card gameCard = new Card();
   private Timer m_timer = new Timer();
   
   
   private int[] selectCard = new int[16];
   private int[] isOpen = {-1, -1};
   private boolean isMatch = false;
   private int[] aryOpenCardIndex = {0, 0}; 
   
   private ImagePanel imagePanel;
   private JPanel topPanel, bottomPanel;
   private JLabel lblTitle, lblLife, lblLife2;
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
   ImagePanel front8 = new ImagePanel(new ImageIcon("./src/image/angry.jpg").getImage());
   ImagePanel front9 = new ImagePanel(new ImageIcon("./src/image/happy.jpg").getImage());
   ImagePanel front10 = new ImagePanel(new ImageIcon("./src/image/oh.jpg").getImage());
   ImagePanel front11 = new ImagePanel(new ImageIcon("./src/image/sorry.jpg").getImage());
   ImagePanel front12 = new ImagePanel(new ImageIcon("./src/image/haha.jpg").getImage());
   ImagePanel front13 = new ImagePanel(new ImageIcon("./src/image/ap.jpg").getImage());
   ImagePanel front14 = new ImagePanel(new ImageIcon("./src/image/um.jpg").getImage());
   ImagePanel front15 = new ImagePanel(new ImageIcon("./src/image/find.jpg").getImage());


   
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
         cardbackPanel[i] =  new JPanel();
         cardbackPanel[i].setLayout(null);
         cardPanel[i] = new JPanel();
         cardPanel[i].setLayout(null);
         bottomPanel.add(cardbackPanel[i]);
         bottomPanel.add(cardPanel[i]);
         
         cardPanel[i].setVisible(false);
      }
   
      cardbackPanel[0].setBounds(100, 10, 60, 80);
      cardbackPanel[0].add(back0);
      cardbackPanel[1].setBounds(200, 10, 60, 80);
      cardbackPanel[1].add(back1);
      cardbackPanel[2].setBounds(300, 10, 60, 80);
      cardbackPanel[2].add(back2);
      cardbackPanel[3].setBounds(400, 10, 60, 80);
      cardbackPanel[3].add(back3);
      cardbackPanel[4].setBounds(100, 130, 60, 80);
      cardbackPanel[4].add(back4);
      cardbackPanel[5].setBounds(200, 130, 60, 80);
      cardbackPanel[5].add(back5);
      cardbackPanel[6].setBounds(300, 130, 60, 80);
      cardbackPanel[6].add(back6);
      cardbackPanel[7].setBounds(400, 130, 60, 80);
      cardbackPanel[7].add(back7);
      cardbackPanel[8].setBounds(100, 250, 60, 80);
      cardbackPanel[8].add(back8);
      cardbackPanel[9].setBounds(200, 250, 60, 80);
      cardbackPanel[9].add(back9);
      cardbackPanel[10].setBounds(300, 250, 60, 80);
      cardbackPanel[10].add(back10);
      cardbackPanel[11].setBounds(400, 250, 60, 80);
      cardbackPanel[11].add(back11);
      cardbackPanel[12].setBounds(100, 370, 60, 80);
      cardbackPanel[12].add(back12);
      cardbackPanel[13].setBounds(200, 370, 60, 80);
      cardbackPanel[13].add(back13);
      cardbackPanel[14].setBounds(300, 370, 60, 80);
      cardbackPanel[14].add(back14);
      cardbackPanel[15].setBounds(400, 370, 60, 80);
      cardbackPanel[15].add(back15);


   
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
   
      
       for (int i = 0; i < 16; i++) {
           selectCard[i] = gameCard.getCardCode1(i, "Hard");
       }
       cardPanel[0].setBounds(100, 10, 60, 80);
       cardPanel[1].setBounds(200, 10, 60, 80);
       cardPanel[2].setBounds(300, 10, 60, 80);
       cardPanel[3].setBounds(400, 10, 60, 80);
       cardPanel[4].setBounds(100, 130, 60, 80);
       cardPanel[5].setBounds(200, 130, 60, 80);
       cardPanel[6].setBounds(300, 130, 60, 80);
       cardPanel[7].setBounds(400, 130, 60, 80);
       cardPanel[8].setBounds(100, 250, 60, 80);
       cardPanel[9].setBounds(200, 250, 60, 80);
       cardPanel[10].setBounds(300, 250, 60, 80);
       cardPanel[11].setBounds(400, 250, 60, 80);
       cardPanel[12].setBounds(100, 370, 60, 80);
       cardPanel[13].setBounds(200, 370, 60, 80);
       cardPanel[14].setBounds(300, 370, 60, 80);
       cardPanel[15].setBounds(400, 370, 60, 80);
      
       
      }
   
   public void InputCard(int btnNum) 
   {
         if(isOpen[0] != (-1))
          {
             isOpen[1] = btnNum;
             cardBtn[isOpen[1]].setEnabled(false);
             if(selectCard[isOpen[1]] == 0)
             {
                  cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front0);
                     front0.repaint();
                     cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 1)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front1);
                     front1.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 2)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front2);
                     front2.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 3)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front3);
                     front3.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 4)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front4);
                     front4.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 5)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front5);
                     front5.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 6)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front6);
                     front6.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 7)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front7);
                     front7.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             /*
             else if(selectCard[isOpen[1]] == 8)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front8);
                     front8.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 9)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front9);
                     front9.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 10)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front10);
                     front10.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 11)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front11);
                     front11.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 12)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front12);
                     front12.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 13)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front13);
                     front13.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 14)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front14);
                     front14.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[1]] == 15)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front15);
                     front15.repaint();
                    cardPanel[btnNum].setVisible(true);
             }*/
      
          }
          else
          {
             isOpen[0] = btnNum;
             cardBtn[isOpen[0]].setEnabled(false);
             if(selectCard[isOpen[0]] == 0)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front8);
                     front8.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[0]] == 1)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front9);
                     front9.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[0]] == 2)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front10);
                     front10.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[0]] == 3)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front11);
                     front11.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[0]] == 4)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front12);
                     front12.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[0]] == 5)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front13);
                     front13.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[0]] == 6)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front14);
                     front14.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             else if(selectCard[isOpen[0]] == 7)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front15);
                     front15.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             /*
             else if(selectCard[isOpen[0]] == 8)
             {
                cardbackPanel[btnNum].setVisible(false);
                cardPanel[btnNum].add(front9);
                     front9.repaint();
                    cardPanel[btnNum].setVisible(true);
             }
             
             else if(selectCard[isOpen[0]] == 9)
             {
                cardPanel[btnNum].add(front9);
                     front9.repaint();
             }
             else if(selectCard[isOpen[0]] == 10)
             {
                cardPanel[btnNum].add(front10);
                     front10.repaint();
             }
             else if(selectCard[isOpen[0]] == 11)
             {
                cardPanel[btnNum].add(front11);
                     front11.repaint();
             }
             else if(selectCard[isOpen[0]] == 12)
             {
                cardPanel[btnNum].add(front12);
                     front12.repaint();
             }
             else if(selectCard[isOpen[0]] == 13)
             {
                cardPanel[btnNum].add(front13);
                     front13.repaint();
             }
             else if(selectCard[isOpen[0]] == 14)
             {
                cardPanel[btnNum].add(front14);
                     front14.repaint();
             }
             else if(selectCard[isOpen[0]] == 15)
             {
                cardPanel[btnNum].add(front15);
                     front15.repaint();
             }
              */
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
            cardbackPanel[isOpen[0]].setVisible(false);
            cardbackPanel[isOpen[1]].setVisible(false);
            cardPanel[isOpen[0]].setVisible(true);
            cardPanel[isOpen[1]].setVisible(true);
         }
         else
         {
            cardBtn[isOpen[0]].setEnabled(true);
            cardBtn[isOpen[1]].setEnabled(true);
            presentLife -=1;
            lblLife.setText(Integer.toString(presentLife));
            if(presentLife == 0)
            {
               ResetCardBtn();
               presentLife = 5;
               lblLife.setText(Integer.toString(presentLife));
               cardLayout.show(mainPanel,"Home");
            }
            
            
            TimerTask m_task = new TimerTask() {

               @Override
               public void run() {
                  // TODO Auto-generated method stub
                  
                  for(int i = 0; i < 16; i++) {
                     if(cardBtn[i].isEnabled() == true )
                     {
                        cardPanel[i].setVisible(false);
                     }
                     
                  }
                  
                  
                  
                  
                  
                  System.out.print("timer");
                  
                  for(int i = 0; i < 16; i++) {
                     if(cardBtn[i].isEnabled() == true )
                     {
                        cardbackPanel[i].setVisible(true);
                     }
                     
                  }
                  
                  
               }
            };
            m_timer.schedule(m_task, 200);
         }
         isOpen[0] = isOpen[1] = -1;
      }
    }
   
   public void end()
   {
      if(cardBtn[0].isEnabled() == false  && cardBtn[1].isEnabled() == false && cardBtn[2].isEnabled() == false && cardBtn[3].isEnabled() == false && cardBtn[4].isEnabled() == false && cardBtn[5].isEnabled() == false && cardBtn[6].isEnabled() == false && cardBtn[7].isEnabled() == false ) {
         presentLife= 5;
         cardPanel[0].setVisible(false);
             cardPanel[1].setVisible(false);
         cardPanel[2].setVisible(false);
         cardPanel[3].setVisible(false);
         cardPanel[4].setVisible(false);
         cardPanel[5].setVisible(false);
         cardPanel[6].setVisible(false);
         cardPanel[7].setVisible(false);
         cardPanel[8].setVisible(false);
             cardPanel[9].setVisible(false);
         cardPanel[10].setVisible(false);
         cardPanel[11].setVisible(false);
         cardPanel[12].setVisible(false);
         cardPanel[13].setVisible(false);
         cardPanel[14].setVisible(false);
         cardPanel[15].setVisible(false);
           
         cardbackPanel[0].setVisible(true);
         cardbackPanel[1].setVisible(true);
         cardbackPanel[2].setVisible(true);
         cardbackPanel[3].setVisible(true);
         cardbackPanel[4].setVisible(true);
         cardbackPanel[5].setVisible(true);
         cardbackPanel[6].setVisible(true);
         cardbackPanel[7].setVisible(true);
         cardbackPanel[8].setVisible(true);
         cardbackPanel[9].setVisible(true);
         cardbackPanel[10].setVisible(true);
         cardbackPanel[11].setVisible(true);
         cardbackPanel[12].setVisible(true);
         cardbackPanel[13].setVisible(true);
         cardbackPanel[14].setVisible(true);
         cardbackPanel[15].setVisible(true);
         ResetCardBtn();
             lblLife.setText(Integer.toString(presentLife));

         cardLayout.show(mainPanel,"Home");
      }
   }

   public void ResetCardBtn()
   {
     
      for(int i = 0; i < 16; i++)
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
             presentLife = 5;
            
             cardPanel[0].setVisible(false);
             cardPanel[1].setVisible(false);
           cardPanel[2].setVisible(false);
           cardPanel[3].setVisible(false);
           cardPanel[4].setVisible(false);
           cardPanel[5].setVisible(false);
           cardPanel[6].setVisible(false);
           cardPanel[7].setVisible(false);
             cardPanel[8].setVisible(false);
             cardPanel[9].setVisible(false);
           cardPanel[10].setVisible(false);
           cardPanel[11].setVisible(false);
           cardPanel[12].setVisible(false);
           cardPanel[13].setVisible(false);
           cardPanel[14].setVisible(false);
           cardPanel[15].setVisible(false);
           
           cardbackPanel[0].setVisible(true);
           cardbackPanel[1].setVisible(true);
           cardbackPanel[2].setVisible(true);
           cardbackPanel[3].setVisible(true);
           cardbackPanel[4].setVisible(true);
           cardbackPanel[5].setVisible(true);
           cardbackPanel[6].setVisible(true);
           cardbackPanel[7].setVisible(true);
           cardbackPanel[8].setVisible(true);
           cardbackPanel[9].setVisible(true);
           cardbackPanel[10].setVisible(true);
           cardbackPanel[11].setVisible(true);
           cardbackPanel[12].setVisible(true);
           cardbackPanel[13].setVisible(true);
           cardbackPanel[14].setVisible(true);
           cardbackPanel[15].setVisible(true);
           ResetCardBtn();
             lblLife.setText(Integer.toString(presentLife));
              cardLayout.show(mainPanel,"Home");
          }
          
          if(obj1 == btnHint) {
             
             
          }
          if(obj1 == cardBtn[0])
         {
             
             InputCard(0);
             MatchCard();
             end();
         }
         if(obj1 == cardBtn[1])
         {
            InputCard(1);
            MatchCard();
            end();
         }
         if(obj1 == cardBtn[2])
         {
            InputCard(2);
            MatchCard();
            end();
         }
         
         if(obj1 == cardBtn[3])
         {
            InputCard(3);
            MatchCard();
            end();
         }
         if(obj1 == cardBtn[4])
         {
            InputCard(4);
            MatchCard();
            end();
         }
         if(obj1 == cardBtn[5])
         {
            InputCard(5);
            MatchCard();
            end();
         }
         
         if(obj1 == cardBtn[6])
         {
            InputCard(6);
            MatchCard();
            end();
         }
         if(obj1 == cardBtn[7])
         {
            InputCard(7);
            MatchCard();
            end();
         }
         if(obj1 == cardBtn[8])
         {
            InputCard(8);
            MatchCard();
            end();
         }
         if(obj1 == cardBtn[9])
         {
            InputCard(9);
            MatchCard();
            end();
         }
         if(obj1 == cardBtn[10])
         {
            InputCard(10);
            MatchCard();
            end();
         }
         if(obj1 == cardBtn[11])
         {
            InputCard(11);
            MatchCard();
            end();
         }
         if(obj1 == cardBtn[12])
         {
            InputCard(12);
            MatchCard();
            end();
         }
         if(obj1 == cardBtn[13])
         {
            InputCard(13);
            MatchCard();
            end();
         }
         if(obj1 == cardBtn[14])
         {
            InputCard(14);
            MatchCard();
            end();
         }
         if(obj1 == cardBtn[15])
         {
            InputCard(15);
            MatchCard();
            end();
         }

       }
    }      
}