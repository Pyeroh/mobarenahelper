package model.enums;

import java.awt.Image;

import javax.swing.ImageIcon;

import model.EnumName;

public enum EPotionEffect {

	speed(1, "speed"),
	slowness(2, "slow"),
	haste(3, "fast_digging"),
	mining_fatigue(4, "slow_digging"),
	strength(5, "increase_damage"),
	instant_health(6, "heal"),
	instant_damage(7, "harm"),
	jump_boost(8, "jump"),
	nausea(9, "confusion"),
	regeneration(10, "regeneration"),
	resistance(11, "damage_resistance"),
	fire_resistance(12, "fire_resistance"),
	water_breathing(13, "water_breathing"),
	invisibility(14, "invisibility"),
	blindness(15, "blindness"),
	night_vision(16, "night_vision"),
	hunger(17, "hunger"),
	weakness(18, "weakness"),
	poison(19, "poison"),
	wither(20, "wither"),
	health_boost(21, "health_boost"),
	absorption(22, "absorption"),
	saturation(23, "saturation");

	private int id;

	private String realName;

	private Image image = null;

	private EPotionEffect(int id, String realName) {
		this.id = id;
		this.realName = realName;

		StringBuffer imagepath = new StringBuffer("gui/eitems/potions/effects/" + name() + ".png");
		this.image = new ImageIcon(getClass().getClassLoader().getResource(imagepath.toString())).getImage();

	}

	public int getId() {
		return id;
	}

	public Image getImage() {
		return image;
	}

	public String getRealName() {
		return realName;
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
		 return name() + " (" + id + ", "+ realName + ")";
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

	public static EPotionEffect getByRealName(String realName) {
		EPotionEffect[] values = values();
		int i = 0;
		while (i < values.length && values[i].realName != realName) {
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
