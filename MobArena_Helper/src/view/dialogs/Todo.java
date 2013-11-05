package view.dialogs;

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
import javax.swing.border.LineBorder;

import view.MenuPrincipal;

public class Todo extends JWindow {

	private static final long serialVersionUID = 4530101048983920413L;
	private MenuPrincipal menu;
	private JTextPane lib_todo;
	private JButton btn_ok;
	private JLabel border;
	
	public Todo(MenuPrincipal menu) {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		lib_todo = new JTextPane();
		lib_todo.setContentType("text/html");
		lib_todo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lib_todo.setText("<html>I plan to add a lot of functionnalities, because the program is still at a very basic stage, it is simply a portage of the Wave Editor by Agnate. To do :<br>"
				+ "- Add control over<br>- general settings<br>"
				+ "<span class=\"marge\"><s>- arena settings</s></span><br>"
				+ "<span class=\"marge\">- class limit by arena<</span>br>"
				+ "- Allow create, modify and delete on :<br>"
				+ "<span class=\"marge\">- classes</span><br>"
				+ "<span class=\"marge\">- rewards</span><br>"
				+ "<span class=\"marge\">- arenas</span><br>"
				+ "- Give control on :<br>"
				+ "<span class=\"marge\">- upgrade waves</span><br>"
				+ "<span class=\"marge\">- supply waves</span>");
		lib_todo.setBounds(10, 11, 390, 210);
		lib_todo.setBorder(null);
		getContentPane().add(lib_todo);
		
		btn_ok = new JButton("OK");
		btn_ok.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				activate();
				setVisible(false);
			}
		});
		btn_ok.setBounds(353, 233, 47, 23);
		getContentPane().add(btn_ok);
		
		border = new JLabel("");
		border.setBounds(0, 0, 422, 264);
		border.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(border);
		this.menu = menu;
		
		setSize(422,264);
		Rectangle d = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		setLocation((d.width-getWidth())/2, (d.height-getHeight())/2);
		setVisible(true);
	}
	
	private void activate(){
		menu.setEnabled(true);
	}
}
