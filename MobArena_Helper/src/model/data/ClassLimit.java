package model.data;

import java.io.Serializable;

public class ClassLimit implements Serializable {

	private static final long serialVersionUID = -8323029982213296029L;

	private Classe classe;

	private int limit;

	public ClassLimit(Classe classe, int limit) {
		this.classe = classe;
		this.limit = limit;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
