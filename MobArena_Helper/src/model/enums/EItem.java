package model.enums;

import java.util.ArrayList;

public enum EItem {
	
	stone(1,0,"stone",EItemCat.block),
	grass(0,0,null,null),
	dirt(0,0,null,null),
	cobblestone(0,0,null,null),
	oakplank(0,0,null,null),
	redplank(0,0,null,null),
	birchplank(0,0,null,null),
	jungleplank(0,0,null,null),
	oaksapling(0,0,null,null),
	redsapling(0,0,null,null),
	birchsapling(0,0,null,null),
	junglesapling(0,0,null,null),
	sand(0,0,null,null),
	gravel(0,0,null,null),
	goldore(0,0,null,null),
	ironore(0,0,null,null),
	coalore(0,0,null,null),
	oakwood(0,0,null,null),
	redwood(0,0,null,null),
	birchwood(0,0,null,null),
	junglewood(0,0,null,null),
	oakleaf(0,0,null,null),
	redleaf(0,0,null,null),
	birchleaf(0,0,null,null),
	jungleleaf(0,0,null,null),
	glass(0,0,null,null),
	lapisore(0,0,null,null),
	lapisblock(0,0,null,null),
	dull(0,0,null,null),
	;
	
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
		EItem[] values = values();
		ArrayList<EItem> items = new ArrayList<>();
		
		for(int i=0;i<values.length;i++) {
			EItem item = values[i];
			if(item.getCategory()==category){
				items.add(item);
			}
			
		}
		
		return null;
	}
	
}
