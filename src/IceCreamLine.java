import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 * IceCreamLine class represents an ice cream shop line. It should maintain a
 * queue of ice cream cone orders using the Queue you just created and the
 * IceCreamCone class from Part 1. Each order should be an ice cream cone with
 * between 1 and 4 random scoop flavors.
 **/

public class IceCreamLine extends Box {
	// instance variables
	private QueueLL<IceCreamCone> mainQueue; // queue to keep the line of ice cream
	
	/**
	 * Constructor
	 */
	public IceCreamLine() {
		// call superclass constructor
		super(BoxLayout.Y_AXIS);
		// initialize the queue
		mainQueue = new QueueLL<IceCreamCone>();
	}

	/**
	 * Method to get the queue
	 */
	public QueueLL<IceCreamCone> getQueue() {
		return mainQueue;
	}

	/**
	 * Method to add ice cream
	 **/
	public void addIC() {
		// create a new ice cream
		IceCreamCone icCone = new IceCreamCone();
		// assign random scoops to it
		icCone.getRandomIC();
		// put in queue
		mainQueue.enqueue(icCone);
		repaint(); // paint the ice cream
		// add to the box
		this.add(icCone);
	}

	/**
	 * Method to add ice cream
	 **/
	public void removeIC() {
		// remove from queue
		IceCreamCone removedCone = mainQueue.dequeue();
		// paint the ice cream
		repaint();
		// remove from display
		this.remove(removedCone);
	}
}