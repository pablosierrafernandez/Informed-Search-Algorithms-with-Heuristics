/**
 * 
 */
package src;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Pablo
 *
 */
public class tractates {

	/**
	 * 
	 */
	private HashSet<box> tractates_boxes;
	public tractates() {
		// TODO Auto-generated constructor stub
		tractates_boxes = new HashSet<box>();
	}
	
	public boolean box_content(box box) {
		Iterator<box> boxes = tractates_boxes.iterator();
		boolean same = false;
		
		while ((!same) && (boxes.hasNext())) {
			if (boxes.next().Same(box) ) {
				same = true;
			}
		}
		return same;
	}
	
	public void add_box(box box) {
		tractates_boxes.add(box);
	}

}
