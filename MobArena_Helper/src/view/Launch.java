package view;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.yaml.snakeyaml.Yaml;

public class Launch {

	public static void main(String[] args) throws Exception {
		/*UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		new MenuPrincipal();*/
		
		Yaml yaml = new Yaml();
		ArrayList<String> test = new ArrayList<>();
		test.add("test1");
		test.add("test2");
		test.add("test3");
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("test", test);
		System.out.println(yaml.dumpAsMap(map));
	}

}