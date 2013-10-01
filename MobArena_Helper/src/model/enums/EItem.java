package model.enums;

import java.util.ArrayList;

public enum EItem {
	
	arc(0,0,"bow",EItemCat.weapon);
	
	private int id;
	private int meta;
	private String name;
	private EItemCat category;
	
	private EItem(int id, int meta, String name, EItemCat category) {
		this.id = id;
		this.meta = meta;
		this.name = name;
		this.category = category;
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
	
	public ArrayList<EItem> getByCategory(EItemCat category) {
		
		
		return null;
	}
	
}
