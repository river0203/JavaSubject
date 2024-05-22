import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class EasyPanel extends JPanel {
	   private JLabel lblTitle;
	   private JButton btnHome, btnHint;
	   private JPanel mainPanel;
<<<<<<< HEAD
=======
	   private Image questCard;
>>>>>>> 05b8a4a882f7b3f6dbce6bc1019208e5b6c0e437
	   private CardLayout cardLayout;

	   
	   private ButtonListener btnL;
	   
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
	      
<<<<<<< HEAD

=======
	      ImageIcon cardImage = new ImageIcon("ImageRescource/Level1Back.jpg");
	      cardImage = questCard.getImage();
>>>>>>> 05b8a4a882f7b3f6dbce6bc1019208e5b6c0e437
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
