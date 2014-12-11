package model.data;

import java.io.Serializable;

import model.enums.EPotionEffect;

public class PotionEffect implements Serializable {

	private static final long serialVersionUID = -1589385434722502831L;

	private EPotionEffect potionEffect;

	private int amplifier = 0;

	private int duration = 0;

	public PotionEffect(EPotionEffect potionEffect) {
		this.potionEffect = potionEffect;
	}

	public PotionEffect(EPotionEffect potionEffect, int amplifier) {
		this(potionEffect);
		this.amplifier = amplifier;
	}

	public PotionEffect(EPotionEffect potionEffect, int amplifier, int duration) {
		this(potionEffect, amplifier);
		this.duration = duration;
	}

	public EPotionEffect getPotionEffect() {
		return potionEffect;
	}

	public void setPotionEffect(EPotionEffect potionEffect) {
		this.potionEffect = potionEffect;
	}

	public int getAmplifier() {
		return amplifier;
	}

	public void setAmplifier(int amplifier) {
		this.amplifier = amplifier;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getString() {
		StringBuffer pe = new StringBuffer();
		pe.append(potionEffect.getRealName());
		if (amplifier != 0) {
			pe.append(":");
			pe.append(amplifier);
			if (duration != 0) {
				pe.append(":");
				pe.append(duration);
			}
		}

		return pe.toString();
	}

	@Override
	public String toString() {
		return potionEffect.getGuiName() + " : " + amplifier + ", " + duration + "s";
	}

}
