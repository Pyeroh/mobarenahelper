package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

import model.Arena;
import model.ArenaConfig;
import model.Arenas;
import model.ArmorList;
import model.Classe;
import model.GestYaml;
import model.Item;
import model.ItemList;
import model.MonsterList;
import model.Monstre;
import model.Wave;
import model.enums.EAbilities;
import model.enums.EAmount;
import model.enums.ECatW;
import model.enums.EGrowth;
import model.enums.EHealth;
import model.enums.EMonsters;
import model.enums.ETypeW;
import model.wave.BossW;
import model.wave.DefaultW;
import model.wave.OtherW;
import model.wave.SpecialW;
import model.wave.SupplyW;
import model.wave.SwarmW;
import model.wave.UpgradeW;
import view.cells.CellListAbility;
import view.cells.CellListCaracs;
import view.cells.CellListClass;
import view.cells.CellListMonster;
import view.cells.CellListWave;
import view.cells.HoverListCellRenderer;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 7504976316824014595L;

	private JMenuItem mntmAbout;
	private JMenuBar menuBar;
	private JMenu mnHelp;
	private JMenuItem mntmHowToUse;
	private GestYaml g;
	private Arenas arenas = null;
	private File file = null;
	private Wave wave;
	private Classe classe;
	private ArenaConfig config;

	private JTabbedPane tabpan_config;

	private JPanel pan_arena_wave;
	private JLabel lib_arena;
	private JComboBox<String> combo_arena;
	private JLabel lib_recurrent;
	private JButton btn_newrecurrent;
	private JScrollPane scrpan_recurrent;
	private JList<CellListWave> list_recurrent;
	private JLabel lib_single;
	private JButton btn_newsingle;
	private JScrollPane scrpan_single;
	private JList<CellListWave> list_single;
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
	private JList<CellListCaracs> list_carac_wave;
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
	private JList<CellListClass> list_classes;
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

	public MenuPrincipal() throws ParseException{
		super("MobArena Helper v2");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/gui/mobarena.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setVisible(true);

		//TODO Gestion (ajout/suppression) des arènes

		MouseAdapter newWave = new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (combo_arena.getSelectedIndex()!=-1) {

					ECatW category = null;
					JList<CellListWave> listToLoad = null;
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
					loadListCaracs_ArenaConfig(waves, listToLoad);
					setVisibleComponents_ArenaConfig(defwave);
					loadData_ArenaConfig(defwave);
					listToLoad.setSelectedIndex(0);
					deselectWaveLists_ArenaConfig(listToLoad);
					sai_name.requestFocus();
					sai_name.selectAll();

				}

			}
		};

		MouseAdapter cellmouseadapter = new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseReleased(MouseEvent e) {

				//On récupère la liste source en tant que liste de caracs pour l'évaluation de situation
				//et en tant que liste de vagues pour le travail sur les données
				JList<CellListCaracs> source = (JList<CellListCaracs>) e.getSource();
				JList<CellListWave> jList = (JList<CellListWave>) e.getSource();
				if (source.getModel().getSize()!=0) {

					jList.ensureIndexIsVisible(jList.getSelectedIndex());

					//Clic gauche (sélection)
					if (e.getButton() == MouseEvent.BUTTON1) {

						if (source != list_carac_wave) {
							wave = jList.getSelectedValue().getWave();
							setVisibleComponents_ArenaConfig(wave);
							loadData_ArenaConfig(wave);
							deselectWaveLists_ArenaConfig(jList);
						}

					}
					//Clic molette (suppression)
					else if (e.getButton() == MouseEvent.BUTTON2) {

						int hoverIndex = ((HoverListCellRenderer) jList
								.getCellRenderer()).getHoverIndex();

						if (hoverIndex != -1) {
							if (source != list_carac_wave) {

								setInvisibleComponents_ArenaConfig();

								wave = jList.getModel()
										.getElementAt(hoverIndex).getWave();
								int reponse = JOptionPane.showConfirmDialog(
										null,
										"Are you sure you want to delete the "
												+ wave.getCategory()
												.name()
												+ " wave named "
												+ wave.getNom() + " ?",
												"Confirmation",
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
									loadListCaracs_ArenaConfig(
											lArene.getWavesType(wave
													.getCategory()), jList);
									break;
								default:
									break;
								}
								deselectWaveLists_ArenaConfig(list_recurrent);
								deselectWaveLists_ArenaConfig(list_single);

							} else {

								CellListCaracs cellcarac = source.getModel()
										.getElementAt(hoverIndex);
								CellListMonster cellmonster = null;
								CellListAbility cellabi = null;
								JList<CellListWave> list_wave = list_recurrent
										.getSelectedIndex() != -1 ? list_recurrent
												: list_single;
								wave = list_wave.getSelectedValue()
										.getWave();
								String toDelete = "";
								String name = "";
								if (cellcarac instanceof CellListMonster) {
									toDelete = "monster";
									cellmonster = (CellListMonster) cellcarac;
									name = cellmonster.getMonstre()
											.getMonstre().getNom();
								} else {
									toDelete = "ability";
									cellabi = (CellListAbility) cellcarac;
									name = cellabi.getAbility().getNom();
								}

								int reponse = JOptionPane.showConfirmDialog(
										null,
										"Are you sure you want to delete the "
												+ toDelete + " " + name + "?",
												"Confirmation",
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
									loadListCaracs_ArenaConfig(listdata, source);
								}
							}
						}
					}
				}
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
				majData_ArenaConfig(e);
			}
		};

		ItemListener itemListener_monster_amount = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				//la clause isFocusOwner() est spécifiée car la combo Amount change de valeur à l'initialisation
				if (e.getStateChange() == ItemEvent.DESELECTED && ((JComponent) e.getSource()).isFocusOwner()) {
					JList<CellListWave> list_sel = combo_category.getSelectedItem().equals("Recurrent") ? list_recurrent : list_single;

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

		btn_load = new JButton("Load Config");
		btn_load.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Classe.classe_list.clear();
				YmlJFileChooser fchoose = new YmlJFileChooser();
				fchoose.showOpenDialog(null);
				file = fchoose.getSelectedFile();
				if (file!=null) {
					try {
						GestYaml.S_gestionnaire = new GestYaml(file);
						g = GestYaml.S_gestionnaire;
						arenas = new Arenas(g.getMap("arenas"),g.getMap("global-settings"),g.getMap("classes"));
						ArrayList<Arena> alArenas = arenas.getALarenas();
						for(int i=0;i<alArenas.size();i++){
							combo_arena.addItem(alArenas.get(i).getNom());
						}
						loadArena(0);
						pan_caracs_class.setVisible(false);
						tabpan_config.setEnabledAt(1, true);
						tabpan_config.setEnabledAt(2, true);
						loadData_ClassConfig(arenas.getALclasses());
					} catch (Exception e1) {
						e1.printStackTrace();

						Classe.classe_list.clear();
						file = null;
						wave = null;
						config = null;
						tabpan_config.setEnabledAt(1, false);
						tabpan_config.setEnabledAt(2, false);
						list_recurrent.setModel(new DefaultListModel<CellListWave>());
						list_single.setModel(new DefaultListModel<CellListWave>());
						combo_arena.setModel(new DefaultComboBoxModel<String>());
						setInvisibleComponents_ArenaConfig();
						JOptionPane.showMessageDialog(rootPane, "Incorrect file format, please check it at\nhttp://yaml-online-parser.appspot.com/\nand verify everything is okay in your config file","Critical error",JOptionPane.ERROR_MESSAGE);

					}

				}
			}
		});
		btn_load.setForeground(new Color(255, 255, 255));
		btn_load.setBackground(new Color(100, 149, 237));
		btn_load.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_load.setBounds(526, 533, 97, 23);
		getContentPane().add(btn_load);

		btn_save = new JButton("Save Config As");
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(arenas!=null){

					YmlJFileChooser fchoose = new YmlJFileChooser(file.getPath());
					fchoose.showOpenDialog(null);
					File f = fchoose.getSelectedFile();
					if (f!=null) {
						if (!f.getPath().endsWith(".yml")) {
							f = new File(f.getPath() + ".yml");
						}
						f.delete();
						try {
							f.createNewFile();
							FileWriter fw = new FileWriter(f);
							GestYaml dumper = new GestYaml(arenas.getMap());
							dumper.dumpAsFile(fw);
							JOptionPane.showMessageDialog(null,
									"Finished saving", "",
									JOptionPane.INFORMATION_MESSAGE);

						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

				}
				else {
					JOptionPane.showMessageDialog(null, "You must load a file before saving it !","Saving error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_save.setForeground(Color.WHITE);
		btn_save.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_save.setBackground(new Color(100, 149, 237));
		btn_save.setBounds(633, 533, 115, 23);
		getContentPane().add(btn_save);

		tabpan_config = new JTabbedPane(JTabbedPane.TOP);
		tabpan_config.setBounds(0, 6, 754, 515);
		getContentPane().add(tabpan_config);

		pan_arena_wave = new JPanel();
		pan_arena_wave.setBounds(43, 54, 732, 443);
		pan_arena_wave.setLayout(null);

		lib_arena = new JLabel("Arena");
		lib_arena.setBounds(9, 8, 46, 17);
		pan_arena_wave.add(lib_arena);
		lib_arena.setFont(new Font("Tahoma", Font.BOLD, 14));

		combo_arena = new JComboBox<String>();
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

		lib_recurrent = new JLabel("Recurrent Waves");
		lib_recurrent.setBounds(9, 55, 132, 17);
		pan_arena_wave.add(lib_recurrent);
		lib_recurrent.setFont(new Font("Tahoma", Font.BOLD, 14));

		btn_newrecurrent = new JButton("New Wave");
		btn_newrecurrent.setBounds(167, 49, 91, 23);
		pan_arena_wave.add(btn_newrecurrent);
		btn_newrecurrent.addMouseListener(newWave);
		btn_newrecurrent.setFont(new Font("Tahoma", Font.BOLD, 11));

		list_recurrent = new JList<CellListWave>();
		list_recurrent.addMouseListener(cellmouseadapter);
		list_recurrent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrpan_recurrent = new JScrollPane(list_recurrent);
		scrpan_recurrent.setBounds(6, 74, 252, 190);
		pan_arena_wave.add(scrpan_recurrent);

		lib_single = new JLabel("Single Waves");
		lib_single.setBounds(9, 276, 132, 17);
		pan_arena_wave.add(lib_single);
		lib_single.setFont(new Font("Tahoma", Font.BOLD, 14));

		btn_newsingle = new JButton("New Wave");
		btn_newsingle.setBounds(167, 270, 91, 23);
		pan_arena_wave.add(btn_newsingle);
		btn_newsingle.addMouseListener(newWave);
		btn_newsingle.setFont(new Font("Tahoma", Font.BOLD, 11));

		list_single = new JList<CellListWave>();
		list_single.addMouseListener(cellmouseadapter);
		list_single.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrpan_single = new JScrollPane(list_single);
		scrpan_single.setBounds(9, 295, 252, 180);
		pan_arena_wave.add(scrpan_single);

		pan_conf = new JPanel();
		pan_conf.setBounds(274, 8, 474, 467);
		pan_arena_wave.add(pan_conf);
		pan_conf.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pan_conf.setLayout(null);

		lib_name = new JLabel("Name :");
		lib_name.setForeground(new Color(81, 133, 190));
		lib_name.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_name.setBounds(10, 11, 58, 20);
		pan_conf.add(lib_name);

		sai_name = new JTextField();
		sai_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				String category = wave.getCategory().name();
				JList<CellListWave> list_sel = category.equals("recurrent") ? list_recurrent : list_single;
				int index_sel = list_sel.getSelectedIndex();
				Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());

				ArrayList<Wave> waveList = lArene.getWavesType(ECatW.valueOf(category));

				String wavename = sai_name.getText().equals("") ? "New_Wave" : sai_name.getText();

				wave.setNom(wavename);
				loadListCaracs_ArenaConfig(waveList, list_sel);
				list_sel.setSelectedIndex(index_sel);

			}
		});
		sai_name.setForeground(new Color(81, 133, 190));
		sai_name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sai_name.setBounds(104, 11, 105, 20);
		sai_name.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_conf.add(sai_name);
		sai_name.setColumns(10);

		lib_category = new JLabel("Category :");
		lib_category.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_category.setBounds(10, 42, 69, 20);
		pan_conf.add(lib_category);

		combo_category = new JComboBox<String>();
		combo_category.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				if(e.getStateChange() == ItemEvent.DESELECTED && combo_category.isFocusOwner()) {

					String scategory = wave.getCategory().name();

					JList<CellListWave> list_sel = scategory.equals("recurrent") ? list_recurrent : list_single;
					JList<CellListWave> otherList_sel = list_sel==list_recurrent ? list_single : list_recurrent;
					Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());

					ECatW category = ECatW.valueOf(scategory);
					ECatW othercat = category==ECatW.recurrent ? ECatW.single : ECatW.recurrent;

					ArrayList<Wave> waveList = lArene.getWavesType(category);
					ArrayList<Wave> otherWaveList = lArene.getWavesType(othercat);

					waveList.remove(wave);
					wave.setCategory(othercat);
					otherWaveList.add(wave);
					Collections.sort(otherWaveList);

					loadListCaracs_ArenaConfig(waveList, list_sel);
					loadListCaracs_ArenaConfig(otherWaveList, otherList_sel);

					list_sel.clearSelection();
					otherList_sel.setSelectedIndex(otherWaveList.indexOf(wave));
					setVisibleComponents_ArenaConfig(wave);
					switch (wave.getType()) {
					case Default: case Special: case Supply:
						loadListCaracs_ArenaConfig(wave.getMonstres(), list_carac_wave);
						break;
					case Boss:
						BossW bwave = (BossW) wave;
						loadListCaracs_ArenaConfig(bwave.getAbilities(), list_carac_wave);
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

		lib_type = new JLabel("Type :");
		lib_type.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_type.setBounds(10, 73, 69, 20);
		pan_conf.add(lib_type);

		combo_type = new JComboBox<String>();
		combo_type.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				Wave nextWave = null;
				if(e.getStateChange() == ItemEvent.DESELECTED && combo_type.isFocusOwner()) {

					ETypeW type = ETypeW.valueOf((String) combo_type.getSelectedItem());
					Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());
					String category = wave.getCategory().name();
					JList<CellListWave> list_sel = category.equals("recurrent") ? list_recurrent : list_single;
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
					loadListCaracs_ArenaConfig(waveList, list_sel);
					list_sel.setSelectedIndex(waveList.indexOf(nextWave));
					setVisibleComponents_ArenaConfig(nextWave);

				}

			}
		});
		combo_type.setModel(new DefaultComboBoxModel<String>(ETypeW.namevalues()));
		combo_type.setBounds(104, 73, 105, 20);
		pan_conf.add(combo_type);

		lib_wave = new JLabel("Wave :");
		lib_wave.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_wave.setBounds(10, 104, 69, 20);
		pan_conf.add(lib_wave);

		sai_wave = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_wave.setBackground(new Color(255, 255, 255));
		sai_wave.addKeyListener(mask_numeric);
		sai_wave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sai_wave.setBounds(104, 104, 105, 20);
		sai_wave.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_conf.add(sai_wave);
		sai_wave.setColumns(10);

		lib_priority = new JLabel("Priority :");
		lib_priority.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_priority.setBounds(10, 135, 69, 20);
		pan_conf.add(lib_priority);

		sai_priority = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_priority.setBackground(new Color(255, 255, 255));
		sai_priority.addKeyListener(mask_numeric);
		sai_priority.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sai_priority.setColumns(10);
		sai_priority.setBounds(104, 135, 105, 20);
		sai_priority.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_conf.add(sai_priority);

		lib_frequency = new JLabel("Frequency :");
		lib_frequency.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_frequency.setBounds(10, 166, 84, 20);
		pan_conf.add(lib_frequency);

		sai_frequency = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_frequency.setBackground(new Color(255, 255, 255));
		sai_frequency.addKeyListener(mask_numeric);
		sai_frequency.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sai_frequency.setColumns(10);
		sai_frequency.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_frequency.setBounds(104, 166, 105, 20);
		pan_conf.add(sai_frequency);

		lib_growth = new JLabel("Growth :");
		lib_growth.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_growth.setBounds(10, 197, 84, 20);
		pan_conf.add(lib_growth);

		combo_growth = new JComboBox<String>();
		combo_growth.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				if(e.getStateChange() == ItemEvent.DESELECTED && combo_growth.isFocusOwner()) {

					EGrowth growth = EGrowth.valueOf(((String) combo_growth.getSelectedItem()).toLowerCase());

					DefaultW defwave = (DefaultW) wave;
					defwave.setGrowth(growth);

				}

			}
		});
		combo_growth.setModel(new DefaultComboBoxModel<String>(EGrowth.namevalues()));
		combo_growth.setBounds(104, 197, 105, 20);
		pan_conf.add(combo_growth);

		lib_carac_wave = new JLabel("Monsters");
		lib_carac_wave.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_carac_wave.setBounds(219, 11, 69, 20);
		pan_conf.add(lib_carac_wave);

		list_carac_wave = new JList<CellListCaracs>();
		list_carac_wave.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				list_carac_wave.clearSelection();
			}
		});
		list_carac_wave.addMouseListener(cellmouseadapter);
		list_carac_wave.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrpan_carac_wave = new JScrollPane(list_carac_wave);
		scrpan_carac_wave.setBounds(219, 42, 245, 389);
		pan_conf.add(scrpan_carac_wave);

		lib_monster = new JLabel("Monster :");
		lib_monster.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_monster.setBounds(10, 228, 84, 20);
		pan_conf.add(lib_monster);

		combo_monster = new JWideComboBox();
		combo_monster.addItemListener(itemListener_monster_amount);
		combo_monster.setModel(new DefaultComboBoxModel<String>(EMonsters.namevalues()));
		combo_monster.setBounds(104, 228, 105, 20);
		pan_conf.add(combo_monster);

		lib_amount = new JLabel("Amount :");
		lib_amount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_amount.setBounds(10, 259, 84, 20);
		pan_conf.add(lib_amount);

		combo_amount = new JComboBox<String>();
		combo_amount.addItemListener(itemListener_monster_amount);
		combo_amount.setModel(new DefaultComboBoxModel<String>(EAmount.namevalues()));
		combo_amount.setSelectedIndex(2);
		combo_amount.setBounds(104, 259, 105, 20);
		pan_conf.add(combo_amount);

		lib_health = new JLabel("Health :");
		lib_health.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_health.setBounds(10, 290, 84, 20);
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

		lib_abi_announce = new JTextArea("Ability Announce :");
		lib_abi_announce.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_abi_announce.setWrapStyleWord(true);
		lib_abi_announce.setLineWrap(true);
		lib_abi_announce.setBackground(new Color(214, 217, 223));
		lib_abi_announce.setBorder(new EmptyBorder(0, 0, 0, 0));
		lib_abi_announce.setEditable(false);
		lib_abi_announce.setBounds(10, 321, 84, 36);
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

		lib_abi_interval = new JTextArea("Ability Interval :");
		lib_abi_interval.setWrapStyleWord(true);
		lib_abi_interval.setLineWrap(true);
		lib_abi_interval.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_abi_interval.setBackground(new Color(214, 217, 223));
		lib_abi_interval.setBorder(new EmptyBorder(0, 0, 0, 0));
		lib_abi_interval.setEditable(false);
		lib_abi_interval.setBounds(10, 363, 84, 36);
		pan_conf.add(lib_abi_interval);

		sai_abi_interval = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_abi_interval.setBackground(new Color(255, 255, 255));
		sai_abi_interval.addKeyListener(mask_numeric);
		sai_abi_interval.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sai_abi_interval.setColumns(10);
		sai_abi_interval.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_abi_interval.setBounds(104, 369, 105, 20);
		pan_conf.add(sai_abi_interval);

		btn_add = new JButton("Add");
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if (combo_carac_wave.getSelectedIndex()!=-1) {

					String name = (String) combo_carac_wave.getSelectedItem();
					if (wave instanceof BossW) {
						BossW bwave = (BossW) wave;
						ArrayList<EAbilities> abilist = bwave.getAbilities();
						if(abilist.contains(EAbilities.getByName(name))){
							JOptionPane.showMessageDialog(null, "You can't add the same ability twice !", "Invalid value", JOptionPane.WARNING_MESSAGE);
						}
						else {
							abilist.add(EAbilities.getByName(name));
							loadListCaracs_ArenaConfig(abilist,list_carac_wave);
							combo_carac_wave.setSelectedIndex(-1);
						}

					} else if (wave instanceof DefaultW	|| wave instanceof SpecialW) {
						if(sai_nb_carac_wave.getValue().equals("")){
							JOptionPane.showMessageDialog(null, "You must set a value for the spawn probability in order to add this monster to the list !","Invalid value",JOptionPane.WARNING_MESSAGE);
						}
						else {
							MonsterList monsterlist = wave.getMonstres();
							int proba = Integer.parseInt((String) sai_nb_carac_wave.getValue());

							if(monsterlist.contain(EMonsters.getByName(name))) {
								JOptionPane.showMessageDialog(null, "You can't add the same monster twice !","Invalid value", JOptionPane.WARNING_MESSAGE);
							}
							else {
								monsterlist.add(new Monstre(EMonsters.getByName(name),proba));
								loadListCaracs_ArenaConfig(monsterlist, list_carac_wave);
								combo_carac_wave.setSelectedIndex(-1);
								sai_nb_carac_wave.setValue(null);
							}
						}
					}

				}
				else {
					JOptionPane.showMessageDialog(null, "You must select a value before adding it to the list !","Invalid value",JOptionPane.WARNING_MESSAGE);
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

		lib_boss_name = new JLabel("Boss name :");
		lib_boss_name.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_boss_name.setBounds(10, 401, 88, 20);
		pan_conf.add(lib_boss_name);

		sai_boss_name = new JTextField();
		sai_boss_name.setBounds(104, 401, 105, 20);
		sai_boss_name.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_conf.add(sai_boss_name);
		sai_boss_name.setColumns(10);

		lib_set = new JLabel("Set");
		lib_set.setFont(new Font("Tahoma", Font.BOLD, 12));
		lib_set.setBounds(10, 433, 84, 28);
		pan_conf.add(lib_set);

		btn_set = new JButton("Set");
		btn_set.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String type = wave.getType().name();

				switch (type) {
				case "Supply":
					SupplyW supw = (SupplyW) wave;
					ItemList drops = new ItemSelector(MenuPrincipal.this,supw.getDrops(), 0, false).getItemList();
					supw.setDrops(drops);
					break;
				case "Boss":
					BossW bwave = (BossW) wave;
					ItemList reward = new ItemSelector(MenuPrincipal.this,bwave.getReward(), 1, false).getItemList();
					bwave.setReward(reward);
					break;
				case "Upgrade":
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

		JMenu mnPlanned = new JMenu("Planned");
		menuBar.add(mnPlanned);

		JMenuItem mntmTodoList = new JMenuItem("ToDo List");
		mntmTodoList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				blocage(e.getActionCommand());
			}
		});
		mnPlanned.add(mntmTodoList);

		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		mntmHowToUse = new JMenuItem("How to use");
		mntmHowToUse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				blocage(e.getActionCommand());
			}
		});
		mnHelp.add(mntmHowToUse);

		mnHelp.addSeparator();

		mntmAbout = new JMenuItem("About...");
		mntmAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				blocage(e.getActionCommand());
			}
		});
		mnHelp.add(mntmAbout);

		//TODO Gestion des classes (permissions à ajouter)
		pan_classes = new JPanel();
		pan_classes.setLayout(null);

		lib_classes = new JLabel("Classes");
		lib_classes.setBounds(7, 7, 64, 22);
		lib_classes.setFont(new Font("Tahoma", Font.BOLD, 14));
		pan_classes.add(lib_classes);

		list_classes = new JList<CellListClass>();
		list_classes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				if(list_classes.getSelectedIndex()!=-1) {
					classe = list_classes.getSelectedValue().getClasse();
					loadClass_ClassConfig(classe);
				}
				else list_classes.clearSelection();

			}
		});

		btn_new_class = new JButton("New class");
		btn_new_class.setBounds(193, 8, 90, 22);
		pan_classes.add(btn_new_class);

		scrpan_classes = new JScrollPane(list_classes);
		scrpan_classes.setBounds(7, 33, 276, 220);
		pan_classes.add(scrpan_classes);

		pan_caracs_class = new JPanel();
		pan_caracs_class.setBounds(295, 7, 276, 246);
		pan_caracs_class.setVisible(false);
		pan_caracs_class.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pan_classes.add(pan_caracs_class);
		pan_caracs_class.setLayout(null);

		lib_class = new JLabel("Class name");
		lib_class.setBounds(8, 6, 110, 25);
		pan_caracs_class.add(lib_class);
		lib_class.setFont(new Font("Tahoma", Font.BOLD, 13));

		sai_class = new JFormattedTextField(new MaskFormatter("U??????????????"));
		sai_class.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				String new_name = sai_class.getText().trim();
				if(new_name.equals("")) {
					classe.setName("New_class");
				}
				else classe.setName(sai_class.getText().trim());

				loadData_ClassConfig(arenas.getALclasses());

			}
		});
		sai_class.setFocusLostBehavior(JFormattedTextField.COMMIT);
		sai_class.setBackground(new Color(255, 255, 255));
		sai_class.setBounds(130, 7, 137, 28);
		sai_class.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_caracs_class.add(sai_class);
		sai_class.setColumns(10);

		lib_items = new JLabel("Items");
		lib_items.setBounds(8, 46, 110, 25);
		lib_items.setFont(new Font("Tahoma", Font.BOLD, 13));
		pan_caracs_class.add(lib_items);

		btn_items = new JButton("Set Items");
		btn_items.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				classe.setItems(new ItemSelector(MenuPrincipal.this, classe.getItems(), 0, false, true).getItemList());
			}
		});
		btn_items.setBounds(130, 47, 137, 28);
		pan_caracs_class.add(btn_items);

		lib_armor = new JLabel("Armor");
		lib_armor.setBounds(8, 86, 110, 25);
		lib_armor.setFont(new Font("Tahoma", Font.BOLD, 13));
		pan_caracs_class.add(lib_armor);

		btn_armor = new JButton("Set Armor");
		btn_armor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				classe.setArmor((ArmorList) new ItemSelector(MenuPrincipal.this, classe.getArmor(), 4, true).getItemList());
			}
		});
		btn_armor.setBounds(130, 87, 137, 28);
		pan_caracs_class.add(btn_armor);

		lib_dogs = new JLabel("Dogs");
		lib_dogs.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_dogs.setBounds(8, 126, 110, 25);
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
		sai_dogs.setBounds(130, 127, 137, 28);
		pan_caracs_class.add(sai_dogs);

		lib_horse = new JLabel("Horse");
		lib_horse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_horse.setBounds(8, 166, 110, 28);
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
		combo_horse.setBounds(130, 167, 137, 26);
		pan_caracs_class.add(combo_horse);

		lib_hArmor = new JLabel("with armor");
		lib_hArmor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_hArmor.setBounds(8, 206, 110, 28);
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
		combo_hArmor.setBounds(130, 208, 137, 26);
		pan_caracs_class.add(combo_hArmor);

		pan_arena_settings = new JPanel();
		pan_arena_settings.setBorder(new LineBorder(new Color(0, 0, 0)));
		pan_arena_settings.setBounds(6, 6, 567, 341);
		pan_arena_settings.setLayout(null);

		lib_world = new JLabel("World");
		lib_world.setToolTipText("The name of the world the arena resides in.");
		lib_world.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_world.setBounds(6, 6, 73, 25);
		pan_arena_settings.add(lib_world);

		sai_world = new JFormattedTextField(new MaskFormatter("????????????????????????????????????????"));
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
		sai_world.setToolTipText("The name of the world the arena resides in.");
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

		chk_enabled = new JCheckBox("Enabled");
		chk_enabled.addItemListener(chkconfig_listener);
		chk_enabled.setToolTipText("If false, players cannot join the arena.");
		chk_enabled.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_enabled.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_enabled.setBounds(6, 43, 84, 25);
		pan_arena_settings.add(chk_enabled);

		chk_protect = new JCheckBox("Protect");
		chk_protect.addItemListener(chkconfig_listener);
		chk_protect.setToolTipText("If false, the arena will not be protected from explosions and players breaking the blocks.");
		chk_protect.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_protect.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_protect.setBounds(91, 43, 73, 25);
		pan_arena_settings.add(chk_protect);

		KeyAdapter int_config_adapter = new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e) {
				JFormattedTextField source = (JFormattedTextField) e.getSource();
				try {
					source.commitEdit();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				int value = (int)((long)source.getValue());
				
				if(source==sai_entry) config.setEntry_fee_money(value);
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
		
		lib_entry = new JLabel("Entry fee");
		lib_entry.setToolTipText("<html>Follows the exact same notation as the class items and rewards. 20 will subtract<br> 20 of whatever currency you use from the players upon joining. $5, stick:2 will <br>require the player to have 5 currency units and 2 sticks to join the arena. The <br>entry-fee will be refunded if the player leaves before the arena starts.");
		lib_entry.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_entry.setBounds(6, 80, 73, 25);
		pan_arena_settings.add(lib_entry);

		sai_entry = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_entry.addKeyListener(int_config_adapter);
		sai_entry.setToolTipText(lib_entry.getToolTipText());
		sai_entry.setBackground(new Color(255, 255, 255));
		sai_entry.setBounds(91, 81, 50, 25);
		sai_entry.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_arena_settings.add(sai_entry);
		sai_entry.setColumns(10);

		btn_entry = new JButton("Set item");
		btn_entry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ItemList il = new ItemList();
				Item it_fee = config.getEntry_fee_item();
				if (it_fee!=null) {
					il.add(config.getEntry_fee_item());
				}
				il = new ItemSelector(MenuPrincipal.this, il, 1, false).getItemList();
				if(il.size()!=0) config.setEntry_fee_item(il.get(0));
			}
		});
		btn_entry.setToolTipText(lib_entry.getToolTipText());
		btn_entry.setBounds(153, 81, 90, 25);
		pan_arena_settings.add(btn_entry);

		chk_clear_wave_next = new JCheckBox("Clear wave before next");
		chk_clear_wave_next.addItemListener(chkconfig_listener);
		chk_clear_wave_next.setToolTipText("<html>If true, no monsters will spawn before all monsters of the previous wave<br> have been killed.");
		chk_clear_wave_next.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_clear_wave_next.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_clear_wave_next.setBounds(6, 117, 182, 25);
		pan_arena_settings.add(chk_clear_wave_next);

		chk_clear_boss_next = new JCheckBox("Clear boss before next");
		chk_clear_boss_next.addItemListener(chkconfig_listener);
		chk_clear_boss_next.setToolTipText("If true, no new waves will spawn before the current boss (if any) is dead.");
		chk_clear_boss_next.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_clear_boss_next.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_clear_boss_next.setBounds(6, 154, 177, 25);
		pan_arena_settings.add(chk_clear_boss_next);

		chk_clear_wave_boss = new JCheckBox("Clear wave before boss");
		chk_clear_wave_boss.addItemListener(chkconfig_listener);
		chk_clear_wave_boss.setToolTipText("If true, a boss wave will not spawn until all previous monsters have been killed.");
		chk_clear_wave_boss.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_clear_wave_boss.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_clear_wave_boss.setBounds(6, 191, 182, 25);
		pan_arena_settings.add(chk_clear_wave_boss);

		chk_lightning = new JCheckBox("Lightning");
		chk_lightning.addItemListener(chkconfig_listener);
		chk_lightning.setToolTipText("If true, every spawnpoint will be struck by lightning (no damage) on special waves.");
		chk_lightning.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_lightning.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_lightning.setBounds(176, 43, 90, 25);
		pan_arena_settings.add(chk_lightning);

		chk_auto_equip = new JCheckBox("Auto equip armor");
		chk_auto_equip.addItemListener(chkconfig_listener);
		chk_auto_equip.setToolTipText("<html>If true, armor pieces will automatically be equipped upon class selection. <br>Note that this does not work if a class has more than 1 of an armor piece type.");
		chk_auto_equip.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_auto_equip.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_auto_equip.setBounds(6, 228, 144, 25);
		pan_arena_settings.add(chk_auto_equip);

		chk_soft_restore = new JCheckBox("Soft restore");
		chk_soft_restore.addItemListener(chkconfig_listener);
		chk_soft_restore.setToolTipText("<html>If true, all destroyed blocks will be saved in a \"repair list\", which will be used to restore <br>blocks at arena end. No data is saved to the harddrive. Note that this setting, if true, <br>ignores the protect flag.");
		chk_soft_restore.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_soft_restore.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_soft_restore.setBounds(161, 228, 105, 25);
		pan_arena_settings.add(chk_soft_restore);

		chk_soft_restore_drops = new JCheckBox("Soft restore drops");
		chk_soft_restore_drops.addItemListener(chkconfig_listener);
		chk_soft_restore_drops.setToolTipText("<html>If true, blocks destroyed by players will drop as items like they normally do (using<br> pickaxes, spades, etc.). Note that this makes it very easy for classes with pickaxes<br> to \"mine the arena\" and build forts.");
		chk_soft_restore_drops.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_soft_restore_drops.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_soft_restore_drops.setBounds(6, 265, 149, 25);
		pan_arena_settings.add(chk_soft_restore_drops);

		chk_require_inv_join = new JCheckBox("Require empty inventory to join");
		chk_require_inv_join.addItemListener(chkconfig_listener);
		chk_require_inv_join.setToolTipText("If false, players' inventories will be saved upon joining, and restored upon death/leaving.");
		chk_require_inv_join.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_require_inv_join.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_require_inv_join.setBounds(6, 300, 242, 28);
		pan_arena_settings.add(chk_require_inv_join);

		chk_require_inv_spec = new JCheckBox("Require empty inventory to spectate");
		chk_require_inv_spec.addItemListener(chkconfig_listener);
		chk_require_inv_spec.setToolTipText("If false, players can spectate the arena without having to empty their inventories.");
		chk_require_inv_spec.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_require_inv_spec.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_require_inv_spec.setBounds(6, 336, 275, 28);
		pan_arena_settings.add(chk_require_inv_spec);

		chk_hellhounds = new JCheckBox("Hellhounds");
		chk_hellhounds.addItemListener(chkconfig_listener);
		chk_hellhounds.setToolTipText("<html>If true, all pet wolves in the arena will be in flames! This has no actual function, and is purely for the cool-factor. <br>Also useful for distinguishing enemy wolves and pet wolves.");
		chk_hellhounds.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_hellhounds.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_hellhounds.setBounds(6, 376, 99, 25);
		pan_arena_settings.add(chk_hellhounds);

		chk_pvp = new JCheckBox("PVP enabled");
		chk_pvp.addItemListener(chkconfig_listener);
		chk_pvp.setToolTipText("If true, players can damage each other in the arena.");
		chk_pvp.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_pvp.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_pvp.setBounds(117, 376, 108, 25);
		pan_arena_settings.add(chk_pvp);

		chk_monster_infight = new JCheckBox("Monster infight");
		chk_monster_infight.addItemListener(chkconfig_listener);
		chk_monster_infight.setToolTipText("If false, monsters will no longer damage each other.");
		chk_monster_infight.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_monster_infight.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_monster_infight.setBounds(6, 413, 127, 25);
		pan_arena_settings.add(chk_monster_infight);

		chk_allow_tp = new JCheckBox("Allow teleporting");
		chk_allow_tp.addItemListener(chkconfig_listener);
		chk_allow_tp.setToolTipText("<html>If false, all warping to and from the arena region is blocked. <br>Useful for preventing players from summoning other players into the arena for help.");
		chk_allow_tp.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_allow_tp.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_allow_tp.setBounds(145, 413, 139, 25);
		pan_arena_settings.add(chk_allow_tp);

		chk_spectate_death = new JCheckBox("Spectate on death");
		chk_spectate_death.addItemListener(chkconfig_listener);
		chk_spectate_death.setToolTipText("<html>If false, players will not get warped to the spectator area, but instead be \"kicked\" <br>from the arena (essentially a forced /ma leave).");
		chk_spectate_death.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_spectate_death.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_spectate_death.setBounds(6, 450, 149, 25);
		pan_arena_settings.add(chk_spectate_death);

		chk_auto_respawn = new JCheckBox("Auto respawn");
		chk_auto_respawn.addItemListener(chkconfig_listener);
		chk_auto_respawn.setToolTipText("<html>If false, players will be greeted with the typical death screen upon dying in the <br>arena, and will have to click the respawn button to respawn. With this setting at false, <br>players will actually die in the arena, meaning plugins like Heroes and mcMMO will <br>properly trigger their resetting of internal data upon respawn.");
		chk_auto_respawn.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_auto_respawn.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_auto_respawn.setBounds(307, 6, 119, 25);
		pan_arena_settings.add(chk_auto_respawn);

		chk_share = new JCheckBox("Share items");
		chk_share.addItemListener(chkconfig_listener);
		chk_share.setToolTipText("If false, players will not be able to drop items in the arena.");
		chk_share.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_share.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_share.setBounds(307, 43, 105, 25);
		pan_arena_settings.add(chk_share);

		lib_min_players = new JLabel("Min players");
		lib_min_players.setToolTipText("<html>Gives a lower limit on how many players are required to start the arena. The default <br>of 0 is the same as 1, which means 1 or more players may start the arena.");
		lib_min_players.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_min_players.setBounds(307, 80, 84, 25);
		pan_arena_settings.add(lib_min_players);

		sai_min_players = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_min_players.addKeyListener(int_config_adapter);
		sai_min_players.setToolTipText(lib_min_players.getToolTipText());
		sai_min_players.setBackground(new Color(255, 255, 255));
		sai_min_players.setColumns(10);
		sai_min_players.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_min_players.setBounds(438, 81, 50, 25);
		pan_arena_settings.add(sai_min_players);

		lib_max_players = new JLabel("Max players");
		lib_max_players.setToolTipText("Gives an upper limit on how many players may join the arena. The default of 0 means no limit.");
		lib_max_players.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_max_players.setBounds(307, 117, 84, 25);
		pan_arena_settings.add(lib_max_players);

		sai_max_players = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_max_players.addKeyListener(int_config_adapter);
		sai_max_players.setToolTipText(lib_max_players.getToolTipText());
		sai_max_players.setBackground(new Color(255, 255, 255));
		sai_max_players.setColumns(10);
		sai_max_players.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_max_players.setBounds(438, 118, 50, 25);
		pan_arena_settings.add(sai_max_players);

		lib_max_join_distance = new JLabel("Max join distance");
		lib_max_join_distance.setToolTipText("<html>The maximum distance (in blocks) from which players can join or spectate the <br>arena. If 0 (default), there is no limit. Note that the distance is calculated from every <br>corner of the arena region, and that players not in the arena world won't be able to <br>join or spectate.");
		lib_max_join_distance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_max_join_distance.setBounds(307, 154, 119, 25);
		pan_arena_settings.add(lib_max_join_distance);

		sai_max_join_distance = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_max_join_distance.addKeyListener(int_config_adapter);
		sai_max_join_distance.setToolTipText(lib_max_join_distance.getToolTipText());
		sai_max_join_distance.setBackground(new Color(255, 255, 255));
		sai_max_join_distance.setColumns(10);
		sai_max_join_distance.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_max_join_distance.setBounds(438, 155, 50, 25);
		pan_arena_settings.add(sai_max_join_distance);

		lib_first_delay = new JLabel("First wave delay");
		lib_first_delay.setToolTipText("The time (in seconds) before the first wave of monsters upon arena start.");
		lib_first_delay.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_first_delay.setBounds(307, 191, 119, 25);
		pan_arena_settings.add(lib_first_delay);

		sai_first_delay = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_first_delay.addKeyListener(int_config_adapter);
		sai_first_delay.setToolTipText(lib_first_delay.getToolTipText());
		sai_first_delay.setBackground(new Color(255, 255, 255));
		sai_first_delay.setColumns(10);
		sai_first_delay.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_first_delay.setBounds(438, 192, 50, 25);
		pan_arena_settings.add(sai_first_delay);

		lib_interval = new JLabel("Wave interval");
		lib_interval.setToolTipText("The time (in seconds) between each new wave of monsters. If clear-wave-before-next: true, this setting will be ignored.");
		lib_interval.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_interval.setBounds(307, 227, 119, 25);
		pan_arena_settings.add(lib_interval);

		sai_interval = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_interval.addKeyListener(int_config_adapter);
		sai_interval.setToolTipText(lib_interval.getToolTipText());
		sai_interval.setBackground(new Color(255, 255, 255));
		sai_interval.setColumns(10);
		sai_interval.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_interval.setBounds(438, 228, 50, 25);
		pan_arena_settings.add(sai_interval);

		lib_final_wave = new JLabel("Final wave");
		lib_final_wave.setToolTipText("<html>The number of the final wave before the arena is force ended. This is useful if you <br>want to set a cap on how many waves an arena will have.");
		lib_final_wave.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_final_wave.setBounds(307, 264, 119, 25);
		pan_arena_settings.add(lib_final_wave);

		sai_final_wave = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_final_wave.addKeyListener(int_config_adapter);
		sai_final_wave.setToolTipText(lib_final_wave.getToolTipText());
		sai_final_wave.setBackground(new Color(255, 255, 255));
		sai_final_wave.setColumns(10);
		sai_final_wave.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_final_wave.setBounds(438, 266, 50, 25);
		pan_arena_settings.add(sai_final_wave);

		lib_monster_limit = new JLabel("Monster limit");
		lib_monster_limit.setToolTipText("<html>The maximum amount of monsters MobArena is allowed to spawn for this arena. <br>The next wave, if any, will not spawn until there is room for more monsters.");
		lib_monster_limit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_monster_limit.setBounds(307, 302, 119, 25);
		pan_arena_settings.add(lib_monster_limit);

		sai_monster_limit = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_monster_limit.addKeyListener(int_config_adapter);
		sai_monster_limit.setToolTipText(lib_monster_limit.getToolTipText());
		sai_monster_limit.setBackground(new Color(255, 255, 255));
		sai_monster_limit.setColumns(10);
		sai_monster_limit.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_monster_limit.setBounds(438, 303, 50, 25);
		pan_arena_settings.add(sai_monster_limit);

		chk_monster_xp = new JCheckBox("Monsters drop XP");
		chk_monster_xp.addItemListener(chkconfig_listener);
		chk_monster_xp.setToolTipText("<html>If true, monsters will drop experience orbs. This is useful if you wish to give players <br>the ability to spend the gathered experience on enchants or something else (using <br>different plugins) during the session.");
		chk_monster_xp.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_monster_xp.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_monster_xp.setBounds(307, 339, 149, 25);
		pan_arena_settings.add(chk_monster_xp);

		chk_keep_xp = new JCheckBox("Keep XP");
		chk_keep_xp.addItemListener(chkconfig_listener);
		chk_keep_xp.setToolTipText("<html>If true, players will keep the experience they gather in the arenas after death. This is <br>useful if you want to allow players to level up or gather experience in the arenas. <br>NOTE: If using display-waves-as-level or display-timer-as-level, set keep-exp to false.");
		chk_keep_xp.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_keep_xp.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_keep_xp.setBounds(307, 376, 80, 25);
		pan_arena_settings.add(chk_keep_xp);

		chk_food_regen = new JCheckBox("Food regeneration");
		chk_food_regen.addItemListener(chkconfig_listener);
		chk_food_regen.setToolTipText("<html>If true, a full food bar will cause players to regenerate health while in the arena. <br>Note that this potentially makes tank-like classes extremely overpowered, since <br>diamond armor (by default) coupled with a full food bar will make a player very hard <br>to kill.");
		chk_food_regen.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_food_regen.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_food_regen.setBounds(307, 413, 150, 25);
		pan_arena_settings.add(chk_food_regen);

		chk_lock_food = new JCheckBox("Lock food level");
		chk_lock_food.addItemListener(chkconfig_listener);
		chk_lock_food.setToolTipText("<html>If true, the food bar will be locked for all players in the arena, meaning they will not <br>end up starving, and they will be able to sprint around as they please.");
		chk_lock_food.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_lock_food.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_lock_food.setBounds(307, 450, 127, 25);
		pan_arena_settings.add(chk_lock_food);

		lib_player_time = new JLabel("Player time of day");
		lib_player_time.setToolTipText("<html>When set to anything but world, this setting will freeze the apparent world time for <br>players in the arena to whatever value you set. This is useful for making time-of-day <br>themed arenas (e.g. constant night time for a cemetery, broad daylight for a pirate <br>ship).");
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
		combo_player_time.setToolTipText(lib_player_time.getToolTipText());
		combo_player_time.setModel(new DefaultComboBoxModel<String>(new String[] {"world", "dawn", "sunrise", "morning", "midday", "noon", "day", "afternoon", "evening", "sunset", "dusk", "night", "midnight"}));
		combo_player_time.setBounds(653, 43, 95, 26);
		pan_arena_settings.add(combo_player_time);

		lib_auto_start = new JLabel("Auto start timer");
		lib_auto_start.setToolTipText("<html>The time (in seconds) before the arena will be force started after the first player has <br>joined the lobby (the default of 0 means deactivated or infinite time). Non-ready <br>players will be removed from the lobby. This setting is useful to prevent ill-minded <br>players from delaying or preventing other players from starting the arena.");
		lib_auto_start.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_auto_start.setBounds(514, 117, 119, 25);
		pan_arena_settings.add(lib_auto_start);

		sai_auto_start = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_auto_start.addKeyListener(int_config_adapter);
		sai_auto_start.setToolTipText(lib_auto_start.getToolTipText());
		sai_auto_start.setBackground(new Color(255, 255, 255));
		sai_auto_start.setColumns(10);
		sai_auto_start.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_auto_start.setBounds(645, 118, 50, 25);
		pan_arena_settings.add(sai_auto_start);

		chk_spout_class = new JCheckBox("Spout class select");
		chk_spout_class.addItemListener(chkconfig_listener);
		chk_spout_class.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_spout_class.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_spout_class.setBounds(514, 6, 149, 25);
		pan_arena_settings.add(chk_spout_class);

		chk_auto_ignite = new JCheckBox("Auto ignite TNT");
		chk_auto_ignite.addItemListener(chkconfig_listener);
		chk_auto_ignite.setToolTipText("<html>If true, TNT will be automatically ignited when placed. This is useful for preventing <br>Oddjob-like classes from forting.");
		chk_auto_ignite.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_auto_ignite.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_auto_ignite.setBounds(514, 80, 149, 25);
		pan_arena_settings.add(chk_auto_ignite);

		chk_use_class_chest = new JCheckBox("Use class chests");
		chk_use_class_chest.addItemListener(chkconfig_listener);
		chk_use_class_chest.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_use_class_chest.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_use_class_chest.setBounds(514, 154, 131, 25);
		pan_arena_settings.add(chk_use_class_chest);

		chk_display_waves = new JCheckBox("Display waves as level");
		chk_display_waves.addItemListener(chkconfig_listener);
		chk_display_waves.setToolTipText("<html>When set to true, the players' level counter (above the experience bar) will be used <br>to display the current wave number. If the wave announcements in the <br>announcements-file are silenced, this can be used to make a much less \"spammy\" <br>MobArena experience. NOTE: Do not use this if keep-exp is set to true!");
		chk_display_waves.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_display_waves.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_display_waves.setBounds(514, 192, 170, 25);
		pan_arena_settings.add(chk_display_waves);

		chk_display_timer = new JCheckBox("Display timer as level");
		chk_display_timer.addItemListener(chkconfig_listener);
		chk_display_timer.setToolTipText("<html>When set to true, the players' level counter (above the experience bar) will be used <br>to display the auto-start timer in the lobby. NOTE: Do not use this if keep-exp is set to <br>true!");
		chk_display_timer.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_display_timer.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_display_timer.setBounds(514, 229, 170, 25);
		pan_arena_settings.add(chk_display_timer);

		chk_auto_ready = new JCheckBox("Auto ready");
		chk_auto_ready.addItemListener(chkconfig_listener);
		chk_auto_ready.setToolTipText("<html>When set to true, players are automatically flagged as ready when they pick a class. <br>Useful for arenas with many players where hitting an iron block becomes difficult.");
		chk_auto_ready.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_auto_ready.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_auto_ready.setBounds(514, 266, 99, 25);
		pan_arena_settings.add(chk_auto_ready);

		chk_scoreboard = new JCheckBox("Use scoreboards");
		chk_scoreboard.addItemListener(chkconfig_listener);
		chk_scoreboard.setToolTipText("Whether to use scoreboards in MobArena or not.");
		chk_scoreboard.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_scoreboard.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_scoreboard.setBounds(514, 306, 139, 25);
		pan_arena_settings.add(chk_scoreboard);

		chk_isolated_chat = new JCheckBox("Isolated chat");
		chk_isolated_chat.addItemListener(chkconfig_listener);
		chk_isolated_chat.setToolTipText("<html>When set to true, all chat messages sent by arena players will be seen only by other <br>arena players in the same arena. The arena players will still be able to see chat <br>messages from other players on the server who aren't in an arena.");
		chk_isolated_chat.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_isolated_chat.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_isolated_chat.setBounds(514, 342, 119, 25);
		pan_arena_settings.add(chk_isolated_chat);

		chk_global_join = new JCheckBox("Global join announce");
		chk_global_join.addItemListener(chkconfig_listener);
		chk_global_join.setToolTipText("<html>When set to true, MobArena will announce the arena-join-global message to all <br>players on the server when the first player joins an arena.");
		chk_global_join.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_global_join.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_global_join.setBounds(514, 376, 170, 25);
		pan_arena_settings.add(chk_global_join);

		chk_global_end = new JCheckBox("Global end announce");
		chk_global_end.addItemListener(chkconfig_listener);
		chk_global_end.setToolTipText("<html>When set to true, MobArena will announce the arena-end-global message  to all <br>players on the server when an arena ends.");
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

		setInvisibleComponents_ArenaConfig();

		setSize(760,618);

		tabpan_config.addTab("Arenas and waves configuration", pan_arena_wave);
		tabpan_config.addTab("Classes configuration", pan_classes);
		tabpan_config.addTab("Arena configuration", pan_arena_settings);

		tabpan_config.setEnabledAt(1, false);
		tabpan_config.setEnabledAt(2, false);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void blocage(String launching){
		setEnabled(false);
		switch (launching) {
		case "About...":
			new About(this);
			break;
		case "How to use":
			new HowTo(this);
			break;
		case "ToDo List":
			new Todo(this);
			break;
		default:
			break;
		}
	}

	private void loadArena(int numarena) {

		setInvisibleComponents_ArenaConfig();
		Arena arena = arenas.getALarenas().get(numarena);
		config = arena.getConfig();

		ArrayList<Wave> recW = arena.getWavesType(ECatW.recurrent);
		loadListCaracs_ArenaConfig(recW, list_recurrent);

		ArrayList<Wave> singW = arena.getWavesType(ECatW.single);
		loadListCaracs_ArenaConfig(singW, list_single);

		loadConfig_ArenaConfig(config);

	}

	private void setVisibleComponents_ArenaConfig(Wave wave) {
		ETypeW typevague = wave.getType();
		ECatW catvague = wave.getCategory();

		setInvisibleComponents_ArenaConfig();
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
			lib_abi_announce.setText("Fixed :");
			lib_carac_wave.setText("Monsters");
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

			lib_set.setText("Reward :");
			lib_set.setVisible(true);
			btn_set.setVisible(true);

			lib_carac_wave.setText("Abilities");
			combo_carac_wave.setModel(new DefaultComboBoxModel<String>(EAbilities.namevalues()));
			combo_carac_wave.setSelectedIndex(-1);
			sai_nb_carac_wave.setVisible(false);
			break;
		case Special:
			lib_carac_wave.setText("Monsters");
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
			lib_carac_wave.setText("Monsters");
			combo_carac_wave.setModel(new DefaultComboBoxModel<String>(EMonsters.namevalues()));
			combo_carac_wave.setSelectedIndex(-1);

			lib_set.setVisible(true);
			lib_set.setText("Drops :");
			btn_set.setVisible(true);
			break;
		case Upgrade:
			lib_abi_announce.setVisible(true);
			lib_abi_announce.setText("Give all  items :");
			chk_abi_announce.setVisible(true);
			lib_set.setVisible(true);
			lib_set.setText("Configure :");
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

	private void setInvisibleComponents_ArenaConfig() {
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

		lib_abi_announce.setText("Ability Announce :");
		list_carac_wave.setModel(new DefaultListModel<CellListCaracs>());
		lib_set.setText("Set");
		btn_set.setText("Set");
	}

	private void deselectWaveLists_ArenaConfig(JList<CellListWave> jList){
		if(jList==list_recurrent){
			list_single.clearSelection();
		}
		else if(jList==list_single){
			list_recurrent.clearSelection();
		}
	}

	private void loadData_ArenaConfig(Wave wave) {
		sai_name.setText(wave.getNom());
		combo_category.setSelectedItem(wave.getCategory().getNom());
		combo_type.setSelectedItem(wave.getType().name());
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
			loadListCaracs_ArenaConfig(defwave.getMonstres(), list_carac_wave);
			break;
		case Boss:
			BossW bwave = (BossW) wave;
			sai_boss_name.setText(bwave.getBossName());
			combo_health.setSelectedItem(bwave.getHealth().getNom());
			chk_abi_announce.setSelected(bwave.isAbility_announce());
			sai_abi_interval.setValue(bwave.getAbility_interval());
			combo_monster.setSelectedItem(bwave.getMonstres().get(0).getMonstre().getNom());
			loadListCaracs_ArenaConfig(bwave.getAbilities(), list_carac_wave);
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
			loadListCaracs_ArenaConfig(spwave.getMonstres(), list_carac_wave);
			break;
		case Supply:
			SupplyW supw = (SupplyW) wave;
			loadListCaracs_ArenaConfig(supw.getMonstres(), list_carac_wave);
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
	private void loadListCaracs_ArenaConfig(ArrayList listdata, JList listview) {

		DefaultListModel modW = new DefaultListModel<>();

		if(listview == list_recurrent || listview == list_single) {
			modW = new DefaultListModel<CellListWave>();

			for(int i=0;i<listdata.size();i++){
				Wave vague = (Wave) listdata.get(i);
				if (!(vague instanceof OtherW)) {
					modW.addElement(new CellListWave(vague));
				}
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
		HoverListCellRenderer renderer = new HoverListCellRenderer(listview);
		listview.setCellRenderer(renderer);
		listview.addMouseListener(renderer.getHandler());
		listview.addMouseMotionListener(renderer.getHandler());

	}

	/**
	 * Met à jour les données numériques d'une vague avec le champ source passé en paramètre
	 * @param e l'évènement source
	 */
	private void majData_ArenaConfig(KeyEvent e) {

		JFormattedTextField source = (JFormattedTextField) e.getSource();
		JList<CellListWave> list_sel = list_recurrent.getSelectedIndex()!=-1 ? list_recurrent : list_single;
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
				int otherw = 0;
				while (i < waveList.size() && waveList.get(i) != wave) {
					if (waveList.get(i) instanceof OtherW) {
						otherw++;
					}
					i++;
				}
				loadListCaracs_ArenaConfig(waveList, list_sel);
				int index_sel = i - otherw;
				list_sel.setSelectedIndex(index_sel);

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
			int otherw = 0;
			while (i < waveList.size() && waveList.get(i) != wave) {
				if (waveList.get(i) instanceof OtherW) {
					otherw++;
				}
				i++;
			}
			loadListCaracs_ArenaConfig(waveList, list_sel);
			int index_sel = i - otherw;
			list_sel.setSelectedIndex(index_sel);

		}
		else if(source==sai_abi_interval){
			BossW bwave = (BossW) wave;
			int abi_interval = (int) (val_src.equals("") ? 3 : val_src);
			bwave.setAbility_interval(abi_interval);

		}

	}

	private void loadData_ClassConfig(ArrayList<Classe> aLclasses) {
		DefaultListModel<CellListClass> mod_Class = new DefaultListModel<>();
		for(int i=0;i<aLclasses.size();i++) {
			mod_Class.addElement(new CellListClass(aLclasses.get(i)));
		}
		list_classes.setModel(mod_Class);
		HoverListCellRenderer renderer = new HoverListCellRenderer(list_classes);
		list_classes.setCellRenderer(renderer);
		list_classes.addMouseListener(renderer.getHandler());
		list_classes.addMouseMotionListener(renderer.getHandler());

	}

	private void loadClass_ClassConfig(Classe classe) {
		pan_caracs_class.setVisible(true);

		String name = classe.getName();
		if(!name.equals("New_class")) {
			sai_class.setValue(name);
		}
		else sai_class.setValue(null);
		sai_dogs.setValue(classe.getDog_number());
		int hArmor = (int) (classe.getHorse()/8f);
		int horse = 5-((hArmor*8)+5-classe.getHorse());
		horse = horse<0 ? 0 : horse;
		combo_horse.setSelectedIndex(horse);
		combo_hArmor.setSelectedIndex(hArmor);

		sai_class.requestFocus();
		sai_class.selectAll();
	}

	private void loadConfig_ArenaConfig(ArenaConfig config) {
		sai_world.setValue(config.getWorld());
		chk_enabled.setSelected(config.isEnabled());
		chk_protect.setSelected(config.isProtect());
		sai_entry.setValue(config.getEntry_fee_money());
		chk_clear_wave_next.setSelected(config.isClear_wave_next());
		chk_clear_wave_boss.setSelected(config.isClear_wave_boss());
		chk_clear_boss_next.setSelected(config.isClear_boss_next());
		chk_lightning.setSelected(config.isLightning());
		chk_auto_equip.setSelected(config.isAuto_equip_armor());
		chk_soft_restore.setSelected(config.isSoft_restore());
		chk_soft_restore_drops.setSelected(config.isSoft_restore_drops());
		chk_require_inv_join.setSelected(config.isEmpty_inv_join());
		chk_require_inv_spec.setSelected(config.isEmpty_inv_spec());
		chk_hellhounds.setSelected(config.isHellhounds());
		chk_pvp.setSelected(config.isPvp_enabled());
		chk_monster_infight.setSelected(config.isMonster_infight());
		chk_allow_tp.setSelected(config.isAllow_tp());
		chk_spectate_death.setSelected(config.isDeath_spec());
		chk_auto_respawn.setSelected(config.isAuto_respawn());
		chk_share.setSelected(config.isShare_items());
		sai_min_players.setValue(config.getMin_players());
		sai_max_players.setValue(config.getMax_players());
		sai_max_join_distance.setValue(config.getMax_join_distance());
		sai_first_delay.setValue(config.getFirst_wave_delay());
		sai_interval.setValue(config.getWave_interval());
		sai_final_wave.setValue(config.getFinal_wave());
		sai_monster_limit.setValue(config.getMonster_limit());
		chk_monster_xp.setSelected(config.isMonster_drop_xp());
		chk_keep_xp.setSelected(config.isKeep_xp());
		chk_food_regen.setSelected(config.isFood_regen());
		chk_lock_food.setSelected(config.isFood_level_lock());
		combo_player_time.setSelectedItem(config.getPlayer_time());
		sai_auto_start.setValue(config.getAuto_start());
		chk_spout_class.setSelected(config.isSpout_select());
		chk_auto_ignite.setSelected(config.isAuto_ignite_tnt());
		chk_use_class_chest.setSelected(config.isClass_chest());
		chk_display_waves.setSelected(config.isWaves_as_level());
		chk_display_timer.setSelected(config.isTimer_as_level());
		chk_auto_ready.setSelected(config.isAuto_ready());
		chk_scoreboard.setSelected(config.isScoreboards());
		chk_isolated_chat.setSelected(config.isIsolated_chat());
		chk_global_join.setSelected(config.isGlobal_join_announce());
		chk_global_end.setSelected(config.isGlobal_end_announce());
	}

}