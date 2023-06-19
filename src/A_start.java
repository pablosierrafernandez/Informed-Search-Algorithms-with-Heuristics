/**
 * 
 */
package src;

/**
 * @author Pablo
 *
 */
public class A_start extends pending {


	@Override
	public boolean IsTheBox(box box) {
		return false;
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
			if (actual_box.getRankH() + actual_box.getCost() < pending.get(i).getRankH() + pending.get(i).getCost()) {
				found = true;
			}
			else {
				i++;
			}
		}
		pending.add(i, actual_box);
	}

}
