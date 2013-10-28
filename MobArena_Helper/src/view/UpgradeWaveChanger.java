package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import model.wave.UpgradeW;
import view.cells.CellListClass;

import javax.swing.DefaultComboBoxModel;

import model.wave.UpgradeSet.UpSetup;

import javax.swing.JButton;

public class UpgradeWaveChanger extends JFrame {

	private static final long serialVersionUID = -8859125188519188824L;
	private UpgradeW upgradew;
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
	private JList<String> list_permissions;

	public UpgradeWaveChanger(UpgradeW upw, JFrame frame) {
		super("Upgrade Wave modifier - "+frame.getTitle());
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpgradeWaveChanger.class.getResource("/gui/mobarena.png")));
		setResizable(false);
		this.upgradew = upw;
		this.frame = frame;
		
		setAlwaysOnTop(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(null);
		
		list_classes = new JList<CellListClass>();
		
		scrpan_classes = new JScrollPane(list_classes);
		scrpan_classes.setBounds(6, 43, 317, 173);
		scrpan_classes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(scrpan_classes);
		
		lib_classes_upgrade = new JLabel("Classes to upgrade");
		lib_classes_upgrade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_classes_upgrade.setBounds(6, 6, 131, 25);
		getContentPane().add(lib_classes_upgrade);
		
		btn_add_class = new JButton("Add class");
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
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(UpSetup.namevalues()));
		comboBox.setBounds(66, 6, 114, 20);
		pan_upgrade_config.add(comboBox);
		
		lib_items = new JLabel("Items");
		lib_items.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_items.setBounds(6, 38, 48, 20);
		pan_upgrade_config.add(lib_items);
		
		btn_set_items = new JButton("Set");
		btn_set_items.setBounds(66, 38, 114, 20);
		pan_upgrade_config.add(btn_set_items);
		
		lib_armor = new JLabel("Armor");
		lib_armor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_armor.setBounds(6, 70, 48, 20);
		pan_upgrade_config.add(lib_armor);
		
		btn_set_armor = new JButton("Set");
		btn_set_armor.setBounds(66, 70, 114, 20);
		pan_upgrade_config.add(btn_set_armor);
		
		list_permissions = new JList<String>();
		
		scrpan_permissions = new JScrollPane(list_permissions);
		scrpan_permissions.setBounds(6, 123, 300, 127);
		pan_upgrade_config.add(scrpan_permissions);
		
		lib_permissions = new JLabel("Permissions");
		lib_permissions.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_permissions.setBounds(6, 102, 76, 20);
		pan_upgrade_config.add(lib_permissions);
		
	}
}
