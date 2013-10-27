package view;

import javax.swing.JFrame;

import model.wave.UpgradeW;
import java.awt.Toolkit;

public class UpgradeWaveChanger extends JFrame {

	private static final long serialVersionUID = -8859125188519188824L;
	private UpgradeW upgradew;
	private JFrame frame;

	public UpgradeWaveChanger(UpgradeW upw, JFrame frame) {
		super("Upgrade Wave modifier - "+frame.getTitle());
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpgradeWaveChanger.class.getResource("/gui/mobarena.png")));
		setResizable(false);
		this.upgradew = upw;
		this.frame = frame;
		
		setAlwaysOnTop(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(null);
		
	}
	
	

}
