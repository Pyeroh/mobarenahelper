package view.cells;

import model.enums.EAbilities;

public class CellListAbility extends CellListCaracs {

	private static final long serialVersionUID = 145152984998921330L;
	private EAbilities ability;
	
	public CellListAbility(EAbilities ability) {
		super(" "+ability.getNom());
		
		this.ability = ability;
	}
	
	public EAbilities getAbility() {
		return ability;
	}

}
