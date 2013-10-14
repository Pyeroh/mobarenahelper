package view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JWindow;

import view.cells.CellListWave;
import javax.swing.border.LineBorder;

public class About extends JWindow {

	private static final long serialVersionUID = -7754918383926484094L;
	private JTextPane lib_about;
	private JLabel img_header;
	private JLabel lib_link;

	private MenuPrincipal menu;
	private JLabel border;

	public About(MenuPrincipal menu) {
		setAlwaysOnTop(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		img_header = new JLabel("");
		img_header.setBounds(0, 0, 437, 140);
		ImageIcon orig_icon = new ImageIcon(About.class.getResource("/gui/Banner.png"));
		Image icon = CellListWave.scaleImage(orig_icon.getImage(), img_header);
		img_header.setIcon(new ImageIcon(icon));
		getContentPane().add(img_header);

		lib_about = new JTextPane();
		lib_about.setText("MobArena Helper v1 is currently a portage of the WaveEditor by Agnate.\r\nPyeroh's Dev Concept is the owner of this software, and the banner above is property of garbagemule.\r\nThis software is designed to edit and customize waves for the plugin MobArena, created by garbagemule.\r\nI'm French, so please excuse me for my mistakes ;)\r\nFeel free to visit my page on facebook at :");
		lib_about.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lib_about.setEditable(false);
		lib_about.setBackground(this.getBackground());
		lib_about.setBounds(10, 151, 417, 123);
		getContentPane().add(lib_about);

		lib_link = new JLabel("https://www.facebook.com/PyerohsDevConcept");
		lib_link.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				URI uri = null;;
				try {
					uri = new URI("https://www.facebook.com/PyerohsDevConcept");
				} catch (URISyntaxException e2) {
					e2.printStackTrace();
					return;
				}
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						desktop.browse(uri);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,
								"Failed to launch the link, " +
										"your computer is likely misconfigured.",
										"Cannot Launch Link",JOptionPane.WARNING_MESSAGE);
						return;
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Java is not able to launch links on your computer.",
							"Cannot Launch Link",JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
		});
		lib_link.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lib_link.setForeground(Color.BLUE);
		lib_link.setBounds(10, 289, 246, 14);
		getContentPane().add(lib_link);

		JButton btn_ok = new JButton("OK");
		btn_ok.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				activate();
				setVisible(false);
			}
		});
		btn_ok.setBounds(368, 285, 59, 23);
		getContentPane().add(btn_ok);
		
		border = new JLabel("");
		border.setBounds(0, 140, 437, 195);
		border.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(border);

		this.menu = menu;

		setSize(437, 335);
		Rectangle d = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		setLocation((d.width-getWidth())/2, (d.height-getHeight())/2);
		setVisible(true);

	}

	private void activate() {
		menu.setEnabled(true);
	}
}
