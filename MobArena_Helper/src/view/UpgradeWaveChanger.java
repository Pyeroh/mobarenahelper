package view;

import javax.swing.JFrame;

import model.wave.UpgradeW;

public class UpgradeWaveChanger extends JFrame {

	private static final long serialVersionUID = -8859125188519188824L;
	private UpgradeW upgradew;
	private JFrame frame;

	public UpgradeWaveChanger(UpgradeW upw, JFrame frame) {
		super("Upgrade Wave modifier");
		this.upgradew = upw;
		this.frame = frame;
		
	}
	
	

}
