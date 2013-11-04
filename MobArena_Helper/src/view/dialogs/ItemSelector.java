package view.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import model.Armor;
import model.ArmorList;
import model.Item;
import model.ItemList;
import model.enums.EItem;
import model.enums.EItemCat;
import view.JWideComboBox;
import view.cells.CellListEItem;
import view.cells.CellListItem;
import view.cells.HoverListCellRenderer;

public class ItemSelector extends JDialog {

	private static final long serialVersionUID = 7238413511342140781L;

	private ItemList items;
	private int max;
	private boolean isArmor;
	private boolean classSelector;

	private JLabel lib_selectable;
	private JLabel lib_sort;
	private JWideComboBox combo_sort;
	private JLabel lib_search;
	private JFormattedTextField sai_search;
	private JList<CellListEItem> list_selectable;
	private JButton btn_add;
	private JButton btn_remove;
	private JScrollPane scrpan_selected;
	private JList<CellListItem> list_selected;
	private JLabel lib_selected;
	private JButton btn_enchant;

	/**
	 * Constructeur d'un sélecteur d'items à partir de la liste {@code items} et
	 * permettant la sélection de {@code max} items.
	 * @param frame 
	 * @param items la liste d'entrée
	 * @param max le nombre d'items sélectionnable max
	 * @param isArmor si la fenêtre est un sélecteur d'armure
	 * @param classSelector si la fenêtre est un sélecteur d'items de classe, si vrai pas d'os ou de balle de foin (loup et cheval)
	 * @throws ParseException 
	 * @wbp.parser.constructor
	 */
	public ItemSelector(JFrame frame, ItemList items, int max, boolean isArmor, boolean classSelector) {
		super();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Item Selector - "+frame.getTitle());
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ItemSelector.class.getResource("/gui/mobarena.png")));
		setResizable(false);
		this.items = items;
		this.max = max;
		this.isArmor = isArmor;
		this.classSelector = classSelector;

		setSize(850,356);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(null);

		lib_selectable = new JLabel("Items selectable");
		lib_selectable.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_selectable.setBounds(6, 6, 121, 25);
		getContentPane().add(lib_selectable);

		lib_sort = new JLabel("Sort by");
		lib_sort.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_sort.setBounds(6, 43, 55, 25);
		getContentPane().add(lib_sort);

		combo_sort = new JWideComboBox();
		combo_sort.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if(e.getStateChange() == ItemEvent.DESELECTED && combo_sort.isFocusOwner()){

					ArrayList<EItem> values = switchValues();

					values.removeAll(ItemSelector.this.items.getEItemList());
					loadSelectable(values);

				}

			}
		});
		combo_sort.setFont(new Font("SansSerif", Font.PLAIN, 12));

		String[] tab = {EItemCat.weapon.getGui_name()};
		if(!this.isArmor) tab = EItemCat.namevalues();
		combo_sort.setModel(new DefaultComboBoxModel<String>(tab));
		combo_sort.setBounds(73, 43, 121, 25);
		getContentPane().add(combo_sort);

		lib_search = new JLabel("Search");
		lib_search.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_search.setBounds(6, 80, 55, 25);
		getContentPane().add(lib_search);

		try {
			sai_search = new JFormattedTextField(new MaskFormatter("LLLLLLLLLLLLLLL"));
			sai_search.setFocusLostBehavior(JFormattedTextField.COMMIT);
			sai_search.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					loadSelectable(crossSearch());
				}
			});
		} catch (ParseException e) {}
		sai_search.setBackground(new Color(255, 255, 255));
		sai_search.setBounds(73, 80, 122, 25);
		sai_search.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(sai_search);
		sai_search.setColumns(10);

		list_selectable = new JList<CellListEItem>();

		ArrayList<EItem> values = switchValues();
		values.removeAll(items.getEItemList());
		loadSelectable(values);
		HoverListCellRenderer render1 = new HoverListCellRenderer(list_selectable);
		list_selectable.setCellRenderer(render1);
		list_selectable.addMouseListener(render1.getHandler());
		list_selectable.addMouseMotionListener(render1.getHandler());

		JScrollPane scrpan_selectable = new JScrollPane(list_selectable);
		scrpan_selectable.setBounds(6, 117, 350, 200);
		getContentPane().add(scrpan_selectable);

		btn_add = new JButton("Add >>");
		btn_add.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {

				addItem();

			}
		});
		btn_add.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_add.setBounds(368, 170, 101, 28);
		getContentPane().add(btn_add);

		btn_remove = new JButton("<< Remove");
		btn_remove.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {

				removeItem();

			}
		});
		btn_remove.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_remove.setBounds(368, 210, 101, 28);
		getContentPane().add(btn_remove);

		lib_selected = new JLabel("Items selected");
		lib_selected.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_selected.setBounds(481, 6, 121, 25);
		getContentPane().add(lib_selected);

		list_selected = new JList<CellListItem>();
		loadSelected(items);
		HoverListCellRenderer render2 = new HoverListCellRenderer(list_selected);
		list_selected.setCellRenderer(render2);
		list_selected.addMouseListener(render2.getHandler());
		list_selected.addMouseMotionListener(render2.getHandler());

		//TODO Gestion des enchantements (peut être un JDialog ?)
		btn_enchant = new JButton("Enchant");
		btn_enchant.setBounds(481, 78, 90, 28);
		btn_enchant.setVisible(false);
		getContentPane().add(btn_enchant);

		scrpan_selected = new JScrollPane(list_selected);
		scrpan_selected.setBounds(481, 112, 350, 200);
		getContentPane().add(scrpan_selected);

		setVisible(true);

	}
	
	/**
	 * Constructeur d'un sélecteur d'items à partir de la liste {@code items} et
	 * permettant la sélection de {@code max} items.
	 * @param frame 
	 * @param items la liste d'entrée
	 * @param max le nombre d'items sélectionnable max
	 * @param isArmor si la fenêtre est un sélecteur d'armure
	 */
	public ItemSelector(JFrame frame, ItemList items, int max, boolean isArmor) {
		this(frame,items,max,isArmor,false);
	}


	public ItemList getItemList() {
		return items;
	}

	private boolean isArmor() {
		return isArmor;
	}

	private void addItem() {

		if (!list_selectable.isSelectionEmpty()) {
			int nb_items = list_selected.getModel().getSize();
			if (nb_items == max) {
				JOptionPane.showMessageDialog(
						rootPane,
						"You can't add more items !", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} else {

				EItem eitem = list_selectable.getSelectedValue().getEItem();
				if(!isArmor()) {

					String input = JOptionPane.showInputDialog(rootPane, "How many items do you wish to add ?",1);
					if (input!=null) {
						input = input.trim();
						if (input.matches("^[1-9][0-9]{0,2}$")) {

							items.add(new Item(eitem, Integer.parseInt(input), null));

							loadSelected(items);
							loadSelectable(crossSearch());

						}
						else JOptionPane.showMessageDialog(rootPane,"Incorrect number format\nMust be a number, between 1 and 999","Error",JOptionPane.ERROR_MESSAGE);
					}

				}
				else {

					boolean present = false;
					DefaultListModel<CellListItem> mod = (DefaultListModel<CellListItem>) list_selected.getModel();
					for(int i=0;i<mod.size();i++) {
						int id = mod.get(i).getEItem().getId();
						float diff = Math.abs(id-eitem.getId())/4f;
						if(diff==(int)diff){
							present = true;
						}
					}
					if(present) {
						JOptionPane.showMessageDialog(rootPane, "You can't add the same armor type twice !", "Warning", JOptionPane.WARNING_MESSAGE);
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
		
		if(!list_selected.isSelectionEmpty()) {
			
			items.remove(list_selected.getSelectedValue().getItem());
			loadSelected(items);
			loadSelectable(crossSearch());
			
		}
		
	}

	private void loadSelectable(ArrayList<EItem> values) {
		DefaultListModel<CellListEItem> mod_ItemsSelectable = new DefaultListModel<>();
		for(int i=0;i<values.size();i++) {
			mod_ItemsSelectable.addElement(new CellListEItem(values.get(i)));
		}
		list_selectable.setModel(mod_ItemsSelectable);
	}

	private void loadSelected(ItemList values) {
		if (!isArmor) {
			values.sort();
		}
		else {
			((ArmorList)values).sort();
		}
		DefaultListModel<CellListItem> mod_ItemsSelectable = new DefaultListModel<>();
		for(int i=0;i<values.size();i++) {
			mod_ItemsSelectable.addElement(new CellListItem(values.get(i)));
		}
		list_selected.setModel(mod_ItemsSelectable);
	}

	private ArrayList<EItem> switchValues() {
		ArrayList<EItem> values;
		String sort = (String) combo_sort.getSelectedItem();
		if(sort.equals("All")) values = new ArrayList<EItem>(Arrays.asList(EItem.values()));
		else if (isArmor) {
			values = new ArrayList<>();
			for(int i=298;i<=317;i++){
				values.add(EItem.searchBy(i, 0));
			}
		}
		else values = EItem.getByCategory(EItemCat.getByName(sort));
		
		if(classSelector) {
			values.remove(EItem.bone);
			values.remove(EItem.hay_block);
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
