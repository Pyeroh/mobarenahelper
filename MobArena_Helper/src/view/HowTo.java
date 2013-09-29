package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JWindow;

public class HowTo extends JWindow {
	
	private static final long serialVersionUID = 1132162114547728162L;
	private JLabel lib_HowToUse;
	private JTextPane lib_howto2;
	
	private MenuPrincipal menu;
	private JButton btn_ok;
	
	public HowTo(MenuPrincipal menu) {
		
		this.menu = menu;
		
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		lib_HowToUse = new JLabel("How to use the MobArena Helper ?");
		lib_HowToUse.setBackground(new Color(255, 255, 255));
		lib_HowToUse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lib_HowToUse.setBounds(10, 11, 287, 19);
		getContentPane().add(lib_HowToUse);
		
		lib_howto2 = new JTextPane();
		lib_howto2.setEditable(false);
		lib_howto2.setText("First, you just have to click on the load button, and search your config file. \r\nThe waves should appear in the lists, then you left-click on it to load it in the right part of the screen.\r\n\r\nYou can change the name of the wave, its category, its type, and every other data linked to it. Moreover, if you try a invalid action, generally, it is blocked by the application (but the soft is not exempt from bugs, so feel free to report them, see the link in About section).\r\n\r\nTo remove a wave, or a monster or an ability, you can middle-click on it, a confirmation pop-up will appear.\r\n\r\nFinally, you can save your work by clicking on Save Config as...\r\nYou're done !");
		lib_howto2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lib_howto2.setBounds(10, 41, 414, 231);
		getContentPane().add(lib_howto2);
		
		btn_ok = new JButton("OK");
		btn_ok.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				activate();
				setVisible(false);
			}
		});
		btn_ok.setBounds(377, 284, 47, 23);
		getContentPane().add(btn_ok);
		
		setSize(437,317);
		Rectangle d = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		setLocation((d.width-getWidth())/2, (d.height-getHeight())/2);
		setVisible(true);
	}
	
	private void activate(){
		menu.setEnabled(true);
	}
}
