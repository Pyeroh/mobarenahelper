package view.cells;

import model.Classe;

public class CellListClass extends CellListCaracs {

	private static final long serialVersionUID = -5691967785973684865L;
	private Classe classe;
	
	public CellListClass(Classe classe) {
		super();
		this.classe = classe;
		
		lib_desc.setText(this.classe.getName());
	}

}
