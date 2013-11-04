package model.lists;

import java.util.ArrayList;

import model.Monstre;
import model.enums.EMonsters;

public class MonsterList extends ArrayList<Monstre> {

	private static final long serialVersionUID = -7703494044357940586L;
	
	public int getTotalNumber() {
		int tot = 0;
		for(int i=0;i<this.size();i++){
			tot += this.get(i).getProbability();
		}
		
		return tot;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if (this.size()!=0) {
			for (int i = 0; i < this.size(); i++) {
				buffer.append("(" + this.get(i).toString() + ")/");
			}
			String ret = buffer.substring(0, buffer.length() - 1);
			return ret;
		}
		else {
			return "";
		}
	}
	
	public boolean contain(EMonsters monster){
		boolean contain = false;
		for(int i=0;i<this.size();i++){
			if(this.get(i).getMonstre()==monster){
				contain = true;
			}
		}
		return contain;
		
	}

}
