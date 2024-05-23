import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class EasyPanel extends JPanel {
	
	static private String[] btnTxt = {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8","b9"};
	static private JButton[] cardBtn = new JButton[9];
	private Card gameCard = new Card();
	
	private int selec1 = 0;
	private int selec2 = 0;
	private int selec3 = 0;
	private JLabel lblTitle;
	private JButton btnHome, btnHint;
	private JPanel mainPanel;
	private CardLayout cardLayout;
	private ButtonListener btnL;
	private int randomCardCode;
	private int[] selectCard = new int[9];

	
	   
	   // change to array
	private JPanel cardPanel1;
	private JPanel cardPanel2;
	private JPanel cardPanel3;
	private JPanel cardPanel4;
	private JPanel cardPanel5;
	private JPanel cardPanel6;
	private JPanel cardPanel7;
	private JPanel cardPanel8;
	private JPanel cardPanel9;
	private JPanel cardPanel10;
	private JPanel cardPanel11;
	private JPanel cardPanel12;
	   
	public EasyPanel(JPanel mainPanel, CardLayout cardLayout){
		this.mainPanel = mainPanel;
	    this.cardLayout = cardLayout;
	      
	    btnL = new ButtonListener();
	    setPreferredSize(new Dimension(600,700));
	    setBackground(Color.white);
	    setLayout(null);

	    lblTitle = new JLabel("EASY LEVEL");
	    lblTitle.setBounds(200, 10, 200, 50);
	    lblTitle.setFont(new Font("Verdana", Font.BOLD, 30));
	    lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
	    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
	    add(lblTitle);
	      
	      
	    btnHome = new JButton("HOME");
	    btnHome.setBounds(28, 60, 100, 50);
	    btnHome.setFont(new Font("Verdana", Font.BOLD, 19));
	    btnHome.setBackground(new Color(255,199,199));
	    btnHome.addActionListener(btnL);
	      
	    add(btnHome);
	      
	    btnHint = new JButton("HINT");
	    btnHint.setBounds(480, 60, 100, 50);
	    btnHint.setFont(new Font("Verdana", Font.BOLD, 19));
	    btnHint.setBackground(new Color(255,199,199));
	    add(btnHint);
	      
	      //cardPnaels
	      cardPanel1 =  new JPanel();
	      cardPanel1.setBounds(140, 160, 60, 80);
	      cardPanel1.setBackground(new Color(170, 240, 180));
	      cardPanel1.setLayout(null);
	      add(cardPanel1);
	      
	      cardPanel2 =  new JPanel();
	      cardPanel2.setBounds(140+100, 160, 60, 80);
	      cardPanel2.setBackground(new Color(170, 240, 180));
	      cardPanel2.setLayout(null);
	      add(cardPanel2);
	      
	      cardPanel3 =  new JPanel();
	      cardPanel3.setBounds(140+(100*2), 160, 60, 80);
	      cardPanel3.setBackground(new Color(170, 240, 180));
	      cardPanel3.setLayout(null);
	      add(cardPanel3);
	      
	      cardPanel4 =  new JPanel();
	      cardPanel4.setBounds(140, 160+180, 60, 80);
	      cardPanel4.setBackground(new Color(170, 240, 180));
	      cardPanel4.setLayout(null);
	      add(cardPanel4);
	      
	      cardPanel5 =  new JPanel();
	      cardPanel5.setBounds(140+100, 160+180, 60, 80);
	      cardPanel5.setBackground(new Color(170, 240, 180));
	      cardPanel5.setLayout(null);
	      add(cardPanel5);
	      
	      cardPanel6 =  new JPanel();
	      cardPanel6.setBounds(140+(100*2), 160+180, 60, 80);
	      cardPanel6.setBackground(new Color(170, 240, 180));
	      cardPanel6.setLayout(null);
	      add(cardPanel6);
	      
	      cardPanel7 =  new JPanel();
	      cardPanel7.setBounds(140, 160+(180*2), 60, 80);
	      cardPanel7.setBackground(new Color(170, 240, 180));
	      cardPanel7.setLayout(null);
	      add(cardPanel7);
	      
	      cardPanel8 =  new JPanel();
	      cardPanel8.setBounds(140+100, 160+(180*2), 60, 80);
	      cardPanel8.setBackground(new Color(170, 240, 180));
	      cardPanel8.setLayout(null);
	      add(cardPanel8);
	      
	      cardPanel9 =  new JPanel();
	      cardPanel9.setBounds(140+(100*2), 160+(180*2), 60, 80);
	      cardPanel9.setBackground(new Color(170, 240, 180));
	      cardPanel9.setLayout(null);
	      add(cardPanel9);
	      
	      for(int i = 0; i < 9; i++)
	      {
	    	  cardBtn[i] = new JButton(btnTxt[i]);
	    	  cardBtn[i].setVisible(true);
	    	  cardBtn[i].addActionListener(btnL);
	    	  add(cardBtn[i]);
	      }
	      
	      cardBtn[0].setBounds(145, 260, 50, 30);
	      cardBtn[1].setBounds(145+100, 260, 50, 30);
	      cardBtn[2].setBounds(145+200, 260, 50, 30);
	      
	      cardBtn[3].setBounds(145, 260+180, 50, 30);
	      cardBtn[4].setBounds(145+100, 260+180, 50, 30);
	      cardBtn[5].setBounds(145+200, 260+180, 50, 30);
	      
	      cardBtn[6].setBounds(145, 260+(180*2), 50, 30);
	      cardBtn[7].setBounds(145+100, 260+(180*2), 50, 30);
	      cardBtn[8].setBounds(145+200, 260+(180*2), 50, 30);
	      
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
	
	public void matchCard(int card1, int card2)
	{
		boolean cardCheck = false;
		
		if((selec1 + selec2) == 2 || (selec1 + selec3) == 2 || (selec2 + selec3) == 2)
		{
			if(selectCard[card1] == selectCard[card2])
			{
				System.out.print("Hi");
				//cardCheck = true;
			}
			selec1 = 0;
			selec2 = 0;
			selec3 = 0;
		}
		//return cardCheck;
	}

	private class ButtonListener implements ActionListener
	   {
		   public void actionPerformed(ActionEvent e) {
			   Object obj1 = e.getSource();
			   if(obj1 == btnHome) {
				   cardLayout.show(mainPanel,"Home");
			   }
			   
			   if(obj1 == cardBtn[0])
			   {
				   selec1 = 1;
				   matchCard(0, 2);
				   matchCard(0, 7);
			   }
			   if(obj1 == cardBtn[1])
			   {
				  
			   }
			   if(obj1 == cardBtn[2])
			   {
				  selec2 = 1;
				  matchCard(0, 2);
				  matchCard(2, 7);
			   }
			   
			   if(obj1 == cardBtn[3])
			   {
				  
				   
			   }
			   if(obj1 == cardBtn[4])
			   {
				   
				   
			   }
			   if(obj1 == cardBtn[5])
			   {
				  
				  
			   }
			   
			   if(obj1 == cardBtn[6])
			   {
				   

			   }
			   if(obj1 == cardBtn[7])
			   {
				   selec3 = 1;
				   matchCard(0, 7);
				   matchCard(2, 7);
			   }
			   if(obj1 == cardBtn[8])
			   {
				  

			   }
			   
		   }
	   }
	      
}
