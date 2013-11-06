package view.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import view.MenuPrincipal;

public class Todo extends JWindow {

	private static final long serialVersionUID = 4530101048983920413L;
	private JEditorPane lib_todo;
	private JButton btn_ok;
	private JLabel border;
	
	public Todo(MenuPrincipal menu) {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		setSize(487,372);
		
		lib_todo = new JEditorPane();
		lib_todo.setEditable(false);
		lib_todo.setContentType("text/html");
		lib_todo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lib_todo.setBounds(10, 11, 464, 317);
		try {
			lib_todo.setPage(Todo.class.getResource("/gui/todo.html"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		lib_todo.setBorder(new CompoundBorder());
		getContentPane().add(lib_todo);
		
		btn_ok = new JButton("OK");
		btn_ok.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btn_ok.setBounds(427, 340, 47, 23);
		getContentPane().add(btn_ok);
		
		border = new JLabel("");
		//border.setBounds(0, 0, this.getWidth(), this.getHeight());
		border.setBounds(0, 0, this.getWidth(), this.getHeight());
		border.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(border);
		
		setLocationRelativeTo(menu);
		setVisible(true);
	}
	
}
