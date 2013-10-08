package model;

import java.util.ArrayList;
import model.enums.EItem;
import model.enums.ETypeW;

public class SupplyW extends Wave {

	private ArrayList<EItem> drops = new ArrayList<>();
	
	public SupplyW(String nom) {
		super(nom, ETypeW.Supply);
	}
	
	public ArrayList<EItem> getDrops() {
		return drops;
	}

}