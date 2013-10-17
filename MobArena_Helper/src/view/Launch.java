package view;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.UIManager;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.MappingNode;



public class Launch {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		new MenuPrincipal();
		
		LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
		data.put("classes", "Knight : bidule, machin");
		data.put("arenas", new LinkedHashMap<String, Object>());
		System.out.println(((MappingNode)(new Yaml().represent(data))).getValue());
		
		
		
		/*EItem[] values = EItem.values();
		for(int i=0;i<values.length;i++){
			System.out.println(values[i].getName()+" : "+values[i].getImage().toString());
		}*/
		
		Yaml yaml = new Yaml();
		ArrayList<String> test = new ArrayList<>();
		test.add("test1");
		test.add("test2");
		test.add("test3");
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("test", test);
		System.out.println(yaml.dumpAsMap(map));
		//System.out.println(yaml.compose(new FileReader(file)).getTag().getClassName());
	}

}