package model.lists;

import java.util.*;

import model.data.Reward;
import model.enums.ERewardType;
import model.exceptions.ArenaException;

public class RewardList extends ArrayList<Reward> {

	private static final long serialVersionUID = -1397983488326183916L;

	public RewardList() {
		super();
	}

	public RewardList(ArrayList<Reward> list) {
		super(list);
	}

	public void fill(LinkedHashMap<String, Object> map, ERewardType type) throws ArenaException {
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			String wave_number = it.next();
			add(new Reward(Integer.parseInt(wave_number), type, map.get(wave_number) + ""));
		}
		sort();
	}

	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		sort();
		for (int i = 0; i < size(); i++) {
			Reward r = get(i);
			map.put(r.getWave_number() + "", r.getRewards().getString());
		}
		return map;
	}

	public boolean add(Reward r, boolean sort) {
		boolean b = super.add(r);
		if (sort)
			sort();
		return b;
	}

	@Override
	public boolean add(Reward r) {
		return add(r, true);
	}

	@Override
	public Reward remove(int index) {
		Reward r = super.remove(index);
		sort();
		return r;
	}

	@Override
	public boolean remove(Object r) {
		boolean b = super.remove(r);
		sort();
		return b;
	}

	/**
	 * Permet de trier la liste
	 */
	public void sort() {
		int size = this.size();
		triRapide(this, 0, size - 1);
	}

	private int partition(RewardList list, int deb, int fin) {
		int compt = deb;
		Reward pivot = list.get(deb);

		for (int i = deb + 1; i <= fin; i++) {
			int lwnumber = list.get(i).getWave_number();
			int pivwnumber = pivot.getWave_number();
			if (lwnumber < pivwnumber) {
				compt++;
				echanger(list, compt, i);
			}
		}
		echanger(list, deb, compt);
		return compt;
	}

	private void triRapide(RewardList list, int deb, int fin) {
		if (deb < fin) {
			int positionPivot = partition(list, deb, fin);
			triRapide(list, deb, positionPivot - 1);
			triRapide(list, positionPivot + 1, fin);
		}
	}

	private void echanger(RewardList list, int deb, int fin) {
		Reward temp = list.get(deb);
		list.set(deb, list.get(fin));
		list.set(fin, temp);
	}

	public int getFirstAvailableNumber() {
		int i = 0;
		if (i < size()) {
			while (i < size() && get(i).getWave_number() == i + 1) {
				i++;
			}
		}
		return i + 1;
	}

	public boolean isAvailable(int wave_number) {
		boolean available = true;
		int i = 0;
		if (i < size()) {
			while (i < size() && get(i).getWave_number() != wave_number) {
				i++;
			}
			if (i < size())
				available = false;
		}
		return available;
	}

}
