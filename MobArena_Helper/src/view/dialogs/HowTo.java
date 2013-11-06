package view.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

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
	
	public HowTo(MenuPrincipal menu) {
		setResizable(false);
		getContentPane().setBackground(new Color(255, 255, 255));
		setModal(true);
		setUndecorated(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setSize(647,429);
		getContentPane().setLayout(null);
		
		lib_HowToUse = new JLabel("How to use the MobArena Helper ?");
		lib_HowToUse.setBackground(new Color(255, 255, 255));
		lib_HowToUse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lib_HowToUse.setBounds(10, 11, 287, 19);
		getContentPane().add(lib_HowToUse);
		
		tab_howto = new JTabbedPane(JTabbedPane.TOP);
		tab_howto.setBounds(1, 42, 644, 342);
		getContentPane().add(tab_howto);
		
		lib_howto2 = new JTextPane();
		lib_howto2.setEditable(false);
		tab_howto.addTab("Arenas and waves configuration", null, lib_howto2, null);
		lib_howto2.setText("First, you just have to click on the load button, and search your config file. \r\nThe waves should appear in the lists, then you left-click on it to load it in the right part of the screen.\r\n\r\nYou can change the name of the wave, its category, its type, and every other data linked to it. Moreover, if you try a invalid action, generally, it is blocked by the application (but the soft is not exempt from bugs, so feel free to report them, see the link in About section). Additionnal actions are possible for boss, supply and upgrade waves, with the button i the bottom of the screen.\r\n\r\nTo remove a wave, or a monster or an ability, you can middle-click on it (with the mouse wheel), a confirmation pop-up will appear. The whole applicationfunction like this : middle-click to delete.\r\n\r\nIf you didn't load a file, you can create your own configuration, but it's at your own risks :  there won't be any rewards, nor coordinates for the arena and class limits, nor global settings for the file. If you are fully aware of this, you can click on the \"+\" button to add an arena, an \"-\" if you want to delete it.\r\n\r\nFinally, you can save your work by clicking on \"Save Config as...\"\r\nYou're done !");
		lib_howto2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lib_howto3 = new JTextPane();
		lib_howto3.setEditable(false);
		lib_howto3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lib_howto3.setText("Well... Do I really need to explain ?\r\n\r\nClick on a class name to see its configuration, edit it as you want, create new permissions, or a new class, or delete it...\r\n\r\nActually, you can't wrap a sandwich with it, but I'm working on it ;)");
		tab_howto.addTab("Classes configuration", null, lib_howto3, null);
		
		lib_howto4 = new JTextPane();
		lib_howto4.setEditable(false);
		lib_howto4.setText("On this pane, you can fully configure every data linked to the arena configuration. It means every node you can activate or not, is clickable here.\r\n\r\nThe node \"logging\" is not here, because garbagemule says it's buggy, but as soon as he fix it, I'll add it here.");
		lib_howto4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tab_howto.addTab("Arena configuration", null, lib_howto4, null);
		
		tab_howto5 = new JTabbedPane(JTabbedPane.LEFT);
		tab_howto.addTab("Dialogs", null, tab_howto5, null);
		
		lib_howto6 = new JTextPane();
		lib_howto6.setText("The Item Selector is relatively simple to use :\r\nYou can select an item category in the drop-down list, or search it by its name, or both.\r\nWhen you find the desired item, you can click on it, and press the Add button to add it to the selected items list, with a selectable amount.\r\n\r\nIf your item is enchantable, the Enchat button will appear (see Enchanter).\r\n\r\nIf one of the items is not desired to be selected, press the Remove button after having clicked on it.\r\n\r\nWhen you are done with the item configuration, simply quit the window with the red cross.");
		lib_howto6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lib_howto6.setEditable(false);
		tab_howto5.addTab("Item Selector", null, lib_howto6, null);
		
		lib_howto7 = new JTextPane();
		lib_howto7.setText("The Upgrade Wave Changer allows you to edit a selected upgrade wave. An upgrade wave is composed by some configuration related to itself, and upgrade sets, linked to a class.\r\nSo you can add a class to the sets, and edit it.\r\n\r\nWhen you select a set, it can be Legacy or Advanced. \r\nWhen Legacy, only items are upgraded, whithout distinction between weapons, tools, and stuff.\r\nIf it is Advanced, you can choose to upgrade items, armor, and also to add permissions for the current arena.\r\n\r\nThe Item Selector displayed when you want to upgrade something doesn't show previous items, you have to remember which items are selected for a specific class.");
		lib_howto7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lib_howto7.setEditable(false);
		tab_howto5.addTab("<html>Upgrade Wave<br>Changer", null, lib_howto7, null);
		
		lib_howto8 = new JTextPane();
		lib_howto8.setText("That window is very simple : it allows you to edit enchantments applied to an item, which can be a piece of armor, a tool, or a weapon.\r\n\r\nTo add an enchantment, select it in the drop-down list, select the level, and click Add.\r\nTo remove one, middle click on it.\r\n\r\nThat's all !");
		lib_howto8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tab_howto5.addTab("Enchanter", null, lib_howto8, null);
		
		btn_ok = new JButton("OK");
		btn_ok.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btn_ok.setBounds(594, 396, 47, 23);
		getContentPane().add(btn_ok);
		
		border = new JLabel("");
		border.setBounds(0, 0, this.getWidth()-1, this.getHeight()-1);
		border.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(border);
		
		setLocationRelativeTo(menu);
		setVisible(true);
	}
}
