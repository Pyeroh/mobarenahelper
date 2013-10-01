package model.enums;

public enum EItem {
	
	arc(0,0,"bow",EItemCat.arme);
	
	private int id;
	private int meta;
	private String name;
	private EItemCat category;
	
	private EItem(int id, int meta, String name, EItemCat category) {
		
	}

	public int getId() {
		return id;
	}

	public int getMeta() {
		return meta;
	}

	public String getName() {
		return name;
	}

	public EItemCat getCategory() {
		return category;
	}
	
}
