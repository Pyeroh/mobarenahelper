package view;

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
import java.util.Collections;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import model.Item;
import model.ItemList;
import model.enums.EItem;
import model.enums.EItemCat;
import view.cells.CellListEItem;
import view.cells.CellListItem;
import view.cells.HoverListCellRenderer;

public class ItemSelector extends JFrame {

	private static final long serialVersionUID = 7238413511342140781L;

	private ItemList items;
	private int max;
	private boolean isArmor;

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

	/**
	 * Constructeur d'un sélecteur d'items à partir de la liste {@code items} et
	 * permettant la sélection de {@code max} items.
	 * @param items la liste d'entrée
	 * @param max le nombre d'items sélectionnable max, non géré pour le moment 
	 * @param isArmor si la fenêtre est un sélecteur d'armure, non géré pour le moment
	 * @throws ParseException 
	 */
	public ItemSelector(ItemList items, int max, boolean isArmor) {
		super("Item Selector - MobArena Helper v2");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ItemSelector.class.getResource("/gui/mobarena.png")));
		setResizable(false);
		this.items = items;
		this.max = max;
		this.isArmor = isArmor;

		setSize(850,356);
		setLocationRelativeTo(null);
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
					
					values.removeAll(ItemSelector.this.items);
					loadSelectable(values);

				}

			}
		});
		combo_sort.setFont(new Font("SansSerif", Font.PLAIN, 12));
		combo_sort.setModel(new DefaultComboBoxModel<String>(EItemCat.namevalues()));
		combo_sort.setBounds(73, 43, 121, 25);
		getContentPane().add(combo_sort);

		lib_search = new JLabel("Search");
		lib_search.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_search.setBounds(6, 80, 55, 25);
		getContentPane().add(lib_search);

		try {
			sai_search = new JFormattedTextField(new MaskFormatter("LLLLLLLLLL"));
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

		ArrayList<EItem> values = new ArrayList<>(Arrays.asList(EItem.values()));
		values.removeAll(items);
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
			public void mouseClicked(MouseEvent e) {
				
				if (!list_selectable.isSelectionEmpty()) {
					int nb_items = list_selected.getModel().getSize();
					if (nb_items == ItemSelector.this.max) {
						JOptionPane.showMessageDialog(
								rootPane,
								"You can't add more items !", "Warning",
								JOptionPane.WARNING_MESSAGE);
					} else {
						
						EItem eitem = list_selectable.getSelectedValue().getEItem();
						if(!isArmor()) {
							
							String input = JOptionPane.showInputDialog(rootPane, "How many items do you wish to add ?",1);
							System.out.println(input);
							if (input!=null) {
								if (input.matches("(\\d)+")) {
									ItemList il = ItemSelector.this.items;
									il.add(new Item(eitem, Integer
											.parseInt(input), null));
									loadSelected(il);
									ArrayList<EItem> values = switchValues();
									ArrayList<EItem> val_search = new ArrayList<EItem>();
									String search = sai_search.getText().trim();
									if (!search.equals("")) {
										val_search = EItem.searchBy(search);
										values.retainAll(val_search);
									}
									
									values.removeAll(ItemSelector.this.items);
									loadSelectable(values);

								}
							}
							
						}
						else {
							
							
							
						}
						
					}
				}
				
			}
		});
		btn_add.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_add.setBounds(368, 170, 101, 28);
		getContentPane().add(btn_add);

		btn_remove = new JButton("<< Remove");
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

		scrpan_selected = new JScrollPane(list_selected);
		scrpan_selected.setBounds(481, 112, 350, 200);
		getContentPane().add(scrpan_selected);

		setVisible(true);

	}


	public ItemList getItemList() {
		return items;
	}
	
	private int getMax() {
		return max;
	}
	
	private boolean isArmor() {
		return isArmor;
	}
	
	private void loadSelectable(ArrayList<EItem> values) {
		DefaultListModel<CellListEItem> mod_ItemsSelectable = new DefaultListModel<>();
		for(int i=0;i<values.size();i++) {
			mod_ItemsSelectable.addElement(new CellListEItem(values.get(i)));
		}
		list_selectable.setModel(mod_ItemsSelectable);
	}
	
	private void loadSelected(ArrayList<Item> values) {
		Collections.sort(values);
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
		else values = EItem.getByCategory(EItemCat.getByName(sort));
		
		return values;
	}
	
	private ArrayList<EItem> crossSearch() {
		ArrayList<EItem> values = switchValues();
		ArrayList<EItem> val_search = EItem.searchBy(sai_search.getText().trim());
		
		values.retainAll(val_search);
		values.removeAll(items);
		
		return values;
	}
}
