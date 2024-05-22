import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class LevelChoicePanel extends JPanel {
    private JLabel lblTitle;
    private JButton btnEasy, btnRegular, btnHard;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private ButtonListener btnL;

    public LevelChoicePanel(JPanel mainPanel, CardLayout cardLayout) {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;
        
        btnL = new ButtonListener();
        setPreferredSize(new Dimension(600, 700));
        setBackground(Color.white);
        setLayout(null);

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
    }
    private class ButtonListener implements ActionListener
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
    	}
    }
}
