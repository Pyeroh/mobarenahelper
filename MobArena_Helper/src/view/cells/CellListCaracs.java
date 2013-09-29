package view.cells;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class CellListCaracs extends JPanel {

	private static final long serialVersionUID = 6617466786415092311L;
	protected JLabel lib_desc;

	public CellListCaracs() {

		setSize(238,25);
		setLayout(new BorderLayout(0, 0));

		lib_desc = new JLabel("");
		lib_desc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lib_desc);


	}
}