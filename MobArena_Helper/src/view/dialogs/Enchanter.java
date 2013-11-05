package view.dialogs;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

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
		btn_add.setBounds(270, 151, 144, 28);
		getContentPane().add(btn_add);
		
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
		HoverListCellRenderer render = new HoverListCellRenderer(list_enchant);
		list_enchant.setCellRenderer(render);
		list_enchant.addMouseListener(render.getHandler());
		list_enchant.addMouseMotionListener(render.getHandler());
		
		ArrayList<EEnchantment> enchant_list = EEnchantItem.getByItem(item.getItem());
		enchant_list.removeAll(enchants.getEEnchantmentList());
		DefaultComboBoxModel<String> mod_enchant = new DefaultComboBoxModel<>();
		for(int i=0;i<enchant_list.size();i++) {
			mod_enchant.addElement(enchant_list.get(i).getName());
		}
		combo_enchantment.setModel(mod_enchant);
		combo_enchantment.setSelectedIndex(-1);
		
	}
}
