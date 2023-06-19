package src;

public class heuristic_3 extends heuristic {

	public heuristic_3(box final_position) {
		// TODO Auto-generated constructor stub
		this.final_position=final_position;
		
	}

	@Override
	public double getRankH(box actual_position) {
		if (actual_position.getHeight() <= final_position.getHeight()) {
			return (final_position.getHeight() - actual_position.getHeight() + 1);
		}
		else {
			return 0.5;
		}	
	}

}
