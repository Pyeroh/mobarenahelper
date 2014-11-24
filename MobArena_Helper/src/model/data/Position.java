package model.data;

import java.io.Serializable;

public class Position implements Serializable {

	private static final long serialVersionUID = 2488303329590693508L;

	private float x, y, z;

	private double angle;

	private double pitch;

	private String world;

	public Position(String pos) {
		String[] coords = pos.split(",");
		x = Float.parseFloat(coords[0]);
		y = Float.parseFloat(coords[1]);
		z = Float.parseFloat(coords[2]);
		angle = Double.parseDouble(coords[3]);
		pitch = Double.parseDouble(coords[4]);
		if (coords.length >= 6) {
			world = coords[5];
		}
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public double getAngle() {
		return angle;
	}

	public double getPitch() {
		return pitch;
	}

	public String getWorld() {
		return world;
	}

	public String toString() {
		return x + "," + y + "," + z + "," + angle + "," + pitch + (world != null ? "," + world : "");
	}

}