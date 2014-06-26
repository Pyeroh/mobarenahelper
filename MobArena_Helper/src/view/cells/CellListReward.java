package view.cells;

import model.Reward;

public class CellListReward extends CellListCaracs {

	private static final long serialVersionUID = -4127164425670417119L;

	private Reward reward;

	public CellListReward(Reward reward) {
		super(reward.getWave_number() + "");
		this.reward = reward;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
		lib_desc.setText(this.reward.getWave_number() + "");
		repaint();
	}

}
