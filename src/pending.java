/**
 * 
 */
package src;

import java.util.ArrayList;

/**
 * @author Pablo
 *
 */
public abstract class pending {

	/**
	 * 
	 */
	protected ArrayList<box> pending;
	public pending() {
		// TODO Auto-generated constructor stub
		pending = new ArrayList<box>();
	}
	
	public boolean ThereAreBoxes() {
		return !pending.isEmpty();
	}
	
	public void DeleteBox(box box) {
		pending.remove(box);
	}
	

	public abstract boolean IsTheBox(box box);
	

	public abstract box GetBox();
	

	public abstract void AddBox(box actual_box);

}
