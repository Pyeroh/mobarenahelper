package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.ArmorList;
import model.Classe;
import model.wave.UpgradeSet;
import model.wave.UpgradeSet.UpSetup;
import model.wave.UpgradeW;
import view.cells.CellListCaracs;
import view.cells.CellListClass;
import view.cells.HoverListCellRenderer;

public class UpgradeWaveChanger extends JFrame {

	private static final long serialVersionUID = -8859125188519188824L;
	private UpgradeW upgradew;
	private UpgradeSet upset;
	private JFrame frame;
	private JScrollPane scrpan_classes;
	private JList<CellListClass> list_classes;
	private JLabel lib_classes_upgrade;
	private JPanel pan_upgrade_config;
	private JLabel lib_setup;
	private JButton btn_add_class;
	private JLabel lib_items;
	private JButton btn_set_items;
	private JLabel lib_armor;
	private JButton btn_set_armor;
	private JLabel lib_permissions;
	private JScrollPane scrpan_permissions;
	private JList<CellListCaracs> list_permissions;
	private JComboBox<String> combo_setup;
	private JButton btn_add_perm;

	public UpgradeWaveChanger(JFrame frame, UpgradeW upw) {
		super("Upgrade Wave modifier - "+frame.getTitle());
		frame.setEnabled(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				UpgradeWaveChanger.this.frame.setEnabled(true);
			}
		});

		setIconImage(Toolkit.getDefaultToolkit().getImage(UpgradeWaveChanger.class.getResource("/gui/mobarena.png")));
		setResizable(false);
		this.upgradew = upw;
		this.frame = frame;

		getContentPane().setLayout(null);
		setSize(658, 300);
		setLocationRelativeTo(frame);
		setVisible(true);

		list_classes = new JList<CellListClass>();
		HoverListCellRenderer render = new HoverListCellRenderer(list_classes);
		list_classes.setCellRenderer(render);
		list_classes.addMouseListener(render.getHandler());
		list_classes.addMouseMotionListener(render.getHandler());
		list_classes.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {

				int index = list_classes.getSelectedIndex();
				
				ArrayList<UpgradeSet> upsetlist = upgradew.getUpgrades();

				if (index!=-1) {
					if (e.getButton() == MouseEvent.BUTTON1) {

						setInvisibleComponents();
						loadUpgradeSet(upsetlist.get(index));
						combo_setup.setSelectedItem(upset.getSetup().toString());

					}

					else if (e.getButton() == MouseEvent.BUTTON2) {

						int choice = JOptionPane.showConfirmDialog(rootPane,
								"Are you sure you want to delete upgrades for the "
										+ upsetlist.get(index).getClasse()
										.getName() + " class ?",
										"Confirmation", JOptionPane.YES_NO_OPTION);
						if (choice == JOptionPane.YES_OPTION) {
							upsetlist.remove(index);
							load();
							setInvisibleComponents();
						}

					}
				}
				else list_classes.clearSelection();

			}
		});

		scrpan_classes = new JScrollPane(list_classes);
		scrpan_classes.setBounds(6, 43, 317, 219);
		scrpan_classes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(scrpan_classes);

		lib_classes_upgrade = new JLabel("Classes to upgrade");
		lib_classes_upgrade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_classes_upgrade.setBounds(6, 6, 131, 25);
		getContentPane().add(lib_classes_upgrade);

		btn_add_class = new JButton("Add class");
		btn_add_class.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				@SuppressWarnings("unchecked")
				ArrayList<Classe> classe_list = (ArrayList<Classe>) Classe.classe_list.clone();
				ArrayList<Classe> up_classe_list = new ArrayList<Classe>();
				ArrayList<UpgradeSet> upset_list = upgradew.getUpgrades();
				for(int i=0;i<upset_list.size();i++) {
					up_classe_list.add(upset_list.get(i).getClasse());
				}
				classe_list.removeAll(up_classe_list);
				String[] tab_classe = new String[classe_list.size()];
				for(int i=0;i<classe_list.size();i++) {
					tab_classe[i] = classe_list.get(i).getName();
				}

				if (tab_classe.length!=0) {
					String selection = (String) JOptionPane
							.showInputDialog(
									rootPane,
									"Which class do you want to add to the upgrade list ?",
									"Class selection",
									JOptionPane.QUESTION_MESSAGE, null,
									tab_classe, null);
					if (selection != null) {
						Classe classe = Classe.getByName(selection);
						UpgradeSet upset = new UpgradeSet(classe);
						upset_list.add(upset);
						upgradew.sortUpgrades();
						setInvisibleComponents();
						load();
					}
				}
			}
		});
		btn_add_class.setBounds(233, 5, 90, 28);
		getContentPane().add(btn_add_class);

		pan_upgrade_config = new JPanel();
		pan_upgrade_config.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pan_upgrade_config.setBounds(335, 6, 312, 256);
		getContentPane().add(pan_upgrade_config);
		pan_upgrade_config.setLayout(null);

		lib_setup = new JLabel("Setup");
		lib_setup.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_setup.setBounds(6, 6, 48, 20);
		pan_upgrade_config.add(lib_setup);

		combo_setup = new JComboBox<String>();
		combo_setup.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if(e.getStateChange() == ItemEvent.DESELECTED && combo_setup.isFocusOwner()) {

					upset.setSetup(UpSetup.valueOf(((String) combo_setup.getSelectedItem()).toLowerCase()));
					setInvisibleComponents();
					loadUpgradeSet(upset);

				}

			}
		});
		combo_setup.setModel(new DefaultComboBoxModel<String>(UpSetup.namevalues()));
		combo_setup.setBounds(66, 6, 114, 20);
		pan_upgrade_config.add(combo_setup);

		lib_items = new JLabel("Items");
		lib_items.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_items.setBounds(6, 38, 48, 20);
		pan_upgrade_config.add(lib_items);

		MouseAdapter itemsetter = new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {

				JFrame frame = UpgradeWaveChanger.this;
				if(e.getSource() == btn_set_items) {
					upset.setItems(new ItemSelector(frame,upset.getItems(),0,false).getItemList());
				}
				else if(e.getSource()== btn_set_armor) {
					upset.setArmor((ArmorList) new ItemSelector(frame,upset.getArmor(),4,true).getItemList());
				}

			}
		};

		btn_set_items = new JButton("Set");
		btn_set_items.addMouseListener(itemsetter);
		btn_set_items.setBounds(66, 38, 114, 20);
		pan_upgrade_config.add(btn_set_items);

		lib_armor = new JLabel("Armor");
		lib_armor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_armor.setBounds(6, 70, 48, 20);
		pan_upgrade_config.add(lib_armor);

		btn_set_armor = new JButton("Set");
		btn_set_armor.addMouseListener(itemsetter);
		btn_set_armor.setBounds(66, 70, 114, 20);
		pan_upgrade_config.add(btn_set_armor);

		list_permissions = new JList<CellListCaracs>();
		list_permissions.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				list_permissions.clearSelection();
			}
		});
		render = new HoverListCellRenderer(list_permissions);
		list_permissions.setCellRenderer(render);
		list_permissions.addMouseListener(render.getHandler());
		list_permissions.addMouseMotionListener(render.getHandler());
		list_permissions.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {

				int index = list_permissions.getSelectedIndex();

				ArrayList<String> perm_list = upset.getPermissions();

				if (index!=-1) {
					if (e.getButton() == MouseEvent.BUTTON2) {
						int choice = JOptionPane.showConfirmDialog(rootPane,
								"Are you sure you want to delete the "
										+ perm_list.get(index)
										+ " permission ?", "Confirmation",
										JOptionPane.YES_NO_OPTION);
						if (choice == JOptionPane.YES_OPTION) {
							perm_list.remove(index);
							loadUpgradeSet(upset);
						}
					}
				}

			}
		});

		lib_permissions = new JLabel("Permissions");
		lib_permissions.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_permissions.setBounds(6, 102, 76, 20);
		pan_upgrade_config.add(lib_permissions);

		btn_add_perm = new JButton("Add");
		btn_add_perm.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				String perm = JOptionPane.showInputDialog(
						rootPane,
						"What is the permission you want to add ?\nWARNING : as MobArena Helper can't see plugins you have \non your server, it can't control permissions you add in the config file.",
						"Permission", JOptionPane.QUESTION_MESSAGE);

				if(perm!=null) {
					upset.getPermissions().add(perm);
					loadUpgradeSet(upset);
				}
			}
		});
		btn_add_perm.setBounds(216, 102, 90, 20);
		pan_upgrade_config.add(btn_add_perm);

		scrpan_permissions = new JScrollPane(list_permissions);
		scrpan_permissions.setBounds(6, 123, 300, 127);
		pan_upgrade_config.add(scrpan_permissions);

		load();
		setInvisibleComponents();

	}

	private void load() {
		DefaultListModel<CellListClass> mod_class = new DefaultListModel<CellListClass>();
		ArrayList<UpgradeSet> upset = upgradew.getUpgrades();
		for(int i=0;i<upset.size();i++) {
			mod_class.addElement(new CellListClass(upset.get(i).getClasse()));
		}
		list_classes.setModel(mod_class);

	}

	private void setInvisibleComponents() {
		pan_upgrade_config.setVisible(false);

		lib_armor.setVisible(false);
		btn_set_armor.setVisible(false);
		lib_permissions.setVisible(false);
		btn_add_perm.setVisible(false);
		scrpan_permissions.setVisible(false);
	}

	private void loadUpgradeSet(UpgradeSet upset) {
		pan_upgrade_config.setVisible(true);

		this.upset = upset;

		if (this.upset.getSetup()==UpSetup.advanced) {
			lib_armor.setVisible(true);
			btn_set_armor.setVisible(true);
			lib_permissions.setVisible(true);
			btn_add_perm.setVisible(true);
			scrpan_permissions.setVisible(true);

			ArrayList<String> permissions = this.upset.getPermissions();
			DefaultListModel<CellListCaracs> mod_perm = new DefaultListModel<CellListCaracs>();
			for (int i = 0; i < permissions.size(); i++) {
				mod_perm.addElement(new CellListCaracs(permissions.get(i)));
			}
			list_permissions.setModel(mod_perm);
		}

	}
}
