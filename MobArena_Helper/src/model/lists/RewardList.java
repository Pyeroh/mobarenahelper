package model.lists;

import java.util.*;

import model.Reward;

public class RewardList extends ArrayList<Reward> {

	private static final long serialVersionUID = -1397983488326183916L;
	
	public RewardList() {
		super();
	}
	
	public RewardList(ArrayList<Reward> list) {
		super(list);
	}
	
	public void fill(LinkedHashMap<String, Object> map) {
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			String wave_number = (String) it.next();
			add(new Reward(Integer.parseInt(wave_number), (String) map.get(wave_number)));
		}
	}
	
	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		sort();
		for(int i=0;i<size();i++) {
			Reward r = get(i);
			map.put(r.getWave_number()+"", r.getRewards().getString());
		}
		return map;
	}
	
	public boolean add(Reward r) {
		boolean b = super.add(r);
		sort();
		return b;
	}
	
	public Reward remove(int index) {
		Reward r = super.remove(index);
		sort();
		return r;
	}
	
	public boolean remove(Object r) {
		boolean b = super.remove(r);
		sort();
		return b;
	}
	
	/**
	 * Permet de trier la liste
	 */
	public void sort() {
		int size=this.size();
		triRapide(this,0,size-1);
	}

	private int partition(RewardList list,int deb,int fin) {
		int compt=deb;
		Reward pivot=list.get(deb);

		for(int i=deb+1;i<=fin;i++) {
			int lwnumber = list.get(i).getWave_number();
			int pivwnumber = pivot.getWave_number();
			if (lwnumber<pivwnumber) {
				compt++;
				echanger(list,compt,i);
			}
		}
		echanger(list,deb,compt);
		return compt;
	}

	private void triRapide(RewardList list,int deb,int fin) {
		if(deb<fin) {
			int positionPivot=partition(list,deb,fin);
			triRapide(list,deb,positionPivot-1);
			triRapide(list,positionPivot+1,fin);
		}
	}
	
	private void echanger(RewardList list, int deb, int fin) {
		Reward temp = list.get(deb);
		list.set(deb,list.get(fin));
		list.set(fin,temp);
	}

}
