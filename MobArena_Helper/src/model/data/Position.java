package model.data;

import java.io.Serializable;

public class Position implements Serializable, Comparable<Position> {

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

	@Override
	public int compareTo(Position other) {

		int xCompare = Float.compare(x, other.x);
		int yCompare = Float.compare(y, other.y);
		int zCompare = Float.compare(z, other.z);
		if (xCompare == 0) {
			if (zCompare == 0) {
				if (yCompare == 0) {
					return 0;
				}
				else {
					return yCompare;
				}
			}
			else {
				return zCompare;
			}
		}
		else {
			return xCompare;
		}

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Position)) {
			return false;
		}
		Position other = (Position) obj;
		if (compareTo(other) != 0) {
			return false;
		}
		return true;
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

	public String getName() {
		return (int) Math.floor(x) + "," + (int) Math.floor(y) + "," + (int) Math.floor(z);
	}

	public String toString() {
		return String.format("%.0f,%.0f,%.0f,%s,%s", x, y, z,  angle, pitch) + (world != null ? "," + world : "");
	}

}