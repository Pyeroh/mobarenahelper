package view.cells;

import model.data.Classe;

public class CellListClass extends CellListCaracs {

	private static final long serialVersionUID = -5691967785973684865L;

	private Classe classe;

	public CellListClass(Classe classe) {
		super(classe.getName());
		this.classe = classe;
	}

	public Classe getClasse() {
		return classe;
	}

}
