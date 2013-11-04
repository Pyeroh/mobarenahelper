package view.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.border.LineBorder;

import view.MenuPrincipal;

public class Todo extends JWindow {

	private static final long serialVersionUID = 4530101048983920413L;
	private MenuPrincipal menu;
	private JTextArea lib_todo;
	private JButton btn_ok;
	private JLabel border;
	
	public Todo(MenuPrincipal menu) {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		lib_todo = new JTextArea();
		lib_todo.setLineWrap(true);
		lib_todo.setWrapStyleWord(true);
		lib_todo.setTabSize(2);
		lib_todo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lib_todo.setText("I plan to add a lot of functionnalities, because the program is still at a very basic stage, it is simply a portage of the Wave Editor by Agnate. To do :\r\n- Add control over\r\n\t- general settings\r\n\t- arena settings\r\n\t- class limit by arena\r\n- Allow create, modify and delete on :\r\n\t- classes\r\n\t- rewards\r\n\t- arenas\r\n- Give control on :\r\n\t- upgrade waves\r\n\t- supply waves");
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
