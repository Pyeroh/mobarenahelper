package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;


public class Arenas {
	
	private LinkedHashMap<String, Object> globalsettings;
	private LinkedHashMap<String, Object> listclasses;
	private LinkedHashMap<String, Object> listarenas;
	private ArrayList<Classe> classes = new ArrayList<Classe>();
	private ArrayList<Arena> arraylistarenas = new ArrayList<Arena>();
	
	/**
	 * Instancie un groupe d'ar�nes et charge chacune d'elle dans une ArrayList d'Arena,
	 * chaque Arena ayant un nom et des vagues (voir description Arena)
	 * @param listarenas la liste des ar�nes
	 * @param globalsettings les settings g�n�raux du fichier
	 * @param classes les classes dans les settings du fichier
	 */
	public Arenas(LinkedHashMap<String, Object> listarenas, LinkedHashMap<String, Object> globalsettings, LinkedHashMap<String, Object> listclasses) {
		this.listarenas = listarenas;
		this.globalsettings = globalsettings;
		this.listclasses = listclasses;
		load();
	}

	public LinkedHashMap<String, Object> getListclasses() {
		return listclasses;
	}

	public LinkedHashMap<String, Object> getListarenas() {
		return listarenas;
	}
	
	public ArrayList<Arena> getALarenas() {
		return arraylistarenas;
	}
	
	private void load(){
		GestYaml g = new GestYaml(listarenas);
		//Extraction des ar�nes
		for (Iterator<String> it = listarenas.keySet().iterator(); it.hasNext();) {
			String arena = (String) it.next();
			arraylistarenas.add(new Arena(arena, g.getMap(arena)));
		}
	}
	
	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> arenas = new LinkedHashMap<>();
		for(int i=0;i<arraylistarenas.size();i++) {
			Arena lArene = arraylistarenas.get(i);
			arenas.put(lArene.getNom(), lArene.getMap());
		}
		
		LinkedHashMap<String, Object> file = new LinkedHashMap<>();
		file.put("global-settings", globalsettings);
		
		//TODO Modifier la gestion de l'ajout des classes
		file.put("classes", classes);
		
		file.put("arenas", arenas);
		
		return file;
	}

}
