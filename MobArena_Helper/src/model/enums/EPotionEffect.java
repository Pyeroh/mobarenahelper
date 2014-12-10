package model.enums;

import java.awt.Image;

import javax.swing.ImageIcon;

import model.EnumName;

// TODO see http://jd.bukkit.org/rb/apidocs/org/bukkit/potion/PotionEffectType.html
public enum EPotionEffect {

	speed(1),
	slowness(2),
	haste(3),
	mining_fatigue(4),
	strength(5),
	instant_health(6),
	instant_damage(7),
	jump_boost(8),
	nausea(9),
	regeneration(10),
	resistance(11),
	fire_resistance(12),
	water_breathing(13),
	invisibility(14),
	blindness(15),
	night_vision(16),
	hunger(17),
	weakness(18),
	poison(19),
	wither(20),
	health_boost(21),
	absorption(22),
	saturation(23);

	private int id;

	private Image image = null;

	private EPotionEffect(int id) {
		this.id = id;

		StringBuffer imagepath = new StringBuffer("gui/eitems/potions/effects/" + name() + ".png");
		this.image = new ImageIcon(getClass().getClassLoader().getResource(imagepath.toString())).getImage();

	}

	public int getId() {
		return id;
	}

	public Image getImage() {
		return image;
	}

	/**
	 * Renvoie le nom correctement formaté pour l'affichage
	 *
	 * @return le nom correctement formaté pour l'affichage
	 */
	public String getGuiName() {
		return EnumName.getString("EPotionEffect." + id);
	}

	@Override
	public String toString() {
		 return name() + " (" + id + ")";
	}

	public static EPotionEffect searchById(int id) {
		EPotionEffect[] values = values();
		int i = 0;
		while (i < values.length && values[i].id != id) {
			i++;
		}
		if (i < values.length) {
			return values[i];
		}
		else {
			return null;
		}
	}

}
