package view.dialogs;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;
import javax.swing.border.LineBorder;

import model.Messages;
import view.MenuPrincipal;
import view.cells.CellListCaracs;

public class About extends JDialog {

	private static final long serialVersionUID = -7754918383926484094L;
	private JTextPane lib_about;
	private JLabel img_header;
	private JLabel lib_link;

	private JLabel border;
	private JLabel lib_github;
	private JLabel lib_link_git;

	public About(MenuPrincipal menu) {
		setUndecorated(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setAlwaysOnTop(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		setSize(437, 344);

		img_header = new JLabel("");
		img_header.setBounds(0, 0, 437, 140);
		ImageIcon orig_icon = new ImageIcon(About.class.getResource("/gui/pics/Banner.png"));
		Image icon = CellListCaracs.scaleImage(orig_icon.getImage(), img_header);
		img_header.setIcon(new ImageIcon(icon));
		getContentPane().add(img_header);

		lib_about = new JTextPane();
		lib_about.setText(Messages.getString("About.lib_about.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_about.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lib_about.setEditable(false);
		lib_about.setBackground(this.getBackground());
		lib_about.setBounds(10, 151, 417, 132);
		getContentPane().add(lib_about);

		MouseAdapter linker = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				URI uri = null;;
				try {
					uri = new URI(((JLabel) e.getSource()).getText());
				} catch (URISyntaxException e2) {
					e2.printStackTrace();
					return;
				}
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						desktop.browse(uri);
						dispose();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,Messages.getString("About.message.failLaunchLink"),Messages.getString("Message.title.cannotLaunch"),JOptionPane.WARNING_MESSAGE);
						return;
					}
				} else {
					JOptionPane.showMessageDialog(null,
							Messages.getString("About.message.javaFailLaunchLink"),
							Messages.getString("Message.title.cannotLaunch"),JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
		};

		lib_link = new JLabel("https://www.facebook.com/PyerohsDevConcept");
		lib_link.addMouseListener(linker);
		lib_link.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lib_link.setForeground(Color.BLUE);
		lib_link.setBounds(10, 294, 246, 14);
		getContentPane().add(lib_link);

		JButton btn_ok = new JButton("OK");
		btn_ok.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btn_ok.setBounds(372, 314, 59, 23);
		getContentPane().add(btn_ok);

		lib_github = new JLabel(Messages.getString("About.lib_github.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_github.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lib_github.setBounds(10, 319, 62, 14);
		getContentPane().add(lib_github);

		lib_link_git = new JLabel("https://github.com/Pyeroh/mobarenahelper");
		lib_link_git.setForeground(Color.BLUE);
		lib_link_git.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lib_link_git.setBounds(79, 319, 210, 14);
		lib_link_git.addMouseListener(linker);
		getContentPane().add(lib_link_git);

		border = new JLabel("");
		border.setBounds(0, 140, 437, this.getHeight()-img_header.getHeight()-1);
		border.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(border);

		setLocationRelativeTo(menu);
		setVisible(true);

	}
	
}
