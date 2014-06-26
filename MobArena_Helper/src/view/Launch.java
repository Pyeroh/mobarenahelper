package view;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Launch {

	private Launch() {
	}

	public static void main(String[] args) throws Exception {

		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		JOptionPane.showMessageDialog(null, (JOptionPane.showInputDialog(null, "Est-ce que la valeur matche ?").matches("\\$ ?\\d+([,\\.]\\d+)?")));
		// new MenuPrincipal();
		// System.out.println(EItem._11_disc);
	}

}