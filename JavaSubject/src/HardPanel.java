import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class HardPanel extends JPanel
{
	   private JPanel topPanel, bottomPanel;
	   private JLabel lbllevel, lbllife;
	   private JButton btnHint, btnHome;
	   private JPanel mainPanel;
	   private CardLayout cardLayout;
	   private ButtonListener btnL;
	   
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
	      
	      lbllevel = new JLabel("HARD LEVEL");
	      lbllevel.setBounds(200,10,200,50);
	      lbllevel.setFont(new Font("Verdana",Font.BOLD,25));
	      topPanel.add(lbllevel);
	   
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