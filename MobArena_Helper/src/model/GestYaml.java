package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;

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
	 * @param io
	 */
	@SuppressWarnings("unchecked")
	public GestYaml(InputStream io) {
		this();
		data = (LinkedHashMap<String, Object>) yaml.load(io);
	}

	/**
	 * Instancie un gestionnaire Yaml à partir du fichier Yaml associé
	 * @param file
	 */
	@SuppressWarnings("unchecked")
	public GestYaml(File file) {
		this();
		try {
			data = (LinkedHashMap<String, Object>) yaml.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Instancie un gestionnaire Yaml à partir du chemin du fichier Yaml associé
	 * @param chemin
	 */
	@SuppressWarnings("unchecked")
	public GestYaml(String chemin) {
		this();
		try {
			File file = new File(chemin);
			data = (LinkedHashMap<String, Object>) yaml.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Utilisé pour gérer les Map YAML issues d'un fichier
	 * @param map
	 */
	public GestYaml(Map<String, Object> map) {
		this();
		data = (LinkedHashMap<String, Object>) map;
	}

	/*public GestYaml(ArrayList<Wave> map) {

		data = new LinkedHashMap<String, Object>();
		for(int i=0;i<map.size();i++) {

		}

	}*/

	@SuppressWarnings("unchecked") 
	protected Object get(String key) {
		String[] arbokey = key.split("[.]");
		Map<String, Object> mapvalue = data;
		for (int i=0;i<arbokey.length-1;i++) {
			mapvalue = (Map<String, Object>)mapvalue.get(arbokey[i]);
		}
		Object value = mapvalue.get(arbokey[arbokey.length-1]);
		return value;
	}

	public String getString(String key) {
		return (String) get(key);
	}

	public int getInt(String key) {
		return (int) get(key);
	}

	public boolean getBool(String key) {
		return Boolean.parseBoolean((String) get(key));
	}

	@SuppressWarnings("unchecked")
	public LinkedHashMap<String, Object> getMap(String key) {
		return (LinkedHashMap<String, Object>) get(key);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getList(String key) {
		return (ArrayList<String>) get(key);
	}
	
	public Tag getTag(String key) {
		return yaml.represent(getMap(key)).getTag();
	}

	public String dump() {
		return yaml.dumpAsMap(data);
	}

	public void dumpAsFile(FileWriter file) throws IOException {
		String dump = dump();
		String[] ligdump = dump.split("\n");
		
		file.write("# MobArena v0.95.5 - Config-file"+"\n");
		file.write("# Read the Wiki for details on how to set up this file: http://goo.gl/F5TTc"+"\n");
		file.write("# Note: You -must- use spaces instead of tabs!"+"\n");

		for(int i=0;i<ligdump.length;i++){
			file.write(ligdump[i]+"\n");
		}
		file.close();

	}

}
