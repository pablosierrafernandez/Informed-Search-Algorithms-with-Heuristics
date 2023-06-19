/**
 * 
 */
package src;

import java.util.ArrayList;

/**
 * @author Pablo
 *
 */
public class box {

	/**
	 * 
	 */
	private int height;
	private int row;
	private int column;
	private ArrayList<box> walk;
	private double cost;
	private double rankH;
	
	public box(int height, int row, int column) {
		// TODO Auto-generated constructor stub
		this.height = height;
		this.row = row;
		this.column = column;
		walk = null;
		cost = 0;
		rankH = -1;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public ArrayList<box> getWalk() {
		return walk;
	}

	public void setWalk(ArrayList<box> walk) {
		this.walk = walk;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getRankH() {
		return rankH;
	}

	public void setRankH(double rankH) {
		this.rankH = rankH;
	}
	
	public void CalculeWalk(ArrayList<box> walk, box box) {
		if (walk == null) {
			this.walk = new ArrayList<box>();
		}
		else {
			this.walk = new ArrayList<box>(walk);
		}
		this.walk.add(box);
	}
	
	public void CalculateCost(box previous_box) {
		if (previous_box.getHeight() <= this.height) {
			cost = previous_box.getCost() + (this.getHeight() - previous_box.getHeight()) + 1; 
		}
		else {
			cost = previous_box.getCost() + 0.5;
		}
	}
	public void CalculateH(heuristic heuristic) {
		rankH = heuristic.getRankH(this);
	}
	
	public boolean Same(box box) {
		return ((this.row == box.row) && (this.column == box.column)); 
		
	}

}
