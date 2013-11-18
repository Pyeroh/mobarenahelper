package view;

import javax.swing.UIManager;

import model.enums.EItem;



public class Launch {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		new MenuPrincipal();
		
		EItem[] values = EItem.values();
		for(int i=0;i<values.length;i++) {
			EItem e = values[i];
			System.out.println("EItem."+e.getId()+"."+e.getMeta()+"="+e.getName());
		}
		
	}

}