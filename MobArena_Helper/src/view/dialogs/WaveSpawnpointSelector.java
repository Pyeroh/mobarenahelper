package view.dialogs;

import java.awt.Font;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import model.Messages;
import model.data.*;
import view.JHoverList;
import view.cells.CellListCaracs;

public class WaveSpawnpointSelector extends JDialog {

	private static final long serialVersionUID = -6905108042017020148L;

	private JFrame frame;

	private Wave wave;

	private ArrayList<Position> coordSP;

	private JLabel lib_coord_sp;

	private JScrollPane scrpan_coord_sp;

	private JHoverList<CellListCaracs> list_coord_sp;

	private JButton btn_add;

	private JButton btn_remove;

	private JLabel lib_wave_sp;

	private JScrollPane scrpan_wave_sp;

	private JHoverList<CellListCaracs> list_wave_sp;

	public WaveSpawnpointSelector(JFrame frame, Wave wave, Coordinates coords) {
		super();

		this.frame = frame;
		this.wave = wave;
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle(Messages.getString("WaveSpawnpointSelector.title") + " - " + frame.getTitle());
		setIconImage(new ImageIcon(ItemSelector.class.getResource("/gui/pics/mobarena.png")).getImage());
		setSize(790, 280);
		setResizable(false);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(null);

		lib_coord_sp = new JLabel(Messages.getString("WaveSpawnpointSelector.lib_coord_sp.text")); //$NON-NLS-1$
		lib_coord_sp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_coord_sp.setBounds(6, 6, 252, 25);
		getContentPane().add(lib_coord_sp);

		list_coord_sp = new JHoverList<CellListCaracs>();

		scrpan_coord_sp = new JScrollPane(list_coord_sp);
		scrpan_coord_sp.setBounds(6, 32, 300, 210);
		getContentPane().add(scrpan_coord_sp);

		btn_add = new JButton(Messages.getString("ItemSelector.btn_add.text"));
		btn_add.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (!list_coord_sp.isSelectionEmpty()) {
					Position pos = new Position(list_coord_sp.getSelectedValue().getText() + ",0,0");
					pos = coordSP.remove(coordSP.indexOf(pos));
					WaveSpawnpointSelector.this.wave.getSpawnpoints().add(pos);

					load();

				}

			}
		});
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_add.setBounds(318, 96, 101, 28);
		getContentPane().add(btn_add);

		btn_remove = new JButton(Messages.getString("ItemSelector.btn_remove.text"));
		btn_remove.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (!list_wave_sp.isSelectionEmpty()) {
					Position pos = new Position(list_wave_sp.getSelectedValue().getText() + ",0,0");
					ArrayList<Position> spawnpoints = WaveSpawnpointSelector.this.wave.getSpawnpoints();
					pos = spawnpoints.remove(spawnpoints.indexOf(pos));
					coordSP.add(pos);

					load();
				}

			}
		});
		btn_remove.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_remove.setBounds(318, 136, 101, 28);
		getContentPane().add(btn_remove);

		lib_wave_sp = new JLabel(Messages.getString("WaveSpawnpointSelector.lib_wave_sp.text")); //$NON-NLS-1$
		lib_wave_sp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_wave_sp.setBounds(431, 6, 252, 25);
		getContentPane().add(lib_wave_sp);

		list_wave_sp = new JHoverList<CellListCaracs>();

		scrpan_wave_sp = new JScrollPane(list_wave_sp);
		scrpan_wave_sp.setBounds(431, 32, 343, 210);
		getContentPane().add(scrpan_wave_sp);

		coordSP = new ArrayList<Position>(coords.getSpawnpoints().values());
		coordSP.removeAll(wave.getSpawnpoints());

		load();

		setVisible(true);
	}

	private void load() {

		Collections.sort(WaveSpawnpointSelector.this.wave.getSpawnpoints());
		Collections.sort(coordSP);

		DefaultListModel<CellListCaracs> defaultListModel = new DefaultListModel<CellListCaracs>();
		for (Position position : wave.getSpawnpoints()) {
			defaultListModel.addElement(new CellListCaracs(position.getName()));
		}
		list_wave_sp.setModel(defaultListModel);

		defaultListModel = new DefaultListModel<CellListCaracs>();
		for (Position position : coordSP) {
			defaultListModel.addElement(new CellListCaracs(position.getName()));
		}
		list_coord_sp.setModel(defaultListModel);
	}

	protected JFrame getFrame() {
		return frame;
	}

}
