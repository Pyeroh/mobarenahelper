package model;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class Coordinates {

	private Position 
		p1 = null,
		p2 = null,
		l1 = null,
		l2 = null,
		arena = null,
		lobby = null,
		spectator = null;
	private LinkedHashMap<String, Object> spawnpoints = null;

	public Coordinates(GestYaml gcoords) throws Exception {
		if(gcoords.containsKey("p1")) p1 = new Position(gcoords.getString("p1"));
		if(gcoords.containsKey("p2")) p2 = new Position(gcoords.getString("p2"));
		if(gcoords.containsKey("l1")) l1 = new Position(gcoords.getString("l1"));
		if(gcoords.containsKey("l2")) l2 = new Position(gcoords.getString("l2"));
		if(gcoords.containsKey("arena")) arena = new Position(gcoords.getString("arena"));
		if(gcoords.containsKey("lobby")) lobby = new Position(gcoords.getString("lobby"));
		if(gcoords.containsKey("spectator")) l2 = new Position(gcoords.getString("spectator"));
		if(gcoords.containsKey("spawnpoints")) {
			spawnpoints = new LinkedHashMap<>();
			LinkedHashMap<String, Object> sp = gcoords.getMap("spawnpoints");
			for (Iterator<String> it = sp.keySet().iterator(); it.hasNext();) {
				String pos = (String) it.next();
				spawnpoints.put(pos, new Position(gcoords.getString("spawnpoints."+pos)));
			}
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

	public LinkedHashMap<String, Object> getSpawnpoints() {
		return spawnpoints;
	}

}

class Position {
	
	private int x,y,z;
	private double angle;
	private double pitch;
	
	public Position(String pos) {
		String[] coords = pos.split(",");
		x = Integer.parseInt(coords[0]);
		y = Integer.parseInt(coords[1]);
		z = Integer.parseInt(coords[2]);
		angle = Double.parseDouble(coords[3]);
		pitch = Double.parseDouble(coords[4]);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public double getAngle() {
		return angle;
	}

	public double getPitch() {
		return pitch;
	}
	
	public String toString() {
		return x+","+y+","+z+","+angle+","+pitch;
	}

}