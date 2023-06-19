package src;

public class heuristic_1  extends heuristic {

	public heuristic_1( box final_position){
		// TODO Auto-generated constructor stub
		this.final_position = final_position;
	}
	

	@Override
	public double getRankH(box actual_position) {
		return Math.abs((final_position.getRow() - actual_position.getRow()) + (final_position.getColumn() - actual_position.getColumn()));
	}

}
