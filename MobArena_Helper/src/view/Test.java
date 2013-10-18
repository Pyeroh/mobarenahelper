package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class Test extends JFrame {
	private JTextField sai_class;
	private JLabel lib_class;
	private JLabel lib_classes;
	private JScrollPane scrpan_classes;
	private JList list_classes;
	private JPanel pan_classes;
	public Test() {
		getContentPane().setLayout(null);
		
		pan_classes = new JPanel();
		pan_classes.setBorder(new LineBorder(new Color(0, 0, 0)));
		pan_classes.setBounds(6, 6, 707, 463);
		getContentPane().add(pan_classes);
		pan_classes.setLayout(null);
		
		lib_class = new JLabel("Class");
		lib_class.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_class.setBounds(422, 238, 45, 28);
		pan_classes.add(lib_class);
		
		sai_class = new JTextField();
		sai_class.setBounds(479, 238, 122, 28);
		pan_classes.add(sai_class);
		sai_class.setColumns(10);
		
		lib_classes = new JLabel("Classes");
		lib_classes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_classes.setBounds(6, 6, 55, 22);
		pan_classes.add(lib_classes);
		
		scrpan_classes = new JScrollPane();
		scrpan_classes.setBounds(6, 31, 210, 156);
		pan_classes.add(scrpan_classes);
		
		list_classes = new JList();
		scrpan_classes.setViewportView(list_classes);
		
		JPanel panel = new JPanel();
		panel.setBounds(228, 6, 373, 156);
		pan_classes.add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		setSize(1079,787);
	}
}
