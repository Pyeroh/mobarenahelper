package model.enums;

public enum EItemCat {
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

}
