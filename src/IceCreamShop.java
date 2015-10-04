// awt
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * IceCreamShop class has an order queue; the player should build the next
 * order, then be able to "serve" it to the next in line. At this point, the
 * order should be checked if it is correct. If so, determine a point system to
 * award points to the player; if the order is incorrect, points should be
 * subtracted.
 **/
public class IceCreamShop extends JPanel // implements ActionListener
{
	// instance fields
	private JLabel score; // hold the score
	private JTextArea instruction; // hold the instruction
	private IceCreamLineManager icLineManager; // hold the ice cream line
	private IceCreamMaker icMaker; // hold the ice cream maker

	private StackLL<String> orderStack;
	private StackLL<String> serveStack;

	// private QueueLL<IceCreamCone> icQueue;
	private static int currentScore;

	// constructor
	public IceCreamShop() {
		// call super constructor
		super();
		// set current score to 0;
		currentScore = 0;

		// call instance method to initialize the graphics
		initGUI();
	}

	// private method to create the GUI components
	// returns the created main panel
	private void initGUI() {
		// use a border layout
		setLayout(new BorderLayout());

		// create panel for instruction and keeping score
		// and add to center
		add(createLabelAndButtons(), BorderLayout.NORTH);

		// create panel for drawing the ice cream cone
		// and add to center
		add(createICMaker(), BorderLayout.CENTER);

		// create panel for ice cream line
		// and add to west
		add(createICLine(), BorderLayout.WEST);
	}

	// private method to create ice cream display
	// returns created IceCreamLine
	private IceCreamLineManager createICLine() {
		// create a new instance of IceCreamLine
		icLineManager = new IceCreamLineManager(this);
		return icLineManager;
	}

	// private method to create ice cream maker display
	private IceCreamMaker createICMaker() {
		// create a new instance of IceCreamLine
		icMaker = new IceCreamMaker();
		return icMaker;
	}

	// private method to create instruction and score panel
	private JPanel createLabelAndButtons() {
		// create and initiate panel
		JPanel labelAndButtons = new JPanel(new GridLayout(2, 2));

		// create a text area
		instruction = new JTextArea();
		// add text to it
		instruction.setText("Make ice cream cones to match the next order."
				+ "\nEvery correct order served earns you 10 points."
				+ "\nMake the wrong cone and you'll lose 5 points.");

		// create a label
		score = new JLabel("Score: " + currentScore);

		// add to panel
		labelAndButtons.add(instruction);
		labelAndButtons.add(score);

		// return the panel
		return labelAndButtons;
	}

	// Method to check if user make the correct ice cream and update score
	public void updateScore() {
		// get the current queue
		QueueLL<IceCreamCone> icQueue = icLineManager.getICLine().getQueue();
		// hold the order stack
		orderStack = icQueue.peek().getStack();
		// hold the serve stack
		serveStack = icMaker.getICCone().getStack();
		// if the first ice cream in line's scoops are similar to the one made
		if (compareStacks(orderStack, serveStack)) {
			// add score
			currentScore += 10;
			// remove ice cream made wrong
			this.remove(icMaker);
			// add a new ice cream maker
			icMaker = new IceCreamMaker();
			this.add(icMaker);
			// remove order in line
			icLineManager.getICLine().removeIC();
		} else{
			// update score
			currentScore -= 5;
			// remove ice cream
			this.remove(icMaker);
			// add a new ice cream maker
			icMaker = new IceCreamMaker();
			this.add(icMaker);
		}
		// update score
		score.setText("Score: " + currentScore);
	}

	// Method to compare 2 stacks
	public boolean compareStacks(StackLL<String> a, StackLL<String> b) {
		// if one stack is empty
		if (a.isEmpty() != b.isEmpty())
			return false;
		// if both stack is empty
		if (a.isEmpty() && b.isEmpty())
			return true;
		// if both stacks are not empty, pop elements from each of them 
		String scoopA = a.pop();
		String scoopB = b.pop();
		// if the 2 elements are not similar
		if (((scoopA == null) && (scoopB != null)) || !scoopA.equals(scoopB)) {
			// push them back and return false
			a.push(scoopA);
			b.push(scoopB);
			return false;
		}
		// compare recursively
		boolean result = compareStacks(a, b);
		// push back elements
		a.push(scoopA);
		b.push(scoopA);
		return result; // return result from recursive call
	}
}