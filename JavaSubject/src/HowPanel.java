import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class HowPanel extends JPanel {
   
   private JPanel mainPanel;
   private CardLayout cardLayout;
   private JLabel lblExplanchoicecard, lblExplanchoicecard2;
   private JLabel lblTitle, lblExplanchoicelevel,lblExplanchoicelevel2,lblExplanLife,lblExplanLife2,lblExplanchoicecard3;
   private JButton btnStart;
   private ButtonListener btnL;
      
   public HowPanel(JPanel mainPanel, CardLayout cardLayout) {
      
      this.mainPanel = mainPanel;
      this.cardLayout = cardLayout;
         
      btnL = new ButtonListener();
        
      addMouseListener(btnL);
      
      setPreferredSize(new Dimension(600,700));
      setBackground(Color.white);
      setLayout(null);
         
      lblTitle = new JLabel("GAME RULE");
      lblTitle.setBounds(200, 40, 200, 50);
      lblTitle.setFont(new Font("Verdana", Font.BOLD, 30));
      lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
      lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
      add(lblTitle);
          
      lblExplanchoicelevel = new JLabel("Press the Start button and select a level. " );
      lblExplanchoicelevel.setBounds(30,200,500,50);
      lblExplanchoicelevel.setFont(new Font("Verdana", Font.BOLD, 15));
      add(lblExplanchoicelevel);
          
      lblExplanchoicelevel2 = new JLabel("EASY LEVEL shows 3X3, 3 lives, 1 hint for 3 seconds.");
      lblExplanchoicelevel2.setBounds(30,250,500,50);
      lblExplanchoicelevel2.setFont(new Font("Verdana", Font.BOLD, 15));
      add(lblExplanchoicelevel2);
          
      lblExplanchoicecard = new JLabel("REGULAR LEVEL show 4 lives of 4X4 and 2 hints for 3 seconds. ");
      lblExplanchoicecard.setBounds(30,300,600,50);
      lblExplanchoicecard.setFont(new Font("Verdana", Font.BOLD, 15));
      add(lblExplanchoicecard);
          
      lblExplanchoicecard2 = new JLabel("HARD LEVEL shows 5X5, 5 lives, 3 hints for 3 seconds. ");
      lblExplanchoicecard2.setBounds(30,350,600,50);
      lblExplanchoicecard2.setFont(new Font("Verdana", Font.BOLD, 15));
      add(lblExplanchoicecard2);
      
      lblExplanchoicecard3 = new JLabel("You need to find two identical pictures.");
      lblExplanchoicecard3.setBounds(30,400,600,50);
      lblExplanchoicecard3.setFont(new Font("Verdana", Font.BOLD, 15));
      add(lblExplanchoicecard3);
          
      lblExplanLife = new JLabel("The game ends when you lose all your lives");
      lblExplanLife.setBounds(30,450,600,50);
      lblExplanLife.setFont(new Font("Verdana", Font.BOLD, 15));
      add(lblExplanLife);
          
      lblExplanLife2 = new JLabel("or when you put all your pairs together.");
      lblExplanLife2.setBounds(30,500,600,50);
      lblExplanLife2.setFont(new Font("Verdana", Font.BOLD, 15));
      add(lblExplanLife2);
          
      btnStart = new JButton("START");
      btnStart.setBounds(420, 120, 100, 50);
      btnStart.setFont(new Font("Verana", Font.BOLD, 20));
      btnStart.setBackground(Color.white);
      btnStart.addActionListener(btnL);
      btnStart.addMouseListener(btnL);
      add(btnStart);   
   }
   private class ButtonListener implements ActionListener, MouseListener
   {
      public void actionPerformed(ActionEvent e) {
         Object obj = e.getSource();
         if(obj == btnStart) {
            cardLayout.show(mainPanel,"LevelChoice");
            }
      }
      public void mouseClicked(MouseEvent e) {}
      
      public void mousePressed(MouseEvent e) {} 
      
      public void mouseReleased(MouseEvent e) {}
      
      public void mouseEntered(MouseEvent e) {
         Object obj = e.getSource();
         if(obj == btnStart) {
            JButton btn = (JButton)obj;
            btnStart.setBackground(Color.black);
            btnStart.setForeground(Color.red);
         }
      }
      public void mouseExited(MouseEvent e) {
         Object obj = e.getSource();
         if(obj == btnStart) {         
            JButton btn = (JButton)e.getSource();
            btnStart.setBackground(Color.white);
            btnStart.setForeground(Color.black);
         }
      }      
   }
}
