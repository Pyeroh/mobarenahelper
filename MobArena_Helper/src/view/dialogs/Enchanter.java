package view.dialogs;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Enchantment;
import model.Item;
import model.enums.EEnchantItem;
import model.enums.EEnchantment;
import model.lists.EnchantList;
import view.JWideComboBox;
import view.cells.CellListCaracs;
import view.cells.HoverListCellRenderer;

public class Enchanter extends JDialog {

	private static final long serialVersionUID = -6398387470645060005L;
	private Item item;
	private JLabel lib_enchant;
	private JScrollPane scrpan_enchant;
	private JList<CellListCaracs> list_enchant;
	private JSeparator separator;
	private JLabel lib_enchantment;
	private JWideComboBox combo_enchantment;
	private JLabel lib_level;
	private JWideComboBox combo_level;
	private JButton btn_add;
	private JLabel lib_help;

	//TODO changer le mode ajout/suppr pour un ajout/suppr/modif
	public Enchanter(JDialog dial, Item item) {
		super();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Enchanter.class.getResource("/gui/mobarena.png")));
		this.item = item;
		setTitle("Enchanter - " + ((ItemSelector)dial).getFrame().getTitle());

		setSize(427,230);
		setLocationRelativeTo(dial);
		getContentPane().setLayout(null);

		lib_enchant = new JLabel("Enchantments");
		lib_enchant.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_enchant.setBounds(6, 6, 92, 20);
		getContentPane().add(lib_enchant);

		list_enchant = new JList<CellListCaracs>();
		HoverListCellRenderer render = new HoverListCellRenderer(list_enchant);
		list_enchant.setCellRenderer(render);
		list_enchant.addMouseListener(render.getHandler());
		list_enchant.addMouseMotionListener(render.getHandler());
		list_enchant.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				list_enchant.clearSelection();
			}
		});
		list_enchant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(list_enchant.getModel().getSize()!=0) {
					list_enchant.ensureIndexIsVisible(list_enchant.getSelectedIndex());
					if(e.getButton()==MouseEvent.BUTTON2) {
						int hoverIndex = ((HoverListCellRenderer) list_enchant.getCellRenderer()).getHoverIndex();
						if(hoverIndex!=-1) {
							Enchantment enchant = Enchanter.this.item.getEnchantements().get(hoverIndex);
							int choice = JOptionPane.showConfirmDialog(
									rootPane,
									"Are you sure you want to delete the "
											+ enchant.toString()
											+ " effect on this "
											+ Enchanter.this.item.getItem()
											.getName()
											.toLowerCase() + " ?",
											"Confirmation",
											JOptionPane.YES_NO_OPTION);
							if(choice==JOptionPane.YES_OPTION) {
								Enchanter.this.item.getEnchantements().remove(enchant);
								load();
							}
						}
					}
				}
				
			}
		});

		scrpan_enchant = new JScrollPane(list_enchant);
		scrpan_enchant.setBounds(6, 38, 238, 152);
		getContentPane().add(scrpan_enchant);

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(256, 6, 2, 184);
		getContentPane().add(separator);

		lib_enchantment = new JLabel("Enchantment");
		lib_enchantment.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_enchantment.setBounds(270, 8, 92, 20);
		getContentPane().add(lib_enchantment);

		combo_enchantment = new JWideComboBox();
		combo_enchantment.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(combo_enchantment.isFocusOwner()){
					loadEnchantLevel((String) combo_enchantment.getSelectedItem());
				}
			}
		});
		combo_enchantment.setBounds(270, 38, 144, 26);
		getContentPane().add(combo_enchantment);

		lib_level = new JLabel("Level");
		lib_level.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_level.setBounds(270, 76, 34, 20);
		getContentPane().add(lib_level);

		combo_level = new JWideComboBox();
		combo_level.setBounds(270, 108, 72, 26);
		getContentPane().add(combo_level);

		btn_add = new JButton("Add !");
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Item item = Enchanter.this.item;
				EEnchantment enchant = EEnchantment.getByName((String) combo_enchantment.getSelectedItem());
				int lvl = combo_level.getSelectedIndex()+1;
				item.getEnchantements().add(new Enchantment(enchant, lvl));

				load();
			}
		});
		btn_add.setBounds(270, 151, 144, 28);
		getContentPane().add(btn_add);
		
		lib_help = new JLabel("");
		lib_help.setToolTipText("<html>This enchanter is done to add or delete an enchantment on a weapon or a <br>tool. You can't modify an existing enchantment by clicking it. But it's not that <br>hard to delete it by wheel-clicking it and creating it again, isn't it ? :p\r\n<br> ... okay, I'll change it in a future update...");
		lib_help.setBounds(220, 6, 24, 24);
		Image img = CellListCaracs.scaleImage(Toolkit.getDefaultToolkit().getImage(Enchanter.class.getResource("/gui/question.png")), lib_help);
		lib_help.setIcon(new ImageIcon(img));
		getContentPane().add(lib_help);

		load();

		setVisible(true);

	}

	private void load() {

		lib_level.setVisible(false);
		combo_level.setVisible(false);
		btn_add.setVisible(false);

		EnchantList enchants = item.getEnchantements();
		DefaultListModel<CellListCaracs> mod_enchants = new DefaultListModel<CellListCaracs>();
		for(int i=0;i<enchants.size();i++) {
			mod_enchants.addElement(new CellListCaracs(enchants.get(i).toString()));
		}
		list_enchant.setModel(mod_enchants);

		ArrayList<EEnchantment> enchant_list = EEnchantItem.getByItem(item.getItem());
		enchant_list.removeAll(enchants.getEEnchantmentList());
		DefaultComboBoxModel<String> mod_enchant = new DefaultComboBoxModel<>();
		for(int i=0;i<enchant_list.size();i++) {
			mod_enchant.addElement(enchant_list.get(i).getName());
		}
		combo_enchantment.setModel(mod_enchant);
		combo_enchantment.setSelectedIndex(-1);

	}

	private void loadEnchantLevel(String sEnchant) {
		lib_level.setVisible(true);
		combo_level.setVisible(true);
		btn_add.setVisible(true);

		EEnchantment e = EEnchantment.getByName(sEnchant);

		int lvlmax = e.getLvlmax();
		DefaultComboBoxModel<String> mod_lvl = new DefaultComboBoxModel<>();
		for(int i=1;i<=lvlmax;i++) {
			switch (i) {
			case 1:
				mod_lvl.addElement("I");
				break;
			case 2:
				mod_lvl.addElement("II");
				break;
			case 3:
				mod_lvl.addElement("III");
				break;
			case 4:
				mod_lvl.addElement("IV");
				break;
			case 5:
				mod_lvl.addElement("V");
				break;
			default:
				mod_lvl.addElement("");
				break;
			}
		}
		combo_level.setModel(mod_lvl);
		combo_level.setSelectedIndex(0);

	}
}