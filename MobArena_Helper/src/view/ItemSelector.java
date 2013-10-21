package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import model.ItemList;
import model.enums.EItemCat;
import view.cells.CellListItem;

public class ItemSelector extends JFrame {

	private static final long serialVersionUID = 7238413511342140781L;
	@SuppressWarnings("unused")
	private ItemList items;
	@SuppressWarnings("unused")
	private int max;
	
	private JLabel lib_selectable;
	private JLabel lib_sort;
	private JWideComboBox combo_sort;
	private JLabel lib_search;
	private JFormattedTextField sai_search;
	private JList<CellListItem> list_selectable;
	private JButton btn_add;
	private JButton btn_remove;
	private JScrollPane scrpan_selected;
	private JList<CellListItem> list_selected;
	private JLabel lib_selected;

	/**
	 * Constructeur d'un sélecteur d'items à partir de la liste {@code items} et
	 * permettant la sélection de {@code max} items.
	 * @param items la liste d'entrée
	 * @param max le nombre d'items sélectionnable max
	 * @throws ParseException 
	 */
	public ItemSelector(ItemList items, int max) throws ParseException {
		super("Item Selector - MobArena Helper v2");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ItemSelector.class.getResource("/gui/mobarena.png")));
		setResizable(false);
		this.items = items;
		this.max = max;
		
		 setSize(623,356);
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
		 combo_sort.setFont(new Font("SansSerif", Font.PLAIN, 12));
		 combo_sort.setModel(new DefaultComboBoxModel<String>(EItemCat.namevalues()));
		 combo_sort.setBounds(73, 43, 121, 25);
		 getContentPane().add(combo_sort);
		 
		 lib_search = new JLabel("Search");
		 lib_search.setFont(new Font("Tahoma", Font.BOLD, 13));
		 lib_search.setBounds(6, 80, 55, 25);
		 getContentPane().add(lib_search);
		 
		 sai_search = new JFormattedTextField(new MaskFormatter("LLLLLLLLLL"));
		 sai_search.setBackground(new Color(255, 255, 255));
		 sai_search.setBounds(73, 80, 122, 25);
		 sai_search.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		 getContentPane().add(sai_search);
		 sai_search.setColumns(10);
		 
		 list_selectable = new JList<CellListItem>();
		 getContentPane().add(list_selectable);
		 
		 JScrollPane scrpan_selectable = new JScrollPane(list_selectable);
		 scrpan_selectable.setBounds(6, 117, 240, 200);
		 getContentPane().add(scrpan_selectable);
		 
		 btn_add = new JButton("Add >>");
		 btn_add.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btn_add.setBounds(258, 175, 101, 28);
		 getContentPane().add(btn_add);
		 
		 btn_remove = new JButton("<< Remove");
		 btn_remove.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btn_remove.setBounds(258, 215, 101, 28);
		 getContentPane().add(btn_remove);
		 
		 list_selected = new JList<CellListItem>();
		 getContentPane().add(list_selected);
		 
		 scrpan_selected = new JScrollPane(list_selected);
		 scrpan_selected.setBounds(371, 117, 240, 200);
		 getContentPane().add(scrpan_selected);
		 
		 lib_selected = new JLabel("Items selected");
		 lib_selected.setFont(new Font("Tahoma", Font.BOLD, 14));
		 lib_selected.setBounds(371, 11, 121, 25);
		 getContentPane().add(lib_selected);
		 
	}


	public ItemList getItemList() {
		
		
		
		return null;
	}
}
