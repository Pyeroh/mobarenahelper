package model.enums;

public enum EItemCat {
	all("All"),
	block("Building blocks"),
	decoration("Decoration blocks"),
	redstone("Redstone"),
	transport("Transportation"),
	misc("Miscellaneous"),
	food("Foodstuffs"),
	tool("Tools"),
	weapon("Combat"),
	potion("Brewing"),
	materials("Materials");
	
	private String gui_name;
	
	EItemCat(String gui_name) {
		this.gui_name = gui_name;
	}

	public String getGui_name() {
		return gui_name;
	}
	
	public static String[] namevalues(){

		EItemCat[] values = values();
		String[] namevalues = new String[values.length];
		for (int i=0;i<namevalues.length;i++) {
			namevalues[i] = values[i].getGui_name();
		}
		return namevalues;
	}
	
	public static EItemCat getByName(String name) {

		if (name!=null) {
			EItemCat[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getGui_name().equals(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			} else {
				throw new IllegalArgumentException(
						"No enum constant EItemCat." + name);
			}
		}
		else {
			throw new NullPointerException("Name is null");
		}

	}

}
