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
	dropper(0,0,null,null),
	sandstone(0,0,null,null),
	sandstonechiseled(0,0,null,null),
	sandstonesmooth(0,0,null,null),
	noteblock(0,0,null,null),
	poweredrail(0,0,null,null),
	pressrail(0,0,null,null),
	pistonstick(0,0,null,null),
	cobweb(0,0,null,null),
	piston(0,0,null,null),
	woolwhite(0,0,null,null),
	woolorange(0,0,null,null),
	woolmagenta(0,0,null,null),
	woollblue(0,0,null,null),
	woolyellow(0,0,null,null),
	woollemon(0,0,null,null),
	woolpink(0,0,null,null),
	woolgray(0,0,null,null),
	woollgray(0,0,null,null),
	woolcyan(0,0,null,null),
	woolpurple(0,0,null,null),
	woolblue(0,0,null,null),
	woolbrown(0,0,null,null),
	woolgreen(0,0,null,null),
	woolred(0,0,null,null),
	woolblack(0,0,null,null),
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
