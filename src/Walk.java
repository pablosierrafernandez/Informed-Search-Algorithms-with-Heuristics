package src;

import java.util.ArrayList;

public class Walk {

	ArrayList<box> walk;
	public Walk(ArrayList<box> walk) {
		// TODO Auto-generated constructor stub
		this.walk=walk;
	}
	
	public int Size_walk() {
		return walk.size();
	}
	
	public void Add_Box(box box) {
		walk.add(box);
	}
	

	public boolean Is_The_Box(box box) {
		int i = 0;
		boolean find = false;
		
		while ((!find) && (i < walk.size())) {
			if (walk.get(i).Same(box)) {
				find = true;
			}
			else {
				i++;
			}
		}
		return find;
	}

}
