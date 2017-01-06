package com.test.EatDish;

class ItemCat implements Comparable<ItemCat>{

	ItemCat(long satisfaction, long time){
		this.satisfaction = satisfaction;
		this.time = time;
	}

	public long getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(long satisfaction) {
		this.satisfaction = satisfaction;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	private long satisfaction;
	private long time;

	@Override
	public int compareTo(ItemCat o) {
		if(Double.compare((double)satisfaction/(double)time, (double)o.satisfaction/(double)o.time) > 0)
			return -1;
		else if(Double.compare((double)satisfaction/(double)time, (double)o.satisfaction/(double)o.time) < 0)
			return 1;
		else if(satisfaction > o.satisfaction)
			return 1;
		else if(satisfaction < o.satisfaction)
			return -1;
		return 0;
	}

}
