package src;

public class heuristic_2 extends heuristic{

	public heuristic_2(box final_position) {
		// TODO Auto-generated constructor stub
		this.final_position=final_position;
		
	}

	@Override
	public double getRankH(box actual_position) {
		return Math.sqrt(Math.pow(final_position.getRow() - actual_position.getRow(), 2) + Math.pow(final_position.getColumn() - actual_position.getColumn(), 2));
	}

}
