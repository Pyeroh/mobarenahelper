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
import model.Arenas;
import model.Classe;
import model.GestYaml;
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
	private JTextField sai_wave;
	private JLabel lib_priority;
	private JTextField sai_priority;
	private JLabel lib_frequency;
	private JTextField sai_frequency;
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
	private JTextField sai_abi_interval;
	private JButton btn_add;
	private JWideComboBox combo_carac_wave;
	private JTextField sai_nb_carac_wave;
	private JLabel lib_set;
	private JButton btn_set;

	private JPanel pan_caracs_class;
	private JLabel lib_dogs;
	private JTextField sai_dogs;
	private JLabel lib_horse;
	private JLabel lib_classes;
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
	private JCheckBox chk_enabled;
	private JCheckBox chk_protect;
	private JLabel lib_entry;
	private JTextField sai_entry;
	private JCheckBox chk_clear_wave_next;
	private JButton btn_entry;
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
	private JTextField sai_min_players;
	private JTextField sai_max_players;
	private JLabel lib_max_players;
	private JLabel lib_max_join_distance;
	private JTextField sai_max_join_distance;
	private JLabel lib_first_delay;
	private JTextField sai_first_delay;
	private JLabel lib_interval;
	private JTextField sai_interval;
	private JLabel lib_final_wave;
	private JTextField sai_final_wave;
	private JLabel lib_monster_limit;
	private JTextField sai_monster_limit;
	private JCheckBox chk_monster_xp;
	private JCheckBox chk_keep_xp;
	private JCheckBox chk_food_regen;
	private JCheckBox chk_lock_food;
	private JLabel lib_player_time;
	private JComboBox<String> combo_player_time;
	private JLabel lib_auto_start;
	private JTextField sai_auto_start;
	private JCheckBox chk_spout_class;
	private JCheckBox chk_auto_ignite;
	private JCheckBox chk_use_class_chest;
	private JCheckBox chk_display_waves;
	private JCheckBox chk_display_timer;
	private JCheckBox chk_auto_ready;
	private JCheckBox chk_scoreboard;
	private JLabel lib_boss_name;
	private JTextField sai_boss_name;

	public MenuPrincipal() throws ParseException{
		super("MobArena Helper v2");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/gui/mobarena.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);

		//TODO Ajouter la gestion (ajout/suppression) des arènes

		MouseAdapter newWave = new MouseAdapter() {
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
			public void keyReleased(KeyEvent e) {
				majData_ArenaConfig(e);
			}
		};

		ItemListener itemListener_monster_amount = new ItemListener() {
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
					} catch (Exception e1) {
						e1.printStackTrace();
						
						Classe.classe_list.clear();
						file = null;
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
		btn_load.setBounds(526, 493, 97, 23);
		getContentPane().add(btn_load);

		btn_save = new JButton("Save Config As");
		btn_save.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if(arenas!=null){

					YmlJFileChooser fchoose = new YmlJFileChooser(file.getPath());
					fchoose.showOpenDialog(null);
					File f = fchoose.getSelectedFile();
					if(!f.getPath().endsWith(".yml")) {
						f = new File(f.getPath()+".yml");
					}
					f.delete();
					try {
						f.createNewFile();
						FileWriter fw = new FileWriter(f);
						GestYaml dumper = new GestYaml(arenas.getMap());
						dumper.dumpAsFile(fw);
						JOptionPane.showMessageDialog(null, "Finished saving","",JOptionPane.INFORMATION_MESSAGE);

					} catch (IOException e1) {
						e1.printStackTrace();
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
		btn_save.setBounds(633, 493, 115, 23);
		getContentPane().add(btn_save);

		tabpan_config = new JTabbedPane(JTabbedPane.TOP);
		tabpan_config.setBounds(0, 6, 754, 484);
		getContentPane().add(tabpan_config);

		pan_arena_wave = new JPanel();
		pan_arena_wave.setBounds(43, 54, 732, 443);
		pan_arena_wave.setLayout(null);

		lib_arena = new JLabel("Arena");
		lib_arena.setBounds(9, 8, 46, 17);
		pan_arena_wave.add(lib_arena);
		lib_arena.setFont(new Font("Tahoma", Font.BOLD, 14));

		combo_arena = new JComboBox<String>();
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
		scrpan_recurrent.setBounds(6, 74, 252, 165);
		pan_arena_wave.add(scrpan_recurrent);

		lib_single = new JLabel("Single Waves");
		lib_single.setBounds(9, 261, 132, 17);
		pan_arena_wave.add(lib_single);
		lib_single.setFont(new Font("Tahoma", Font.BOLD, 14));

		btn_newsingle = new JButton("New Wave");
		btn_newsingle.setBounds(167, 255, 91, 23);
		pan_arena_wave.add(btn_newsingle);
		btn_newsingle.addMouseListener(newWave);
		btn_newsingle.setFont(new Font("Tahoma", Font.BOLD, 11));

		list_single = new JList<CellListWave>();
		list_single.addMouseListener(cellmouseadapter);
		list_single.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrpan_single = new JScrollPane(list_single);
		scrpan_single.setBounds(9, 280, 252, 165);
		pan_arena_wave.add(scrpan_single);

		pan_conf = new JPanel();
		pan_conf.setBounds(267, 8, 474, 437);
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
			public void keyReleased(KeyEvent e) {

				String category = wave.getCategory().name();
				//JList<CellListWave> list_sel = combo_category.getSelectedItem().equals("Recurrent") ? list_recurrent : list_single;
				JList<CellListWave> list_sel = category.equals("recurrent") ? list_recurrent : list_single;
				int index_sel = list_sel.getSelectedIndex();
				Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());
				//String category = ((String) combo_category.getSelectedItem()).toLowerCase();
				
				ArrayList<Wave> waveList = lArene.getWavesType(ECatW.valueOf(category));

				String wavename = sai_name.getText().equals("") ? "New_Wave" : sai_name.getText();

				//list_sel.getSelectedValue().getWave().setNom(wavename);
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
			public void itemStateChanged(ItemEvent e) {

				if(e.getStateChange() == ItemEvent.DESELECTED && combo_category.isFocusOwner()) {

					//String scategory = combo_category.getSelectedItem().equals("Recurrent") ? "single" : "recurrent";
					String scategory = wave.getCategory().name();

					JList<CellListWave> list_sel = scategory.equals("recurrent") ? list_recurrent : list_single;
					JList<CellListWave> otherList_sel = list_sel==list_recurrent ? list_single : list_recurrent;
					//int index_sel = list_sel.getSelectedIndex();
					Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());

					ECatW category = ECatW.valueOf(scategory);
					ECatW othercat = category==ECatW.recurrent ? ECatW.single : ECatW.recurrent;

					ArrayList<Wave> waveList = lArene.getWavesType(category);
					ArrayList<Wave> otherWaveList = lArene.getWavesType(othercat);

					//Wave wave = list_sel.getSelectedValue().getWave();
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

			public void itemStateChanged(ItemEvent e) {

				Wave nextWave = null;
				if(e.getStateChange() == ItemEvent.DESELECTED && combo_type.isFocusOwner()) {

					ETypeW type = ETypeW.valueOf((String) combo_type.getSelectedItem());
					Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());
					String category = wave.getCategory().name();
					JList<CellListWave> list_sel = category.equals("recurrent") ? list_recurrent : list_single;
					//int index_sel = list_sel.getSelectedIndex();
					ArrayList<Wave> waveList = lArene.getWavesType(wave.getCategory());

					//Wave wave = list_sel.getSelectedValue().getWave();
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

		sai_wave = new JFormattedTextField(new MaskFormatter("###"));
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

		sai_priority = new JFormattedTextField(new MaskFormatter("###"));
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

		sai_frequency = new JFormattedTextField(new MaskFormatter("###"));
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
			public void valueChanged(ListSelectionEvent e) {
				list_carac_wave.clearSelection();
			}
		});
		list_carac_wave.addMouseListener(cellmouseadapter);
		list_carac_wave.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrpan_carac_wave = new JScrollPane(list_carac_wave);
		scrpan_carac_wave.setBounds(219, 42, 245, 357);
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
			public void itemStateChanged(ItemEvent e) {

				//la clause isFocusOwner() est spécifiée car la combo Amount change de valeur à l'initialisation
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

		sai_abi_interval = new JFormattedTextField(new MaskFormatter("###"));
		sai_abi_interval.setBackground(new Color(255, 255, 255));
		sai_abi_interval.addKeyListener(mask_numeric);
		sai_abi_interval.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sai_abi_interval.setColumns(10);
		sai_abi_interval.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_abi_interval.setBounds(104, 369, 105, 20);
		pan_conf.add(sai_abi_interval);

		btn_add = new JButton("Add");
		btn_add.addMouseListener(new MouseAdapter() {
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
						if(sai_nb_carac_wave.getText().equals("")){
							JOptionPane.showMessageDialog(null, "You must set a value for the spawn probability in order to add this monster to the list !","Invalid value",JOptionPane.WARNING_MESSAGE);
						}
						else {
							MonsterList monsterlist = wave.getMonstres();
							int proba = Integer.parseInt(sai_nb_carac_wave.getText());

							if(monsterlist.contain(EMonsters.getByName(name))) {
								JOptionPane.showMessageDialog(null, "You can't add the same monster twice !","Invalid value", JOptionPane.WARNING_MESSAGE);
							}
							else {
								monsterlist.add(new Monstre(EMonsters.getByName(name),proba));
								loadListCaracs_ArenaConfig(monsterlist, list_carac_wave);
								combo_carac_wave.setSelectedIndex(-1);
								sai_nb_carac_wave.setText("");
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
		btn_add.setBounds(219, 408, 58, 23);
		pan_conf.add(btn_add);

		combo_carac_wave = new JWideComboBox();
		combo_carac_wave.setFont(new Font("SansSerif", Font.PLAIN, 12));
		combo_carac_wave.setBounds(287, 409, 105, 20);
		pan_conf.add(combo_carac_wave);

		sai_nb_carac_wave = new JFormattedTextField(new MaskFormatter("###"));
		sai_nb_carac_wave.setBackground(new Color(255, 255, 255));
		sai_nb_carac_wave.addKeyListener(mask_numeric);
		sai_nb_carac_wave.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sai_nb_carac_wave.setBounds(402, 409, 62, 22);
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
		lib_set.setHorizontalAlignment(SwingConstants.TRAILING);
		lib_set.setFont(new Font("Tahoma", Font.BOLD, 12));
		lib_set.setBounds(300, 11, 70, 20);
		pan_conf.add(lib_set);

		btn_set = new JButton("Set");
		btn_set.addMouseListener(new MouseAdapter() {
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
					new UpgradeWaveChanger(upw, MenuPrincipal.this);
					//TODO créer une fenêtre de configuration des vagues upgrade
					break;
				default:
					break;
				}
			}
		});
		btn_set.setBounds(374, 7, 90, 28);
		pan_conf.add(btn_set);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnPlanned = new JMenu("Planned");
		menuBar.add(mnPlanned);

		JMenuItem mntmTodoList = new JMenuItem("ToDo List");
		mntmTodoList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blocage(e.getActionCommand());
			}
		});
		mnPlanned.add(mntmTodoList);

		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		mntmHowToUse = new JMenuItem("How to use");
		mntmHowToUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blocage(e.getActionCommand());
			}
		});
		mnHelp.add(mntmHowToUse);

		mnHelp.addSeparator();

		mntmAbout = new JMenuItem("About...");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				blocage(e.getActionCommand());
			}
		});
		mnHelp.add(mntmAbout);

		pan_classes = new JPanel();
		pan_classes.setLayout(null);

		lib_classes = new JLabel("Classes");
		lib_classes.setBounds(7, 7, 64, 22);
		lib_classes.setFont(new Font("Tahoma", Font.BOLD, 14));
		pan_classes.add(lib_classes);

		list_classes = new JList<CellListClass>();

		scrpan_classes = new JScrollPane(list_classes);
		scrpan_classes.setBounds(7, 33, 276, 220);
		pan_classes.add(scrpan_classes);

		pan_caracs_class = new JPanel();
		pan_caracs_class.setBounds(295, 7, 276, 246);
		pan_caracs_class.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pan_classes.add(pan_caracs_class);
		pan_caracs_class.setLayout(null);

		lib_class = new JLabel("Class name");
		lib_class.setBounds(8, 6, 110, 25);
		pan_caracs_class.add(lib_class);
		lib_class.setFont(new Font("Tahoma", Font.BOLD, 13));

		sai_class = new JFormattedTextField(new MaskFormatter("U??????????????"));
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
		btn_items.setBounds(130, 47, 137, 28);
		pan_caracs_class.add(btn_items);

		lib_armor = new JLabel("Armor");
		lib_armor.setBounds(8, 86, 110, 25);
		lib_armor.setFont(new Font("Tahoma", Font.BOLD, 13));
		pan_caracs_class.add(lib_armor);

		btn_armor = new JButton("Set Armor");
		btn_armor.setBounds(130, 87, 137, 28);
		pan_caracs_class.add(btn_armor);

		lib_dogs = new JLabel("Dogs");
		lib_dogs.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_dogs.setBounds(8, 126, 110, 25);
		pan_caracs_class.add(lib_dogs);

		sai_dogs = new JFormattedTextField(new MaskFormatter("###"));
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
		combo_horse.setModel(new DefaultComboBoxModel<String>(new String[] {"None", "Horse", "Donkey", "Mule", "Skeleton", "Undead"}));
		combo_horse.setBounds(130, 167, 137, 26);
		pan_caracs_class.add(combo_horse);

		lib_hArmor = new JLabel("with armor");
		lib_hArmor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_hArmor.setBounds(8, 206, 110, 28);
		pan_caracs_class.add(lib_hArmor);

		combo_hArmor = new JComboBox<String>();
		combo_hArmor.setModel(new DefaultComboBoxModel<String>(new String[] {"None", "Iron", "Gold", "Diamond"}));
		combo_hArmor.setBounds(130, 208, 137, 26);
		pan_caracs_class.add(combo_hArmor);

		pan_arena_settings = new JPanel();
		pan_arena_settings.setBorder(new LineBorder(new Color(0, 0, 0)));
		pan_arena_settings.setBounds(6, 6, 567, 341);
		pan_arena_settings.setLayout(null);

		chk_enabled = new JCheckBox("Enabled");
		chk_enabled.setToolTipText("If false, players cannot join the arena.");
		chk_enabled.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_enabled.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_enabled.setBounds(6, 6, 84, 25);
		pan_arena_settings.add(chk_enabled);

		chk_protect = new JCheckBox("Protect");
		chk_protect.setToolTipText("If false, the arena will not be protected from explosions and players breaking the blocks.");
		chk_protect.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_protect.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_protect.setBounds(91, 6, 73, 25);
		pan_arena_settings.add(chk_protect);

		lib_entry = new JLabel("Entry fee");
		lib_entry.setToolTipText("<html>Follows the exact same notation as the class items and rewards. $20 will subtract<br> 20 of whatever currency you use from the players upon joining. $5, stick:2 will <br>require the player to have 5 currency units and 2 sticks to join the arena. The <br>entry-fee will be refunded if the player leaves before the arena starts.");
		lib_entry.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_entry.setBounds(6, 43, 73, 25);
		pan_arena_settings.add(lib_entry);

		sai_entry = new JFormattedTextField(new MaskFormatter("$###"));
		sai_entry.setToolTipText(lib_entry.getToolTipText());
		sai_entry.setBackground(new Color(255, 255, 255));
		sai_entry.setBounds(91, 44, 50, 25);
		sai_entry.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pan_arena_settings.add(sai_entry);
		sai_entry.setColumns(10);

		btn_entry = new JButton("Set item");
		btn_entry.setToolTipText(lib_entry.getToolTipText());
		btn_entry.setBounds(153, 44, 90, 25);
		pan_arena_settings.add(btn_entry);

		chk_clear_wave_next = new JCheckBox("Clear wave before next");
		chk_clear_wave_next.setToolTipText("<html>If true, no monsters will spawn before all monsters of the previous wave<br> have been killed.");
		chk_clear_wave_next.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_clear_wave_next.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_clear_wave_next.setBounds(6, 80, 182, 25);
		pan_arena_settings.add(chk_clear_wave_next);

		chk_clear_boss_next = new JCheckBox("Clear boss before next");
		chk_clear_boss_next.setToolTipText("If true, no new waves will spawn before the current boss (if any) is dead.");
		chk_clear_boss_next.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_clear_boss_next.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_clear_boss_next.setBounds(6, 117, 177, 25);
		pan_arena_settings.add(chk_clear_boss_next);

		chk_clear_wave_boss = new JCheckBox("Clear wave before boss");
		chk_clear_wave_boss.setToolTipText("If true, a boss wave will not spawn until all previous monsters have been killed.");
		chk_clear_wave_boss.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_clear_wave_boss.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_clear_wave_boss.setBounds(6, 154, 182, 25);
		pan_arena_settings.add(chk_clear_wave_boss);

		chk_lightning = new JCheckBox("Lightning");
		chk_lightning.setToolTipText("If true, every spawnpoint will be struck by lightning (no damage) on special waves.");
		chk_lightning.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_lightning.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_lightning.setBounds(176, 6, 90, 25);
		pan_arena_settings.add(chk_lightning);

		chk_auto_equip = new JCheckBox("Auto equip armor");
		chk_auto_equip.setToolTipText("<html>If true, armor pieces will automatically be equipped upon class selection. <br>Note that this does not work if a class has more than 1 of an armor piece type.");
		chk_auto_equip.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_auto_equip.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_auto_equip.setBounds(6, 191, 144, 25);
		pan_arena_settings.add(chk_auto_equip);

		chk_soft_restore = new JCheckBox("Soft restore");
		chk_soft_restore.setToolTipText("<html>If true, all destroyed blocks will be saved in a \"repair list\", which will be used to restore <br>blocks at arena end. No data is saved to the harddrive. Note that this setting, if true, <br>ignores the protect flag.");
		chk_soft_restore.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_soft_restore.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_soft_restore.setBounds(161, 191, 105, 25);
		pan_arena_settings.add(chk_soft_restore);

		chk_soft_restore_drops = new JCheckBox("Soft restore drops");
		chk_soft_restore_drops.setToolTipText("<html>If true, blocks destroyed by players will drop as items like they normally do (using<br> pickaxes, spades, etc.). Note that this makes it very easy for classes with pickaxes<br> to \"mine the arena\" and build forts.");
		chk_soft_restore_drops.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_soft_restore_drops.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_soft_restore_drops.setBounds(6, 228, 149, 25);
		pan_arena_settings.add(chk_soft_restore_drops);

		chk_require_inv_join = new JCheckBox("Require empty inventory to join");
		chk_require_inv_join.setToolTipText("If false, players' inventories will be saved upon joining, and restored upon death/leaving.");
		chk_require_inv_join.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_require_inv_join.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_require_inv_join.setBounds(6, 263, 242, 28);
		pan_arena_settings.add(chk_require_inv_join);

		chk_require_inv_spec = new JCheckBox("Require empty inventory to spectate");
		chk_require_inv_spec.setToolTipText("If false, players can spectate the arena without having to empty their inventories.");
		chk_require_inv_spec.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_require_inv_spec.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_require_inv_spec.setBounds(6, 299, 275, 28);
		pan_arena_settings.add(chk_require_inv_spec);

		chk_hellhounds = new JCheckBox("Hellhounds");
		chk_hellhounds.setToolTipText("<html>If true, all pet wolves in the arena will be in flames! This has no actual function, and is purely for the cool-factor. <br>Also useful for distinguishing enemy wolves and pet wolves.");
		chk_hellhounds.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_hellhounds.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_hellhounds.setBounds(6, 339, 99, 25);
		pan_arena_settings.add(chk_hellhounds);

		chk_pvp = new JCheckBox("PVP enabled");
		chk_pvp.setToolTipText("If true, players can damage each other in the arena.");
		chk_pvp.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_pvp.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_pvp.setBounds(6, 376, 108, 25);
		pan_arena_settings.add(chk_pvp);

		chk_monster_infight = new JCheckBox("Monster infight");
		chk_monster_infight.setToolTipText("If false, monsters will no longer damage each other.");
		chk_monster_infight.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_monster_infight.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_monster_infight.setBounds(6, 413, 127, 25);
		pan_arena_settings.add(chk_monster_infight);

		chk_allow_tp = new JCheckBox("Allow teleporting");
		chk_allow_tp.setToolTipText("<html>If false, all warping to and from the arena region is blocked. <br>Useful for preventing players from summoning other players into the arena for help.");
		chk_allow_tp.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_allow_tp.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_allow_tp.setBounds(307, 6, 139, 25);
		pan_arena_settings.add(chk_allow_tp);

		chk_spectate_death = new JCheckBox("Spectate on death");
		chk_spectate_death.setToolTipText("<html>If false, players will not get warped to the spectator area, but instead be \"kicked\" <br>from the arena (essentially a forced /ma leave).");
		chk_spectate_death.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_spectate_death.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_spectate_death.setBounds(307, 43, 149, 25);
		pan_arena_settings.add(chk_spectate_death);

		chk_auto_respawn = new JCheckBox("Auto respawn");
		chk_auto_respawn.setToolTipText("<html>If false, players will be greeted with the typical death screen upon dying in the <br>arena, and will have to click the respawn button to respawn. With this setting at false, <br>players will actually die in the arena, meaning plugins like Heroes and mcMMO will <br>properly trigger their resetting of internal data upon respawn.");
		chk_auto_respawn.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_auto_respawn.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_auto_respawn.setBounds(307, 80, 119, 25);
		pan_arena_settings.add(chk_auto_respawn);

		chk_share = new JCheckBox("Share items");
		chk_share.setToolTipText("If false, players will not be able to drop items in the arena.");
		chk_share.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_share.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_share.setBounds(307, 117, 105, 25);
		pan_arena_settings.add(chk_share);

		lib_min_players = new JLabel("Min players");
		lib_min_players.setToolTipText("<html>Gives a lower limit on how many players are required to start the arena. The default <br>of 0 is the same as 1, which means 1 or more players may start the arena.");
		lib_min_players.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_min_players.setBounds(307, 154, 84, 25);
		pan_arena_settings.add(lib_min_players);

		sai_min_players = new JFormattedTextField(new MaskFormatter("###"));
		sai_min_players.setToolTipText(lib_min_players.getToolTipText());
		sai_min_players.setBackground(new Color(255, 255, 255));
		sai_min_players.setColumns(10);
		sai_min_players.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_min_players.setBounds(438, 155, 50, 25);
		pan_arena_settings.add(sai_min_players);

		lib_max_players = new JLabel("Max players");
		lib_max_players.setToolTipText("Gives an upper limit on how many players may join the arena. The default of 0 means no limit.");
		lib_max_players.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_max_players.setBounds(307, 191, 84, 25);
		pan_arena_settings.add(lib_max_players);

		sai_max_players = new JFormattedTextField(new MaskFormatter("###"));
		sai_max_players.setToolTipText(lib_max_players.getToolTipText());
		sai_max_players.setBackground(new Color(255, 255, 255));
		sai_max_players.setColumns(10);
		sai_max_players.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_max_players.setBounds(438, 192, 50, 25);
		pan_arena_settings.add(sai_max_players);

		lib_max_join_distance = new JLabel("Max join distance");
		lib_max_join_distance.setToolTipText("<html>The maximum distance (in blocks) from which players can join or spectate the <br>arena. If 0 (default), there is no limit. Note that the distance is calculated from every <br>corner of the arena region, and that players not in the arena world won't be able to <br>join or spectate.");
		lib_max_join_distance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_max_join_distance.setBounds(307, 228, 119, 25);
		pan_arena_settings.add(lib_max_join_distance);

		sai_max_join_distance = new JFormattedTextField(new MaskFormatter("###"));
		sai_max_join_distance.setToolTipText(lib_max_join_distance.getToolTipText());
		sai_max_join_distance.setBackground(new Color(255, 255, 255));
		sai_max_join_distance.setColumns(10);
		sai_max_join_distance.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_max_join_distance.setBounds(438, 229, 50, 25);
		pan_arena_settings.add(sai_max_join_distance);

		lib_first_delay = new JLabel("First wave delay");
		lib_first_delay.setToolTipText("The time (in seconds) before the first wave of monsters upon arena start.");
		lib_first_delay.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_first_delay.setBounds(307, 265, 119, 25);
		pan_arena_settings.add(lib_first_delay);

		sai_first_delay = new JFormattedTextField(new MaskFormatter("###"));
		sai_first_delay.setToolTipText(lib_first_delay.getToolTipText());
		sai_first_delay.setBackground(new Color(255, 255, 255));
		sai_first_delay.setColumns(10);
		sai_first_delay.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_first_delay.setBounds(438, 266, 50, 25);
		pan_arena_settings.add(sai_first_delay);

		lib_interval = new JLabel("Wave interval");
		lib_interval.setToolTipText("The time (in seconds) between each new wave of monsters. If clear-wave-before-next: true, this setting will be ignored.");
		lib_interval.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_interval.setBounds(307, 301, 119, 25);
		pan_arena_settings.add(lib_interval);

		sai_interval = new JFormattedTextField(new MaskFormatter("###"));
		sai_interval.setToolTipText(lib_interval.getToolTipText());
		sai_interval.setBackground(new Color(255, 255, 255));
		sai_interval.setColumns(10);
		sai_interval.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_interval.setBounds(438, 302, 50, 25);
		pan_arena_settings.add(sai_interval);

		lib_final_wave = new JLabel("Final wave");
		lib_final_wave.setToolTipText("<html>The number of the final wave before the arena is force ended. This is useful if you <br>want to set a cap on how many waves an arena will have.");
		lib_final_wave.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_final_wave.setBounds(307, 338, 119, 25);
		pan_arena_settings.add(lib_final_wave);

		sai_final_wave = new JFormattedTextField(new MaskFormatter("###"));
		sai_final_wave.setToolTipText(lib_final_wave.getToolTipText());
		sai_final_wave.setBackground(new Color(255, 255, 255));
		sai_final_wave.setColumns(10);
		sai_final_wave.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_final_wave.setBounds(438, 340, 50, 25);
		pan_arena_settings.add(sai_final_wave);

		lib_monster_limit = new JLabel("Monster limit");
		lib_monster_limit.setToolTipText("<html>The maximum amount of monsters MobArena is allowed to spawn for this arena. <br>The next wave, if any, will not spawn until there is room for more monsters.");
		lib_monster_limit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_monster_limit.setBounds(307, 376, 119, 25);
		pan_arena_settings.add(lib_monster_limit);

		sai_monster_limit = new JFormattedTextField(new MaskFormatter("###"));
		sai_monster_limit.setToolTipText(lib_monster_limit.getToolTipText());
		sai_monster_limit.setBackground(new Color(255, 255, 255));
		sai_monster_limit.setColumns(10);
		sai_monster_limit.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_monster_limit.setBounds(438, 377, 50, 25);
		pan_arena_settings.add(sai_monster_limit);

		chk_monster_xp = new JCheckBox("Monsters drop XP");
		chk_monster_xp.setToolTipText("<html>If true, monsters will drop experience orbs. This is useful if you wish to give players <br>the ability to spend the gathered experience on enchants or something else (using <br>different plugins) during the session.");
		chk_monster_xp.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_monster_xp.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_monster_xp.setBounds(307, 413, 149, 25);
		pan_arena_settings.add(chk_monster_xp);

		chk_keep_xp = new JCheckBox("Keep XP");
		chk_keep_xp.setToolTipText("<html>If true, players will keep the experience they gather in the arenas after death. This is <br>useful if you want to allow players to level up or gather experience in the arenas. <br>NOTE: If using display-waves-as-level or display-timer-as-level, set keep-exp to false.");
		chk_keep_xp.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_keep_xp.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_keep_xp.setBounds(514, 6, 80, 25);
		pan_arena_settings.add(chk_keep_xp);

		chk_food_regen = new JCheckBox("Food regeneration");
		chk_food_regen.setToolTipText("<html>If true, a full food bar will cause players to regenerate health while in the arena. <br>Note that this potentially makes tank-like classes extremely overpowered, since <br>diamond armor (by default) coupled with a full food bar will make a player very hard <br>to kill.");
		chk_food_regen.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_food_regen.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_food_regen.setBounds(514, 39, 150, 25);
		pan_arena_settings.add(chk_food_regen);

		chk_lock_food = new JCheckBox("Lock food level");
		chk_lock_food.setToolTipText("<html>If true, the food bar will be locked for all players in the arena, meaning they will not <br>end up starving, and they will be able to sprint around as they please.");
		chk_lock_food.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_lock_food.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_lock_food.setBounds(514, 80, 127, 25);
		pan_arena_settings.add(chk_lock_food);

		lib_player_time = new JLabel("Player time of day");
		lib_player_time.setToolTipText("<html>When set to anything but world, this setting will freeze the apparent world time for <br>players in the arena to whatever value you set. This is useful for making time-of-day <br>themed arenas (e.g. constant night time for a cemetery, broad daylight for a pirate <br>ship).");
		lib_player_time.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_player_time.setBounds(514, 150, 127, 25);
		pan_arena_settings.add(lib_player_time);

		combo_player_time = new JComboBox<String>();
		combo_player_time.setToolTipText(lib_player_time.getToolTipText());
		combo_player_time.setModel(new DefaultComboBoxModel<String>(new String[] {"world", "dawn", "sunrise", "morning", "midday", "noon", "day", "afternoon", "evening", "sunset", "dusk", "night", "midnight"}));
		combo_player_time.setBounds(653, 150, 95, 26);
		pan_arena_settings.add(combo_player_time);

		lib_auto_start = new JLabel("Auto start timer");
		lib_auto_start.setToolTipText("<html>The time (in seconds) before the arena will be force started after the first player has <br>joined the lobby (the default of 0 means deactivated or infinite time). Non-ready <br>players will be removed from the lobby. This setting is useful to prevent ill-minded <br>players from delaying or preventing other players from starting the arena.");
		lib_auto_start.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_auto_start.setBounds(514, 224, 119, 25);
		pan_arena_settings.add(lib_auto_start);

		sai_auto_start = new JFormattedTextField(new MaskFormatter("###"));
		sai_auto_start.setToolTipText(lib_auto_start.getToolTipText());
		sai_auto_start.setBackground(new Color(255, 255, 255));
		sai_auto_start.setColumns(10);
		sai_auto_start.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_auto_start.setBounds(645, 225, 50, 25);
		pan_arena_settings.add(sai_auto_start);

		chk_spout_class = new JCheckBox("Spout class select");
		chk_spout_class.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_spout_class.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_spout_class.setBounds(514, 113, 149, 25);
		pan_arena_settings.add(chk_spout_class);

		chk_auto_ignite = new JCheckBox("Auto ignite TNT");
		chk_auto_ignite.setToolTipText("<html>If true, TNT will be automatically ignited when placed. This is useful for preventing <br>Oddjob-like classes from forting.");
		chk_auto_ignite.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_auto_ignite.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_auto_ignite.setBounds(514, 187, 149, 25);
		pan_arena_settings.add(chk_auto_ignite);

		chk_use_class_chest = new JCheckBox("Use class chests");
		chk_use_class_chest.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_use_class_chest.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_use_class_chest.setBounds(514, 261, 131, 25);
		pan_arena_settings.add(chk_use_class_chest);

		chk_display_waves = new JCheckBox("Display waves as level");
		chk_display_waves.setToolTipText("<html>When set to true, the players' level counter (above the experience bar) will be used <br>to display the current wave number. If the wave announcements in the <br>announcements-file are silenced, this can be used to make a much less \"spammy\" <br>MobArena experience. NOTE: Do not use this if keep-exp is set to true!");
		chk_display_waves.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_display_waves.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_display_waves.setBounds(514, 299, 170, 25);
		pan_arena_settings.add(chk_display_waves);

		chk_display_timer = new JCheckBox("Display timer as level");
		chk_display_timer.setToolTipText("<html>When set to true, the players' level counter (above the experience bar) will be used <br>to display the auto-start timer in the lobby. NOTE: Do not use this if keep-exp is set to <br>true!");
		chk_display_timer.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_display_timer.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_display_timer.setBounds(514, 336, 170, 25);
		pan_arena_settings.add(chk_display_timer);

		chk_auto_ready = new JCheckBox("Auto ready");
		chk_auto_ready.setToolTipText("<html>When set to true, players are automatically flagged as ready when they pick a class. <br>Useful for arenas with many players where hitting an iron block becomes difficult.");
		chk_auto_ready.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_auto_ready.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_auto_ready.setBounds(514, 373, 99, 25);
		pan_arena_settings.add(chk_auto_ready);

		chk_scoreboard = new JCheckBox("Use scoreboards");
		chk_scoreboard.setToolTipText("Whether to use scoreboards in MobArena or not.");
		chk_scoreboard.setHorizontalTextPosition(SwingConstants.LEFT);
		chk_scoreboard.setFont(new Font("Tahoma", Font.BOLD, 14));
		chk_scoreboard.setBounds(514, 413, 139, 25);
		pan_arena_settings.add(chk_scoreboard);

		setInvisibleComponents_ArenaConfig();

		setSize(760,580);

		tabpan_config.addTab("Arenas and waves configuration", pan_arena_wave);
		tabpan_config.addTab("Classes configuration", pan_classes);
		tabpan_config.addTab("Arena configuration", pan_arena_settings);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(293, 6, 2, 441);
		pan_arena_settings.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(500, 6, 2, 441);
		pan_arena_settings.add(separator_1);

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

	public void loadArena(int numarena) {

		setInvisibleComponents_ArenaConfig();
		Arena arena = arenas.getALarenas().get(numarena);

		ArrayList<Wave> recW = arena.getWavesType(ECatW.recurrent);
		loadListCaracs_ArenaConfig(recW, list_recurrent);

		ArrayList<Wave> singW = arena.getWavesType(ECatW.single);
		loadListCaracs_ArenaConfig(singW, list_single);
		
		loadClasses_ClassConfig(arenas.getALclasses());

	}

	public void setVisibleComponents_ArenaConfig(Wave wave) {
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

	public void setInvisibleComponents_ArenaConfig() {
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

	public void deselectWaveLists_ArenaConfig(JList<CellListWave> jList){
		if(jList==list_recurrent){
			list_single.clearSelection();
		}
		else if(jList==list_single){
			list_recurrent.clearSelection();
		}
	}

	public void loadData_ArenaConfig(Wave wave) {
		sai_name.setText(wave.getNom());
		combo_category.setSelectedItem(wave.getCategory().getNom());
		combo_type.setSelectedItem(wave.getType().name());
		sai_wave.setText(wave.getNumwave()+"");

		sai_priority.setText(wave.getPriority()+"");
		sai_frequency.setText(wave.getFrequency()+"");

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
			sai_abi_interval.setText(bwave.getAbility_interval()+"");
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
	public void loadListCaracs_ArenaConfig(ArrayList listdata, JList listview) {

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
	public void majData_ArenaConfig(KeyEvent e) {

		JTextField source = (JTextField) e.getSource();
		JList<CellListWave> list_sel = list_recurrent.getSelectedIndex()!=-1 ? list_recurrent : list_single;
		Wave wave = list_sel.getSelectedValue().getWave();
		Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());
		ArrayList<Wave> waveList = lArene.getWavesType(list_sel == list_recurrent ? ECatW.recurrent	: ECatW.single);
		String txtsource = source.getText();

		if(source==sai_wave){

			int numwave = txtsource.equals("") ? 1 : Integer.parseInt(txtsource);

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

			int numcarac = txtsource.equals("") ? 1 : Integer.parseInt(txtsource);
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
			int abi_interval = txtsource.equals("") ? 3 : Integer.parseInt(txtsource);
			bwave.setAbility_interval(abi_interval);

		}

	}

	private void loadClasses_ClassConfig(ArrayList<Classe> aLclasses) {
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
}
