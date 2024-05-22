import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class RegularPanel extends JPanel
{
   private JLabel lblTitle;
   private JButton btnHome, btnHint;
   private JPanel mainPanel;
   private CardLayout cardLayout;
   
   private ButtonListener btnL;
   
   public RegularPanel(JPanel mainPanel,CardLayout cardLayout ) {
	  this.mainPanel = mainPanel;
	  this.cardLayout = cardLayout;
	  
	  btnL = new ButtonListener();
      setPreferredSize(new Dimension(600, 700));
      setBackground(Color.white);
      setLayout(null);
      
      
      lblTitle = new JLabel("REGULA LEVEL");
      lblTitle.setBounds(200, 10, 200, 50);
      lblTitle.setFont(new Font("Verdana", Font.BOLD, 24));
      lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
      lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
      add(lblTitle);
      
      btnHome = new JButton ("HOME");
      btnHome.setBounds(40, 60, 100, 50);
      btnHome.setFont(new Font("Verana", Font.BOLD, 20));
      btnHome.setBackground(new Color(250, 239, 110));
      btnHome.addActionListener(btnL);
      add(btnHome);
      
      btnHint = new JButton ("HINT");
      btnHint.setBounds(450, 60, 100, 50);
      btnHint.setFont(new Font("Verana", Font.BOLD, 20));
      btnHint.setBackground(new Color(250, 239, 110));
      add(btnHint);
      
      
   }
   private class ButtonListener implements ActionListener
   {
	   public void actionPerformed(ActionEvent e) {
		   Object obj = e.getSource();
		   if(obj == btnHome) {
			   cardLayout.show(mainPanel,"Home");
		   }
	   }
   }
}