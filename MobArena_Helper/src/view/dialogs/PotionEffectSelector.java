package view.dialogs;

import java.awt.*;
import java.awt.event.*;
import java.text.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import model.Messages;
import model.data.PotionEffect;
import model.lists.PotionEffectList;
import view.JHoverList;
import view.cells.CellListEPotionEffect;

public class PotionEffectSelector extends JDialog {

	private static final long serialVersionUID = 8666174169936535354L;

	private JFrame frame;

	private PotionEffectList potionEffectList;

	private JLabel lib_available;

	private JLabel lib_applied;

	private JScrollPane scrpan_available;

	private JHoverList<CellListEPotionEffect> list_available;

	private JScrollPane scrpan_applied;

	private JHoverList<CellListEPotionEffect> list_applied;

	private JButton btn_add;

	private JButton btn_remove;

	private JPanel pan_applied;

	private JLabel lib_amplifier;

	private JSlider sld_amplifier;

	private JLabel lib_seconds;

	private JFormattedTextField sai_seconds;

	public PotionEffectSelector(JFrame frame, PotionEffectList potionEffectList) {
		super();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle(Messages.getString("PotionEffectSelector.title") + " - " + frame.getTitle());
		setIconImage(new ImageIcon(ItemSelector.class.getResource("/gui/pics/mobarena.png")).getImage());
		setResizable(false);
		setSize(750, 374);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(null);

		this.frame = frame;
		this.potionEffectList = potionEffectList;

		lib_available = new JLabel(Messages.getString("PotionEffectSelector.lib_available.text"));
		lib_available.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_available.setBounds(6, 6, 120, 25);
		getContentPane().add(lib_available);

		list_available = new JHoverList<CellListEPotionEffect>();

		scrpan_available = new JScrollPane(list_available);
		scrpan_available.setBounds(6, 43, 300, 180);
		getContentPane().add(scrpan_available);

		lib_applied = new JLabel(Messages.getString("PotionEffectSelector.lib_applied.text")); //$NON-NLS-1$
		lib_applied.setFont(new Font("Tahoma", Font.BOLD, 14));
		lib_applied.setBounds(431, 6, 109, 25);
		getContentPane().add(lib_applied);

		list_applied = new JHoverList<CellListEPotionEffect>();
		list_applied.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO affichage du panneau de config de l'effet
			}
		});

		scrpan_applied = new JScrollPane(list_applied);
		scrpan_applied.setBounds(431, 43, 300, 180);
		getContentPane().add(scrpan_applied);

		btn_add = new JButton(Messages.getString("ItemSelector.btn_add.text"));
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO add
			}
		});
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_add.setBounds(318, 93, 101, 28);
		getContentPane().add(btn_add);

		btn_remove = new JButton(Messages.getString("ItemSelector.btn_remove.text"));
		btn_remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO remove et disparition du panneau de config
			}
		});
		btn_remove.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_remove.setBounds(318, 133, 101, 28);
		getContentPane().add(btn_remove);

		pan_applied = new JPanel();
		pan_applied.setBounds(431, 235, 300, 104);
		pan_applied.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), Messages
				.getString("PotionEffectSelector.pan_applied.text"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pan_applied.setLayout(null);
		getContentPane().add(pan_applied);

		lib_amplifier = new JLabel(Messages.getString("PotionEffectSelector.lib_amplifier.text")); //$NON-NLS-1$
		lib_amplifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_amplifier.setBounds(6, 27, 95, 25);
		pan_applied.add(lib_amplifier);

		sld_amplifier = new JSlider();
		sld_amplifier.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				if (!sld_amplifier.getValueIsAdjusting()) {
					PotionEffectList pel = PotionEffectSelector.this.potionEffectList;
					PotionEffect pe = pel.get(pel.indexOfEPE(list_applied.getSelectedValue().getPotionEffect()));

					int amplifier = sld_amplifier.getValue();
					lib_amplifier.setText(lib_amplifier.getText() + " " + amplifier);
					pe.setAmplifier(amplifier);

				}

			}
		});
		sld_amplifier.setSnapToTicks(true);
		sld_amplifier.setMinorTickSpacing(1);
		sld_amplifier.setMajorTickSpacing(10);
		sld_amplifier.setValue(0);
		sld_amplifier.setMaximum(254);
		sld_amplifier.setBounds(113, 27, 181, 25);
		pan_applied.add(sld_amplifier);

		lib_seconds = new JLabel(Messages.getString("PotionEffectSelector.lib_seconds.text")); //$NON-NLS-1$
		lib_seconds.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_seconds.setBounds(6, 64, 95, 25);
		pan_applied.add(lib_seconds);

		// TODO essayer de faire un timer sympa avec une sorte d'horloge

		sai_seconds = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_seconds.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					sai_seconds.commitEdit();

					PotionEffectList pel = PotionEffectSelector.this.potionEffectList;
					PotionEffect pe = pel.get(pel.indexOfEPE(list_applied.getSelectedValue().getPotionEffect()));
					pe.setDuration(((Number)(sai_seconds.getValue())).intValue());

				}
				catch (ParseException e1) {
				}
			}
		});
		sai_seconds.setBounds(113, 64, 181, 28);
		sai_seconds.setBackground(new Color(255, 255, 255));
		sai_seconds.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sai_seconds.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_seconds.setColumns(10);
		pan_applied.add(sai_seconds);

		setVisible(true);
	}

	protected JFrame getFrame() {
		return frame;
	}
}
