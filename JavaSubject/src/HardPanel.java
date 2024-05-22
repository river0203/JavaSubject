import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class HardPanel extends JPanel
{
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
		
		lbllevel = new JLabel("HARD LEVEL");
		lbllevel.setBounds(200,10,200,50);
		lbllevel.setFont(new Font("Verdana",Font.BOLD,25));
		add(lbllevel);
	
		
		btnHome = new JButton("Home");
		btnHome.setBounds(30,60,70,50);
		btnHome.setFont(new Font("Verdana",Font.BOLD,15));
		btnHome.setBackground(new Color(176,224,230));
		btnHome.addActionListener(btnL);
		add(btnHome);
		
		
		
		btnHint = new JButton("HINT");
		btnHint.setBounds(500,60,70,50);
		btnHint.setFont(new Font("Verdana",Font.BOLD,15));
		btnHint.setBackground(new Color(176,224,230));
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