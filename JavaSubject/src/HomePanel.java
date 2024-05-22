import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class HomePanel extends JPanel {
    private JLabel lblTitle1, lblTitle2, lblTitle3;
    private JButton btnStart, btnHow;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private ButtonListener btnL;
    
    public HomePanel(JPanel mainPanel, CardLayout cardLayout) {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;
        
        setPreferredSize(new Dimension(600, 700));
        setBackground(Color.white);
        setLayout(null);
        
        btnL = new ButtonListener();
        
        lblTitle1 = new JLabel("FIND");
        lblTitle1.setBounds(260, 170, 200, 50);
        lblTitle1.setFont(new Font("Verdana", Font.BOLD, 30));
        lblTitle1.setVerticalAlignment(SwingConstants.BOTTOM);
        lblTitle1.setHorizontalTextPosition(SwingConstants.CENTER);
        add(lblTitle1);
        
        lblTitle2 = new JLabel("THE SAME");
        lblTitle2.setBounds(225, 230, 200, 50);
        lblTitle2.setFont(new Font("Verdana", Font.BOLD, 30));
        lblTitle2.setVerticalAlignment(SwingConstants.BOTTOM);
        lblTitle2.setHorizontalTextPosition(SwingConstants.CENTER);
        add(lblTitle2);
        
        lblTitle3 = new JLabel("CARD");
        lblTitle3.setBounds(260, 290, 200, 50);
        lblTitle3.setFont(new Font("Verdana", Font.BOLD, 30));
        lblTitle3.setVerticalAlignment(SwingConstants.BOTTOM);
        lblTitle3.setHorizontalTextPosition(SwingConstants.CENTER);
        add(lblTitle3);
        
        btnStart = new JButton("START");
        btnStart.setBounds(40, 500, 100, 50);
        btnStart.setFont(new Font("Verana", Font.BOLD, 20));
        btnStart.setBackground(Color.white);
        btnStart.addActionListener(btnL);
        add(btnStart);
        
        btnHow = new JButton("HOW");
        btnHow.setBounds(450, 500, 100, 50);
        btnHow.setFont(new Font("Verana", Font.BOLD, 20));
        btnHow.setBackground(Color.white);
        add(btnHow);
    }
    private class ButtonListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e) {
    		Object obj = e.getSource();
    		if(obj == btnStart) {
    			cardLayout.show(mainPanel,"LevelChoice");
    		}
    		
    	}
    }
}
