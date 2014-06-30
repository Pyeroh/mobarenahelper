package model.wave;

import java.io.Serializable;
import java.util.*;

import model.*;
import model.lists.*;

/**
 * Un set d'upgrade est la combinaison d'une vague Upgrade et d'une classe. Pour une certaine classe, il est possible
 * d'améliorer de l'équipement, des objets, de donner des permissions. On peut retrouver plusieurs UpgradeSet dans une
 * vague Upgrade.
 *
 * @author Pyeroh
 * @see UpgradeW
 */
public class UpgradeSet implements Serializable {

	private static final long serialVersionUID = 3588098791670748965L;

	/**
	 * Le setup d'un set d'upgrade permet de savoir si c'est simple ({@link #legacy}) ou avancé ({@link #advanced})
	 *
	 * @author Pyeroh
	 */
	public enum UpSetup {
		legacy,
		advanced;

		/**
		 * Renvoie la liste des noms des constantes.
		 *
		 * @return la liste des noms des constantes.
		 */
		public static String[] namevalues() {

			UpSetup[] values = values();
			String[] namevalues = new String[values.length];
			for (int i = 0; i < namevalues.length; i++) {
				String name = values[i].name();
				String first = name.charAt(0) + "";
				namevalues[i] = name.replaceFirst("^[a-z]", first.toUpperCase());
			}
			return namevalues;
		}

		public String toString() {
			String name = this.name();
			String first = name.charAt(0) + "";
			name = name.replaceFirst("^[a-z]", first.toUpperCase());
			return name;
		}
	}

	private UpSetup setup = UpSetup.legacy;

	private Classe classe;

	private ItemList items = new ItemList();

	private ArmorList armor = new ArmorList();

	private ArrayList<String> permissions = new ArrayList<String>();

	public UpgradeSet(UpSetup setup, Classe classe) {
		this.setup = setup;
		this.classe = classe;
	}

	public UpgradeSet(Classe classe) {
		this.classe = classe;
	}

	public UpSetup getSetup() {
		return setup;
	}

	public void setSetup(UpSetup setup) {
		this.setup = setup;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public ItemList getItems() {
		return items;
	}

	public void setItems(ItemList items) {
		this.items = items;
	}

	public ArmorList getArmor() {
		return armor;
	}

	public void setArmor(ArmorList armor) {
		this.armor = armor;
	}

	public ArrayList<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(ArrayList<String> permissions) {
		this.permissions = permissions;
	}

	/**
	 * Renvoie la "map" des informations relatives à l'upgradeSet.
	 *
	 * @return si la config de l'upgradeSet est simple, renvoie une chaîne. Sinon, renvoie une LinkedHashMap, seulement
	 *         si la liste des objets n'est pas la seule à être renseignée. Si on est dans ce cas là, à la réouverture
	 *         du fichier dans le MobArena_Helper, cet upgradeSet sera considéré legacy.
	 */
	public Object getMap() {
		LinkedHashMap<String, Object> lhMap = new LinkedHashMap<String, Object>();
		String sMap = null;
		switch (setup) {
		case legacy:
			lhMap = null;
			if (items.size() != 0) {
				sMap = items.getString();
			}
			else
				sMap = null;
			break;
		case advanced:
			int isize = items.size();
			int asize = armor.size();
			int psize = permissions.size();
			if (isize != 0 && asize == 0 && psize == 0) {
				lhMap = null;
				sMap = items.getString();
				break;
			}
			if (isize != 0 || asize != 0 || psize != 0) {
				if (asize != 0)
					lhMap.put("armor", armor.getString());
				if (isize != 0)
					lhMap.put("items", items.getString());
				if (psize != 0)
					lhMap.put("permissions", permissions);
			}
			else
				lhMap = null;
			break;
		default:
			break;
		}

		if (lhMap == null) {
			if (sMap == null) {
				return null;
			}
			else
				return sMap;
		}
		else
			return lhMap;
	}

	/**
	 * Instancie un upgradeSet et remplis complètement ses informations grâce à la Map.
	 *
	 * @param nom
	 *            le nom de la classe associée
	 * @param map
	 *            la map d'informations de la vague
	 * @return l'upgradeSet, avec ses informations complétées
	 * @throws ArenaException
	 */
	public static UpgradeSet setUpgradeSet(String nom_classe, LinkedHashMap<String, Object> map) throws ArenaException {
		GestYaml g = new GestYaml(map);
		UpgradeSet set = null;

		String tag = g.getTag(nom_classe).getClassName();
		ArrayList<Classe> classe_list = Classe.classe_list;
		int i = 0;
		while (!classe_list.get(i).getName().equals(nom_classe) && i < classe_list.size() - 1)
			i++;

		if (i < classe_list.size()) {
			switch (tag) {
			case "map":
				set = new UpgradeSet(UpSetup.advanced, classe_list.get(i));
				map = g.getMap(nom_classe);
				if (map.containsKey("armor")) {
					set.getArmor().fill(g.getString(nom_classe + ".armor"));
				}
				if (map.containsKey("items")) {
					set.getItems().fill(g.getString(nom_classe + ".items"));
				}
				if (map.containsKey("permissions")) {
					set.setPermissions(g.getList(nom_classe + ".permissions"));
				}
				break;
			case "str":
				set = new UpgradeSet(UpSetup.legacy, classe_list.get(i));
				set.getItems().fill(g.getString(nom_classe));
				break;
			default:
				break;
			}
			return set;
		}
		else
			return null;
	}

}