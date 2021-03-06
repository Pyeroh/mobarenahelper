package view.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import model.*;
import model.enums.*;
import model.exceptions.ArenaException;
import model.item.*;
import model.lists.ArmorList;
import model.lists.ItemList;
import view.JHoverList;
import view.JWideComboBox;
import view.cells.*;

public class ItemSelector extends JDialog {

	private static final long serialVersionUID = 7238413511342140781L;

	private ItemList items;

	private JFrame frame;

	private int max;

	private boolean isArmor;

	private boolean classSelector;

	private boolean isMoneySelectable;

	private AbstractItem selectedItem;

	private JLabel lib_selectable;

	private JLabel lib_sort;

	private JWideComboBox combo_sort;

	private JLabel lib_search;

	private JFormattedTextField sai_search;

	private JScrollPane scrpan_selectable;

	private JHoverList<CellListEItem> list_selectable;

	private JButton btn_add;

	private JButton btn_remove;

	private JScrollPane scrpan_selected;

	private JHoverList<CellListItem> list_selected;

	private JLabel lib_selected;

	private JButton btn_enchant;

	private JButton btn_add_custom;

	/**
	 * Constructeur d'un s�lecteur d'items � partir de la liste {@code items} et permettant la s�lection de {@code max}
	 * items.
	 *
	 * @param frame
	 * @param items
	 *            la liste d'entr�e
	 * @param max
	 *            le nombre d'items s�lectionnable max
	 * @param isArmor
	 *            si la fen�tre est un s�lecteur d'armure
	 * @param classSelector
	 *            si la fen�tre est un s�lecteur d'items de classe, si vrai pas d'os ou de balle de foin (loup et
	 *            cheval)
	 * @wbp.parser.constructor Constructeur graphique
	 */
	public ItemSelector(JFrame frame, ItemList items, int max, boolean isArmor, boolean classSelector, boolean isMoneySelectable) {
		super();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle(Messages.getString("ItemSelector.title") + " - " + frame.getTitle());

		setIconImage(new ImageIcon(ItemSelector.class.getResource("/gui/pics/mobarena.png")).getImage());
		setResizable(false);
		this.items = items;
		this.frame = frame;
		this.max = max;
		this.isArmor = isArmor;
		this.classSelector = classSelector;
		this.isMoneySelectable = isArmor ? false : isMoneySelectable;

		setSize(850, 356);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(null);

		lib_selectable = new JLabel(Messages.getString("ItemSelector.lib_selectable.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_selectable.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_selectable.setBounds(6, 6, 154, 25);
		getContentPane().add(lib_selectable);

		lib_sort = new JLabel(Messages.getString("ItemSelector.lib_sort.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_sort.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_sort.setBounds(6, 43, 86, 25);
		getContentPane().add(lib_sort);

		combo_sort = new JWideComboBox();
		combo_sort.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.DESELECTED && combo_sort.isFocusOwner()) {

					ArrayList<EItem> values = switchValues();

					values.removeAll(ItemSelector.this.items.getEItemList());
					loadSelectable(values);

				}

			}
		});
		combo_sort.setFont(new Font("SansSerif", Font.PLAIN, 12));

		String[] tab = { EItemCat.weapon.getGui_name() };
		if (!this.isArmor)
			tab = EItemCat.namevalues();
		combo_sort.setModel(new DefaultComboBoxModel<String>(tab));
		combo_sort.setBounds(104, 43, 121, 25);
		getContentPane().add(combo_sort);

		lib_search = new JLabel(Messages.getString("ItemSelector.lib_search.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_search.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_search.setBounds(6, 80, 86, 25);
		getContentPane().add(lib_search);

		try {
			sai_search = new JFormattedTextField(new MaskFormatter("LLLLLLLLLLLLLLL"));
			sai_search.setFocusLostBehavior(JFormattedTextField.COMMIT);
			sai_search.addKeyListener(new KeyAdapter() {

				public void keyReleased(KeyEvent e) {
					loadSelectable(crossSearch());
				}
			});
		}
		catch (ParseException e) {
		}
		sai_search.setBackground(new Color(255, 255, 255));
		sai_search.setBounds(104, 80, 122, 25);
		sai_search.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(sai_search);
		sai_search.setColumns(10);

		list_selectable = new JHoverList<CellListEItem>();

		ArrayList<EItem> values = switchValues();
		values.removeAll(items.getEItemList());
		loadSelectable(values);

		scrpan_selectable = new JScrollPane(list_selectable);
		scrpan_selectable.setBounds(6, 117, 350, 200);
		getContentPane().add(scrpan_selectable);

		btn_add = new JButton(Messages.getString("ItemSelector.btn_add.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_add.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					addItem();
				}
				catch (ArenaException e1) {
				}
			}
		});

		btn_add_custom = new JButton(Messages.getString("ItemSelector.btn_add_custom.text")); //$NON-NLS-1$
		btn_add_custom.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				int nb_items = list_selected.getModel().getSize();
				if (ItemSelector.this.max - nb_items == 1)
					btn_add_custom.setVisible(false);

				CustomItem ci = new CustomItemCreator(ItemSelector.this.frame).getItem();
				if (ci != null) {
					ItemSelector.this.items.add(ci);

					loadSelected(ItemSelector.this.items);
					loadSelectable(crossSearch());
				}

			}
		});
		btn_add_custom.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_add_custom.setBounds(360, 116, 118, 42);
		getContentPane().add(btn_add_custom);
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_add.setBounds(368, 170, 101, 28);
		getContentPane().add(btn_add);

		btn_remove = new JButton(Messages.getString("ItemSelector.btn_remove.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_remove.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				removeItem();
			}
		});
		btn_remove.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_remove.setBounds(368, 210, 101, 28);
		getContentPane().add(btn_remove);

		lib_selected = new JLabel(Messages.getString("ItemSelector.lib_selected.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_selected.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_selected.setBounds(481, 6, 134, 25);
		getContentPane().add(lib_selected);

		list_selected = new JHoverList<CellListItem>();
		loadSelected(items);
		list_selected.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {

				int hoverIndex = ((HoverListCellRenderer) list_selected.getCellRenderer()).getHoverIndex();

				if (hoverIndex != -1) {
					selectedItem = list_selected.getModel().getElementAt(hoverIndex).getItem();
					if (selectedItem instanceof Item) {
						if (EEnchantItem.getByItem(selectedItem.getItem()).size() == 0)
							btn_enchant.setVisible(false);
						else
							btn_enchant.setVisible(true);
					}
					else if (!(selectedItem instanceof Money)) {
						btn_enchant.setVisible(true);
					}
				}
				else {
					list_selected.clearSelection();
					selectedItem = null;
					btn_enchant.setVisible(false);
				}

			}
		});

		btn_enchant = new JButton(Messages.getString("ItemSelector.btn_enchant.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_enchant.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_enchant.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				new Enchanter(ItemSelector.this, selectedItem);
			}
		});
		btn_enchant.setBounds(481, 78, 90, 28);
		btn_enchant.setVisible(false);
		getContentPane().add(btn_enchant);

		scrpan_selected = new JScrollPane(list_selected);
		scrpan_selected.setBounds(481, 112, 350, 200);
		getContentPane().add(scrpan_selected);

		setVisible(true);

	}

	/**
	 * Constructeur d'un s�lecteur d'items � partir de la liste {@code items} et permettant la s�lection de {@code max}
	 * items.
	 *
	 * @param frame
	 * @param items
	 *            la liste d'entr�e
	 * @param max
	 *            le nombre d'items s�lectionnable max
	 * @param isArmor
	 *            si la fen�tre est un s�lecteur d'armure
	 * @param classSelector
	 *            si la fen�tre est un s�lecteur d'items de classe, si vrai pas d'os ou de balle de foin (loup et
	 *            cheval)
	 */
	public ItemSelector(JFrame frame, ItemList items, int max, boolean isArmor, boolean classSelector) {
		this(frame, items, max, isArmor, classSelector, false);
	}

	/**
	 * Constructeur d'un s�lecteur d'items � partir de la liste {@code items} et permettant la s�lection de {@code max}
	 * items.
	 *
	 * @param frame
	 * @param items
	 *            la liste d'entr�e
	 * @param max
	 *            le nombre d'items s�lectionnable max
	 * @param isArmor
	 *            si la fen�tre est un s�lecteur d'armure
	 */
	public ItemSelector(JFrame frame, ItemList items, int max, boolean isArmor) {
		this(frame, items, max, isArmor, false);
	}

	public ItemList getItemList() {
		return items;
	}

	protected JFrame getFrame() {
		return frame;
	}

	private boolean isArmor() {
		return isArmor;
	}

	private void addItem() throws ArenaException {

		if (!list_selectable.isSelectionEmpty()) {
			int nb_items = list_selected.getModel().getSize();
			if (max - nb_items == 1)
				btn_add_custom.setVisible(false);
			if (nb_items == max) {
				JOptionPane.showMessageDialog(rootPane, Messages.getString("ItemSelector.message.noMore"),
						Messages.getString("Message.title.warning"), JOptionPane.WARNING_MESSAGE);
			}
			else {

				EItem eitem = list_selectable.getSelectedValue().getEItem();

				if (isMoneySelectable && eitem == EItem.money) {

					String input = JOptionPane.showInputDialog(rootPane, Messages.getString("ItemSelector.message.howMuchMoney"), 0f);
					if (input != null) {
						input = input.replaceAll(" ", "");
						if (input.matches("\\d+([,\\.]\\d+)?")) {

							items.add(new Money(Float.parseFloat(input)));

							loadSelected(items);
							loadSelectable(crossSearch());

						}
						else
							JOptionPane.showMessageDialog(rootPane, Messages.getString("ItemSelector.message.incorrectMoneyFormat"),
									Messages.getString("Message.title.error"), JOptionPane.ERROR_MESSAGE);
					}

				}
				else if (!isArmor()) {

					String input = JOptionPane.showInputDialog(rootPane, Messages.getString("ItemSelector.message.howMany"), 1);
					if (input != null) {
						input = input.trim();
						if (input.matches("^[1-9]\\d{0,2}$")) {

							items.add(new Item(eitem, Integer.parseInt(input), null));

							loadSelected(items);
							loadSelectable(crossSearch());

						}
						else
							JOptionPane.showMessageDialog(rootPane, Messages.getString("ItemSelector.message.incorrectNumberFormat"),
									Messages.getString("Message.title.error"), JOptionPane.ERROR_MESSAGE);
					}

				}
				else {

					boolean present = false;
					DefaultListModel<CellListItem> mod = (DefaultListModel<CellListItem>) list_selected.getModel();
					for (int i = 0; i < mod.size(); i++) {
						int id = mod.get(i).getEItem().getId();
						float diff = Math.abs(id - eitem.getId()) / 4f;
						if (diff == (int) diff) {
							present = true;
						}
					}
					if (present) {
						JOptionPane.showMessageDialog(rootPane, Messages.getString("ItemSelector.message.doubleArmor"),
								Messages.getString("Message.title.warning"), JOptionPane.WARNING_MESSAGE);
					}
					else {
						items.add(new Armor(eitem, null));

						loadSelected(items);
						loadSelectable(crossSearch());
					}
				}
			}
		}
	}

	private void removeItem() {

		if (!list_selected.isSelectionEmpty()) {
			int nb_items = list_selected.getModel().getSize();
			if (nb_items < ItemSelector.this.max)
				btn_add_custom.setVisible(true);

			items.remove(selectedItem);
			loadSelected(items);
			loadSelectable(crossSearch());

		}

	}

	private void loadSelectable(ArrayList<EItem> values) {
		DefaultListModel<CellListEItem> mod_ItemsSelectable = new DefaultListModel<>();
		for (int i = 0; i < values.size(); i++) {
			mod_ItemsSelectable.addElement(new CellListEItem(values.get(i)));
		}
		list_selectable.setModel(mod_ItemsSelectable);
	}

	private void loadSelected(ItemList values) {
		if (!isArmor) {
			values.sort();
		}
		else {
			((ArmorList) values).sort();
		}
		DefaultListModel<CellListItem> mod_ItemsSelectable = new DefaultListModel<>();
		for (int i = 0; i < values.size(); i++) {
			mod_ItemsSelectable.addElement(new CellListItem(values.get(i)));
		}
		list_selected.setModel(mod_ItemsSelectable);
	}

	private ArrayList<EItem> switchValues() {
		ArrayList<EItem> values;
		String sort = (String) combo_sort.getSelectedItem();
		if (sort.equals(EItemCat.all.getGui_name())) {
			values = new ArrayList<EItem>(Arrays.asList(EItem.values()));
			values.remove(0);
		}
		else if (isArmor) {
			values = new ArrayList<>();
			for (int i = 298; i <= 317; i++) {
				values.add(EItem.searchBy(i, 0));
			}
		}
		else
			values = EItem.getByCategory(EItemCat.getByName(sort));

		if (classSelector) {
			values.remove(EItem.bone);
			values.remove(EItem.hay_block);
		}
		if (!isMoneySelectable) {
			values.remove(EItem.money);
		}

		return values;
	}

	private ArrayList<EItem> crossSearch() {
		ArrayList<EItem> values = switchValues();
		ArrayList<EItem> val_search = EItem.searchBy(sai_search.getText().trim());

		values.retainAll(val_search);
		values.removeAll(items.getEItemList());

		return values;
	}
}
