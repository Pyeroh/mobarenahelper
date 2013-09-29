package model;

import java.util.Map;

import model.enums.ETypeW;

public class OtherW extends Wave {

	private Map<String, Object> defvague;
	
	public OtherW(String nom, Map<String, Object> defvague, ETypeW type) {
		super(nom, type);
		this.defvague = defvague;
	}

	public Map<String, Object> getDefvague() {
		return defvague;
	}

	public void setDefvague(Map<String, Object> defvague) {
		this.defvague = defvague;
	}

}
