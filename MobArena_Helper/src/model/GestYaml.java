package model;

import java.io.*;
import java.util.*;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;

/**
 * Gestionnaire YAML. Gère en réalité l'instanciation du {@link Yaml} et la récupération des données dans une
 * LinkedHashMap.
 *
 * @author Pyeroh
 */
public class GestYaml {

	private LinkedHashMap<String, Object> data;

	private Yaml yaml;

	public static GestYaml S_gestionnaire;

	private GestYaml() {
		DumperOptions options = new DumperOptions();
		options.setIndent(4);
		yaml = new Yaml(options);
	}

	/**
	 * Instancie un gestionnaire Yaml avec un objet InputStream
	 *
	 * @param io
	 */
	@SuppressWarnings("unchecked")
	public GestYaml(InputStream io) {
		this();
		data = (LinkedHashMap<String, Object>) yaml.load(io);
	}

	/**
	 * Instancie un gestionnaire Yaml à partir du fichier Yaml associé
	 *
	 * @param file
	 */
	@SuppressWarnings("unchecked")
	public GestYaml(File file) {
		this();
		try {
			data = (LinkedHashMap<String, Object>) yaml.load(new FileInputStream(file));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Instancie un gestionnaire Yaml à partir du chemin du fichier Yaml associé
	 *
	 * @param chemin
	 */
	@SuppressWarnings("unchecked")
	public GestYaml(String chemin) {
		this();
		try {
			File file = new File(chemin);
			data = (LinkedHashMap<String, Object>) yaml.load(new FileInputStream(file));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Utilisé pour gérer les Map YAML issues d'un fichier
	 *
	 * @param map
	 */
	public GestYaml(Map<String, Object> map) {
		this();
		data = (LinkedHashMap<String, Object>) map;
	}

	/**
	 * Récupère une valeur pour une clé, en descendant dans l'arborescence avec des points (ex : node1.node2)
	 *
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Object get(String key) {
		String[] arbokey = key.split("[.]");
		Map<String, Object> mapvalue = data;
		for (int i = 0; i < arbokey.length - 1; i++) {
			mapvalue = (Map<String, Object>) mapvalue.get(arbokey[i]);
		}
		Object value = mapvalue.get(arbokey[arbokey.length - 1]);
		return value;
	}

	public LinkedHashMap<String, Object> getData() {
		return data;
	}

	/**
	 * Renvoie une chaîne à partir de la clé d'accès
	 *
	 * @param key
	 *            peut être composée de '.', chacun indiquant un niveau dans l'arborescence YAML
	 * @return la valeur pour la clé passée en paramètre
	 */
	public String getString(String key) {
		return (String) get(key);
	}

	/**
	 * Renvoie un entier à partir de la clé d'accès
	 *
	 * @param key
	 *            peut être composée de '.', chacun indiquant un niveau dans l'arborescence YAML
	 * @return la valeur pour la clé passée en paramètre
	 */
	public int getInt(String key) {
		return (int) get(key);
	}

	/**
	 * Renvoie un booléen à partir de la clé d'accès
	 *
	 * @param key
	 *            peut être composée de '.', chacun indiquant un niveau dans l'arborescence YAML
	 * @return la valeur pour la clé passée en paramètre
	 */
	public boolean getBool(String key) {
		return Boolean.parseBoolean(get(key).toString());
	}

	/**
	 * Renvoie une Map à partir de la clé d'accès
	 *
	 * @param key
	 *            peut être composée de '.', chacun indiquant un niveau dans l'arborescence YAML
	 * @return la valeur pour la clé passée en paramètre
	 */
	@SuppressWarnings("unchecked")
	public LinkedHashMap<String, Object> getMap(String key) {
		return (LinkedHashMap<String, Object>) get(key);
	}

	/**
	 * Renvoie une List à partir de la clé d'accès
	 *
	 * @param key
	 *            peut être composée de '.', chacun indiquant un niveau dans l'arborescence YAML
	 * @return la valeur pour la clé passée en paramètre
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<String> getList(String key) {
		return (ArrayList<String>) get(key);
	}

	/**
	 * Renvoie le tag du noeud correspondant au dernier noeud de la clé d'accès
	 *
	 * @param key
	 *            peut être composée de '.', chacun indiquant un niveau dans l'arborescence YAML
	 * @return le tag du dernier noeud de la clé
	 */
	public Tag getTag(String key) {
		return yaml.represent(get(key)).getTag();
	}

	/**
	 * Renvoie le tag de la Map du gestionnaire YAML en cours
	 *
	 * @return
	 */
	public Tag getTag() {
		return yaml.represent(data).getTag();
	}

	/**
	 * Renvoie le gestionnaire associé à la clé passée en paramètre
	 *
	 * @param key
	 * @return
	 */
	public GestYaml getGest(String key) {
		return new GestYaml(getMap(key));
	}

	/**
	 * Effectue un dump de la Map du gestionnaire en cours
	 *
	 * @return la chaîne de caractères complète représentant la Map du gestionnaire
	 */
	public String dump() {
		return yaml.dumpAsMap(data);
	}

	public String dump(String key) {
		if (get(key) instanceof String)
			return getString(key);
		else
			return yaml.dumpAsMap(getMap(key));
	}

	/**
	 * Réalise un dump de la Map chargée dans le fichier passé en paramètre
	 *
	 * @param file
	 *            le fichier dans lequel on écrit
	 * @throws IOException
	 *             exception à gérer pour l'écriture dans le fichier
	 */
	public void dumpAsFile(FileWriter file) throws IOException {

		file.write("# MobArena v0.95.5 - Config-file" + "\n");
		file.write("# Read the Wiki for details on how to set up this file: http://goo.gl/F5TTc" + "\n");
		file.write("# Note: You -must- use spaces instead of tabs!" + "\n");
		file.write("# Config file generated by Pyeroh's " + Messages.getString("MenuPrincipal.this.title") + "\n");

		file.write(dump());
		file.close();

	}

	/**
	 * Est-ce que la Map du gestionnaire contient la clé passée en paramètre ?
	 *
	 * @param key
	 * @return
	 */
	public boolean containsKey(String key) {
		if (data != null)
			return (data.containsKey(key) || get(key) != null);
		else
			return false;
	}

}
