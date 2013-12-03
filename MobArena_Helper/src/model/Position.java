package model;

public class Position {
	
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