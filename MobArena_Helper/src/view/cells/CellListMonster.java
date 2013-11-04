package view.cells;

import model.Monstre;
import model.lists.MonsterList;

public class CellListMonster extends CellListCaracs {

	private static final long serialVersionUID = 982513681138674941L;
	
	private Monstre monstre;
	
	public CellListMonster(MonsterList monsterlist, int index) {
		super("");
		
		monstre = monsterlist.get(index);
		int proba = Math.round((((float)monstre.getProbability())/((float)monsterlist.getTotalNumber()))*100);
		lib_desc.setText(" "+monstre.getMonstre().getNom()+" ("+monstre.getProbability()+" ~= "+proba+"%)");
	}
	
	public Monstre getMonstre() {
		return monstre;
	}

}
