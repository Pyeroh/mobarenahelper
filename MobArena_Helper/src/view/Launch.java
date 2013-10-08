package view;

import javax.swing.UIManager;

public class Launch {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		new MenuPrincipal();
		
		/*Yaml yaml = new Yaml();
		String test = "- test1\n- test2\n- test3";
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("test", yaml.load(test));
		System.out.println(yaml.dumpAsMap(map));*/
	}

}