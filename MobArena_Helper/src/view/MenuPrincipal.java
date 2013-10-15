package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
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
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Arena;
import model.Arenas;
import model.Classe;
import model.GestYaml;
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
import model.wave.SwarmW;
import view.cells.CellListAbility;
import view.cells.CellListCaracs;
import view.cells.CellListMonster;
import view.cells.CellListWave;
import view.cells.HoverListCellRenderer;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 7504976316824014595L;
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
	private JComboBox<String> combo_abi_announce;
	private JTextArea lib_abi_interval;
	private JTextField sai_abi_interval;
	private JButton btn_add;
	private JWideComboBox combo_carac_wave;
	private JTextField sai_nb_carac_wave;
	private JButton btn_set;
	private JLabel lib_set;

	private JMenuItem mntmAbout;
	private JMenuBar menuBar;
	private JMenu mnHelp;
	private JMenuItem mntmHowToUse;

	private GestYaml g;
	private Arenas arenas = null;
	private File file = null;

	public MenuPrincipal(){
		super("MobArena Helper v1");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/gui/mobarena.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);

		lib_arena = new JLabel("Arena");
		lib_arena.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_arena.setBounds(10, 11, 46, 17);
		getContentPane().add(lib_arena);

		combo_arena = new JComboBox<String>();
		combo_arena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combo_arena.setBounds(66, 11, 192, 20);
		getContentPane().add(combo_arena);

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
					loadListCaracs(waves, listToLoad);
					setVisibleComponents(defwave);
					loadData(defwave);
					listToLoad.setSelectedIndex(0);
					deselectWaveLists(listToLoad);
					sai_name.requestFocus();
					sai_name.selectAll();

				}

			}
		};

		lib_recurrent = new JLabel("Recurrent Waves");
		lib_recurrent.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_recurrent.setBounds(10, 50, 132, 17);
		getContentPane().add(lib_recurrent);

		btn_newrecurrent = new JButton("New Wave");
		btn_newrecurrent.addMouseListener(newWave);
		btn_newrecurrent.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_newrecurrent.setBounds(167, 49, 91, 23);
		getContentPane().add(btn_newrecurrent);

		MouseAdapter cellmouseadapter = new MouseAdapter() {
			@SuppressWarnings("unchecked")
			public void mouseReleased(MouseEvent e) {

				//On récupère la liste source en tant que liste de caracs pour l'évaluation de situation
				//et en tant que liste de vagues pour le travail sur les données
				JList<CellListCaracs> source = (JList<CellListCaracs>) e.getSource();
				JList<CellListWave> jList = (JList<CellListWave>) e.getSource();
				if (source.getModel().getSize()!=0) {
					//Clic gauche (sélection)
					if (e.getButton() == MouseEvent.BUTTON1) {

						if (source != list_carac_wave) {
							Wave vague = jList.getSelectedValue().getWave();
							setVisibleComponents(vague);
							loadData(vague);
							deselectWaveLists(jList);
						}

					}
					//Clic molette (suppression)
					else if (e.getButton() == MouseEvent.BUTTON2) {

						int hoverIndex = ((HoverListCellRenderer) jList
								.getCellRenderer()).getHoverIndex();

						if (hoverIndex != -1) {
							if (source != list_carac_wave) {

								setInvisibleComponents();

								Wave hoverWave = jList.getModel()
										.getElementAt(hoverIndex).getWave();
								int reponse = JOptionPane.showConfirmDialog(
										null,
										"Are you sure you want to delete the "
												+ hoverWave.getCategory()
														.getNom().toLowerCase()
												+ " wave named "
												+ hoverWave.getNom() + " ?",
										"Confirmation",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE);
								switch (reponse) {
								case 0:
									//Récupération de l'arène en cours
									Arena lArene = arenas.getALarenas().get(
											combo_arena.getSelectedIndex());
									//Suppression de la vague voulue
									lArene.getWavesType(hoverWave.getCategory())
											.remove(hoverIndex);
									//Rechargement
									loadListCaracs(
											lArene.getWavesType(hoverWave
													.getCategory()), jList);
									break;
								default:
									break;
								}
								deselectWaveLists(list_recurrent);
								deselectWaveLists(list_single);

							} else {

								CellListCaracs cellcarac = source.getModel()
										.getElementAt(hoverIndex);
								CellListMonster cellmonster = null;
								CellListAbility cellabi = null;
								JList<CellListWave> list_wave = list_recurrent
										.getSelectedIndex() != -1 ? list_recurrent
										: list_single;
								Wave wave = list_wave.getSelectedValue()
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
									loadListCaracs(listdata, source);
								}
							}
						}
					}
				}
			}
		};

		list_recurrent = new JList<CellListWave>();
		list_recurrent.addMouseListener(cellmouseadapter);
		list_recurrent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrpan_recurrent = new JScrollPane(list_recurrent);
		scrpan_recurrent.setBounds(10, 82, 252, 165);
		getContentPane().add(scrpan_recurrent);

		lib_single = new JLabel("Single Waves");
		lib_single.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_single.setBounds(10, 264, 132, 17);
		getContentPane().add(lib_single);

		btn_newsingle = new JButton("New Wave");
		btn_newsingle.addMouseListener(newWave);
		btn_newsingle.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_newsingle.setBounds(167, 258, 91, 23);
		getContentPane().add(btn_newsingle);

		list_single = new JList<CellListWave>();
		list_single.addMouseListener(cellmouseadapter);
		list_single.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrpan_single = new JScrollPane(list_single);
		scrpan_single.setBounds(10, 290, 252, 165);
		getContentPane().add(scrpan_single);

		pan_conf = new JPanel();
		pan_conf.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pan_conf.setBounds(268, 11, 474, 410);
		getContentPane().add(pan_conf);
		pan_conf.setLayout(null);

		lib_name = new JLabel("Name :");
		lib_name.setForeground(new Color(81, 133, 190));
		lib_name.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_name.setBounds(10, 11, 58, 20);
		pan_conf.add(lib_name);

		sai_name = new JTextField();
		sai_name.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				JList<CellListWave> list_sel = combo_category.getSelectedItem().equals("Recurrent") ? list_recurrent : list_single;
				int index_sel = list_sel.getSelectedIndex();
				Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());
				String category = ((String) combo_category.getSelectedItem()).toLowerCase();
				ArrayList<Wave> waveList = lArene.getWavesType(ECatW.valueOf(category));

				String wavename = sai_name.getText().equals("") ? "New_Wave" : sai_name.getText();

				list_sel.getSelectedValue().getWave().setNom(wavename);
				loadListCaracs(waveList, list_sel);
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

					String scategory = combo_category.getSelectedItem().equals("Recurrent") ? "single" : "recurrent";

					JList<CellListWave> list_sel = scategory.equals("recurrent") ? list_recurrent : list_single;
					JList<CellListWave> otherList_sel = list_sel==list_recurrent ? list_single : list_recurrent;
					int index_sel = list_sel.getSelectedIndex();
					Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());

					ECatW category = ECatW.valueOf(scategory);
					ECatW othercat = category==ECatW.recurrent ? ECatW.single : ECatW.recurrent;

					ArrayList<Wave> waveList = lArene.getWavesType(category);
					ArrayList<Wave> otherWaveList = lArene.getWavesType(othercat);

					Wave wave = list_sel.getSelectedValue().getWave();
					waveList.remove(wave);
					wave.setCategory(othercat);
					otherWaveList.add(wave);
					Collections.sort(otherWaveList);

					loadListCaracs(waveList, list_sel);
					loadListCaracs(otherWaveList, otherList_sel);

					int i=0;
					int otherw=0;
					while(i<otherWaveList.size() && otherWaveList.get(i)!=wave){
						if(otherWaveList.get(i) instanceof OtherW){otherw++;}
						i++;
					}

					index_sel = i-otherw;
					list_sel.clearSelection();
					otherList_sel.setSelectedIndex(index_sel);
					setVisibleComponents(wave);

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
					String category = combo_category.getSelectedItem().equals("Recurrent") ? "recurrent" : "single";
					JList<CellListWave> list_sel = category.equals("recurrent") ? list_recurrent : list_single;
					int index_sel = list_sel.getSelectedIndex();
					ArrayList<Wave> waveList = lArene.getWavesType(ECatW.valueOf(category));

					Wave wave = list_sel.getSelectedValue().getWave();
					wave.setType(type);
					waveList.remove(wave);

					switch (type) {
					case Default:
						nextWave = wave.getDefaultW();
						combo_growth.setSelectedItem(EGrowth.old.getNom());
						combo_abi_announce.setSelectedItem("false");
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
					default:
						break;
					}
					waveList.add(index_sel,nextWave);

					//Collections.sort(waveList);
					loadListCaracs(waveList, list_sel);
					list_sel.setSelectedIndex(index_sel);
					setVisibleComponents(nextWave);

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

		KeyAdapter mask_numeric = new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				JTextField source = (JTextField) e.getSource();
				String orig = source.getText();
				if (orig.length()>0) {
					int modif = -1;
					try {
						modif = Integer.parseInt(orig);
					} catch (NumberFormatException e1) {}
					String sModif = Integer.toString(modif);
					if (!orig.equals(sModif)) {
						source.setText(orig.substring(0, orig.length() - 1));
					}
				}
				majData(e);

			}
		};

		sai_wave = new JTextField();
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

		sai_priority = new JTextField();
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

		sai_frequency = new JTextField();
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
					String category = combo_category.getSelectedItem().equals("Recurrent") ? "recurrent" : "single";
					Arena lArene = arenas.getALarenas().get(combo_arena.getSelectedIndex());
					JList<CellListWave> list_sel = category.equals("recurrent") ? list_recurrent : list_single;
					ArrayList<Wave> waveList = lArene.getWavesType(ECatW.valueOf(category));
					int index_sel = list_sel.getSelectedIndex();

					DefaultW wave = (DefaultW) list_sel.getSelectedValue().getWave();
					wave.setGrowth(growth);
					loadListCaracs(waveList, list_sel);
					list_sel.setSelectedIndex(index_sel);

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
		scrpan_carac_wave.setBounds(219, 42, 245, 328);
		pan_conf.add(scrpan_carac_wave);

		lib_monster = new JLabel("Monster :");
		lib_monster.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_monster.setBounds(10, 228, 84, 20);
		pan_conf.add(lib_monster);

		ItemListener itemListener_monster_amount = new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				//la clause isFocusOwner() est spécifiée car la combo Amount change de valeur à l'initialisation
				if (e.getStateChange() == ItemEvent.DESELECTED && ((JComponent) e.getSource()).isFocusOwner()) {
					JList<CellListWave> list_sel = combo_category.getSelectedItem().equals("Recurrent") ? list_recurrent : list_single;

					@SuppressWarnings("unchecked")
					JComboBox<String> combo_sel = (JComboBox<String>) e.getSource();

					Wave wave = list_sel.getSelectedValue().getWave();
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

					JList<CellListWave> list_sel = combo_category.getSelectedItem().equals("Recurrent") ? list_recurrent : list_single;
					BossW bwave = (BossW) list_sel.getSelectedValue().getWave();

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

		combo_abi_announce = new JComboBox<String>();
		combo_abi_announce.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				//la clause isFocusOwner() est spécifiée car la combo Amount change de valeur à l'initialisation
				if(e.getStateChange() == ItemEvent.DESELECTED && combo_abi_announce.isFocusOwner()) {

					JList<CellListWave> list_sel = combo_category.getSelectedItem().equals("Recurrent") ? list_recurrent : list_single;
					boolean b = new Boolean((String) combo_abi_announce.getSelectedItem());
					Wave wave = list_sel.getSelectedValue().getWave();
					//Cas d'une vague Default
					if(lib_abi_announce.getText().equals("Fixed :")){
						DefaultW defwave = (DefaultW) wave;

						defwave.setFixed(b);
					}
					//Cas d'une vague Boss
					else {
						BossW bwave = (BossW) wave;

						bwave.setAbility_announce(b);
					}

				}

			}
		});
		combo_abi_announce.setModel(new DefaultComboBoxModel<String>(new String[] {"true", "false"}));
		combo_abi_announce.setSelectedIndex(0);
		combo_abi_announce.setBounds(104, 322, 105, 20);
		pan_conf.add(combo_abi_announce);

		lib_abi_interval = new JTextArea("Ability Interval :");
		lib_abi_interval.setWrapStyleWord(true);
		lib_abi_interval.setLineWrap(true);
		lib_abi_interval.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_abi_interval.setBackground(new Color(214, 217, 223));
		lib_abi_interval.setBorder(new EmptyBorder(0, 0, 0, 0));
		lib_abi_interval.setEditable(false);
		lib_abi_interval.setBounds(10, 363, 84, 36);
		pan_conf.add(lib_abi_interval);

		sai_abi_interval = new JTextField();
		sai_abi_interval.addKeyListener(mask_numeric);
		sai_abi_interval.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sai_abi_interval.setColumns(10);
		sai_abi_interval.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_abi_interval.setBounds(104, 369, 105, 20);
		pan_conf.add(sai_abi_interval);

		btn_add = new JButton("Add");
		btn_add.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {

				JList<CellListWave> list_sel = combo_category.getSelectedItem().equals("Recurrent") ? list_recurrent : list_single;
				Wave wave = list_sel.getSelectedValue().getWave();
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
							loadListCaracs(abilist,list_carac_wave);
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
								loadListCaracs(monsterlist, list_carac_wave);
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
		btn_add.setBounds(219, 381, 58, 23);
		pan_conf.add(btn_add);

		combo_carac_wave = new JWideComboBox();
		combo_carac_wave.setFont(new Font("SansSerif", Font.PLAIN, 12));
		combo_carac_wave.setBounds(287, 382, 105, 20);
		pan_conf.add(combo_carac_wave);

		sai_nb_carac_wave = new JTextField();
		sai_nb_carac_wave.addKeyListener(mask_numeric);
		sai_nb_carac_wave.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sai_nb_carac_wave.setBounds(402, 382, 62, 22);
		pan_conf.add(sai_nb_carac_wave);
		sai_nb_carac_wave.setColumns(10);

		btn_set = new JButton("Set");
		btn_set.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {

				String name = JOptionPane.showInputDialog(null, "Set the new boss name for the current boss wave :", "Setting the name", JOptionPane.QUESTION_MESSAGE);
				if (name!=null) {
					JList<CellListWave> list_sel = combo_category
							.getSelectedItem().equals("Recurrent") ? list_recurrent
									: list_single;
					BossW bwave = (BossW) list_sel.getSelectedValue().getWave();
					bwave.setBossName(name);
					lib_set.setText(" "+name);
				}

			}
		});
		btn_set.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_set.setBounds(300, 11, 92, 23);
		pan_conf.add(btn_set);

		lib_set = new JLabel("");
		lib_set.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lib_set.setBorder(new LineBorder(new Color(0, 0, 0)));
		lib_set.setBounds(397, 11, 67, 20);
		pan_conf.add(lib_set);

		btn_load = new JButton("Load Config");
		btn_load.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				Classe.classe_list.clear();
				YmlJFileChooser fchoose = new YmlJFileChooser();
				fchoose.showOpenDialog(null);
				file = fchoose.getSelectedFile();
				if (file!=null) {
					g = new GestYaml(file);
					arenas = new Arenas(g.getMap("arenas"),g.getMap("global-settings"),g.getMap("classes"));
					ArrayList<Arena> alArenas = arenas.getALarenas();
					for(int i=0;i<alArenas.size();i++){
						combo_arena.addItem(alArenas.get(i).getNom());
					}
					loadArena(0);
				}
			}
		});
		btn_load.setForeground(new Color(255, 255, 255));
		btn_load.setBackground(new Color(100, 149, 237));
		btn_load.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_load.setBounds(268, 432, 97, 23);
		getContentPane().add(btn_load);

		btn_save = new JButton("Save Config As");
		btn_save.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if(arenas!=null){

					YmlJFileChooser fchoose = new YmlJFileChooser(file.getPath());
					fchoose.showOpenDialog(null);
					File f = fchoose.getSelectedFile();
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
		btn_save.setBounds(375, 432, 115, 23);
		getContentPane().add(btn_save);

		setInvisibleComponents();

		setSize(756,515);

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

		Rectangle d = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		setLocation((d.width-getWidth())/2, (d.height-getHeight())/2);
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

		setInvisibleComponents();
		Arena arena = arenas.getALarenas().get(numarena);

		ArrayList<Wave> recW = arena.getWavesType(ECatW.recurrent);
		loadListCaracs(recW, list_recurrent);

		ArrayList<Wave> singW = arena.getWavesType(ECatW.single);
		loadListCaracs(singW, list_single);

	}

	public void setVisibleComponents(Wave wave) {
		ETypeW typevague = wave.getType();
		ECatW catvague = wave.getCategory();

		setInvisibleComponents();
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

			combo_abi_announce.setVisible(true);
			lib_abi_announce.setText("Fixed :");
			lib_carac_wave.setText("Monsters");
			combo_carac_wave.setModel(new DefaultComboBoxModel<String>(EMonsters.namevalues()));
			combo_carac_wave.setSelectedIndex(-1);
			break;
		case Boss:
			btn_set.setVisible(true);
			btn_set.setText("Set Name");
			lib_set.setVisible(true);
			lib_monster.setVisible(true);
			combo_monster.setVisible(true);
			lib_health.setVisible(true);
			combo_health.setVisible(true);
			lib_abi_announce.setVisible(true);
			combo_abi_announce.setVisible(true);
			lib_abi_interval.setVisible(true);
			sai_abi_interval.setVisible(true);

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

	public void setInvisibleComponents() {
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
		combo_abi_announce.setVisible(false);
		lib_abi_interval.setVisible(false);
		sai_abi_interval.setVisible(false);
		btn_add.setVisible(false);
		combo_carac_wave.setVisible(false);
		sai_nb_carac_wave.setVisible(false);
		btn_set.setVisible(false);
		lib_set.setVisible(false);

		lib_abi_announce.setText("Ability Announce :");
		btn_set.setText("Set");
		lib_set.setText("");
		list_carac_wave.setModel(new DefaultListModel<CellListCaracs>());
	}

	public void deselectWaveLists(JList<CellListWave> jList){
		if(jList==list_recurrent){
			list_single.clearSelection();
		}
		else if(jList==list_single){
			list_recurrent.clearSelection();
		}
	}

	public void loadData(Wave wave) {
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
			combo_abi_announce.setSelectedItem(new Boolean(defwave.isFixed()).toString());
			loadListCaracs(defwave.getMonstres(), list_carac_wave);
			break;
		case Boss:
			BossW bwave = (BossW) wave;
			lib_set.setText(" "+bwave.getBossName());
			combo_health.setSelectedItem(bwave.getHealth().getNom());
			combo_abi_announce.setSelectedItem(new Boolean(bwave.isAbility_announce()).toString());
			sai_abi_interval.setText(bwave.getAbility_interval()+"");
			combo_monster.setSelectedItem(bwave.getMonstres().get(0).getMonstre().getNom());
			loadListCaracs(bwave.getAbilities(), list_carac_wave);
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
			loadListCaracs(spwave.getMonstres(), list_carac_wave);
			break;
		default:
			break;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void loadListCaracs(ArrayList listdata, JList listview) {

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

	public void majData(KeyEvent e) {

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
				loadListCaracs(waveList, list_sel);
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
			loadListCaracs(waveList, list_sel);
			int index_sel = i - otherw;
			list_sel.setSelectedIndex(index_sel);

		}
		else if(source==sai_abi_interval){
			BossW bwave = (BossW) wave;
			int abi_interval = txtsource.equals("") ? 3 : Integer.parseInt(txtsource);
			bwave.setAbility_interval(abi_interval);

		}

	}
}
