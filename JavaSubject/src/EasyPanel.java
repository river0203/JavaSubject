import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class EasyPanel extends JPanel {
	   private JLabel lblTitle;
	   private JButton btnHome, btnHint;
	   private JPanel mainPanel;
	   private CardLayout cardLayout;
	   private ButtonListener btnL;
	   
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
	   
	   static private String[] btnTxt = {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8","b9"};
	   static private JButton[] cardBtn = new JButton[9];
	   
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
	   }
	   private class ButtonListener implements ActionListener
	   {
		   public void actionPerformed(ActionEvent e) {
			   Object obj = e.getSource();
			   if(obj == btnHome) {
				   cardLayout.show(mainPanel,"Home");
			   }
			   else if(obj == cardBtn[1])
			   {
				   System.out.print("HI");
			   }
		   }
	   }
	      
}
