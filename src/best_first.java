/**
 * 
 */
package src;

/**
 * @author Pablo
 *
 */
public class best_first extends pending {


	
	@Override
	public boolean IsTheBox(box box) {
		int i = 0;
		boolean found = false;
		
		while ((!found) && (i < pending.size())) {
			if (pending.get(i).equals(box)) {
				found = true;
			}
			else {
				i++;
			}
		}
		return found;
	}
	

	@Override
	public box GetBox() {
		return pending.get(0);
	}
	

	@Override
	public void AddBox(box actual_box) {
		int i = 0;
		boolean found = false;
		
		while ((!found) && (i < pending.size())) {
			if (actual_box.getRankH() <= pending.get(i).getRankH()) {
				found = true;
			}
			else {
				i++;
			}
		}
		pending.add(i, actual_box);	
	}
}
