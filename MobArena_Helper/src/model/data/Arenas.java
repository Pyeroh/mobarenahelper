package model.data;

import java.io.Serializable;
import java.util.*;

import model.GestYaml;
import model.exceptions.ArenaException;

import org.yaml.snakeyaml.nodes.Tag;

/**
 * Un groupe d'arènes. Est généralement chargé à partir d'un fichier, et est dans tous les cas intégré à un seul fichier
 * à la sauvegarde des données.
 *
 * @author Pyeroh
 * @see Arena
 */
public class Arenas implements Serializable {

	private static final long serialVersionUID = -929527876390581159L;

	private transient LinkedHashMap<String, Object> globalsettings = new LinkedHashMap<String, Object>();

	private transient LinkedHashMap<String, Object> listclasses;

	private transient LinkedHashMap<String, Object> listarenas;

	private ArrayList<Arena> arraylistarenas = new ArrayList<Arena>();

	private GlobalSettings settings = new GlobalSettings();

	/**
	 * Instancie un groupe d'arènes et charge chacune d'elle dans une ArrayList d'Arena, chaque Arena ayant un nom et
	 * des vagues (voir description Arena)
	 *
	 * @param listarenas
	 *            la liste des arènes
	 * @param globalsettings
	 *            les settings généraux du fichier
	 * @param listclasses
	 *            les classes dans les settings du fichier
	 * @throws ArenaException
	 */
	public Arenas(LinkedHashMap<String, Object> listarenas, LinkedHashMap<String, Object> globalsettings, LinkedHashMap<String, Object> listclasses) throws ArenaException {
		this.listarenas = listarenas;
		this.globalsettings = globalsettings;
		this.listclasses = listclasses;
		load();
	}

	/**
	 * Instance un nouveau groupe d'arènes, vide. Les ArrayList pour les arènes et les classes sont déjà instanciées,
	 * les LinkedHashMap des paramètres sont à {@code null}.
	 */
	public Arenas() {
	}

	public LinkedHashMap<String, Object> getListclasses() {
		return listclasses;
	}

	public LinkedHashMap<String, Object> getListarenas() {
		return listarenas;
	}

	public ArrayList<Classe> getALclasses() {
		return Classe.classe_list;
	}

	public ArrayList<Arena> getALarenas() {
		return arraylistarenas;
	}

	public GlobalSettings getGlobalSettings() {
		return settings;
	}

	public boolean containsArena(String name) {
		boolean contains = false;
		for (int i = 0; i < arraylistarenas.size(); i++) {
			if (arraylistarenas.get(i).getNom().equalsIgnoreCase(name)) {
				contains = true;
			}
		}
		return contains;
	}

	public void addClassForLimit(Classe classe) {
		for (int i = 0; i < arraylistarenas.size(); i++) {
			arraylistarenas.get(i).addClass(classe);
		}
	}

	public void removeClassForLimit(Classe classe) {
		for (int i = 0; i < arraylistarenas.size(); i++) {
			arraylistarenas.get(i).removeClass(classe);
		}
	}

	private void load() throws ArenaException {
		settings = new GlobalSettings(globalsettings);

		GestYaml gclasse = new GestYaml(listclasses);
		if (gclasse.getTag() != Tag.NULL) {
			// Extraction des classes
			for (Iterator<String> it = listclasses.keySet().iterator(); it.hasNext();) {
				String nomclasse = (String) it.next();
				new Classe(nomclasse, gclasse.getMap(nomclasse));
			}
		}
		GestYaml garena = new GestYaml(listarenas);
		// Extraction des arènes
		for (Iterator<String> it = listarenas.keySet().iterator(); it.hasNext();) {
			String arena = (String) it.next();
			arraylistarenas.add(new Arena(arena, garena.getMap(arena)));
		}
	}

	/**
	 * Renvoie la Map des informations du groupe d'arènes (la combinaison des informations de toutes les arènes).
	 *
	 * @return
	 * @throws ArenaException
	 */
	public LinkedHashMap<String, Object> getMap() throws ArenaException {
		LinkedHashMap<String, Object> listarenas = new LinkedHashMap<String, Object>();
		for (int i = 0; i < arraylistarenas.size(); i++) {
			Arena lArene = arraylistarenas.get(i);
			listarenas.put(lArene.getNom(), lArene.getMap());
		}

		LinkedHashMap<String, Object> listclasses = new LinkedHashMap<String, Object>();
		for (int i = 0; i < getALclasses().size(); i++) {
			Classe classe = getALclasses().get(i);
			if (!classe.getName().equals("all")) {
				listclasses.put(classe.getName(), classe.getMap());
			}
		}

		LinkedHashMap<String, Object> file = new LinkedHashMap<String, Object>();
		file.put("global-settings", settings.getMap());

		if (!listclasses.isEmpty()) {
			file.put("classes", listclasses);
		}
		else
			throw new ArenaException("Classes must be provided !");
		file.put("arenas", listarenas);

		return file;
	}

}
