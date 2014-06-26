package model;

import model.enums.ERewardType;
import model.lists.ItemList;

public class Reward {

	private int wave_number;
	private ERewardType type;
	private ItemList rewards = new ItemList();

	public Reward(int wave_number, ERewardType type, String rewards) {
		this.wave_number = wave_number;
		this.type = type;
		this.rewards.fill(rewards);
	}

	public Reward(int wave_number, ERewardType type) {
		this(wave_number, type, "");
	}

	public int getWave_number() {
		return wave_number;
	}

	public void setWave_number(int wave_number) {
		this.wave_number = wave_number;
	}

	public ERewardType getType() {
		return type;
	}

	public void setType(ERewardType type) {
		this.type = type;
	}

	public ItemList getRewards() {
		return rewards;
	}

	public void setRewards(ItemList rewards) {
		this.rewards = rewards;
	}

}
