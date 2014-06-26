package view.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

import model.Messages;
import view.MenuPrincipal;

public class HowTo extends JDialog {

	private static final long serialVersionUID = 1132162114547728162L;

	private JLabel lib_HowToUse;

	private JTextPane lib_howto2;

	private JButton btn_ok;

	private JLabel border;

	private JTabbedPane tab_howto;

	private JTextPane lib_howto3;

	private JTextPane lib_howto4;

	private JTabbedPane tab_howto5;

	private JTextPane lib_howto6;

	private JTextPane lib_howto7;

	private JTextPane lib_howto8;

	private JTextPane lib_howto9;

	public HowTo(MenuPrincipal menu) {
		setResizable(false);
		getContentPane().setBackground(new Color(255, 255, 255));
		setModal(true);
		setUndecorated(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setSize(647, 460);
		getContentPane().setLayout(null);

		lib_HowToUse = new JLabel(Messages.getString("HowTo.lib_HowToUse.text")); //$NON-NLS-1$
		lib_HowToUse.setBackground(new Color(255, 255, 255));
		lib_HowToUse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lib_HowToUse.setBounds(10, 11, 300, 19);
		getContentPane().add(lib_HowToUse);

		tab_howto = new JTabbedPane(JTabbedPane.TOP);
		tab_howto.setBounds(1, 42, 644, 377);
		getContentPane().add(tab_howto);

		lib_howto2 = new JTextPane();
		lib_howto2.setEditable(false);
		tab_howto.addTab(Messages.getString("MenuPrincipal.tabpan_arena_wave.title"), null, lib_howto2, null); //$NON-NLS-1$
		lib_howto2.setText(Messages.getString("HowTo.lib_howto2.text")); //$NON-NLS-1$
		lib_howto2.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lib_howto3 = new JTextPane();
		lib_howto3.setEditable(false);
		lib_howto3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lib_howto3.setText(Messages.getString("HowTo.lib_howto3.text")); //$NON-NLS-1$
		tab_howto.addTab(Messages.getString("MenuPrincipal.tabpan_classes.title"), null, lib_howto3, null); //$NON-NLS-1$

		lib_howto4 = new JTextPane();
		lib_howto4.setEditable(false);
		lib_howto4.setText(Messages.getString("HowTo.lib_howto4.text")); //$NON-NLS-1$
		lib_howto4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tab_howto.addTab(Messages.getString("MenuPrincipal.tabpan_arena_settings.title"), null, lib_howto4, null); //$NON-NLS-1$

		lib_howto9 = new JTextPane();
		lib_howto9.setEditable(false);
		lib_howto9.setText(Messages.getString("HowTo.lib_howto9.text")); //$NON-NLS-1$
		tab_howto.addTab(Messages.getString("HowTo.lib_howto9.title"), null, lib_howto9, null); //$NON-NLS-1$

		tab_howto5 = new JTabbedPane(JTabbedPane.LEFT);
		tab_howto.addTab(Messages.getString("HowTo.tabpan_dialogs"), null, tab_howto5, null); //$NON-NLS-1$

		lib_howto6 = new JTextPane();
		lib_howto6.setText(Messages.getString("HowTo.lib_howto6.text")); //$NON-NLS-1$
		lib_howto6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lib_howto6.setEditable(false);
		tab_howto5.addTab(Messages.getString("ItemSelector.title"), null, lib_howto6, null); //$NON-NLS-1$

		lib_howto7 = new JTextPane();
		lib_howto7.setText(Messages.getString("HowTo.lib_howto7.text")); //$NON-NLS-1$
		lib_howto7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lib_howto7.setEditable(false);
		tab_howto5.addTab(Messages.getString("HowTo.tabpan_upwavechanger"), null, lib_howto7, null); //$NON-NLS-1$

		lib_howto8 = new JTextPane();
		lib_howto8.setEditable(false);
		lib_howto8.setText(Messages.getString("HowTo.lib_howto8.text")); //$NON-NLS-1$
		lib_howto8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tab_howto5.addTab(Messages.getString("Enchanter.title"), null, lib_howto8, null); //$NON-NLS-1$

		btn_ok = new JButton("OK");
		btn_ok.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_ok.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btn_ok.setBounds(594, 431, 47, 23);
		getContentPane().add(btn_ok);

		border = new JLabel("");
		border.setBounds(0, 0, this.getWidth() - 1, this.getHeight() - 1);
		border.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(border);

		setLocationRelativeTo(menu);
		setVisible(true);
	}
}
