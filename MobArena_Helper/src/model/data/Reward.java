package model.data;

import java.io.Serializable;

import model.enums.ERewardType;
import model.exceptions.ArenaException;
import model.lists.ItemList;

public class Reward implements Serializable {

	private static final long serialVersionUID = -5257929091456842234L;

	private int wave_number;

	private ERewardType type;

	private ItemList rewards = new ItemList();

	public Reward(int wave_number, ERewardType type, String rewards) throws ArenaException {
		this.wave_number = wave_number;
		this.type = type;
		this.rewards.fill(rewards);
	}

	public Reward(int wave_number, ERewardType type) {
		this.wave_number = wave_number;
		this.type = type;
		try {
			this.rewards.fill("");
		}
		catch (ArenaException e) {
		}
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
