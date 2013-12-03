package model;

import model.lists.ItemList;

public class Reward {

	private int wave_number;
	private ItemList rewards = new ItemList();
	
	public Reward(int wave_number, String rewards) {
		this.wave_number = wave_number;
		this.rewards.fill(rewards);
	}

	public int getWave_number() {
		return wave_number;
	}

	public void setWave_number(int wave_number) {
		this.wave_number = wave_number;
	}

	public ItemList getRewards() {
		return rewards;
	}

	public void setRewards(ItemList rewards) {
		this.rewards = rewards;
	}
	
}
