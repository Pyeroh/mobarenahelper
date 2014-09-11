package model.lists;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import model.data.*;

/**
 * Liste des limites de classe pour une arène
 *
 * @author Pyeroh
 *
 */
public class ClassLimitList extends ArrayList<ClassLimit> {

	private static final long serialVersionUID = -4260267733587193197L;

	/**
	 * Renvoie une limite de classe par rapport à la classe passée en paramètre; null sinon
	 *
	 * @param classe
	 *            la classe cherchée
	 * @return la limite de classe attendue
	 */
	public ClassLimit get(Classe classe) {
		int i = 0;
		if (!isEmpty()) {
			while (i < size() && get(i).getClasse() != classe)
				i++;
			if (i < this.size())
				return get(i);
		}
		return null;
	}

	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		for (int i = 0; i < size(); i++) {
			ClassLimit cl = get(i);
			map.put(cl.getClasse().getName(), cl.getLimit());
		}
		return map;
	}

}
