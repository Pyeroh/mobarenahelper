package model;

import java.util.*;

/**
 * Un groupe d'ar�nes. Est g�n�ralement charg� � partir d'un fichier, et est dans tous les cas int�gr� � un seul fichier � la sauvegarde des donn�es.
 * @author Pyeroh
 * @see Arena
 */
public class Arenas {
	
	private LinkedHashMap<String, Object> globalsettings = new LinkedHashMap<>();
	private LinkedHashMap<String, Object> listclasses;
	private LinkedHashMap<String, Object> listarenas;
	private ArrayList<Arena> arraylistarenas = new ArrayList<Arena>();
	
	/**
	 * Instancie un groupe d'ar�nes et charge chacune d'elle dans une ArrayList d'Arena,
	 * chaque Arena ayant un nom et des vagues (voir description Arena)
	 * @param listarenas la liste des ar�nes
	 * @param globalsettings les settings g�n�raux du fichier
	 * @param listclasses les classes dans les settings du fichier
	 */
	public Arenas(LinkedHashMap<String, Object> listarenas, LinkedHashMap<String, Object> globalsettings, LinkedHashMap<String, Object> listclasses) {
		this.listarenas = listarenas;
		this.globalsettings = globalsettings;
		this.listclasses = listclasses;
		load();
	}

	/**
	 * Instance un nouveau groupe d'ar�nes, vide. Les ArrayList pour les ar�nes et les
	 * classes sont d�j� instanci�es, les LinkedHashMap des param�tres sont � {@code null}.
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
	
	public boolean containsArena(String name) {
		boolean contains = false;
		for(int i=0;i<arraylistarenas.size();i++) {
			if(arraylistarenas.get(i).getNom().equalsIgnoreCase(name)) {
				contains = true;
			}
		}
		return contains;
	}
	
	private void load(){
		GestYaml gclasse = new GestYaml(listclasses);
		//Extraction des classes
		for (Iterator<String> it = listclasses.keySet().iterator(); it.hasNext();) {
			String nomclasse = (String) it.next();
			new Classe(nomclasse, gclasse.getMap(nomclasse));
		}
		
		GestYaml garena = new GestYaml(listarenas);
		//Extraction des ar�nes
		for (Iterator<String> it = listarenas.keySet().iterator(); it.hasNext();) {
			String arena = (String) it.next();
			arraylistarenas.add(new Arena(arena, garena.getMap(arena)));
		}
	}
	
	/**
	 * Renvoie la Map des informations du groupe d'ar�nes (la combinaison des informations de toutes les ar�nes).
	 * @return
	 */
	public LinkedHashMap<String, Object> getMap() {
		listarenas = new LinkedHashMap<>();
		for(int i=0;i<arraylistarenas.size();i++) {
			Arena lArene = arraylistarenas.get(i);
			listarenas.put(lArene.getNom(), lArene.getMap());
		}
		
		listclasses = new LinkedHashMap<>();
		for(int i=0;i<getALclasses().size();i++) {
			Classe classe = getALclasses().get(i);
			if (!classe.getName().equals("all")) {
				listclasses.put(classe.getName(), classe.getMap());
			}
		}
		
		LinkedHashMap<String, Object> file = new LinkedHashMap<>();
		file.put("global-settings", globalsettings);
		
		file.put("classes", listclasses);
		file.put("arenas", listarenas);
		
		return file;
	}

}
