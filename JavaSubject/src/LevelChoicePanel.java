import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


class LevelChoicePanel extends JPanel {

    private JLabel lblTitle;
    private JButton btnEasy, btnRegular, btnHard, btnBack;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private ButtonListener btnL;
    
    public LevelChoicePanel(JPanel mainPanel, CardLayout cardLayout) {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;
       
        setPreferredSize(new Dimension(600, 700));
        setBackground(Color.white);
        setLayout(null);
        
      btnL = new ButtonListener();
        
        addMouseListener(btnL);
        
        lblTitle = new JLabel("LEVEL CHOICE");
        lblTitle.setBounds(200, 80, 200, 50);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 24));
        lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitle);
        
        btnEasy = new JButton("EASY");
        btnEasy.setBounds(200, 200, 200, 50);
        btnEasy.setFont(new Font("Verdana", Font.BOLD, 19));
        btnEasy.setBackground(new Color(255, 199, 199));
        btnEasy.addActionListener(btnL);
        add(btnEasy);
        
        btnRegular = new JButton("REGULAR");
        btnRegular.setBounds(200, 320, 200, 50);
        btnRegular.setFont(new Font("Verdana", Font.BOLD, 19));
        btnRegular.setBackground(new Color(250, 239, 110));
        btnRegular.addActionListener(btnL);
        add(btnRegular);
        
        btnHard = new JButton("HARD");
        btnHard.setBounds(200, 440, 200, 50);
        btnHard.setFont(new Font("Verdana", Font.BOLD, 19));
        btnHard.setBackground(new Color(176, 224, 230));
        btnHard.addActionListener(btnL);
        add(btnHard);
        
        btnBack = new JButton("BACK");
        btnBack.setBounds(28, 60, 100, 50);
        btnBack.setFont(new Font("Verdana", Font.BOLD, 19));
        btnBack.setBackground(Color.white);
        btnBack.addActionListener(btnL);
        btnBack.addMouseListener(btnL);
        add(btnBack);
    }
    private class ButtonListener implements ActionListener, MouseListener
    {
       public void actionPerformed(ActionEvent e) {
          Object obj = e.getSource();
          if(obj == btnEasy) {
             cardLayout.show(mainPanel,"EasyLevel");
          }
          else if(obj == btnRegular) {
             cardLayout.show(mainPanel,"RegularLevel");
          }
          else if(obj == btnHard) {
             cardLayout.show(mainPanel, "HardLevel");
          }
          else if(obj == btnBack) {
             cardLayout.show(mainPanel, "Home");
          }
       }
       public void mouseClicked(MouseEvent e) {}
      
      public void mousePressed(MouseEvent e) {} 
      
      public void mouseReleased(MouseEvent e) {}
      
      public void mouseEntered(MouseEvent e) {
         Object obj = e.getSource();
         if(obj == btnBack) {
            JButton btn = (JButton)obj;
            btnBack.setBackground(Color.black);
            btnBack.setForeground(Color.red);
         }
      }
      public void mouseExited(MouseEvent e) {
         Object obj = e.getSource();
         if(obj == btnBack) {         
            JButton btn = (JButton)e.getSource();
            btnBack.setBackground(Color.white);
            btnBack.setForeground(Color.black);
         }
      }
    }
}
