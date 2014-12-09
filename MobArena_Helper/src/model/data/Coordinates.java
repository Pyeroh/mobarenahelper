package model.data;

import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

import model.GestYaml;

public class Coordinates implements Serializable {

	private static final long serialVersionUID = 1493476666483082732L;

	private Position p1 = null, p2 = null, l1 = null, l2 = null, arena = null, lobby = null, spectator = null, leaderboard = null, exit = null;

	private LinkedHashMap<String, Position> spawnpoints = null;

	private LinkedHashMap<String, Position> containers = null;

	public Coordinates(GestYaml gcoords) throws Exception {
		if (gcoords.containsKey("p1"))
			p1 = new Position(gcoords.getString("p1"));
		if (gcoords.containsKey("p2"))
			p2 = new Position(gcoords.getString("p2"));
		if (gcoords.containsKey("l1"))
			l1 = new Position(gcoords.getString("l1"));
		if (gcoords.containsKey("l2"))
			l2 = new Position(gcoords.getString("l2"));
		if (gcoords.containsKey("arena"))
			arena = new Position(gcoords.getString("arena"));
		if (gcoords.containsKey("lobby"))
			lobby = new Position(gcoords.getString("lobby"));
		if (gcoords.containsKey("spectator"))
			spectator = new Position(gcoords.getString("spectator"));
		if (gcoords.containsKey("leaderboard"))
			leaderboard = new Position(gcoords.getString("leaderboard"));
		if (gcoords.containsKey("exit"))
			exit = new Position(gcoords.getString("exit"));
		if (gcoords.containsKey("spawnpoints")) {
			spawnpoints = new LinkedHashMap<>();
			LinkedHashMap<String, Object> sp = gcoords.getMap("spawnpoints");
			for (Iterator<String> it = sp.keySet().iterator(); it.hasNext();) {
				String pos = (String) it.next();
				spawnpoints.put(pos, new Position(gcoords.getString("spawnpoints." + pos)));
			}
			sortPositionMap(spawnpoints);
		}
		if (gcoords.containsKey("containers")) {
			containers = new LinkedHashMap<>();
			LinkedHashMap<String, Object> sp = gcoords.getMap("containers");
			for (Iterator<String> it = sp.keySet().iterator(); it.hasNext();) {
				String pos = (String) it.next();
				containers.put(pos, new Position(gcoords.getString("containers." + pos)));
			}
			sortPositionMap(containers);
		}

	}

	public static void sortPositionMap(Map<String, Position> map) {
		ArrayList<Map.Entry<String, Position>> list = new ArrayList<Map.Entry<String, Position>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Position>>() {

			@Override
			public int compare(Entry<String, Position> o1, Entry<String, Position> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		map.clear();
		for (Iterator<Entry<String, Position>> it = list.iterator(); it.hasNext();) {
			Entry<String, Position> entry = (Entry<String, Position>) it.next();
			map.put(entry.getKey(), entry.getValue());
		}
	}

	public Position getP1() {
		return p1;
	}

	public Position getP2() {
		return p2;
	}

	public Position getL1() {
		return l1;
	}

	public Position getL2() {
		return l2;
	}

	public Position getArena() {
		return arena;
	}

	public Position getLobby() {
		return lobby;
	}

	public Position getSpectator() {
		return spectator;
	}

	public Position getLeaderboard() {
		return leaderboard;
	}

	public Position getExit() {
		return exit;
	}

	public LinkedHashMap<String, Position> getSpawnpoints() {
		return spawnpoints;
	}

	public LinkedHashMap<String, Position> getContainers() {
		return containers;
	}

	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> coords = new LinkedHashMap<>();

		if (l1 != null) {
			coords.put("l1", l1.toString());
		}
		if (l2 != null) {
			coords.put("l2", l2.toString());
		}
		if (lobby != null) {
			coords.put("lobby", lobby.toString());
		}
		if (spectator != null) {
			coords.put("spectator", spectator.toString());
		}
		if (p1 != null) {
			coords.put("p1", p1.toString());
		}
		if (p2 != null) {
			coords.put("p2", p2.toString());
		}
		if (arena != null) {
			coords.put("arena", arena.toString());
		}
		if (leaderboard != null) {
			coords.put("leaderboard", leaderboard.toString());
		}
		if (exit != null) {
			coords.put("exit", exit.toString());
		}
		if (spawnpoints != null) {
			LinkedHashMap<String, Object> spawnpoints = new LinkedHashMap<>();
			for (String spawnpoint : this.spawnpoints.keySet()) {
				spawnpoints.put(spawnpoint, this.spawnpoints.get(spawnpoint).toString());
			}
			coords.put("spawnpoints", spawnpoints);
		}
		if (containers != null) {
			LinkedHashMap<String, Object> containers = new LinkedHashMap<>();
			for (String container : this.containers.keySet()) {
				containers.put(container, this.containers.get(container).toString());
			}
			coords.put("containers", containers);
		}

		return coords;
	}

}