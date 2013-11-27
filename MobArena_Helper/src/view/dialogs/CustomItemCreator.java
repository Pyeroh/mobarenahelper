package view.dialogs;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import model.Messages;
import model.item.CustomItem;
import view.cells.CellListCaracs;

public class CustomItemCreator extends JDialog{

	private static final long serialVersionUID = -6074492696500572347L;
	@SuppressWarnings("unused")
	private JFrame frame;
	private JLabel lib_id;
	private JLabel lib_meta;
	private JFormattedTextField sai_id;
	private JLabel lib_quantity;
	private JFormattedTextField sai_meta;
	private JFormattedTextField sai_quantity;
	private JButton btn_ok;
	private JLabel img_help;
	
	public CustomItemCreator(JFrame frame) {
		this.frame = frame;
		
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CustomItemCreator.class.getResource("/gui/pics/mobarena.png")));
		setTitle(Messages.getString("CustomItemCreator.title")+" - "+frame.getTitle());
		
		setSize(384,194);
		getContentPane().setLayout(null);
		
		lib_id = new JLabel(Messages.getString("CustomItemCreator.lib_id.text")); //$NON-NLS-1$ //$NON-NLS-2$
		lib_id.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_id.setBounds(81, 6, 107, 25);
		getContentPane().add(lib_id);
		
		sai_id = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_id.setFocusLostBehavior(JFormattedTextField.COMMIT);
		sai_id.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_id.setBounds(241, 6, 47, 25);
		sai_id.setValue(0L);
		getContentPane().add(sai_id);
		
		lib_meta = new JLabel(Messages.getString("CustomItemCreator.lib_meta.text")); //$NON-NLS-1$
		lib_meta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_meta.setBounds(81, 43, 148, 25);
		getContentPane().add(lib_meta);
		
		sai_meta = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_meta.setFocusLostBehavior(JFormattedTextField.COMMIT);
		sai_meta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_meta.setBounds(241, 43, 47, 25);
		sai_meta.setValue(0L);
		getContentPane().add(sai_meta);
		
		lib_quantity = new JLabel(Messages.getString("CustomItemCreator.lib_quantity.text")); //$NON-NLS-1$
		lib_quantity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lib_quantity.setBounds(81, 80, 148, 25);
		getContentPane().add(lib_quantity);
		
		sai_quantity = new JFormattedTextField(NumberFormat.getIntegerInstance());
		sai_quantity.setFocusLostBehavior(JFormattedTextField.COMMIT);
		sai_quantity.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sai_quantity.setBounds(241, 80, 47, 25);
		sai_quantity.setValue(1L);
		getContentPane().add(sai_quantity);
		
		btn_ok = new JButton("OK");
		btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ToolTipManager.sharedInstance().setDismissDelay(4000);
				setVisible(false);
			}
		});
		btn_ok.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_ok.setBounds(145, 117, 90, 28);
		getContentPane().add(btn_ok);
		
		img_help = new JLabel();
		img_help.setToolTipText(Messages.getString("CustomItemCreator.img_help.toolTipText")); //$NON-NLS-1$
		img_help.setBounds(6, 6, 28, 28);
		Image img = CellListCaracs.scaleImage(new ImageIcon(CustomItemCreator.class.getResource("/gui/pics/question.png")).getImage(), img_help);
		img_help.setIcon(new ImageIcon(img));
		getContentPane().add(img_help);
		
		ToolTipManager.sharedInstance().setDismissDelay(15000);
		
		setLocationRelativeTo(frame);
		setVisible(true);
	}
	
	public CustomItem getItem() {
		int id = (int)((long) sai_id.getValue());
		int meta = (int) ((long) sai_meta.getValue());
		int quantity = (int) ((long) sai_quantity.getValue());
		if (id>0) {
			CustomItem ci = new CustomItem(id, meta, quantity);
			return ci;
		}
		else return null;
	}
}
