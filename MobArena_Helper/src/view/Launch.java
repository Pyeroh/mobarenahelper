package view;

import model.enums.EItem;


public class Launch {

	public static void main(String[] args) throws Exception {
		/*UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		new MenuPrincipal();*/
		
		EItem[] values = EItem.values();
		for(int i=0;i<values.length;i++){
			System.out.println(values[i].getName()+" : "+values[i].getImage().toString());
		}
		
		/*Yaml yaml = new Yaml();
		ArrayList<String> test = new ArrayList<>();
		test.add("test1");
		test.add("test2");
		test.add("test3");
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("test", test);
		System.out.println(yaml.dumpAsMap(map));*/
	}

}