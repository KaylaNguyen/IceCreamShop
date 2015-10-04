// awt
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// swing 
import javax.swing.JButton;
import javax.swing.JPanel;

/** 
 * IceCreamLineManager got passed in IceCreamShop
 * acts as Viewer
 **/
public class IceCreamLineManager extends JPanel implements ActionListener {
	// buttons
	private JButton addOrder; // hold the add button
	private JButton serveOrder; // hold the serve button
	private IceCreamLine icLine; // hold the ice cream line
	private IceCreamShop icShop;

	// constructor
	public IceCreamLineManager(IceCreamShop icShop) {
		// call super constructor
		super();
		// call instance method to initialize the graphics
		initGUI();
		// pass value to icShop instance
		this.icShop = icShop;
	}

	// private method to create the GUI components
	// returns the created main panel
	private void initGUI() {
		// use a border layout
		setLayout(new BorderLayout());

		// create panel for drawing the ice cream cone
		// and add to center
		add(createIceCreamLine(), BorderLayout.CENTER);

		// create buttons for "ordering" the cone
		// and add to south
		add(createOrderButtons(), BorderLayout.NORTH);
	}

	// private method to create ice cream display
	// returns created IceCreamLine
	private IceCreamLine createIceCreamLine() {
		// create a new instance of IceCreamLine
		icLine = new IceCreamLine();
		return icLine;
	}

	// private method to create buttons
	// returns created buttons
	private JPanel createOrderButtons() {
		// create a panel
		JPanel buttonPanel = new JPanel(new GridLayout(2, 4));

		// create a button
		addOrder = new JButton("Add a random order");
		// add this as the action listener for button's action (click)
		addOrder.addActionListener(this);

		// create a button
		serveOrder = new JButton("Serve the next order");
		// add this as the action listener for button's action (click)
		serveOrder.addActionListener(this);

		// add to panel
		buttonPanel.add(addOrder);
		buttonPanel.add(serveOrder);

		// return the panel
		return buttonPanel;
	}

	// get line
	public IceCreamLine getICLine() {
		return icLine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// check what button was clicked
		if (e.getSource() == addOrder) {
			// invoke method to enqueue
			icLine.addIC();
		}
		if (e.getSource() == serveOrder) {
			// if the queue is not empty
			if (!icLine.getQueue().isEmpty()) {
				// update score
				icShop.updateScore();
			}
		}
		validate(); // added a component
		repaint(); // call the paint method
	}
}