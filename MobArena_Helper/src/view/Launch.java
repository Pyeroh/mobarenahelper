package view;

import javax.swing.UIManager;

public class Launch {

	private Launch(){}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		new MenuPrincipal();
		//System.out.println(EItem._11_disc);
	}

}