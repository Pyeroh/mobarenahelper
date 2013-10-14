package model.wave;

import java.util.Map;

import model.Wave;
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

}
