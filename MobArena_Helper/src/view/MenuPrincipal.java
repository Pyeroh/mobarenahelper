package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.math.RoundingMode;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.*;
import model.enums.*;
import model.item.AbstractItem;
import model.lists.*;
import model.wave.*;
import view.cells.*;
import view.dialogs.*;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 7504976316824014595L;

	private Arenas arenas = null;
	private File file = null;
	private Wave wave;
	private Reward reward;
	private Classe classe;
	private ArenaConfig config;
	private boolean initializing = true;

	private JMenuItem mntmAbout;
	private JMenuBar menuBar;
	private JMenu mnApplication;

	private JMenuItem mntmNewConfiguration;

	private JMenu mnHelp;
	private JMenuItem mntmHowToUse;
	private JMenu mnPlanned;
	private JMenuItem mntmTodoList;

	private JTabbedPane tabpan_config;
	private JPanel pan_arena_wave;
	private JLabel lib_arena;
	private JWideComboBox combo_arena;
	private JButton btn_plus;
	private JButton btn_moins;

	private JLabel lib_recurrent;
	private JButton btn_newrecurrent;
	private JScrollPane scrpan_recurrent;
	private JHoverList<CellListWave> list_recurrent;
	private JLabel lib_single;
	private JButton btn_newsingle;
	private JScrollPane scrpan_single;
	private JHoverList<CellListWave> list_single;
	private JButton btn_load;
	private JButton btn_save;
	private JPanel pan_conf;
	private JLabel lib_name;
	private JTextField sai_name;
	private JLabel lib_category;
	private JComboBox<String> combo_category;
	private JLabel lib_type;
	private JComboBox<String> combo_type;
	private JLabel lib_wave;
	private JFormattedTextField sai_wave;
	private JLabel lib_priority;
	private JFormattedTextField sai_priority;
	private JLabel lib_frequency;
	private JFormattedTextField sai_frequency;
	private JLabel lib_growth;
	private JComboBox<String> combo_growth;
	private JLabel lib_carac_wave;
	private JScrollPane scrpan_carac_wave;
	private JHoverList<CellListCaracs> list_carac_wave;
	private JLabel lib_monster;
	private JWideComboBox combo_monster;
	private JLabel lib_amount;
	private JComboBox<String> combo_amount;
	private JLabel lib_health;
	private JComboBox<String> combo_health;
	private JTextArea lib_abi_announce;
	private JCheckBox chk_abi_announce;
	private JTextArea lib_abi_interval;
	private JFormattedTextField sai_abi_interval;
	private JLabel lib_boss_name;

	private JTextField sai_boss_name;

	private JButton btn_add;
	private JWideComboBox combo_carac_wave;
	private JFormattedTextField sai_nb_carac_wave;
	private JLabel lib_set;
	private JButton btn_set;

	private JPanel pan_caracs_class;
	private JLabel lib_dogs;
	private JFormattedTextField sai_dogs;
	private JLabel lib_horse;
	private JLabel lib_classes;
	private JButton btn_new_class;
	private JScrollPane scrpan_classes;
	private JHoverList<CellListClass> list_classes;
	private JLabel lib_class;
	private JLabel lib_items;
	private JButton btn_items;
	private JLabel lib_armor;
	private JButton btn_armor;
	private JFormattedTextField sai_class;
	private JComboBox<String> combo_horse;
	private JPanel pan_classes;
	private JLabel lib_hArmor;
	private JComboBox<String> combo_hArmor;
	private JLabel lib_permissions;
	private JButton btn_add_perm;
	private JScrollPane scrpan_permissions;
	private JHoverList<CellListCaracs> list_permissions;
	private JLabel lib_lobby_permissions;
	private JButton btn_add_lobby_permissions;
	private JHoverList<CellListCaracs> list_lobby_permissions;
	private JScrollPane scrpan_lobby_permissions;
	private JPanel pan_arena_settings;
	private JLabel lib_world;
	private JFormattedTextField sai_world;
	private JCheckBox chk_enabled;
	private JCheckBox chk_protect;
	private JLabel lib_entry;
	private JFormattedTextField sai_entry;
	private JButton btn_entry;
	private JCheckBox chk_clear_wave_next;
	private JCheckBox chk_clear_boss_next;
	private JCheckBox chk_clear_wave_boss;
	private JCheckBox chk_lightning;
	private JCheckBox chk_auto_equip;
	private JCheckBox chk_soft_restore;
	private JCheckBox chk_soft_restore_drops;
	private JCheckBox chk_require_inv_join;
	private JCheckBox chk_require_inv_spec;
	private JCheckBox chk_hellhounds;
	private JCheckBox chk_pvp;
	private JCheckBox chk_monster_infight;
	private JCheckBox chk_allow_tp;
	private JCheckBox chk_spectate_death;
	private JCheckBox chk_auto_respawn;
	private JCheckBox chk_share;
	private JLabel lib_min_players;
	private JFormattedTextField sai_min_players;
	private JFormattedTextField sai_max_players;
	private JLabel lib_max_players;
	private JLabel lib_max_join_distance;
	private JFormattedTextField sai_max_join_distance;
	private JLabel lib_first_delay;
	private JFormattedTextField sai_first_delay;
	private JLabel lib_interval;
	private JFormattedTextField sai_interval;
	private JLabel lib_final_wave;
	private JFormattedTextField sai_final_wave;
	private JLabel lib_monster_limit;
	private JFormattedTextField sai_monster_limit;
	private JCheckBox chk_monster_xp;
	private JCheckBox chk_keep_xp;
	private JCheckBox chk_food_regen;
	private JCheckBox chk_lock_food;
	private JLabel lib_player_time;
	private JComboBox<String> combo_player_time;
	private JLabel lib_auto_start;
	private JFormattedTextField sai_auto_start;
	private JCheckBox chk_spout_class;
	private JCheckBox chk_auto_ignite;
	private JCheckBox chk_use_class_chest;
	private JCheckBox chk_display_waves;
	private JCheckBox chk_display_timer;
	private JCheckBox chk_auto_ready;
	private JCheckBox chk_scoreboard;
	private JCheckBox chk_isolated_chat;
	private JCheckBox chk_global_join;
	private JCheckBox chk_global_end;
	private JMenuItem mntmQuit;
	private JMenu mnLanguage;
	private JRadioButtonMenuItem rdbtnmntmFrench;
	private JRadioButtonMenuItem rdbtnmntmEnglish;
	private JPanel pan_class_limit;
	private JFormattedTextField sai_class_limit;
	private JLabel lib_class_limit;
	private JPanel pan_global_settings;
	private JCheckBox chk_gs_enabled;
	private JCheckBox chk_notifications;
	private JLabel lib_commands;
	private JButton btn_command;
	private JScrollPane scrpan_commands;
	private JHoverList<CellListCaracs> list_commands;
	private JPanel pan_commands;
	private JLabel lib_command;
	private JFormattedTextField sai_command;
	private JLabel lib_command_help;
	private JPanel pan_coordinates;
	private JPanel pan_rewards;
	private JLabel lib_every;
	private JScrollPane scrpan_every;
	private JHoverList<CellListReward> list_every;
	private JLabel lib_after;
	private JScrollPane scrpan_after;
	private JHoverList<CellListReward> list_after;
	private JButton btn_add_every;
	private JButton btn_add_after;
	private JButton btn_set_rewards;
	private JScrollPane scrpan_points;
	private JTree tree_points;
	private JLabel lib_X;
	private JLabel lib_Y;
	private JLabel lib_Z;
	private JTextField sai_X;
	private JTextField sai_Y;
	private JTextField sai_Z;
	private JLabel lib_angle;
	private JTextField sai_angle;
	private JLabel lib_pitch;
	private JTextField sai_pitch;
	private JPanel pan_coords;
	private JPanel pan_reward_control;
	private JFormattedTextField sai_reward_wave_number;
	private JLabel lib_reward_wave;
	private JLabel lib_moment;
	private JWideComboBox combo_montant;

	public MenuPrincipal() throws ParseException{
		super("MobArena Helper v2.3");
		setTitle(Messages.getString("MenuPrincipal.this.title")); //$NON-NLS-1$
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int choice = JOptionPane.showConfirmDialog(rootPane, Messages.getString("MenuPrincipal.message.unsavedChangesQuit"), Messages.getString("Message.title.confirmation"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(choice==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		loadLocale();

		setIconImage(new ImageIcon(MenuPrincipal.class.getResource("/gui/pics/mobarena.png")).getImage());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setVisible(true);

		MouseAdapter newWave = new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				newWave(e);
			}
		};

		MouseAdapter cellmouseadapter = new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				waveArenaCellMouseAdapter(e);
			}
		};

		KeyAdapter mask_numeric = new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				JComponent component = (JComponent) e.getSource();
				if(component instanceof JFormattedTextField){
					try {
						((JFormattedTextField)component).commitEdit();
					} catch (ParseException e1) {}
				}
				if (((JFormattedTextField) component).getValue()!=null) {
					majData_Arena(component);
				}
			}
		};

		ItemListener itemListener_monster_amount = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				//la clause isFocusOwner() est spécifiée car la combo Amount change de valeur à l'initialisation
				if (e.getStateChange() == ItemEvent.DESELECTED && ((JComponent) e.getSource()).isFocusOwner()) {
					JHoverList<CellListWave> list_sel = combo_category.getSelectedItem().equals("Recurrent") ? list_recurrent : list_single;

					@SuppressWarnings("unchecked")
					JComboBox<String> combo_sel = (JComboBox<String>) e.getSource();

					wave = list_sel.getSelectedValue().getWave();
					String type = (String) combo_sel.getSelectedItem();

					if (combo_sel == combo_monster) {

						MonsterList monstres = wave.getMonstres();
						monstres.clear();
						monstres.add(new Monstre(EMonsters.getByName(type), 0));

					}
					else {

						SwarmW swwave = (SwarmW) wave;
						swwave.setAmount(EAmount.getByName(type));

					}

				}

			}
		};

		ItemListener language_listener = new ItemListener() {
			@SuppressWarnings("unused")
			private JRadioButtonMenuItem deselected_one;
			@Override
			public void itemStateChanged(ItemEvent e) {
				JRadioButtonMenuItem source = (JRadioButtonMenuItem) e.getSource();
				if (e.getStateChange()==ItemEvent.SELECTED) {
					if (!initializing) {
						int choice = JOptionPane
								.showConfirmDialog(
										rootPane,
										Messages.getString("MenuPrincipal.message.changeLang"),
										Messages.getString("Message.title.confirmation"),
										JOptionPane.YES_NO_OPTION);
						switch (choice) {
						case JOptionPane.YES_OPTION:
							if (source == rdbtnmntmEnglish) {
								Locale.setDefault(Locale.ENGLISH);
							} else if (source == rdbtnmntmFrench) {
								Locale.setDefault(Locale.FRENCH);
							}
							MenuPrincipal.this.setVisible(false);
							try {
								new MenuPrincipal();
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							break;
						case JOptionPane.NO_OPTION:
							source.setSelected(true);
							break;
						}
					}
				}
				else deselected_one = source;

			}
		};

		btn_load = new JButton(Messages.getString("MenuPrincipal.btn_load.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_load.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Classe.classe_list.clear();
				YmlJFileChooser fchoose = new YmlJFileChooser();
				fchoose.showOpenDialog(null);
				file = fchoose.getSelectedFile();
				if (file!=null) {
					raz();
					try {
						file = fchoose.getSelectedFile();
						GestYaml.S_gestionnaire = new GestYaml(file);
						GestYaml g = GestYaml.S_gestionnaire;
						arenas = new Arenas(g.getMap("arenas"),g.getMap("global-settings"),g.getMap("classes"));
						ArrayList<Arena> alArenas = arenas.getALarenas();
						for(int i=0;i<alArenas.size();i++){
							combo_arena.addItem(alArenas.get(i).getNom());
						}
						loadArena(0);
						tabpan_config.setEnabledAt(1, true);
						tabpan_config.setEnabledAt(2, true);
						tabpan_config.setEnabledAt(3, true);
						tabpan_config.setEnabledAt(4, true);
						tabpan_config.setEnabledAt(5, true);
					} catch (Exception e1) {
						e1.printStackTrace();
						raz();

						JOptionPane.showMessageDialog(rootPane, Messages.getString("MenuPrincipal.message.incorrectFileFormat"),Messages.getString("Message.title.criticalError"),JOptionPane.ERROR_MESSAGE);
						error_log(e1);
					}

				}
			}
		});
		btn_load.setForeground(new Color(255, 255, 255));
		btn_load.setBackground(new Color(100, 149, 237));
		btn_load.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_load.setBounds(532, 554, 97, 23);
		getContentPane().add(btn_load);

		btn_save = new JButton(Messages.getString("MenuPrincipal.btn_save.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(arenas!=null){

					YmlJFileChooser fchoose;
					if (file!=null) {
						fchoose = new YmlJFileChooser(file.getPath());
					}
					else fchoose = new YmlJFileChooser();
					fchoose.showOpenDialog(null);
					File f = fchoose.getSelectedFile();
					if (f!=null) {
						if (!f.getPath().endsWith(".yml")) {
							f = new File(f.getPath() + ".yml");
						}

						if(f.exists()) {
							int choice = JOptionPane
									.showConfirmDialog(
											rootPane,
											Messages.getString("MenuPrincipal.message.overwrite"),
											Messages.getString("Message.title.confirmation"),
											JOptionPane.YES_NO_OPTION);
							if(choice==JOptionPane.NO_OPTION) return;
						}

						f.delete();
						try {
							f.createNewFile();
							FileWriter fw = new FileWriter(f);
							GestYaml dumper = new GestYaml(
									arenas.getMap());
							dumper.dumpAsFile(fw);
							JOptionPane
							.showMessageDialog(
									rootPane,
									Messages.getString("MenuPrincipal.message.finishSaving"),
									"",
									JOptionPane.INFORMATION_MESSAGE);

						} catch (Exception e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(rootPane, Messages.getString("MenuPrincipal.message.savingError"),Messages.getString("Message.title.savingError"),JOptionPane.ERROR_MESSAGE);
							error_log(e1);
						}
					}

				}
				else {
					JOptionPane.showMessageDialog(rootPane, Messages.getString("MenuPrincipal.message.mustLoad"),Messages.getString("Message.title.savingError"), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_save.setForeground(Color.WHITE);
		btn_save.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_save.setBackground(new Color(100, 149, 237));
		btn_save.setBounds(639, 554, 115, 23);
		getContentPane().add(btn_save);

		tabpan_config = new JTabbedPane(JTabbedPane.TOP);
		tabpan_config.setBorder(new MatteBorder(0, 0, 1, 0, (Color) UIManager.getColor("Tree.dropLineColor")));
		tabpan_config.setBounds(0, 6, 754, 536);
		getContentPane().add(tabpan_config);

		pan_arena_wave = new JPanel();
		pan_arena_wave.setBounds(43, 54, 732, 443);
		pan_arena_wave.setLayout(null);

		lib_arena = new JLabel(Messages.getString("MenuPrincipal.lib_arena.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_arena.setBounds(9, 8, 46, 17);
		pan_arena_wave.add(lib_arena);
		lib_arena.setFont(new Font("Tahoma", Font.BOLD, 14));

		combo_arena = new JWideComboBox();
		combo_arena.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.DESELECTED && combo_arena.isFocusOwner()) {
					loadArena(combo_arena.getSelectedIndex());
				}
			}
		});
		combo_arena.setBounds(66, 6, 192, 20);
		pan_arena_wave.add(combo_arena);
		combo_arena.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btn_plus = new JButton("+");
		btn_plus.setToolTipText(Messages.getString("MenuPrincipal.btn_plus.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_plus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(arenas==null) {
					raz();
					arenas = new  Arenas();
				}
				String name = JOptionPane.showInputDialog(rootPane, Messages.getString("MenuPrincipal.message.arenaName"),Messages.getString("Message.title.arenaName"), JOptionPane.QUESTION_MESSAGE);
				if(name!=null) {
					name = name.trim();
					if (!name.equals("")) {
						if (!arenas.containsArena(name)) {
							arenas.getALarenas().add(new Arena(name));
							combo_arena.addItem(name);
							combo_arena.setSelectedItem(name);
							loadArena(combo_arena.getSelectedIndex());
							tabpan_config.setEnabledAt(1, true);
							tabpan_config.setEnabledAt(2, true);
							tabpan_config.setEnabledAt(3, true);
							tabpan_config.setEnabledAt(4, true);
							tabpan_config.setEnabledAt(5, true);
						} else
							JOptionPane
							.showMessageDialog(
									rootPane,
									Messages.getString("MenuPrincipal.message.errorArena"),
									Messages.getString("Message.title.error"),
									JOptionPane.ERROR_MESSAGE);
					}
					else JOptionPane.showMessageDialog(rootPane,Messages.getString("MenuPrincipal.message.noNameForArena"),Messages.getString("Message.title.invalidValue"),JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btn_plus.setBounds(215, 27, 20, 20);
		btn_plus.setBorder(new CompoundBorder());
		pan_arena_wave.add(btn_plus);

		btn_moins = new JButton("-");
		btn_moins.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int index = combo_arena.getSelectedIndex();
				if(index!=-1) {
					int choice = JOptionPane.showConfirmDialog(rootPane, String.format(Messages.getString("MenuPrincipal.message.delArena1"), combo_arena.getSelectedItem()), Messages.getString("Message.title.confirmation"), JOptionPane.YES_NO_OPTION);
					if(choice==JOptionPane.YES_OPTION) {
						choice = JOptionPane.showConfirmDialog(rootPane, Messages.getString("MenuPrincipal.message.delArena2"), Messages.getString("Message.title.confirmation"), JOptionPane.YES_NO_OPTION);
						if(choice==JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(rootPane,String.format(Messages.getString("MenuPrincipal.message.delArena3"),combo_arena.getSelectedItem()),Messages.getString("Message.title.confirmation"),JOptionPane.INFORMATION_MESSAGE);
							arenas.getALarenas().remove(index);
							combo_arena.removeItemAt(index);
							combo_arena.setSelectedIndex(combo_arena.getModel().getSize()-1);
							if(arenas.getALarenas().size()==0) {
								raz();
							}
							else loadArena(arenas.getALarenas().size()-1);
						}
					}

				}
			}
		});
		btn_moins.setToolTipText(Messages.getString("MenuPrincipal.btn_moins.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_moins.setBorder(new CompoundBorder());
		btn_moins.setBounds(238, 27, 20, 20);
		pan_arena_wave.add(btn_moins);

		lib_recurrent = new JLabel(Messages.getString("MenuPrincipal.lib_recurrent.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_recurrent.setBounds(9, 60, 146, 17);
		pan_arena_wave.add(lib_recurrent);
		lib_recurrent.setFont(new Font("Tahoma", Font.BOLD, 14));

		btn_newrecurrent = new JButton(Messages.getString("MenuPrincipal.btn_newrecurrent.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_newrecurrent.setBounds(167, 59, 91, 23);
		pan_arena_wave.add(btn_newrecurrent);
		btn_newrecurrent.addMouseListener(newWave);
		btn_newrecurrent.setFont(new Font("Tahoma", Font.BOLD, 11));

		list_recurrent = new JHoverList<CellListWave>();
		list_recurrent.addMouseListener(cellmouseadapter);
		scrpan_recurrent = new JScrollPane(list_recurrent);
		scrpan_recurrent.setBounds(9, 84, 252, 180);
		pan_arena_wave.add(scrpan_recurrent);

		lib_single = new JLabel(Messages.getString("MenuPrincipal.lib_single.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_single.setBounds(9, 276, 132, 17);
		pan_arena_wave.add(lib_single);
		lib_single.setFont(new Font("Tahoma", Font.BOLD, 14));

		btn_newsingle = new JButton(Messages.getString("MenuPrincipal.btn_newsingle.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_newsingle.setBounds(167, 270, 91, 23);
		pan_arena_wave.add(btn_newsingle);
		btn_newsingle.addMouseListener(newWave);
		btn_newsingle.setFont(new Font("Tahoma", Font.BOLD, 11));

		list_single = new JHoverList<CellListWave>();
		list_single.addMouseListener(cellmouseadapter);
		scrpan_single = new JScrollPane(list_single);
		scrpan_single.setBounds(9, 295, 252, 180);
		pan_arena_wave.add(scrpan_single);

		pan_conf = new JPanel();
		pan_conf.setBounds(274, 8, 474, 467);
		pan_arena_wave.add(pan_conf);
		pan_conf.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pan_conf.setLayout(null);

		lib_name = new JLabel(Messages.getString("MenuPrincipal.lib_name.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_name.setForeground(new Color(81, 133, 190));
		lib_name.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_name.setBounds(10, 11, 58, 20);
		pan_conf.add(lib_name);

		sai_name = new JTextField();
		sai_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				ECatW category = wave.getCategory();
				JHoverList<CellListWave> list_sel = category==ECatW.recurrent ? list_recurrent : list_single;
				int index_sel = list_sel.getSelectedIndex();
				Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());

				ArrayList<Wave> waveList = lArene.getWavesType(category);

				String wavename = sai_name.getText().equals("") ? "New_Wave" : sai_name.getText();

				wave.setNom(wavename);
				loadListCaracs_Arena(waveList, list_sel);
				list_sel.setSelectedIndex(index_sel);

			}
		});
		sai_name.setForeground(new Color(81, 133, 190));
		sai_name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sai_name.setBounds(104, 11, 105, 20);
		sai_name.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_conf.add(sai_name);
		sai_name.setColumns(10);

		lib_category = new JLabel(Messages.getString("MenuPrincipal.lib_category.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_category.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_category.setBounds(10, 42, 82, 20);
		pan_conf.add(lib_category);

		combo_category = new JComboBox<String>();
		combo_category.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				if(e.getStateChange() == ItemEvent.DESELECTED && combo_category.isFocusOwner()) {

					ECatW category = wave.getCategory();
					ECatW othercat = category==ECatW.recurrent ? ECatW.single : ECatW.recurrent;

					JHoverList<CellListWave> list_sel = category==ECatW.recurrent ? list_recurrent : list_single;
					JHoverList<CellListWave> otherList_sel = list_sel==list_recurrent ? list_single : list_recurrent;
					Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());

					ArrayList<Wave> waveList = lArene.getWavesType(category);
					ArrayList<Wave> otherWaveList = lArene.getWavesType(othercat);

					waveList.remove(wave);
					wave.setCategory(othercat);
					otherWaveList.add(wave);
					Collections.sort(otherWaveList);

					loadListCaracs_Arena(waveList, list_sel);
					loadListCaracs_Arena(otherWaveList, otherList_sel);

					list_sel.clearSelection();
					otherList_sel.setSelectedIndex(otherWaveList.indexOf(wave));
					setVisibleComponents_Arena(wave);
					switch (wave.getType()) {
					case Default: case Special: case Supply:
						loadListCaracs_Arena(wave.getMonstres(), list_carac_wave);
						break;
					case Boss:
						BossW bwave = (BossW) wave;
						loadListCaracs_Arena(bwave.getAbilities(), list_carac_wave);
						break;
					default:
						break;
					}

				}

			}
		});
		combo_category.setModel(new DefaultComboBoxModel<String>(ECatW.namevalues()));
		combo_category.setBounds(104, 42, 105, 20);
		pan_conf.add(combo_category);

		lib_type = new JLabel(Messages.getString("MenuPrincipal.lib_type.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_type.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_type.setBounds(10, 73, 82, 20);
		pan_conf.add(lib_type);

		combo_type = new JComboBox<String>();
		combo_type.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				Wave nextWave = null;
				if(e.getStateChange() == ItemEvent.DESELECTED && combo_type.isFocusOwner()) {

					ETypeW type = ETypeW.getByName((String) combo_type.getSelectedItem());
					Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());
					String category = wave.getCategory().name();
					JHoverList<CellListWave> list_sel = category.equals("recurrent") ? list_recurrent : list_single;
					ArrayList<Wave> waveList = lArene.getWavesType(wave.getCategory());

					wave.setType(type);
					waveList.remove(wave);

					switch (type) {
					case Default:
						nextWave = wave.getDefaultW();
						combo_growth.setSelectedItem(EGrowth.old.getNom());
						chk_abi_announce.setSelected(false);
						break;
					case Special:
						nextWave = wave.getSpecialW();
						break;
					case Swarm:
						nextWave = wave.getSwarmW();
						combo_amount.setSelectedItem(EAmount.low.getNom());
						break;
					case Boss:
						nextWave = wave.getBossW();
						break;
					case Supply:
						nextWave = wave.getSupplyW();
						break;
					case Upgrade:
						nextWave = wave.getUpgradeW();
						break;
					default:
						break;
					}
					waveList.add(nextWave);
					wave = nextWave;

					Collections.sort(waveList);
					loadListCaracs_Arena(waveList, list_sel);
					list_sel.setSelectedIndex(waveList.indexOf(nextWave));
					setVisibleComponents_Arena(nextWave);

				}

			}
		});
		combo_type.setModel(new DefaultComboBoxModel<String>(ETypeW.namevalues()));
		combo_type.setBounds(104, 73, 105, 20);
		pan_conf.add(combo_type);

		lib_wave = new JLabel(Messages.getString("MenuPrincipal.lib_wave.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_wave.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_wave.setBounds(10, 104, 82, 20);
		pan_conf.add(lib_wave);

		sai_wave = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_wave.setBackground(new Color(255, 255, 255));
		sai_wave.addKeyListener(mask_numeric);
		sai_wave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sai_wave.setBounds(104, 104, 105, 20);
		sai_wave.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_conf.add(sai_wave);
		sai_wave.setColumns(10);

		lib_priority = new JLabel(Messages.getString("MenuPrincipal.lib_priority.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_priority.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_priority.setBounds(10, 135, 82, 20);
		pan_conf.add(lib_priority);

		sai_priority = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_priority.setBackground(new Color(255, 255, 255));
		sai_priority.addKeyListener(mask_numeric);
		sai_priority.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sai_priority.setColumns(10);
		sai_priority.setBounds(104, 135, 105, 20);
		sai_priority.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_conf.add(sai_priority);

		lib_frequency = new JLabel(Messages.getString("MenuPrincipal.lib_frequency.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_frequency.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_frequency.setBounds(10, 166, 82, 20);
		pan_conf.add(lib_frequency);

		sai_frequency = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_frequency.setBackground(new Color(255, 255, 255));
		sai_frequency.addKeyListener(mask_numeric);
		sai_frequency.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sai_frequency.setColumns(10);
		sai_frequency.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_frequency.setBounds(104, 166, 105, 20);
		pan_conf.add(sai_frequency);

		lib_growth = new JLabel(Messages.getString("MenuPrincipal.lib_growth.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_growth.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_growth.setBounds(10, 197, 82, 20);
		pan_conf.add(lib_growth);

		combo_growth = new JComboBox<String>();
		combo_growth.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				if(e.getStateChange() == ItemEvent.DESELECTED && combo_growth.isFocusOwner()) {

					EGrowth growth = EGrowth.getByName(((String) combo_growth.getSelectedItem()).toLowerCase());

					DefaultW defwave = (DefaultW) wave;
					defwave.setGrowth(growth);

				}

			}
		});
		combo_growth.setModel(new DefaultComboBoxModel<String>(EGrowth.namevalues()));
		combo_growth.setBounds(104, 197, 105, 20);
		pan_conf.add(combo_growth);

		lib_carac_wave = new JLabel(); //$NON-NLS-1$ //$NON-NLS-2$
		lib_carac_wave.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_carac_wave.setBounds(219, 11, 69, 20);
		pan_conf.add(lib_carac_wave);

		list_carac_wave = new JHoverList<CellListCaracs>();
		list_carac_wave.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				list_carac_wave.clearSelection();
			}
		});
		list_carac_wave.addMouseListener(cellmouseadapter);

		scrpan_carac_wave = new JScrollPane(list_carac_wave);
		scrpan_carac_wave.setBounds(219, 42, 245, 389);
		pan_conf.add(scrpan_carac_wave);

		lib_monster = new JLabel(Messages.getString("MenuPrincipal.lib_monster.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_monster.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_monster.setBounds(10, 228, 82, 20);
		pan_conf.add(lib_monster);

		combo_monster = new JWideComboBox();
		combo_monster.addItemListener(itemListener_monster_amount);
		combo_monster.setModel(new DefaultComboBoxModel<String>(EMonsters.namevalues()));
		combo_monster.setBounds(104, 228, 105, 20);
		pan_conf.add(combo_monster);

		lib_amount = new JLabel(Messages.getString("MenuPrincipal.lib_amount.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_amount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_amount.setBounds(10, 259, 82, 20);
		pan_conf.add(lib_amount);

		combo_amount = new JComboBox<String>();
		combo_amount.addItemListener(itemListener_monster_amount);
		combo_amount.setModel(new DefaultComboBoxModel<String>(EAmount.namevalues()));
		combo_amount.setSelectedIndex(2);
		combo_amount.setBounds(104, 259, 105, 20);
		pan_conf.add(combo_amount);

		lib_health = new JLabel(Messages.getString("MenuPrincipal.lib_health.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_health.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_health.setBounds(10, 290, 82, 20);
		pan_conf.add(lib_health);

		combo_health = new JComboBox<String>();
		combo_health.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				//la clause isFocusOwner() est spécifiée car la combo Amount change de valeur à l'initialisation
				if(e.getStateChange() == ItemEvent.DESELECTED && combo_health.isFocusOwner()) {

					BossW bwave = (BossW) wave;

					bwave.setHealth(EHealth.getByName((String) combo_health.getSelectedItem()));

				}

			}
		});
		combo_health.setModel(new DefaultComboBoxModel<String>(EHealth.namevalues()));
		combo_health.setSelectedIndex(1);
		combo_health.setBounds(104, 290, 105, 20);
		pan_conf.add(combo_health);

		lib_abi_announce = new JTextArea();
		lib_abi_announce.setFont(new Font("Tahoma", Font.BOLD, 12));
		lib_abi_announce.setWrapStyleWord(true);
		lib_abi_announce.setLineWrap(true);
		lib_abi_announce.setBackground(new Color(214, 217, 223));
		lib_abi_announce.setBorder(new EmptyBorder(0, 0, 0, 0));
		lib_abi_announce.setEditable(false);
		lib_abi_announce.setBounds(10, 321, 82, 36);
		pan_conf.add(lib_abi_announce);

		chk_abi_announce = new JCheckBox();
		chk_abi_announce.setHorizontalAlignment(SwingConstants.CENTER);
		chk_abi_announce.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				//la clause isFocusOwner() est spécifiée car la checkbox change de valeur à l'initialisation
				if(chk_abi_announce.isFocusOwner()) {

					boolean b = chk_abi_announce.isSelected();
					//Cas d'une vague Default
					if(wave instanceof DefaultW){
						DefaultW defwave = (DefaultW) wave;
						defwave.setFixed(b);
					}
					//Cas d'une vague Boss
					else if(wave instanceof BossW){
						BossW bwave = (BossW) wave;
						bwave.setAbility_announce(b);
					}
					else if(wave instanceof UpgradeW) {
						UpgradeW upwave = (UpgradeW) wave;
						upwave.setGive_all_items(b);
					}

				}

			}
		});
		chk_abi_announce.setBounds(104, 322, 105, 20);
		pan_conf.add(chk_abi_announce);

		lib_abi_interval = new JTextArea(Messages.getString("MenuPrincipal.lib_abi_interval.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_abi_interval.setWrapStyleWord(true);
		lib_abi_interval.setLineWrap(true);
		lib_abi_interval.setFont(new Font("Tahoma", Font.BOLD, 12));
		lib_abi_interval.setBackground(new Color(214, 217, 223));
		lib_abi_interval.setBorder(new EmptyBorder(0, 0, 0, 0));
		lib_abi_interval.setEditable(false);
		lib_abi_interval.setBounds(10, 363, 92, 36);
		pan_conf.add(lib_abi_interval);

		sai_abi_interval = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_abi_interval.setBackground(new Color(255, 255, 255));
		sai_abi_interval.addKeyListener(mask_numeric);
		sai_abi_interval.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sai_abi_interval.setColumns(10);
		sai_abi_interval.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_abi_interval.setBounds(104, 369, 105, 20);
		pan_conf.add(sai_abi_interval);

		btn_add = new JButton(Messages.getString("MenuPrincipal.btn_add.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_add.setBorder(new CompoundBorder());
		btn_add.setMargin(new Insets(0, 0, 0, 0));
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (combo_carac_wave.getSelectedIndex()!=-1) {

					String name = (String) combo_carac_wave.getSelectedItem();
					if (wave instanceof BossW) {
						BossW bwave = (BossW) wave;
						ArrayList<EAbilities> abilist = bwave.getAbilities();
						if(abilist.contains(EAbilities.getByName(name))){
							JOptionPane.showMessageDialog(rootPane, Messages.getString("MenuPrincipal.message.doubleAbility"), Messages.getString("Message.title.invalidValue"), JOptionPane.WARNING_MESSAGE);
						}
						else {
							abilist.add(EAbilities.getByName(name));
							loadListCaracs_Arena(abilist,list_carac_wave);
							combo_carac_wave.setSelectedIndex(-1);
						}

					} 
					else if (wave instanceof DefaultW|| wave instanceof SpecialW || wave instanceof SupplyW) {
						if (sai_nb_carac_wave.getValue()==null) {
							JOptionPane
							.showMessageDialog(
									rootPane,
									Messages.getString("MenuPrincipal.message.monsterSpawnProba"),
									Messages.getString("Message.title.invalidValue"),
									JOptionPane.WARNING_MESSAGE);
						} else {
							MonsterList monsterlist = wave.getMonstres();
							int proba = (int)((long) sai_nb_carac_wave.getValue());

							if (monsterlist.contains(EMonsters
									.getByName(name))) {
								JOptionPane
								.showMessageDialog(
										rootPane,
										Messages.getString("MenuPrincipal.message.doubleMonster"),
										Messages.getString("Message.title.invalidValue"),
										JOptionPane.WARNING_MESSAGE);
							} else {
								monsterlist.add(new Monstre(EMonsters
										.getByName(name), proba));
								loadListCaracs_Arena(monsterlist,
										list_carac_wave);
								combo_carac_wave.setSelectedIndex(-1);
								sai_nb_carac_wave.setValue(null);
							}
						}
					}

				}
				else {
					JOptionPane.showMessageDialog(rootPane, Messages.getString("MenuPrincipal.message.noValue"),Messages.getString("Message.title.invalidValue"),JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_add.setBounds(219, 438, 58, 23);
		pan_conf.add(btn_add);

		combo_carac_wave = new JWideComboBox();
		combo_carac_wave.setFont(new Font("SansSerif", Font.PLAIN, 12));
		combo_carac_wave.setBounds(287, 439, 105, 20);
		pan_conf.add(combo_carac_wave);

		sai_nb_carac_wave = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_nb_carac_wave.setBackground(new Color(255, 255, 255));
		sai_nb_carac_wave.addKeyListener(mask_numeric);
		sai_nb_carac_wave.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sai_nb_carac_wave.setBounds(402, 439, 62, 22);
		pan_conf.add(sai_nb_carac_wave);
		sai_nb_carac_wave.setColumns(10);

		lib_boss_name = new JLabel(Messages.getString("MenuPrincipal.lib_boss_name.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_boss_name.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_boss_name.setBounds(10, 401, 92, 20);
		pan_conf.add(lib_boss_name);

		sai_boss_name = new JTextField();
		sai_boss_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				ECatW category = wave.getCategory();
				JHoverList<CellListWave> list_sel = category==ECatW.recurrent ? list_recurrent : list_single;
				int index_sel = list_sel.getSelectedIndex();
				Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());

				ArrayList<Wave> waveList = lArene.getWavesType(category);

				String bossname = sai_boss_name.getText();

				((BossW) wave).setBossName(bossname);
				loadListCaracs_Arena(waveList, list_sel);
				list_sel.setSelectedIndex(index_sel);

			}
		});
		sai_boss_name.setBounds(104, 401, 105, 20);
		sai_boss_name.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_conf.add(sai_boss_name);
		sai_boss_name.setColumns(10);

		lib_set = new JLabel();
		lib_set.setFont(new Font("Tahoma", Font.BOLD, 11));
		lib_set.setBounds(10, 433, 92, 28);
		pan_conf.add(lib_set);

		btn_set = new JButton(Messages.getString("MenuPrincipal.btn_set.text"));
		btn_set.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ETypeW type = wave.getType();

				switch (type) {
				case Supply:
					SupplyW supw = (SupplyW) wave;
					ItemList drops = new ItemSelector(MenuPrincipal.this,supw.getDrops(), -1, false).getItemList();
					supw.setDrops(drops);
					break;
				case Boss:
					BossW bwave = (BossW) wave;
					ItemList reward = new ItemSelector(MenuPrincipal.this,bwave.getReward(), 1, false).getItemList();
					bwave.setReward(reward);
					break;
				case Upgrade:
					UpgradeW upw = (UpgradeW) wave;
					new UpgradeWaveChanger(MenuPrincipal.this, upw);
					break;
				default:
					break;
				}
			}
		});
		btn_set.setBounds(104, 433, 105, 28);
		pan_conf.add(btn_set);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnApplication = new JMenu(Messages.getString("MenuPrincipal.mnApplication.text")); //$NON-NLS-1$ //$NON-NLS-2$
		menuBar.add(mnApplication);

		mntmNewConfiguration = new JMenuItem(Messages.getString("MenuPrincipal.mntmNewConfiguration.text")); //$NON-NLS-1$ //$NON-NLS-2$
		mntmNewConfiguration.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(rootPane, Messages.getString("MenuPrincipal.message.unsavedChangesNew"), Messages.getString("Message.title.confirmation"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(choice==JOptionPane.YES_OPTION) {
					raz();
				}
			}
		});
		mnApplication.add(mntmNewConfiguration);

		mnLanguage = new JMenu(Messages.getString("MenuPrincipal.mnLanguage.text")); //$NON-NLS-1$ //$NON-NLS-2$
		mnApplication.add(mnLanguage);

		rdbtnmntmEnglish = new JRadioButtonMenuItem(Messages.getString("MenuPrincipal.rdbtnmntmEnglish.text"),new ImageIcon(MenuPrincipal.class.getResource("/gui/pics/gb-icon.png"))); //$NON-NLS-1$ //$NON-NLS-2$
		rdbtnmntmEnglish.addItemListener(language_listener);
		mnLanguage.add(rdbtnmntmEnglish);

		rdbtnmntmFrench = new JRadioButtonMenuItem(Messages.getString("MenuPrincipal.rdbtnmntmFrench.text"),new ImageIcon(MenuPrincipal.class.getResource("/gui/pics/fr-icon.png"))); //$NON-NLS-1$ //$NON-NLS-2$
		rdbtnmntmFrench.addItemListener(language_listener);
		mnLanguage.add(rdbtnmntmFrench);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnmntmEnglish);
		bg.add(rdbtnmntmFrench);
		Locale defloc = Locale.getDefault();
		if(defloc==Locale.ENGLISH) {
			rdbtnmntmEnglish.setSelected(true);
		}
		else if(defloc==Locale.FRENCH) {
			rdbtnmntmFrench.setSelected(true);
		}

		mnApplication.addSeparator();

		mntmQuit = new JMenuItem(Messages.getString("MenuPrincipal.mntmQuit.text")); //$NON-NLS-1$ //$NON-NLS-2$
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(rootPane, Messages.getString("MenuPrincipal.message.unsavedChangesQuit"), Messages.getString("Message.title.confirmation"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(choice==JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		mnApplication.add(mntmQuit);

		mnPlanned = new JMenu(Messages.getString("MenuPrincipal.mnPlanned.text")); //$NON-NLS-1$ //$NON-NLS-2$
		menuBar.add(mnPlanned);

		mntmTodoList = new JMenuItem(Messages.getString("MenuPrincipal.mntmTodoList.text")); //$NON-NLS-1$ //$NON-NLS-2$
		mntmTodoList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Todo(MenuPrincipal.this);
			}
		});
		mnPlanned.add(mntmTodoList);

		mnHelp = new JMenu(Messages.getString("MenuPrincipal.mnHelp.text")); //$NON-NLS-1$ //$NON-NLS-2$
		menuBar.add(mnHelp);

		mntmHowToUse = new JMenuItem(Messages.getString("MenuPrincipal.mntmHowToUse.text")); //$NON-NLS-1$ //$NON-NLS-2$
		mntmHowToUse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new HowTo(MenuPrincipal.this);
			}
		});
		mnHelp.add(mntmHowToUse);

		mnHelp.addSeparator();

		mntmAbout = new JMenuItem(Messages.getString("MenuPrincipal.mntmAbout.text")); //$NON-NLS-1$ //$NON-NLS-2$
		mntmAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new About(MenuPrincipal.this);
			}
		});
		mnHelp.add(mntmAbout);

		pan_classes = new JPanel();
		pan_classes.setLayout(null);

		lib_classes = new JLabel(Messages.getString("MenuPrincipal.lib_classes.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_classes.setBounds(7, 7, 64, 22);
		lib_classes.setFont(new Font("Tahoma", Font.BOLD, 14));
		pan_classes.add(lib_classes);

		list_classes = new JHoverList<CellListClass>();
		list_classes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				@SuppressWarnings("unchecked")
				JHoverList<CellListCaracs> source = (JHoverList<CellListCaracs>) e.getSource();
				if(source.getModel().getSize()!=0) {

					switch (e.getButton()) {
					case MouseEvent.BUTTON1:
						classe = list_classes.getSelectedValue().getClasse();
						loadClass_ClassConfig(classe);
						break;
					case MouseEvent.BUTTON2:
						int hoverIndex = ((HoverListCellRenderer) list_classes.getCellRenderer()).getHoverIndex();
						if(hoverIndex!=-1) {
							Classe classe = list_classes.getModel().getElementAt(hoverIndex).getClasse();
							int choix = JOptionPane.showConfirmDialog(rootPane,String.format(Messages.getString("MenuPrincipal.message.delClass"), classe.getName()), Messages.getString("Message.title.confirmation"), JOptionPane.YES_NO_OPTION);
							if(choix==JOptionPane.YES_OPTION) {
								arenas.removeClassForLimit(classe);
								Classe.classe_list.remove(classe);
								loadData_ClassConfig(Classe.classe_list);
								MenuPrincipal.this.classe = null;
							}
						}
						break;
					default:
						break;
					}

				}
				else list_classes.clearSelection();

			}
		});

		btn_new_class = new JButton(Messages.getString("MenuPrincipal.btn_new_class.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_new_class.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_new_class.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				classe = new Classe("New_Class");
				arenas.addClassForLimit(classe);
				int index = Classe.classe_list.indexOf(classe)-1;
				loadData_ClassConfig(Classe.classe_list, index);
				loadClass_ClassConfig(classe);
			}
		});
		btn_new_class.setBounds(262, 8, 116, 22);
		pan_classes.add(btn_new_class);

		scrpan_classes = new JScrollPane(list_classes);
		scrpan_classes.setBounds(7, 33, 371, 188);
		pan_classes.add(scrpan_classes);

		pan_caracs_class = new JPanel();
		pan_caracs_class.setBounds(7, 233, 741, 246);
		pan_caracs_class.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pan_classes.add(pan_caracs_class);
		pan_caracs_class.setLayout(null);

		lib_class = new JLabel(Messages.getString("MenuPrincipal.lib_class.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_class.setBounds(8, 6, 99, 25);
		pan_caracs_class.add(lib_class);
		lib_class.setFont(new Font("Tahoma", Font.BOLD, 12));

		sai_class = new JFormattedTextField(new MaskFormatter("U??????????????"));
		sai_class.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				String new_name = sai_class.getText().trim();
				if (new_name.equals("")) {
					classe.setName("New_class");
				} else
					classe.setName(new_name);
				loadData_ClassConfig(Classe.classe_list);

			}
		});
		sai_class.setFocusLostBehavior(JFormattedTextField.COMMIT);
		sai_class.setBackground(new Color(255, 255, 255));
		sai_class.setBounds(110, 6, 137, 28);
		sai_class.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_caracs_class.add(sai_class);
		sai_class.setColumns(10);

		lib_items = new JLabel(Messages.getString("MenuPrincipal.lib_items.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_items.setBounds(8, 46, 90, 25);
		lib_items.setFont(new Font("Tahoma", Font.BOLD, 13));
		pan_caracs_class.add(lib_items);

		btn_items = new JButton(Messages.getString("MenuPrincipal.btn_items.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_items.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				classe.setItems(new ItemSelector(MenuPrincipal.this, classe.getItems(), -1, false, true).getItemList());
			}
		});
		btn_items.setBounds(110, 46, 137, 28);
		pan_caracs_class.add(btn_items);

		lib_armor = new JLabel(Messages.getString("MenuPrincipal.lib_armor.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_armor.setBounds(8, 86, 90, 25);
		lib_armor.setFont(new Font("Tahoma", Font.BOLD, 13));
		pan_caracs_class.add(lib_armor);

		btn_armor = new JButton(Messages.getString("MenuPrincipal.btn_armor.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_armor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				classe.setArmor((ArmorList) new ItemSelector(MenuPrincipal.this, classe.getArmor(), 4, true).getItemList());
			}
		});
		btn_armor.setBounds(110, 86, 137, 28);
		pan_caracs_class.add(btn_armor);

		lib_dogs = new JLabel(Messages.getString("MenuPrincipal.lib_dogs.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_dogs.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_dogs.setBounds(8, 126, 99, 25);
		pan_caracs_class.add(lib_dogs);

		sai_dogs = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_dogs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {sai_dogs.commitEdit();}
				catch (ParseException e1) {}
				classe.setDog_number((int)((long) sai_dogs.getValue()));
			}
		});
		sai_dogs.setBackground(new Color(255, 255, 255));
		sai_dogs.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_dogs.setColumns(10);
		sai_dogs.setBounds(110, 126, 137, 28);
		pan_caracs_class.add(sai_dogs);

		lib_horse = new JLabel(Messages.getString("MenuPrincipal.lib_horse.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_horse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_horse.setBounds(8, 166, 90, 28);
		pan_caracs_class.add(lib_horse);

		combo_horse = new JComboBox<String>();
		combo_horse.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				@SuppressWarnings("unchecked")
				JComboBox<String> combo = (JComboBox<String>) e.getSource();

				if(e.getStateChange() == ItemEvent.DESELECTED && combo.isFocusOwner()){

					if(combo_horse.getSelectedIndex()==0) {
						combo_hArmor.setSelectedIndex(0);
						combo_hArmor.setEnabled(false);
						classe.setHorse(0);
					}
					else if(combo_horse.getSelectedIndex()!=-1) {
						combo_hArmor.setEnabled(true);

						classe.setHorse(combo_horse.getSelectedIndex()+(8*combo_hArmor.getSelectedIndex()));
					}

				}

			}
		});
		combo_horse.setModel(new DefaultComboBoxModel<String>(new String[] {"None", "Horse", "Donkey", "Mule", "Skeleton", "Undead"}));
		combo_horse.setBounds(110, 166, 137, 26);
		pan_caracs_class.add(combo_horse);

		lib_hArmor = new JLabel(Messages.getString("MenuPrincipal.lib_hArmor.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_hArmor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_hArmor.setBounds(8, 206, 99, 28);
		pan_caracs_class.add(lib_hArmor);

		combo_hArmor = new JComboBox<String>();
		combo_hArmor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				@SuppressWarnings("unchecked")
				JComboBox<String> combo = (JComboBox<String>) e.getSource();

				if(e.getStateChange() == ItemEvent.DESELECTED && combo.isFocusOwner()){

					classe.setHorse(combo_horse.getSelectedIndex()+(8*combo_hArmor.getSelectedIndex()));

				}

			}
		});
		combo_hArmor.setModel(new DefaultComboBoxModel<String>(new String[] {"None", "Iron", "Gold", "Diamond"}));
		combo_hArmor.setBounds(110, 207, 137, 26);
		pan_caracs_class.add(combo_hArmor);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(259, 6, 2, 228);
		pan_caracs_class.add(separator_2);

		lib_permissions = new JLabel(Messages.getString("MenuPrincipal.lib_permissions.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_permissions.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_permissions.setBounds(273, 10, 76, 25);
		pan_caracs_class.add(lib_permissions);

		MouseAdapter add_perm_adapter = new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				JButton source = (JButton) e.getSource();

				String perm = JOptionPane.showInputDialog(
						rootPane,
						Messages.getString("MenuPrincipal.message.addPerm"),
						Messages.getString("Message.title.permissions"), JOptionPane.QUESTION_MESSAGE);
				if(perm!=null){
					ArrayList<String> perm_list = null;

					if(source==btn_add_perm) perm_list = classe.getPermissions();
					else if(source==btn_add_lobby_permissions) perm_list = classe.getLobby_permissions();

					if (perm_list==null) {
						perm_list = new ArrayList<String>();
						if(source==btn_add_perm) classe.setPermissions(perm_list);
						else if(source==btn_add_lobby_permissions) classe.setLobby_permissions(perm_list);
					}
					perm_list.add(perm.trim());
					loadClass_ClassConfig(classe);
				}

			}
		};

		MouseAdapter list_perm_adapter = new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				@SuppressWarnings("unchecked")
				JHoverList<CellListCaracs> source = (JHoverList<CellListCaracs>) e.getSource();

				switch (e.getButton()) {
				case MouseEvent.BUTTON2:
					String lobby_perm = "";
					ArrayList<String> perm_list = null;
					if(source==list_lobby_permissions) {
						lobby_perm=Messages.getString("MenuPrincipal.message.delPerm1");
						perm_list = classe.getLobby_permissions();
					}
					else if(source==list_permissions) {
						perm_list = classe.getPermissions();						
					}
					int index = ((HoverListCellRenderer) source.getCellRenderer()).getHoverIndex();
					if (index!=-1) {
						if (e.getButton() == MouseEvent.BUTTON2) {
							int choice = JOptionPane.showConfirmDialog(rootPane,
									MessageFormat.format(Messages.getString("MenuPrincipal.message.delPerm"),perm_list.get(index),lobby_perm), 
									Messages.getString("Message.title.confirmation"),
									JOptionPane.YES_NO_OPTION);
							if (choice == JOptionPane.YES_OPTION) {
								perm_list.remove(index);
								loadClass_ClassConfig(classe);
							}
						}
					}
					break;
				default:
					break;
				}

			}
		};

		ListSelectionListener clear_list_perm = new ListSelectionListener() {
			@SuppressWarnings("unchecked")
			public void valueChanged(ListSelectionEvent e) {
				((JHoverList<CellListCaracs>) e.getSource()).clearSelection();
			}
		};

		btn_add_perm = new JButton(Messages.getString("MenuPrincipal.btn_add_perm.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_add_perm.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_add_perm.addMouseListener(add_perm_adapter);
		btn_add_perm.setBounds(395, 9, 90, 22);
		pan_caracs_class.add(btn_add_perm);

		list_permissions = new JHoverList<CellListCaracs>();
		list_permissions.addListSelectionListener(clear_list_perm);
		list_permissions.addMouseListener(list_perm_adapter);

		scrpan_permissions = new JScrollPane(list_permissions);
		scrpan_permissions.setBounds(273, 34, 212, 200);
		pan_caracs_class.add(scrpan_permissions);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(497, 6, 2, 228);
		pan_caracs_class.add(separator_3);

		lib_lobby_permissions = new JLabel(Messages.getString("MenuPrincipal.lib_lobby_permissions.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_lobby_permissions.setFont(new Font("Tahoma", Font.BOLD, 11));
		lib_lobby_permissions.setBounds(511, 10, 123, 25);
		pan_caracs_class.add(lib_lobby_permissions);

		btn_add_lobby_permissions = new JButton(Messages.getString("MenuPrincipal.btn_add_lobby_permissions.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_add_lobby_permissions.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_add_lobby_permissions.addMouseListener(add_perm_adapter);
		btn_add_lobby_permissions.setBounds(633, 9, 90, 22);
		pan_caracs_class.add(btn_add_lobby_permissions);

		list_lobby_permissions = new JHoverList<CellListCaracs>();
		list_lobby_permissions.addListSelectionListener(clear_list_perm);
		list_lobby_permissions.addMouseListener(list_perm_adapter);

		scrpan_lobby_permissions = new JScrollPane(list_lobby_permissions);
		scrpan_lobby_permissions.setBounds(511, 34, 212, 200);
		pan_caracs_class.add(scrpan_lobby_permissions);

		pan_class_limit = new JPanel();
		pan_class_limit.setLayout(null);
		pan_class_limit.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pan_class_limit.setBounds(573, 6, 175, 40);
		pan_classes.add(pan_class_limit);

		lib_class_limit = new JLabel(Messages.getString("MenuPrincipal.lib_class_limit.text"));
		lib_class_limit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lib_class_limit.setBounds(6, 8, 95, 25);
		pan_class_limit.add(lib_class_limit);

		sai_class_limit = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_class_limit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{sai_class_limit.commitEdit();}
				catch(ParseException e1){}
				Object olimit = sai_class_limit.getValue();
				int limit;
				if(olimit instanceof Long) limit = (int)((long) olimit);
				else limit = (int) olimit;
				arenas.getALarenas().get(combo_arena.getSelectedIndex()).setClassLimit(classe, limit);
			}
		});
		sai_class_limit.setBounds(113, 6, 57, 28);
		pan_class_limit.add(sai_class_limit);
		sai_class_limit.setColumns(10);

		pan_arena_settings = new JPanel();
		pan_arena_settings.setBorder(new LineBorder(new Color(0, 0, 0)));
		pan_arena_settings.setBounds(6, 6, 567, 341);
		pan_arena_settings.setLayout(null);

		lib_world = new JLabel(Messages.getString("MenuPrincipal.lib_world.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_world.setToolTipText(Messages.getString("MenuPrincipal.lib_world.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_world.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_world.setBounds(6, 6, 73, 25);
		pan_arena_settings.add(lib_world);

		sai_world = new JFormattedTextField(new MaskFormatter("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
		sai_world.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String text = sai_world.getText().trim();
				if(text.equals("")) {
					text = "world";
					sai_world.setText(text);
				}
				config.setWorld(text);

			}
		});
		sai_world.setFocusLostBehavior(JFormattedTextField.COMMIT);
		sai_world.setToolTipText(Messages.getString("MenuPrincipal.lib_world.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		sai_world.setBounds(91, 5, 127, 28);
		sai_world.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_arena_settings.add(sai_world);

		ItemListener chkconfig_listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				JCheckBox source = (JCheckBox) e.getSource();
				boolean b = source.isSelected();
				if(source.isFocusOwner()) {

					if(source==chk_enabled)					config.setEnabled(b);
					else if(source==chk_protect)			config.setProtect(b);
					else if(source==chk_clear_wave_next)	config.setClear_wave_next(b);
					else if(source==chk_clear_wave_boss)	config.setClear_wave_boss(b);
					else if(source==chk_clear_boss_next)	config.setClear_boss_next(b);
					else if(source==chk_lightning)			config.setLightning(b);
					else if(source==chk_auto_equip)			config.setAuto_equip_armor(b);
					else if(source==chk_soft_restore)		config.setSoft_restore(b);
					else if(source==chk_soft_restore_drops)	config.setSoft_restore_drops(b);
					else if(source==chk_require_inv_join)	config.setEmpty_inv_join(b);
					else if(source==chk_require_inv_spec)	config.setEmpty_inv_spec(b);
					else if(source==chk_hellhounds)			config.setHellhounds(b);
					else if(source==chk_pvp)				config.setPvp_enabled(b);
					else if(source==chk_monster_infight)	config.setMonster_infight(b);
					else if(source==chk_allow_tp)			config.setAllow_tp(b);
					else if(source==chk_spectate_death)		config.setDeath_spec(b);
					else if(source==chk_auto_respawn)		config.setAuto_respawn(b);
					else if(source==chk_share)				config.setShare_items(b);
					else if(source==chk_monster_xp)			config.setMonster_drop_xp(b);
					else if(source==chk_keep_xp)			config.setKeep_xp(b);
					else if(source==chk_food_regen)			config.setFood_regen(b);
					else if(source==chk_lock_food)			config.setFood_level_lock(b);
					else if(source==chk_spout_class)		config.setSpout_select(b);
					else if(source==chk_auto_ignite)		config.setAuto_ignite_tnt(b);
					else if(source==chk_use_class_chest)	config.setClass_chest(b);
					else if(source==chk_display_waves)		config.setWaves_as_level(b);
					else if(source==chk_display_timer)		config.setTimer_as_level(b);
					else if(source==chk_auto_ready)			config.setAuto_ready(b);
					else if(source==chk_scoreboard)			config.setScoreboards(b);
					else if(source==chk_isolated_chat)		config.setIsolated_chat(b);
					else if(source==chk_global_join)		config.setGlobal_join_announce(b);
					else if(source==chk_global_end)			config.setGlobal_end_announce(b);
					else if(source==chk_gs_enabled)			arenas.getGlobalSettings().setEnabled(b);
					else if(source==chk_notifications)		arenas.getGlobalSettings().setUpdate_notifications(b);

					if(source==chk_keep_xp && b) {
						chk_display_waves.setSelected(false);
						config.setWaves_as_level(false);
						chk_display_timer.setSelected(false);
						config.setTimer_as_level(false);
					}
					if((source==chk_display_waves || source==chk_display_timer) && b) {
						chk_keep_xp.setSelected(false);
						config.setKeep_xp(false);
					}


				}

			}
		};

		chk_enabled = new JCheckBox(Messages.getString("MenuPrincipal.chk_enabled.text"));
		chk_enabled.setHorizontalAlignment(SwingConstants.CENTER);
		chk_enabled.addItemListener(chkconfig_listener);
		chk_enabled.setToolTipText(Messages.getString("MenuPrincipal.chk_enabled.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_enabled.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_enabled.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_enabled.setBounds(6, 43, 84, 25);
		pan_arena_settings.add(chk_enabled);

		chk_protect = new JCheckBox(Messages.getString("MenuPrincipal.chk_protect.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_protect.addItemListener(chkconfig_listener);
		chk_protect.setToolTipText(Messages.getString("MenuPrincipal.chk_protect.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_protect.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_protect.setFont(new Font("Tahoma", Font.BOLD, 12));
		chk_protect.setBounds(91, 43, 73, 25);
		pan_arena_settings.add(chk_protect);

		KeyAdapter int_config_adapter = new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e) {
				JFormattedTextField source = (JFormattedTextField) e.getSource();
				try {
					source.commitEdit();
				} catch (ParseException e1) {}
				Number nvalue = (Number) source.getValue();
				int value = nvalue.intValue();
				float fvalue = nvalue.floatValue();

				if(source==sai_entry) config.setEntry_fee_money(fvalue);
				else if(source==sai_min_players) config.setMin_players(value);
				else if(source==sai_max_players) config.setMax_players(value);
				else if(source==sai_max_join_distance) config.setMax_join_distance(value);
				else if(source==sai_first_delay) config.setFirst_wave_delay(value);
				else if(source==sai_interval) config.setWave_interval(value);
				else if(source==sai_final_wave) config.setFinal_wave(value);
				else if(source==sai_monster_limit) config.setMonster_limit(value);
				else if(source==sai_auto_start) config.setAuto_start(value);
			}
		};

		lib_entry = new JLabel(Messages.getString("MenuPrincipal.lib_entry.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_entry.setToolTipText(Messages.getString("MenuPrincipal.lib_entry.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_entry.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_entry.setBounds(6, 80, 84, 25);
		pan_arena_settings.add(lib_entry);

		NumberFormat format = DecimalFormat.getInstance();
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);
		format.setRoundingMode(RoundingMode.HALF_UP);
		InternationalFormatter formatter = new InternationalFormatter(format);
		sai_entry = new JFormattedTextField(formatter);
		sai_entry.addKeyListener(int_config_adapter);
		sai_entry.setToolTipText(Messages.getString("MenuPrincipal.lib_entry.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		sai_entry.setBackground(new Color(255, 255, 255));
		sai_entry.setBounds(91, 81, 50, 25);
		sai_entry.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_arena_settings.add(sai_entry);
		sai_entry.setColumns(10);

		btn_entry = new JButton(Messages.getString("MenuPrincipal.btn_entry.text")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_entry.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_entry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ItemList il = new ItemList();
				AbstractItem it_fee = config.getEntry_fee_item();
				if (it_fee!=null) {
					il.add(config.getEntry_fee_item());
				}
				il = new ItemSelector(MenuPrincipal.this, il, 1, false).getItemList();
				if(il.size()!=0) config.setEntry_fee_item(il.get(0));
				else config.setEntry_fee_item(null);
			}
		});
		btn_entry.setToolTipText(Messages.getString("MenuPrincipal.lib_entry.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		btn_entry.setBounds(153, 81, 90, 25);
		pan_arena_settings.add(btn_entry);

		chk_clear_wave_next = new JCheckBox(Messages.getString("MenuPrincipal.chk_clear_wave_next.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_clear_wave_next.addItemListener(chkconfig_listener);
		chk_clear_wave_next.setToolTipText(Messages.getString("MenuPrincipal.chk_clear_wave_next.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_clear_wave_next.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_clear_wave_next.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_clear_wave_next.setBounds(6, 117, 212, 25);
		pan_arena_settings.add(chk_clear_wave_next);

		chk_clear_boss_next = new JCheckBox(Messages.getString("MenuPrincipal.chk_clear_boss_next.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_clear_boss_next.addItemListener(chkconfig_listener);
		chk_clear_boss_next.setToolTipText(Messages.getString("MenuPrincipal.chk_clear_boss_next.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_clear_boss_next.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_clear_boss_next.setFont(new Font("Tahoma", Font.BOLD, 13));
		chk_clear_boss_next.setBounds(6, 154, 228, 25);
		pan_arena_settings.add(chk_clear_boss_next);

		chk_clear_wave_boss = new JCheckBox(Messages.getString("MenuPrincipal.chk_clear_wave_boss.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_clear_wave_boss.addItemListener(chkconfig_listener);
		chk_clear_wave_boss.setToolTipText(Messages.getString("MenuPrincipal.chk_clear_wave_boss.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_clear_wave_boss.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_clear_wave_boss.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_clear_wave_boss.setBounds(6, 191, 182, 25);
		pan_arena_settings.add(chk_clear_wave_boss);

		chk_lightning = new JCheckBox(Messages.getString("MenuPrincipal.chk_lightning.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_lightning.setHorizontalAlignment(SwingConstants.CENTER);
		chk_lightning.addItemListener(chkconfig_listener);
		chk_lightning.setToolTipText(Messages.getString("MenuPrincipal.chk_lightning.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_lightning.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_lightning.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_lightning.setBounds(191, 45, 90, 25);
		pan_arena_settings.add(chk_lightning);

		chk_auto_equip = new JCheckBox(Messages.getString("MenuPrincipal.chk_auto_equip.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_auto_equip.addItemListener(chkconfig_listener);
		chk_auto_equip.setToolTipText(Messages.getString("MenuPrincipal.chk_auto_equip.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_auto_equip.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_auto_equip.setFont(new Font("Tahoma", Font.BOLD, 12));
		chk_auto_equip.setBounds(6, 228, 158, 25);
		pan_arena_settings.add(chk_auto_equip);

		chk_soft_restore = new JCheckBox(Messages.getString("MenuPrincipal.chk_soft_restore.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_soft_restore.addItemListener(chkconfig_listener);
		chk_soft_restore.setToolTipText(Messages.getString("MenuPrincipal.chk_soft_restore.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_soft_restore.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_soft_restore.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_soft_restore.setBounds(161, 228, 120, 25);
		pan_arena_settings.add(chk_soft_restore);

		chk_soft_restore_drops = new JCheckBox(Messages.getString("MenuPrincipal.chk_soft_restore_drops.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_soft_restore_drops.addItemListener(chkconfig_listener);
		chk_soft_restore_drops.setToolTipText(Messages.getString("MenuPrincipal.chk_soft_restore_drops.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_soft_restore_drops.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_soft_restore_drops.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_soft_restore_drops.setBounds(6, 265, 199, 25);
		pan_arena_settings.add(chk_soft_restore_drops);

		chk_require_inv_join = new JCheckBox(Messages.getString("MenuPrincipal.chk_require_inv_join.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_require_inv_join.addItemListener(chkconfig_listener);
		chk_require_inv_join.setToolTipText(Messages.getString("MenuPrincipal.chk_require_inv_join.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_require_inv_join.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_require_inv_join.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_require_inv_join.setBounds(6, 300, 242, 28);
		pan_arena_settings.add(chk_require_inv_join);

		chk_require_inv_spec = new JCheckBox(Messages.getString("MenuPrincipal.chk_require_inv_spec.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_require_inv_spec.addItemListener(chkconfig_listener);
		chk_require_inv_spec.setToolTipText(Messages.getString("MenuPrincipal.chk_require_inv_spec.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_require_inv_spec.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_require_inv_spec.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_require_inv_spec.setBounds(6, 336, 275, 28);
		pan_arena_settings.add(chk_require_inv_spec);

		chk_hellhounds = new JCheckBox(Messages.getString("MenuPrincipal.chk_hellhounds.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_hellhounds.addItemListener(chkconfig_listener);
		chk_hellhounds.setToolTipText(Messages.getString("MenuPrincipal.chk_hellhounds.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_hellhounds.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_hellhounds.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_hellhounds.setBounds(6, 376, 139, 25);
		pan_arena_settings.add(chk_hellhounds);

		chk_pvp = new JCheckBox(Messages.getString("MenuPrincipal.chk_pvp.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_pvp.addItemListener(chkconfig_listener);
		chk_pvp.setToolTipText(Messages.getString("MenuPrincipal.chk_pvp.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_pvp.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_pvp.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_pvp.setBounds(153, 376, 108, 25);
		pan_arena_settings.add(chk_pvp);

		chk_monster_infight = new JCheckBox(Messages.getString("MenuPrincipal.chk_monster_infight.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_monster_infight.addItemListener(chkconfig_listener);
		chk_monster_infight.setToolTipText(Messages.getString("MenuPrincipal.chk_monster_infight.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_monster_infight.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_monster_infight.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_monster_infight.setBounds(6, 413, 170, 25);
		pan_arena_settings.add(chk_monster_infight);

		chk_allow_tp = new JCheckBox(Messages.getString("MenuPrincipal.chk_allow_tp.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_allow_tp.addItemListener(chkconfig_listener);
		chk_allow_tp.setToolTipText(Messages.getString("MenuPrincipal.chk_allow_tp.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_allow_tp.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_allow_tp.setFont(new Font("Tahoma", Font.BOLD, 13));
		chk_allow_tp.setBounds(161, 450, 134, 25);
		pan_arena_settings.add(chk_allow_tp);

		chk_spectate_death = new JCheckBox(Messages.getString("MenuPrincipal.chk_spectate_death.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_spectate_death.addItemListener(chkconfig_listener);
		chk_spectate_death.setToolTipText(Messages.getString("MenuPrincipal.chk_spectate_death.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_spectate_death.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_spectate_death.setFont(new Font("Tahoma", Font.BOLD, 12));
		chk_spectate_death.setBounds(6, 450, 149, 25);
		pan_arena_settings.add(chk_spectate_death);

		chk_auto_respawn = new JCheckBox(Messages.getString("MenuPrincipal.chk_auto_respawn.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_auto_respawn.addItemListener(chkconfig_listener);
		chk_auto_respawn.setToolTipText(Messages.getString("MenuPrincipal.chk_auto_respawn.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_auto_respawn.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_auto_respawn.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_auto_respawn.setBounds(307, 6, 149, 25);
		pan_arena_settings.add(chk_auto_respawn);

		chk_share = new JCheckBox(Messages.getString("MenuPrincipal.chk_share.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_share.addItemListener(chkconfig_listener);
		chk_share.setToolTipText(Messages.getString("MenuPrincipal.chk_share.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_share.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_share.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_share.setBounds(307, 43, 139, 25);
		pan_arena_settings.add(chk_share);

		lib_min_players = new JLabel(Messages.getString("MenuPrincipal.lib_min_players.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_min_players.setToolTipText(Messages.getString("MenuPrincipal.lib_min_players.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		lib_min_players.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_min_players.setBounds(307, 80, 95, 25);
		pan_arena_settings.add(lib_min_players);

		sai_min_players = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_min_players.addKeyListener(int_config_adapter);
		sai_min_players.setToolTipText(Messages.getString("MenuPrincipal.lib_min_players.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		sai_min_players.setBackground(new Color(255, 255, 255));
		sai_min_players.setColumns(10);
		sai_min_players.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_min_players.setBounds(438, 81, 50, 25);
		pan_arena_settings.add(sai_min_players);

		lib_max_players = new JLabel(Messages.getString("MenuPrincipal.lib_max_players.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_max_players.setToolTipText(Messages.getString("MenuPrincipal.lib_max_players.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		lib_max_players.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_max_players.setBounds(307, 117, 95, 25);
		pan_arena_settings.add(lib_max_players);

		sai_max_players = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_max_players.addKeyListener(int_config_adapter);
		sai_max_players.setToolTipText(Messages.getString("MenuPrincipal.lib_max_players.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		sai_max_players.setBackground(new Color(255, 255, 255));
		sai_max_players.setColumns(10);
		sai_max_players.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_max_players.setBounds(438, 118, 50, 25);
		pan_arena_settings.add(sai_max_players);

		lib_max_join_distance = new JLabel(Messages.getString("MenuPrincipal.lib_max_join_distance.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_max_join_distance.setToolTipText(Messages.getString("MenuPrincipal.lib_max_join_distance.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		lib_max_join_distance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_max_join_distance.setBounds(307, 154, 119, 25);
		pan_arena_settings.add(lib_max_join_distance);

		sai_max_join_distance = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_max_join_distance.addKeyListener(int_config_adapter);
		sai_max_join_distance.setToolTipText(Messages.getString("MenuPrincipal.lib_max_join_distance.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		sai_max_join_distance.setBackground(new Color(255, 255, 255));
		sai_max_join_distance.setColumns(10);
		sai_max_join_distance.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_max_join_distance.setBounds(438, 155, 50, 25);
		pan_arena_settings.add(sai_max_join_distance);

		lib_first_delay = new JLabel(Messages.getString("MenuPrincipal.lib_first_delay.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_first_delay.setToolTipText(Messages.getString("MenuPrincipal.lib_first_delay.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		lib_first_delay.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_first_delay.setBounds(307, 191, 119, 25);
		pan_arena_settings.add(lib_first_delay);

		sai_first_delay = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_first_delay.addKeyListener(int_config_adapter);
		sai_first_delay.setToolTipText(Messages.getString("MenuPrincipal.lib_first_delay.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		sai_first_delay.setBackground(new Color(255, 255, 255));
		sai_first_delay.setColumns(10);
		sai_first_delay.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_first_delay.setBounds(438, 192, 50, 25);
		pan_arena_settings.add(sai_first_delay);

		lib_interval = new JLabel(Messages.getString("MenuPrincipal.lib_interval.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_interval.setToolTipText(Messages.getString("MenuPrincipal.lib_interval.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		lib_interval.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_interval.setBounds(307, 227, 119, 25);
		pan_arena_settings.add(lib_interval);

		sai_interval = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_interval.addKeyListener(int_config_adapter);
		sai_interval.setToolTipText(Messages.getString("MenuPrincipal.lib_interval.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		sai_interval.setBackground(new Color(255, 255, 255));
		sai_interval.setColumns(10);
		sai_interval.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_interval.setBounds(438, 228, 50, 25);
		pan_arena_settings.add(sai_interval);

		lib_final_wave = new JLabel(Messages.getString("MenuPrincipal.lib_final_wave.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_final_wave.setToolTipText(Messages.getString("MenuPrincipal.lib_final_wave.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		lib_final_wave.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_final_wave.setBounds(307, 264, 119, 25);
		pan_arena_settings.add(lib_final_wave);

		sai_final_wave = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_final_wave.addKeyListener(int_config_adapter);
		sai_final_wave.setToolTipText(Messages.getString("MenuPrincipal.lib_final_wave.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		sai_final_wave.setBackground(new Color(255, 255, 255));
		sai_final_wave.setColumns(10);
		sai_final_wave.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_final_wave.setBounds(438, 266, 50, 25);
		pan_arena_settings.add(sai_final_wave);

		lib_monster_limit = new JLabel(Messages.getString("MenuPrincipal.lib_monster_limit.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_monster_limit.setToolTipText(Messages.getString("MenuPrincipal.lib_monster_limit.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		lib_monster_limit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_monster_limit.setBounds(307, 302, 127, 25);
		pan_arena_settings.add(lib_monster_limit);

		sai_monster_limit = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_monster_limit.addKeyListener(int_config_adapter);
		sai_monster_limit.setToolTipText(Messages.getString("MenuPrincipal.lib_monster_limit.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		sai_monster_limit.setBackground(new Color(255, 255, 255));
		sai_monster_limit.setColumns(10);
		sai_monster_limit.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_monster_limit.setBounds(438, 303, 50, 25);
		pan_arena_settings.add(sai_monster_limit);

		chk_monster_xp = new JCheckBox(Messages.getString("MenuPrincipal.chk_monster_xp.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_monster_xp.addItemListener(chkconfig_listener);
		chk_monster_xp.setToolTipText(Messages.getString("MenuPrincipal.chk_monster_xp.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_monster_xp.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_monster_xp.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_monster_xp.setBounds(307, 339, 181, 25);
		pan_arena_settings.add(chk_monster_xp);

		chk_keep_xp = new JCheckBox(Messages.getString("MenuPrincipal.chk_keep_xp.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_keep_xp.addItemListener(chkconfig_listener);
		chk_keep_xp.setToolTipText(Messages.getString("MenuPrincipal.chk_keep_xp.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_keep_xp.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_keep_xp.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_keep_xp.setBounds(307, 376, 95, 25);
		pan_arena_settings.add(chk_keep_xp);

		chk_food_regen = new JCheckBox(Messages.getString("MenuPrincipal.chk_food_regen.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_food_regen.addItemListener(chkconfig_listener);
		chk_food_regen.setToolTipText(Messages.getString("MenuPrincipal.chk_food_regen.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_food_regen.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_food_regen.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_food_regen.setBounds(307, 413, 150, 25);
		pan_arena_settings.add(chk_food_regen);

		chk_lock_food = new JCheckBox(Messages.getString("MenuPrincipal.chk_lock_food.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_lock_food.addItemListener(chkconfig_listener);
		chk_lock_food.setToolTipText(Messages.getString("MenuPrincipal.chk_lock_food.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_lock_food.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_lock_food.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_lock_food.setBounds(307, 450, 170, 25);
		pan_arena_settings.add(chk_lock_food);

		lib_player_time = new JLabel(Messages.getString("MenuPrincipal.lib_player_time.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_player_time.setToolTipText(Messages.getString("MenuPrincipal.lib_player_time.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		lib_player_time.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_player_time.setBounds(514, 43, 127, 25);
		pan_arena_settings.add(lib_player_time);

		combo_player_time = new JComboBox<String>();
		combo_player_time.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.DESELECTED && combo_player_time.isFocusOwner()) {
					config.setPlayer_time((String) combo_player_time.getSelectedItem());
				}
			}
		});
		combo_player_time.setToolTipText(Messages.getString("MenuPrincipal.lib_player_time.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		combo_player_time.setModel(new DefaultComboBoxModel<String>(new String[] {"world", "dawn", "sunrise", "morning", "midday", "noon", "day", "afternoon", "evening", "sunset", "dusk", "night", "midnight"}));
		combo_player_time.setBounds(653, 43, 95, 26);
		pan_arena_settings.add(combo_player_time);

		lib_auto_start = new JLabel(Messages.getString("MenuPrincipal.lib_auto_start.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_auto_start.setToolTipText(Messages.getString("MenuPrincipal.lib_auto_start.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		lib_auto_start.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_auto_start.setBounds(514, 117, 147, 25);
		pan_arena_settings.add(lib_auto_start);

		sai_auto_start = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_auto_start.addKeyListener(int_config_adapter);
		sai_auto_start.setToolTipText(Messages.getString("MenuPrincipal.lib_auto_start.toolTipText")); //$NON-NLS-1$ //$NON-NLS-2$
		sai_auto_start.setBackground(new Color(255, 255, 255));
		sai_auto_start.setColumns(10);
		sai_auto_start.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_auto_start.setBounds(662, 118, 50, 25);
		pan_arena_settings.add(sai_auto_start);

		chk_spout_class = new JCheckBox(Messages.getString("MenuPrincipal.chk_spout_class.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_spout_class.addItemListener(chkconfig_listener);
		chk_spout_class.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_spout_class.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_spout_class.setBounds(514, 6, 181, 25);
		pan_arena_settings.add(chk_spout_class);

		chk_auto_ignite = new JCheckBox(Messages.getString("MenuPrincipal.chk_auto_ignite.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_auto_ignite.addItemListener(chkconfig_listener);
		chk_auto_ignite.setToolTipText(Messages.getString("MenuPrincipal.chk_auto_ignite.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_auto_ignite.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_auto_ignite.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_auto_ignite.setBounds(514, 80, 158, 25);
		pan_arena_settings.add(chk_auto_ignite);

		chk_use_class_chest = new JCheckBox(Messages.getString("MenuPrincipal.chk_use_class_chest.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_use_class_chest.addItemListener(chkconfig_listener);
		chk_use_class_chest.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_use_class_chest.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_use_class_chest.setBounds(514, 154, 147, 25);
		pan_arena_settings.add(chk_use_class_chest);

		chk_display_waves = new JCheckBox(Messages.getString("MenuPrincipal.chk_display_waves.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_display_waves.addItemListener(chkconfig_listener);
		chk_display_waves.setToolTipText(Messages.getString("MenuPrincipal.chk_display_waves.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_display_waves.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_display_waves.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_display_waves.setBounds(514, 192, 170, 25);
		pan_arena_settings.add(chk_display_waves);

		chk_display_timer = new JCheckBox(Messages.getString("MenuPrincipal.chk_display_timer.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_display_timer.addItemListener(chkconfig_listener);
		chk_display_timer.setToolTipText(Messages.getString("MenuPrincipal.chk_display_timer.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_display_timer.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_display_timer.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_display_timer.setBounds(514, 229, 170, 25);
		pan_arena_settings.add(chk_display_timer);

		chk_auto_ready = new JCheckBox(Messages.getString("MenuPrincipal.chk_auto_ready.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_auto_ready.addItemListener(chkconfig_listener);
		chk_auto_ready.setToolTipText(Messages.getString("MenuPrincipal.chk_auto_ready.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_auto_ready.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_auto_ready.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_auto_ready.setBounds(514, 266, 181, 25);
		pan_arena_settings.add(chk_auto_ready);

		chk_scoreboard = new JCheckBox(Messages.getString("MenuPrincipal.chk_scoreboard.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_scoreboard.addItemListener(chkconfig_listener);
		chk_scoreboard.setToolTipText(Messages.getString("MenuPrincipal.chk_scoreboard.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_scoreboard.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_scoreboard.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_scoreboard.setBounds(514, 306, 139, 25);
		pan_arena_settings.add(chk_scoreboard);

		chk_isolated_chat = new JCheckBox(Messages.getString("MenuPrincipal.chk_isolated_chat.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_isolated_chat.addItemListener(chkconfig_listener);
		chk_isolated_chat.setToolTipText(Messages.getString("MenuPrincipal.chk_isolated_chat.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_isolated_chat.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_isolated_chat.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_isolated_chat.setBounds(514, 342, 119, 25);
		pan_arena_settings.add(chk_isolated_chat);

		chk_global_join = new JCheckBox(Messages.getString("MenuPrincipal.chk_global_join.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_global_join.addItemListener(chkconfig_listener);
		chk_global_join.setToolTipText(Messages.getString("MenuPrincipal.chk_global_join.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_global_join.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_global_join.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_global_join.setBounds(514, 376, 181, 25);
		pan_arena_settings.add(chk_global_join);

		chk_global_end = new JCheckBox(Messages.getString("MenuPrincipal.chk_global_end.text")); //$NON-NLS-1$ //$NON-NLS-2$
		chk_global_end.addItemListener(chkconfig_listener);
		chk_global_end.setToolTipText(Messages.getString("MenuPrincipal.chk_global_end.toolTipText")); //$NON-NLS-2$ //$NON-NLS-1$
		chk_global_end.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_global_end.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_global_end.setBounds(514, 413, 170, 25);
		pan_arena_settings.add(chk_global_end);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(293, 6, 2, 473);
		pan_arena_settings.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(500, 6, 2, 473);
		pan_arena_settings.add(separator_1);

		pan_global_settings = new JPanel();
		pan_global_settings.setLayout(null);

		chk_gs_enabled = new JCheckBox(Messages.getString("MenuPrincipal.chk_enabled.text")); //$NON-NLS-1$
		chk_gs_enabled.setBounds(6, 6, 77, 25);
		chk_gs_enabled.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_gs_enabled.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_gs_enabled.addItemListener(chkconfig_listener);
		pan_global_settings.add(chk_gs_enabled);

		chk_notifications = new JCheckBox(Messages.getString("MenuPrincipal.chk_notifications.text")); //$NON-NLS-1$
		chk_notifications.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_notifications.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_notifications.setBounds(6, 43, 209, 25);
		chk_notifications.addItemListener(chkconfig_listener);
		pan_global_settings.add(chk_notifications);

		lib_commands = new JLabel(Messages.getString("MenuPrincipal.lib_commands.text")); //$NON-NLS-1$
		lib_commands.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_commands.setBounds(6, 81, 146, 17);
		pan_global_settings.add(lib_commands);

		btn_command = new JButton(Messages.getString("MenuPrincipal.btn_command.text")); //$NON-NLS-1$
		btn_command.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				pan_commands.setVisible(true);
				String command = "/test";
				ArrayList<String> ac = arenas.getGlobalSettings().getAllowed_commands();
				ac.add(command);
				loadCommands_GlobalSettings(ac);
				list_commands.setSelectedIndex(ac.indexOf(command));
				sai_command.setText(command);
				sai_command.requestFocus();
				sai_command.select(0, 5);
			}
		});
		btn_command.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_command.setBounds(164, 80, 146, 23);
		pan_global_settings.add(btn_command);

		list_commands = new JHoverList<CellListCaracs>();
		list_commands.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int hoverindex = ((HoverListCellRenderer) list_commands.getCellRenderer()).getHoverIndex();
				if(hoverindex!=-1) {
					String command = arenas.getGlobalSettings().getAllowed_commands().get(hoverindex);
					switch (e.getButton()) {
					case MouseEvent.BUTTON1:
						pan_commands.setVisible(true);
						sai_command.setText(command);
						break;
					case MouseEvent.BUTTON2:
						int choice = JOptionPane.showConfirmDialog(rootPane,MessageFormat.format(Messages.getString("MenuPrincipal.message.delMonsterAbility"),Messages.getString("MenuPrincipal.message.delCommand"),command),Messages.getString("Message.title.confirmation"),JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(choice==JOptionPane.YES_OPTION) {
							arenas.getGlobalSettings().getAllowed_commands().remove(hoverindex);
							loadCommands_GlobalSettings(arenas.getGlobalSettings().getAllowed_commands());
							loadData_GlobalSettings();
						}
						break;
					default:
						break;
					}
				}
			}
		});

		scrpan_commands = new JScrollPane(list_commands);
		scrpan_commands.setBounds(6, 110, 304, 168);
		pan_global_settings.add(scrpan_commands);

		pan_commands = new JPanel();
		pan_commands.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), Messages.getString("MenuPrincipal.pan_commands.title"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pan_commands.setBounds(6, 290, 304, 94);
		pan_global_settings.add(pan_commands);
		pan_commands.setLayout(null);

		lib_command = new JLabel(Messages.getString("MenuPrincipal.lib_command.text")); //$NON-NLS-1$
		lib_command.setToolTipText("");
		lib_command.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_command.setBounds(6, 22, 122, 25);
		pan_commands.add(lib_command);

		sai_command = new JFormattedTextField(new MaskFormatter("******************************"));
		sai_command.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				String command = sai_command.getText().trim();
				int index = list_commands.getSelectedIndex();
				ArrayList<String> ac = arenas.getGlobalSettings().getAllowed_commands();
				ac.set(index, command);
				loadCommands_GlobalSettings(ac);
				list_commands.setSelectedIndex(index);
			}
		});
		sai_command.setFocusLostBehavior(JFormattedTextField.COMMIT);
		sai_command.setBounds(132, 21, 166, 28);
		pan_commands.add(sai_command);
		sai_command.setColumns(10);

		lib_command_help = new JLabel("");
		lib_command_help.setBounds(274, 61, 24, 24);
		lib_command_help.setToolTipText(Messages.getString("MenuPrincipal.lib_command_help.tooltip")); //$NON-NLS-1$
		Image img = new ImageIcon(MenuPrincipal.class.getResource("/gui/pics/question.png")).getImage();
		lib_command_help.setIcon(new ImageIcon(CellListCaracs.scaleImage(img,lib_command_help)));
		pan_commands.add(lib_command_help);

		pan_coordinates = new JPanel();
		pan_coordinates.setLayout(null);

		tree_points = new JTree();
		tree_points.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				if (e.getNewLeadSelectionPath()!=null) {
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getNewLeadSelectionPath().getLastPathComponent();
					loadCoords((String) node.getUserObject());
				}
			}
		});

		scrpan_points = new JScrollPane(tree_points);
		scrpan_points.setBounds(6, 6, 167, 168);
		pan_coordinates.add(scrpan_points);

		pan_coords = new JPanel();
		pan_coords.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pan_coords.setBounds(185, 6, 239, 103);
		pan_coordinates.add(pan_coords);
		pan_coords.setLayout(null);
		pan_coords.setVisible(false);

		lib_X = new JLabel("X");
		lib_X.setBounds(6, 8, 10, 20);
		pan_coords.add(lib_X);
		lib_X.setFont(new Font("Tahoma", Font.BOLD, 14));

		sai_X = new JTextField();
		sai_X.setBounds(28, 9, 65, 20);
		pan_coords.add(sai_X);
		sai_X.setEditable(false);
		sai_X.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_X.setColumns(10);

		lib_Y = new JLabel("Y");
		lib_Y.setBounds(6, 40, 10, 20);
		pan_coords.add(lib_Y);
		lib_Y.setFont(new Font("Tahoma", Font.BOLD, 14));

		sai_Y = new JTextField();
		sai_Y.setBounds(28, 40, 65, 20);
		pan_coords.add(sai_Y);
		sai_Y.setEditable(false);
		sai_Y.setColumns(10);
		sai_Y.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		lib_Z = new JLabel("Z");
		lib_Z.setBounds(6, 72, 10, 20);
		pan_coords.add(lib_Z);
		lib_Z.setFont(new Font("Tahoma", Font.BOLD, 14));

		sai_Z = new JTextField();
		sai_Z.setBounds(28, 72, 65, 20);
		pan_coords.add(sai_Z);
		sai_Z.setEditable(false);
		sai_Z.setColumns(10);
		sai_Z.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		lib_angle = new JLabel(Messages.getString("MenuPrincipal.lib_angle.text")); //$NON-NLS-1$
		lib_angle.setBounds(105, 8, 39, 20);
		pan_coords.add(lib_angle);
		lib_angle.setFont(new Font("Tahoma", Font.BOLD, 14));

		sai_angle = new JTextField();
		sai_angle.setBounds(166, 6, 65, 20);
		pan_coords.add(sai_angle);
		sai_angle.setEditable(false);
		sai_angle.setColumns(10);
		sai_angle.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		lib_pitch = new JLabel(Messages.getString("MenuPrincipal.lib_pitch.text")); //$NON-NLS-1$
		lib_pitch.setBounds(105, 40, 61, 20);
		pan_coords.add(lib_pitch);
		lib_pitch.setFont(new Font("Tahoma", Font.BOLD, 14));

		sai_pitch = new JTextField();
		sai_pitch.setBounds(166, 41, 65, 20);
		pan_coords.add(sai_pitch);
		sai_pitch.setEditable(false);
		sai_pitch.setColumns(10);
		sai_pitch.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		pan_rewards = new JPanel();
		pan_rewards.setLayout(null);

		//TODO
		tabpan_config.addTab(Messages.getString("MenuPrincipal.tabpan_arena_wave.title"), pan_arena_wave); //$NON-NLS-2$ //$NON-NLS-1$
		tabpan_config.addTab(Messages.getString("MenuPrincipal.tabpan_classes.title"), pan_classes); //$NON-NLS-2$ //$NON-NLS-1$
		tabpan_config.addTab(Messages.getString("MenuPrincipal.tabpan_arena_settings.title"), pan_arena_settings); //$NON-NLS-2$ //$NON-NLS-1$
		tabpan_config.addTab(Messages.getString("MenuPrincipal.pan_coordinates.title"), pan_coordinates); //$NON-NLS-2$ //$NON-NLS-1$
		tabpan_config.addTab(Messages.getString("MenuPrincipal.pan_rewards.title"), pan_rewards); //$NON-NLS-2$ //$NON-NLS-1$
		tabpan_config.addTab(Messages.getString("MenuPrincipal.pan_global_settings.title"), pan_global_settings); //$NON-NLS-1$

		lib_every = new JLabel(Messages.getString("MenuPrincipal.lib_every.text")); //$NON-NLS-1$
		lib_every.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_every.setBounds(6, 6, 110, 25);
		pan_rewards.add(lib_every);

		btn_add_every = new JButton(Messages.getString("MenuPrincipal.btn_add_every.text")); //$NON-NLS-1$
		btn_add_every.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				newReward(e);
			}
		});
		btn_add_every.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_add_every.setBounds(178, 8, 90, 25);
		pan_rewards.add(btn_add_every);

		list_every = new JHoverList<CellListReward>();
		list_every.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				rewardCellMouseAdapter(e);
			}
		});

		scrpan_every = new JScrollPane(list_every);
		scrpan_every.setBounds(6, 43, 262, 146);
		pan_rewards.add(scrpan_every);

		lib_after = new JLabel(Messages.getString("MenuPrincipal.lib_after.text")); //$NON-NLS-1$
		lib_after.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_after.setBounds(6, 218, 121, 25);
		pan_rewards.add(lib_after);

		list_after = new JHoverList<CellListReward>();
		list_after.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				rewardCellMouseAdapter(e);
			}
		});

		scrpan_after = new JScrollPane(list_after);
		scrpan_after.setBounds(6, 255, 262, 146);
		pan_rewards.add(scrpan_after);

		btn_add_after = new JButton(Messages.getString("MenuPrincipal.btn_add_after.text")); //$NON-NLS-1$
		btn_add_after.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_add_after.setBounds(178, 220, 90, 25);
		btn_add_after.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				newReward(e);
			}
		});
		pan_rewards.add(btn_add_after);

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(280, 6, 2, 395);
		pan_rewards.add(separator_4);

		pan_reward_control = new JPanel();
		pan_reward_control.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pan_reward_control.setBounds(294, 149, 168, 146);
		pan_rewards.add(pan_reward_control);
		pan_reward_control.setLayout(null);
		pan_reward_control.setVisible(false);

		lib_reward_wave = new JLabel(Messages.getString("MenuPrincipal.lib_reward_wave.text")); //$NON-NLS-1$
		lib_reward_wave.setBounds(6, 6, 55, 25);
		pan_reward_control.add(lib_reward_wave);
		lib_reward_wave.setFont(new Font("Tahoma", Font.BOLD, 14));

		sai_reward_wave_number = new JFormattedTextField();
		sai_reward_wave_number.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//TODO keyReleased
			}
		});
		sai_reward_wave_number.setBounds(89, 6, 73, 25);
		pan_reward_control.add(sai_reward_wave_number);
		sai_reward_wave_number.setText("");

		lib_moment = new JLabel(Messages.getString("MenuPrincipal.lib_moment.text")); //$NON-NLS-1$
		lib_moment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_moment.setBounds(6, 43, 72, 25);
		pan_reward_control.add(lib_moment);

		combo_montant = new JWideComboBox();
		combo_montant.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				//TODO ItemListener
			}
		});
		combo_montant.setModel(new DefaultComboBoxModel<String>(ERewardType.namevalues()));
		combo_montant.setBounds(89, 43, 73, 26);
		pan_reward_control.add(combo_montant);

		btn_set_rewards = new JButton(Messages.getString("MenuPrincipal.btn_set_rewards.text")); //$NON-NLS-1$
		btn_set_rewards.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//TODO mouseReleased
			}
		});
		btn_set_rewards.setBounds(6, 80, 156, 58);
		pan_reward_control.add(btn_set_rewards);
		btn_set_rewards.setFont(new Font("Tahoma", Font.BOLD, 13));

		raz();

		setSize(760,637);

		setLocationRelativeTo(null);
		initializing = false;
		setVisible(true);
	}

	private void loadLocale() {
		Locale def = Locale.getDefault();
		Locale newdef = Locale.getDefault();

		if(def==Locale.ENGLISH || def==Locale.CANADA || def==Locale.UK || def==Locale.US) {
			newdef = Locale.ENGLISH;
		}
		else if(def==Locale.FRENCH || def==Locale.CANADA_FRENCH || def==Locale.FRANCE) {
			newdef = Locale.FRENCH;
		}
		Locale.setDefault(newdef);
		YmlJFileChooser.setDefaultLocale(newdef);
		Messages.load();
		EnumName.load();
	}

	private void error_log(Exception e) {
		try {
			File ferr = new File("mah_error.log");
			ferr.delete();
			ferr.createNewFile();
			FileWriter err = new FileWriter(ferr);
			err.write(e.getMessage()+"\n");
			StackTraceElement[] ste = e.getStackTrace();
			for(int i=0;i<ste.length;i++) {
				err.write("\t"+ste[i].toString()+"\n");
			}
			err.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void raz() {
		Classe.classe_list.clear();
		arenas = null;
		file = null;
		wave = null;
		config = null;
		tabpan_config.setEnabledAt(1, false);
		tabpan_config.setEnabledAt(2, false);
		tabpan_config.setEnabledAt(3, false);
		tabpan_config.setEnabledAt(4, false);
		tabpan_config.setEnabledAt(5, false);
		tabpan_config.setSelectedIndex(0);
		loadData_ClassConfig(Classe.classe_list, -1);
		list_recurrent.setModel(new DefaultListModel<CellListWave>());
		list_single.setModel(new DefaultListModel<CellListWave>());
		combo_arena.setModel(new DefaultComboBoxModel<String>());
		setInvisibleComponents_Arena();
	}

	public void newWave(MouseEvent e) {
		if (combo_arena.getSelectedIndex()!=-1) {

			ECatW category = null;
			JHoverList<CellListWave> listToLoad = null;
			if(e.getSource()==btn_newrecurrent){
				category = ECatW.recurrent;
				listToLoad = list_recurrent;
			}
			else {
				category = ECatW.single;
				listToLoad = list_single;
			}

			Arena lArene = arenas.getALarenas().get(
					combo_arena.getSelectedIndex());
			ArrayList<Wave> waves = lArene
					.getWavesType(category);
			DefaultW defwave = new DefaultW(category);
			waves.add(0, defwave);
			wave = defwave;
			loadListCaracs_Arena(waves, listToLoad);
			setVisibleComponents_Arena(defwave);
			loadData_Arena(defwave);
			listToLoad.setSelectedIndex(0);
			deselectWaveLists_Arena(listToLoad);
			sai_name.requestFocus();
			sai_name.selectAll();

		}
	}

	public void newReward(MouseEvent e) {
		ERewardType rewardtype = null;
		JHoverList<CellListReward> listToLoad = null;
		if(e.getSource()==btn_add_every){
			rewardtype = ERewardType.every;
			listToLoad = list_every;
		}
		else {
			rewardtype = ERewardType.after;
			listToLoad = list_after;
		}

		Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());
		RewardList rewards = lArene.getRewardsType(rewardtype);
		reward = new Reward(rewards.getFirstAvailableNumber(), rewardtype);
		rewards.add(reward);
		loadData_Rewards();

		int index = rewards.indexOf(reward);
		listToLoad.setSelectedIndex(index);
		listToLoad.ensureIndexIsVisible(index);

		deselectRewardLists_Rewards(listToLoad);

		loadReward(reward);	
	}

	@SuppressWarnings("unchecked")
	public void waveArenaCellMouseAdapter(MouseEvent e) {
		//On récupère la liste source en tant que liste de caracs pour l'évaluation de situation
		//et en tant que liste de vagues pour le travail sur les données
		JHoverList<CellListCaracs> source = (JHoverList<CellListCaracs>) e.getSource();
		JHoverList<CellListWave> jList = (JHoverList<CellListWave>) e.getSource();
		if (source.getModel().getSize()!=0) {

			jList.ensureIndexIsVisible(jList.getSelectedIndex());

			switch (e.getButton()) {
			//Clic gauche (sélection)
			case MouseEvent.BUTTON1:
				if (source != list_carac_wave) {
					wave = jList.getSelectedValue().getWave();
					setVisibleComponents_Arena(wave);
					loadData_Arena(wave);
					deselectWaveLists_Arena(jList);
					sai_name.selectAll();
				}
				break;
				//Clic molette (suppression)
			case MouseEvent.BUTTON2:
				int hoverIndex = ((HoverListCellRenderer) jList
						.getCellRenderer()).getHoverIndex();

				if (hoverIndex != -1) {
					if (source != list_carac_wave) {

						setInvisibleComponents_Arena();

						wave = jList.getModel().getElementAt(hoverIndex).getWave();
						int reponse = JOptionPane.showConfirmDialog(
								rootPane,
								MessageFormat.format(Messages.getString("MenuPrincipal.message.delWave"), wave.getCategory().getNom().toLowerCase(),wave.getNom()),
								Messages.getString("Message.title.confirmation"),
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
						switch (reponse) {
						case 0:
							//Récupération de l'arène en cours
							Arena lArene = arenas.getALarenas().get(
									combo_arena.getSelectedIndex());
							//Suppression de la vague voulue
							lArene.getWavesType(wave.getCategory())
							.remove(hoverIndex);
							//Rechargement
							loadListCaracs_Arena(
									lArene.getWavesType(wave
											.getCategory()), jList);
							wave = null;
							break;
						default:
							break;
						}
						deselectWaveLists_Arena(list_recurrent);
						deselectWaveLists_Arena(list_single);

					} else {

						CellListCaracs cellcarac = source.getModel()
								.getElementAt(hoverIndex);
						CellListMonster cellmonster = null;
						CellListAbility cellabi = null;
						JHoverList<CellListWave> list_wave = list_recurrent
								.getSelectedIndex() != -1 ? list_recurrent
										: list_single;
						wave = list_wave.getSelectedValue()
								.getWave();
						String toDelete = "";
						String name = "";
						if (cellcarac instanceof CellListMonster) {
							toDelete = Messages.getString("MenuPrincipal.message.delMonster1");
							cellmonster = (CellListMonster) cellcarac;
							name = cellmonster.getMonstre()
									.getMonstre().getNom();
						} else {
							toDelete = Messages.getString("MenuPrincipal.message.delAbility1");
							cellabi = (CellListAbility) cellcarac;
							name = cellabi.getAbility().getNom();
						}

						int reponse = JOptionPane.showConfirmDialog(
								null,
								MessageFormat.format(Messages.getString("MenuPrincipal.message.delMonsterAbility"),toDelete,name),
								Messages.getString("Message.title.confirmation"),
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
						@SuppressWarnings("rawtypes")
						ArrayList listdata = null;
						switch (reponse) {
						case 0:
							if (cellcarac instanceof CellListAbility) {

								BossW bwave = (BossW) wave;
								listdata = bwave.getAbilities();
								listdata.remove(cellabi.getAbility());

							} else {
								listdata = wave.getMonstres();
								listdata.remove(cellmonster
										.getMonstre());
							}
							break;
						default:
							break;
						}

						if (listdata != null) {
							loadListCaracs_Arena(listdata, source);
						}
					}
				}
				break;
			default:
				break;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void rewardCellMouseAdapter(MouseEvent e) {
		JHoverList<CellListReward> source = (JHoverList<CellListReward>) e.getSource();
		if(source.getModel().getSize()!=0) {
			source.ensureIndexIsVisible(source.getSelectedIndex());

			switch (e.getButton()) {
			//Clic gauche (sélection)
			case MouseEvent.BUTTON1:
				reward = source.getSelectedValue().getReward();
				deselectRewardLists_Rewards(source);
				loadReward(reward);
				break;
				//Clic molette (suppression)
			case MouseEvent.BUTTON2:
				int hoverIndex = ((HoverListCellRenderer) source.getCellRenderer()).getHoverIndex();
				if (hoverIndex!=-1) {
					reward = source.getModel().getElementAt(hoverIndex).getReward();
					pan_reward_control.setVisible(false);

					int reponse = JOptionPane.showConfirmDialog(
							rootPane,
							MessageFormat.format(Messages.getString("MenuPrincipal.message.delReward"), 
									reward.getType().getNom().toLowerCase(), 
									reward.getWave_number()),
									Messages.getString("Message.title.confirmation"),
									JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE);
					switch (reponse) {
					case 0:
						Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());
						lArene.getRewardsType(reward.getType()).remove(hoverIndex);
						loadData_Rewards();
						reward = null;
						break;
					default:
						break;
					}
				}
			default:
				break;
			}
		}
	}

	public void loadArena(int numarena) {

		setInvisibleComponents_Arena();
		Arena arena = arenas.getALarenas().get(numarena);
		config = arena.getConfig();

		ArrayList<Wave> recW = arena.getWavesType(ECatW.recurrent);
		loadListCaracs_Arena(recW, list_recurrent);

		ArrayList<Wave> singW = arena.getWavesType(ECatW.single);
		loadListCaracs_Arena(singW, list_single);

		loadData_ArenaConfig(config);
		loadData_ClassConfig(Classe.classe_list,-1);
		loadData_GlobalSettings();

		loadData_Coordinates();

		loadData_Rewards();

	}

	public void loadCoords(String position) {
		pan_coords.setVisible(true);
		Coordinates coords = arenas.getALarenas().get(combo_arena.getSelectedIndex()).getCcoords();
		Position pos = null;
		switch (position) {
		case "Coordinates":case "spawnpoints": 
			break;
		case "p1":
			pos = coords.getP1();
			break;
		case "p2":
			pos = coords.getP2();
			break;
		case "l1":
			pos = coords.getL1();
			break;
		case "l2":
			pos = coords.getL2();
			break;
		case "arena":
			pos = coords.getArena();
			break;
		case "lobby":
			pos = coords.getLobby();
			break;
		case "spectator":
			pos = coords.getSpectator();
			break;
		default:
			pos = (Position) coords.getSpawnpoints().get(position);
			break;
		}
		if ((!position.equals("Coordinates") || !position.equals("spawnpoints")) && pos!=null) {
			sai_X.setText(pos.getX()+"");
			sai_Y.setText(pos.getY()+"");
			sai_Z.setText(pos.getZ()+"");
			sai_angle.setText(pos.getAngle()+"");
			sai_pitch.setText(pos.getPitch()+"");
		}
		else pan_coords.setVisible(false);
	}

	public void setVisibleComponents_Arena(Wave wave) {
		ETypeW typevague = wave.getType();
		ECatW catvague = wave.getCategory();

		setInvisibleComponents_Arena();
		lib_name.setVisible(true);
		sai_name.setVisible(true);
		lib_category.setVisible(true);
		combo_category.setVisible(true);
		lib_type.setVisible(true);
		combo_type.setVisible(true);
		lib_wave.setVisible(true);
		sai_wave.setVisible(true);

		lib_carac_wave.setVisible(true);
		scrpan_carac_wave.setVisible(true);
		btn_add.setVisible(true);
		combo_carac_wave.setVisible(true);
		sai_nb_carac_wave.setVisible(true);

		switch (typevague) {
		case Default:
			lib_growth.setVisible(true);
			combo_growth.setVisible(true);
			lib_abi_announce.setVisible(true);

			chk_abi_announce.setVisible(true);
			lib_abi_announce.setText(Messages.getString("MenuPrincipal.fixed"));
			lib_carac_wave.setText(Messages.getString("MenuPrincipal.monsters"));
			combo_carac_wave.setModel(new DefaultComboBoxModel<String>(EMonsters.namevalues()));
			combo_carac_wave.setSelectedIndex(-1);
			break;
		case Boss:
			lib_boss_name.setVisible(true);
			sai_boss_name.setVisible(true);
			lib_monster.setVisible(true);
			combo_monster.setVisible(true);
			lib_health.setVisible(true);
			combo_health.setVisible(true);
			lib_abi_announce.setVisible(true);
			chk_abi_announce.setVisible(true);
			lib_abi_interval.setVisible(true);
			sai_abi_interval.setVisible(true);

			lib_set.setText(Messages.getString("MenuPrincipal.reward"));
			lib_set.setVisible(true);
			btn_set.setVisible(true);

			lib_carac_wave.setText(Messages.getString("MenuPrincipal.abilities"));
			combo_carac_wave.setModel(new DefaultComboBoxModel<String>(EAbilities.namevalues()));
			combo_carac_wave.setSelectedIndex(-1);
			sai_nb_carac_wave.setVisible(false);
			break;
		case Special:
			lib_carac_wave.setText(Messages.getString("MenuPrincipal.monsters"));
			combo_carac_wave.setModel(new DefaultComboBoxModel<String>(EMonsters.namevalues()));
			combo_carac_wave.setSelectedIndex(-1);
			break;
		case Swarm:
			lib_monster.setVisible(true);
			combo_monster.setVisible(true);
			lib_amount.setVisible(true);
			combo_amount.setVisible(true);

			lib_carac_wave.setVisible(false);
			combo_carac_wave.setVisible(false);
			btn_add.setVisible(false);
			scrpan_carac_wave.setVisible(false);
			sai_nb_carac_wave.setVisible(false);
			break;
		case Supply:
			lib_carac_wave.setText(Messages.getString("MenuPrincipal.monsters"));
			combo_carac_wave.setModel(new DefaultComboBoxModel<String>(EMonsters.namevalues()));
			combo_carac_wave.setSelectedIndex(-1);

			lib_set.setVisible(true);
			lib_set.setText(Messages.getString("MenuPrincipal.drops"));
			btn_set.setVisible(true);
			break;
		case Upgrade:
			lib_abi_announce.setVisible(true);
			lib_abi_announce.setText(Messages.getString("MenuPrincipal.give_all_items"));
			chk_abi_announce.setVisible(true);
			lib_set.setVisible(true);
			lib_set.setText(Messages.getString("MenuPrincipal.configure"));
			btn_set.setVisible(true);

			lib_carac_wave.setVisible(false);
			combo_carac_wave.setVisible(false);
			btn_add.setVisible(false);
			scrpan_carac_wave.setVisible(false);
			sai_nb_carac_wave.setVisible(false);
			break;
		default:
			break;
		}

		switch (catvague) {
		case recurrent:
			lib_priority.setVisible(true);
			sai_priority.setVisible(true);
			lib_frequency.setVisible(true);
			sai_frequency.setVisible(true);
			break;
		case single:
			break;
		}

	}

	public void setInvisibleComponents_Arena() {
		lib_name.setVisible(false);
		sai_name.setVisible(false);
		lib_category.setVisible(false);
		combo_category.setVisible(false);
		lib_type.setVisible(false);
		combo_type.setVisible(false);
		lib_wave.setVisible(false);
		sai_wave.setVisible(false);
		lib_priority.setVisible(false);
		sai_priority.setVisible(false);
		lib_frequency.setVisible(false);
		sai_frequency.setVisible(false);
		lib_growth.setVisible(false);
		combo_growth.setVisible(false);
		lib_carac_wave.setVisible(false);
		scrpan_carac_wave.setVisible(false);
		lib_monster.setVisible(false);
		combo_monster.setVisible(false);
		lib_amount.setVisible(false);
		combo_amount.setVisible(false);
		lib_health.setVisible(false);
		combo_health.setVisible(false);
		lib_abi_announce.setVisible(false);
		chk_abi_announce.setVisible(false);
		lib_abi_interval.setVisible(false);
		sai_abi_interval.setVisible(false);
		lib_boss_name.setVisible(false);
		sai_boss_name.setVisible(false);
		btn_add.setVisible(false);
		combo_carac_wave.setVisible(false);
		sai_nb_carac_wave.setVisible(false);

		lib_set.setVisible(false);
		btn_set.setVisible(false);

		lib_abi_announce.setText(Messages.getString("MenuPrincipal.lib_abi_announce.text")); //$NON-NLS-1$ //$NON-NLS-2$
		list_carac_wave.setModel(new DefaultListModel<CellListCaracs>());
		lib_set.setText("");
		btn_set.setText(Messages.getString("MenuPrincipal.btn_set.text")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public void deselectWaveLists_Arena(JHoverList<CellListWave> jList){
		if(jList==list_recurrent){
			list_single.clearSelection();
		}
		else if(jList==list_single){
			list_recurrent.clearSelection();
		}
	}

	public void deselectRewardLists_Rewards(JHoverList<CellListReward> jList) {
		if(jList==list_every){
			list_after.clearSelection();
		}
		else if(jList==list_after){
			list_every.clearSelection();
		}
	}

	public void loadData_Arena(Wave wave) {
		sai_name.setText(wave.getNom());
		combo_category.setSelectedItem(wave.getCategory().getNom());
		combo_type.setSelectedItem(wave.getType().getNom());
		sai_wave.setValue(wave.getNumwave());

		sai_priority.setValue(wave.getPriority());
		sai_frequency.setValue(wave.getFrequency());

		switch (wave.getType()) {
		case Default:
			DefaultW defwave = (DefaultW) wave;
			StringBuffer growth = new StringBuffer(defwave.getGrowth().getNom());
			growth.replace(0, 1, Character.toString(growth.charAt(0)).toUpperCase());
			combo_growth.setSelectedItem(growth.toString());
			chk_abi_announce.setSelected(defwave.isFixed());
			loadListCaracs_Arena(defwave.getMonstres(), list_carac_wave);
			break;
		case Boss:
			BossW bwave = (BossW) wave;
			sai_boss_name.setText(bwave.getBossName());
			combo_health.setSelectedItem(bwave.getHealth().getNom());
			chk_abi_announce.setSelected(bwave.isAbility_announce());
			sai_abi_interval.setValue(bwave.getAbility_interval());
			combo_monster.setSelectedItem(bwave.getMonstres().get(0).getMonstre().getNom());
			loadListCaracs_Arena(bwave.getAbilities(), list_carac_wave);
			break;
		case Swarm:
			SwarmW swwave = (SwarmW) wave;
			EMonsters m = null;
			if(swwave.getMonstres().size()!=0){
				m = swwave.getMonstres().get(0).getMonstre();
			}
			combo_monster.setSelectedItem(m==null ? null : m.getNom());
			combo_amount.setSelectedItem(swwave.getAmount().getNom());
			break;
		case Special:
			SpecialW spwave = (SpecialW) wave;
			loadListCaracs_Arena(spwave.getMonstres(), list_carac_wave);
			break;
		case Supply:
			SupplyW supw = (SupplyW) wave;
			loadListCaracs_Arena(supw.getMonstres(), list_carac_wave);
			break;
		case Upgrade:
			UpgradeW upw = (UpgradeW) wave;
			chk_abi_announce.setSelected(upw.isGive_all_items());
		default:
			break;
		}
	}


	/**
	 * Charge les informations d'une liste de données dans une liste graphique
	 * @param listdata
	 * @param listview
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void loadListCaracs_Arena(ArrayList listdata, JHoverList listview) {

		DefaultListModel modW = new DefaultListModel<>();

		if(listview == list_recurrent || listview == list_single) {
			modW = new DefaultListModel<CellListWave>();

			for(int i=0;i<listdata.size();i++){
				Wave vague = (Wave) listdata.get(i);
				modW.addElement(new CellListWave(vague));
			}

		}
		else {
			if(listdata.size()!=0){
				Object o = listdata.get(0);
				if(o instanceof Monstre){

					modW = new DefaultListModel<CellListMonster>();
					MonsterList mlistdata = (MonsterList)listdata;
					for(int i=0;i<listdata.size();i++){
						modW.addElement(new CellListMonster(mlistdata, i));
					}

				}
				else if(o instanceof EAbilities){

					modW = new DefaultListModel<CellListAbility>();
					for(int i=0;i<listdata.size();i++){
						EAbilities ability = (EAbilities) listdata.get(i);
						modW.addElement(new CellListAbility(ability));
					}

				}

			}

		}

		listview.setModel(modW);

	}

	/**
	 * Met à jour les données numériques d'une vague avec le champ source passé en paramètre
	 * @param component le composant source
	 */
	public void majData_Arena(JComponent component) {

		JFormattedTextField source = (JFormattedTextField) component;
		JHoverList<CellListWave> list_sel = list_recurrent.getSelectedIndex()!=-1 ? list_recurrent : list_single;
		Wave wave = list_sel.getSelectedValue().getWave();
		Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());
		ArrayList<Wave> waveList = lArene.getWavesType(list_sel == list_recurrent ? ECatW.recurrent	: ECatW.single);
		Integer val_src = ((Number) source.getValue()).intValue();



		if(source==sai_wave){

			int numwave = (int) (val_src.equals("") ? 1 : val_src);

			wave.setNumwave(numwave);

			if (list_sel==list_single) {

				Collections.sort(waveList);
				int i = 0;
				while (i < waveList.size() && waveList.get(i) != wave) {
					i++;
				}
				loadListCaracs_Arena(waveList, list_sel);
				list_sel.setSelectedIndex(i);

			}

		}
		else if(source==sai_priority || source==sai_frequency){

			int numcarac = (int) (val_src.equals("") ? 1 : val_src);
			if(source==sai_priority)
				wave.setPriority(numcarac);
			else
				wave.setFrequency(numcarac);

			Collections.sort(waveList);
			int i = 0;
			while (i < waveList.size() && waveList.get(i) != wave) {
				i++;
			}
			loadListCaracs_Arena(waveList, list_sel);
			list_sel.setSelectedIndex(i);

		}
		else if(source==sai_abi_interval){
			BossW bwave = (BossW) wave;
			int abi_interval = (int) (val_src.equals("") ? 3 : val_src);
			bwave.setAbility_interval(abi_interval);

		}

	}

	public void loadData_ClassConfig(ArrayList<Classe> aLclasses) {
		loadData_ClassConfig(aLclasses, list_classes.getSelectedIndex());
	}

	public void loadData_ClassConfig(ArrayList<Classe> aLclasses, int index) {
		DefaultListModel<CellListClass> mod_Class = new DefaultListModel<>();
		for(int i=0;i<aLclasses.size();i++) {
			Classe iclasse = aLclasses.get(i);
			if (!iclasse.getName().equals("all")) {
				mod_Class.addElement(new CellListClass(iclasse));
			}
		}
		list_classes.setModel(mod_Class);

		if(index==-1) {
			pan_caracs_class.setVisible(false);
			pan_class_limit.setVisible(false);
		}
		else {
			list_classes.setSelectedIndex(index);
			list_classes.ensureIndexIsVisible(index);
		}
	}

	public void loadClass_ClassConfig(Classe classe) {
		pan_caracs_class.setVisible(true);
		pan_class_limit.setVisible(true);

		String name = classe.getName();
		if(!name.equals("New_class")) {
			sai_class.setText(name);
		}
		else sai_class.setText(null);
		sai_dogs.setValue(classe.getDog_number());
		int hArmor = (int) (classe.getHorse()/8f);
		int horse = 5-((hArmor*8)+5-classe.getHorse());
		horse = horse<0 ? 0 : horse;
		combo_horse.setSelectedIndex(horse);
		combo_hArmor.setSelectedIndex(hArmor);

		ArrayList<String> perm_list = classe.getPermissions();
		DefaultListModel<CellListCaracs> mod_perm = new DefaultListModel<CellListCaracs>();
		if(perm_list!=null) {
			for(int i=0;i<perm_list.size();i++) {
				mod_perm.addElement(new CellListCaracs(perm_list.get(i)));
			}
		}
		list_permissions.setModel(mod_perm);

		perm_list = classe.getLobby_permissions();
		mod_perm = new DefaultListModel<CellListCaracs>();
		if(perm_list!=null) {
			for(int i=0;i<perm_list.size();i++) {
				mod_perm.addElement(new CellListCaracs(perm_list.get(i)));
			}
		}
		list_lobby_permissions.setModel(mod_perm);

		sai_class_limit.setValue(arenas.getALarenas().get(combo_arena.getSelectedIndex()).getClassLimit(classe));

		sai_class.requestFocus();
		sai_class.select(0, classe.getName().length());
	}

	public void loadData_ArenaConfig(ArenaConfig config) {
		sai_world.setValue(config.getWorld());
		chk_enabled.setSelected(config.getEnabled());
		chk_protect.setSelected(config.getProtect());
		sai_entry.setValue(config.getEntry_fee_money());
		chk_clear_wave_next.setSelected(config.getClear_wave_next());
		chk_clear_wave_boss.setSelected(config.getClear_wave_boss());
		chk_clear_boss_next.setSelected(config.getClear_boss_next());
		chk_lightning.setSelected(config.getLightning());
		chk_auto_equip.setSelected(config.getAuto_equip_armor());
		chk_soft_restore.setSelected(config.getSoft_restore());
		chk_soft_restore_drops.setSelected(config.getSoft_restore_drops());
		chk_require_inv_join.setSelected(config.getEmpty_inv_join());
		chk_require_inv_spec.setSelected(config.getEmpty_inv_spec());
		chk_hellhounds.setSelected(config.getHellhounds());
		chk_pvp.setSelected(config.getPvp_enabled());
		chk_monster_infight.setSelected(config.getMonster_infight());
		chk_allow_tp.setSelected(config.getAllow_tp());
		chk_spectate_death.setSelected(config.getDeath_spec());
		chk_auto_respawn.setSelected(config.getAuto_respawn());
		chk_share.setSelected(config.getShare_items());
		sai_min_players.setValue(config.getMin_players());
		sai_max_players.setValue(config.getMax_players());
		sai_max_join_distance.setValue(config.getMax_join_distance());
		sai_first_delay.setValue(config.getFirst_wave_delay());
		sai_interval.setValue(config.getWave_interval());
		sai_final_wave.setValue(config.getFinal_wave());
		sai_monster_limit.setValue(config.getMonster_limit());
		chk_monster_xp.setSelected(config.getMonster_drop_xp());
		chk_keep_xp.setSelected(config.getKeep_xp());
		chk_food_regen.setSelected(config.getFood_regen());
		chk_lock_food.setSelected(config.getFood_level_lock());
		combo_player_time.setSelectedItem(config.getPlayer_time());
		sai_auto_start.setValue(config.getAuto_start());
		chk_spout_class.setSelected(config.getSpout_select());
		chk_auto_ignite.setSelected(config.getAuto_ignite_tnt());
		chk_use_class_chest.setSelected(config.getClass_chest());
		chk_display_waves.setSelected(config.getWaves_as_level());
		chk_display_timer.setSelected(config.getTimer_as_level());
		chk_auto_ready.setSelected(config.getAuto_ready());
		chk_scoreboard.setSelected(config.getScoreboards());
		chk_isolated_chat.setSelected(config.getIsolated_chat());
		chk_global_join.setSelected(config.getGlobal_join_announce());
		chk_global_end.setSelected(config.getGlobal_end_announce());
	}

	public void loadData_GlobalSettings() {
		GlobalSettings gs = arenas.getGlobalSettings();
		chk_gs_enabled.setSelected(gs.isEnabled());
		chk_notifications.setSelected(gs.isUpdate_notifications());
		loadCommands_GlobalSettings(gs.getAllowed_commands());
		pan_commands.setVisible(false);
	}

	public void loadCommands_GlobalSettings(ArrayList<String> commands) {
		DefaultListModel<CellListCaracs> mod_commands = new DefaultListModel<>();
		for(int i=0;i<commands.size();i++) {
			mod_commands.addElement(new CellListCaracs(commands.get(i)));
		}
		list_commands.setModel(mod_commands);
	}

	public void loadData_Coordinates() {
		pan_coords.setVisible(true);

		DefaultMutableTreeNode coords = new DefaultMutableTreeNode("Coordinates");
		tree_points.setModel(new DefaultTreeModel(coords));
		Coordinates ccoords = arenas.getALarenas().get(combo_arena.getSelectedIndex()).getCcoords();
		if (ccoords!=null) {
			if (ccoords.getP1() != null) {
				DefaultMutableTreeNode p1 = new DefaultMutableTreeNode("p1");
				DefaultMutableTreeNode p2 = new DefaultMutableTreeNode("p2");
				coords.add(p1);
				coords.add(p2);
			}
			if(ccoords.getL1() != null) {
				DefaultMutableTreeNode p1 = new DefaultMutableTreeNode("l1");
				DefaultMutableTreeNode p2 = new DefaultMutableTreeNode("l2");
				coords.add(p1);
				coords.add(p2);
			}
			if(ccoords.getArena() != null) {
				DefaultMutableTreeNode p1 = new DefaultMutableTreeNode("arena");
				coords.add(p1);
			}
			if(ccoords.getLobby() != null) {
				DefaultMutableTreeNode p1 = new DefaultMutableTreeNode("lobby");
				coords.add(p1);
			}
			if(ccoords.getSpectator() != null) {
				DefaultMutableTreeNode p1 = new DefaultMutableTreeNode("spectator");
				coords.add(p1);
			}
			if(ccoords.getSpawnpoints() != null) {
				DefaultMutableTreeNode p1 = new DefaultMutableTreeNode("spawnpoints");
				coords.add(p1);
				LinkedHashMap<String, Object> spawnpoints = ccoords.getSpawnpoints();
				for (Iterator<String> it = spawnpoints.keySet().iterator(); it.hasNext();) {
					String spawn = (String) it.next();
					DefaultMutableTreeNode s = new DefaultMutableTreeNode(spawn);
					p1.add(s);
				}
			}
		}
	}

	public void loadData_Rewards() {
		Arena arena = arenas.getALarenas().get(combo_arena.getSelectedIndex());

		DefaultListModel<CellListReward> mod_every = new DefaultListModel<>();
		RewardList rlist = arena.getRewardsType(ERewardType.every);
		for(int i=0;i<rlist.size();i++) {
			mod_every.addElement(new CellListReward(rlist.get(i)));
		}
		list_every.setModel(mod_every);

		DefaultListModel<CellListReward> mod_after = new DefaultListModel<>();
		rlist = arena.getRewardsType(ERewardType.after);
		for(int i=0;i<rlist.size();i++) {
			mod_after.addElement(new CellListReward(rlist.get(i)));
		}
		list_after.setModel(mod_after);

	}

	public void loadReward(Reward r) {
		pan_reward_control.setVisible(true);
		sai_reward_wave_number.setValue((long)r.getWave_number());
		combo_montant.setSelectedItem(r.getType().getNom());
		sai_reward_wave_number.requestFocus();
	}
}
