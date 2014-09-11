package view.dialogs;

import java.awt.Font;
import java.awt.event.*;
import java.text.MessageFormat;
import java.util.ArrayList;

import javax.swing.*;

import model.Messages;
import model.enums.*;
import model.item.*;
import model.lists.EnchantList;
import view.JHoverList;
import view.JWideComboBox;
import view.cells.CellListCaracs;
import view.cells.HoverListCellRenderer;

public class Enchanter extends JDialog {

	private static final long serialVersionUID = -6398387470645060005L;

	private AbstractItem item;

	private JLabel lib_enchant;

	private JScrollPane scrpan_enchant;

	private JHoverList<CellListCaracs> list_enchant;

	private JSeparator separator;

	private JLabel lib_enchantment;

	private JWideComboBox combo_enchantment;

	private JLabel lib_level;

	private JWideComboBox combo_level;

	private JButton btn_add;

	public Enchanter(JDialog dial, AbstractItem item) {
		super();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setIconImage(new ImageIcon(Enchanter.class.getResource("/gui/pics/mobarena.png")).getImage());
		this.item = item;
		setTitle(Messages.getString("Enchanter.title") + " - " + ((ItemSelector) dial).getFrame().getTitle());

		setSize(436, 230);
		setLocationRelativeTo(dial);
		getContentPane().setLayout(null);

		lib_enchant = new JLabel(Messages.getString("Enchanter.lib_enchant.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_enchant.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_enchant.setBounds(6, 6, 100, 20);
		getContentPane().add(lib_enchant);

		list_enchant = new JHoverList<CellListCaracs>();
		list_enchant.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {

				if (list_enchant.getModel().getSize() != 0) {
					list_enchant.ensureIndexIsVisible(list_enchant.getSelectedIndex());
					int hoverIndex = ((HoverListCellRenderer) list_enchant.getCellRenderer()).getHoverIndex();
					if (e.getButton() == MouseEvent.BUTTON2) {
						if (hoverIndex != -1) {
							Enchantment enchant = Enchanter.this.item.getEnchantements().get(hoverIndex);
							int choice = JOptionPane.showConfirmDialog(rootPane, MessageFormat.format(Messages
									.getString("Enchanter.message.delEnchant"), enchant.toString(), Enchanter.this.item.getItem().getGuiName()),
									Messages.getString("Message.title.confirmation"), JOptionPane.YES_NO_OPTION);
							if (choice == JOptionPane.YES_OPTION) {
								Enchanter.this.item.getEnchantements().remove(enchant);
								// list_enchant.clearSelection();
								load();
							}
						}
					}
					else if (e.getButton() == MouseEvent.BUTTON1) {
						if (hoverIndex != -1) {
							AbstractItem item = Enchanter.this.item;
							Enchantment enchant = item.getEnchantements().get(hoverIndex);

							setVisibleComponents(true);

							loadEnchantCombo(enchant);

							loadEnchantLevel(enchant.getEnchantement().getName());
							combo_level.setSelectedIndex(enchant.getLvl() - 1);
						}
						else
							list_enchant.clearSelection();
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

		lib_enchantment = new JLabel(Messages.getString("Enchanter.lib_enchantment.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_enchantment.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_enchantment.setBounds(270, 8, 100, 20);
		getContentPane().add(lib_enchantment);

		combo_enchantment = new JWideComboBox();
		combo_enchantment.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (combo_enchantment.isFocusOwner()) {
					if (list_enchant.isSelectionEmpty()) {
						loadEnchantLevel((String) combo_enchantment.getSelectedItem());
					}
					else {
						int index = list_enchant.getSelectedIndex();
						Enchantment enchant = Enchanter.this.item.getEnchantements().get(index);
						String enchant_name = (String) combo_enchantment.getSelectedItem();
						enchant.setEnchantement(EEnchantment.getByName(enchant_name));
						loadEnchantLevel(enchant_name);
						int lvl = Math.min(enchant.getLvl(), combo_level.getModel().getSize());
						enchant.setLvl(lvl);
						combo_level.setSelectedIndex(lvl - 1);
						loadEnchantments();
						list_enchant.setSelectedIndex(index);

					}
				}
			}
		});
		combo_enchantment.setBounds(270, 38, 144, 26);
		getContentPane().add(combo_enchantment);

		lib_level = new JLabel(Messages.getString("Enchanter.lib_level.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_level.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_level.setBounds(270, 76, 43, 20);
		getContentPane().add(lib_level);

		combo_level = new JWideComboBox();
		combo_level.setBounds(270, 108, 72, 26);
		combo_level.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (combo_level.isFocusOwner()) {
					if (!list_enchant.isSelectionEmpty()) {
						int index = list_enchant.getSelectedIndex();
						Enchantment enchant = Enchanter.this.item.getEnchantements().get(index);
						enchant.setLvl(combo_level.getSelectedIndex() + 1);
						loadEnchantments();
						list_enchant.setSelectedIndex(index);
					}
				}
			}
		});
		getContentPane().add(combo_level);

		btn_add = new JButton(Messages.getString("Enchanter.btn_add.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_add.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				setVisibleComponents(true);

				AbstractItem item = Enchanter.this.item;
				ArrayList<EEnchantment> enchant_list;
				if (item instanceof CustomItem)
					enchant_list = EEnchantItem.getByItem(EItem.enchanted_book);
				else
					enchant_list = EEnchantItem.getByItem(item.getItem());
				enchant_list.removeAll(item.getEnchantements().getEEnchantmentList());

				if (enchant_list.size() == 1) {
					btn_add.setVisible(false);
				}

				Enchantment enchant = new Enchantment(enchant_list.get(0), 1);
				item.getEnchantements().add(enchant);
				loadEnchantCombo(enchant);

				loadEnchantLevel(enchant.getEnchantement().getName());
				combo_level.setSelectedIndex(enchant.getLvl() - 1);
				loadEnchantments();
				int index = item.getEnchantements().size() - 1;
				list_enchant.setSelectedIndex(index);
				list_enchant.ensureIndexIsVisible(index);
			}
		});
		btn_add.setBounds(158, 5, 86, 25);
		getContentPane().add(btn_add);

		load();

		ToolTipManager.sharedInstance().setDismissDelay(10000);
		setVisible(true);
		ToolTipManager.sharedInstance().setDismissDelay(4000);

	}

	private void load() {

		setVisibleComponents(false);

		loadEnchantments();

		ArrayList<EEnchantment> enchant_list;
		if (item instanceof CustomItem)
			enchant_list = EEnchantItem.getByItem(EItem.enchanted_book);
		else
			enchant_list = EEnchantItem.getByItem(item.getItem());

		enchant_list.removeAll(item.getEnchantements().getEEnchantmentList());
		DefaultComboBoxModel<String> mod_enchant = new DefaultComboBoxModel<String>();
		for (int i = 0; i < enchant_list.size(); i++) {
			mod_enchant.addElement(enchant_list.get(i).getName());
		}
		combo_enchantment.setModel(mod_enchant);
		combo_enchantment.setSelectedIndex(-1);

		if (enchant_list.size() > 0)
			btn_add.setVisible(true);
		else
			btn_add.setVisible(false);

	}

	private void loadEnchantments() {
		EnchantList enchants = item.getEnchantements();
		DefaultListModel<CellListCaracs> mod_enchants = new DefaultListModel<CellListCaracs>();
		for (int i = 0; i < enchants.size(); i++) {
			mod_enchants.addElement(new CellListCaracs(enchants.get(i).toString()));
		}
		list_enchant.setModel(mod_enchants);
	}

	private void loadEnchantCombo(Enchantment enchant) {
		ArrayList<EEnchantment> enchant_list;
		if (item instanceof CustomItem)
			enchant_list = EEnchantItem.getByItem(EItem.enchanted_book);
		else
			enchant_list = EEnchantItem.getByItem(item.getItem());

		enchant_list.removeAll(item.getEnchantements().getEEnchantmentList());
		enchant_list.add(0, enchant.getEnchantement());
		DefaultComboBoxModel<String> mod_enchant = new DefaultComboBoxModel<String>();
		for (int i = 0; i < enchant_list.size(); i++) {
			mod_enchant.addElement(enchant_list.get(i).getName());
		}
		combo_enchantment.setModel(mod_enchant);
		combo_enchantment.setSelectedIndex(0);
	}

	private void loadEnchantLevel(String sEnchant) {
		setVisibleComponents(true);

		EEnchantment e = EEnchantment.getByName(sEnchant);

		int lvlmax = e.getLvlmax();
		DefaultComboBoxModel<String> mod_lvl = new DefaultComboBoxModel<String>();
		for (int i = 1; i <= lvlmax; i++) {
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

	private void setVisibleComponents(boolean visible) {
		lib_enchantment.setVisible(visible);
		combo_enchantment.setVisible(visible);
		lib_level.setVisible(visible);
		combo_level.setVisible(visible);
	}

}
